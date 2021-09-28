#!/usr/bin/env python
# coding: utf-8


from urllib.request import Request
from urllib.request import urlopen
from urllib.parse import urlencode
from urllib.parse import quote_plus
import json


import cx_Oracle
import os
import pandas as pd
import numpy as np
os.putenv('NLS_LANG', '.UTF8')


# In[200]:

def endprosess():
    print("end!")


def select(s):
    conn = cx_Oracle.connect('scott','tiger','192.168.119.119/dink',encoding='UTF-8')
    cursor = conn.cursor()
    sql = s
    cursor.execute(sql)
    homelist = pd.read_sql(sql, con=conn)
    
    return homelist

def insertHomeDetail(data):
    conn = cx_Oracle.connect('scott','tiger','192.168.119.119/dink',encoding='UTF-8')
    cursor = conn.cursor()
    sql = """insert into homedetail(HSMPSN, STYLENM, SUPLYPRVUSEAR, SUPLYCMNUSEAR, HOUSETYNM,BASSRENTGTN, BASSMTRNTCHRG, BASSCNVRSGTNLMT) values(:1,:2,:3,:4,:5,:6,:7,:8)"""
    val = [data['HSMPSN'],data['STYLENM'],data['SUPLYPRVUSEAR'],data['SUPLYPRVUSEAR'],data['HOUSETYNM'], data['BASSRENTGTN'], data['BASSMTRNTCHRG'],data['BASSCNVRSGTNLMT']]
    cursor.execute(sql,val)
    cursor.close()
    conn.commit()
    conn.close()
    
def insertHomeList(data):
    conn = cx_Oracle.connect('scott','tiger','192.168.119.119/dink',encoding='UTF-8')
    cursor = conn.cursor()
    insertsql = """insert into homelist(HSMPSN, INSTTNM, BRTCCODE, SIGNGUCODE, HSMPNM, RNADRES,COMPETDE, HSHLDCO, SUPLYTYNM, HEATMTHDDETAILNM, BULDSTLENM,HOUSETYNM, ELVTRINSTLATNM, PARKNGCO,LATI, LONGS) values(:1,:2,:3,:4,:5,:6,:7,:8,:9,:10,:11,:12,:13,:14,:15,:16)"""
    val = [data['HSMPSN'], data['INSTTNM'], data['BRTCCODE'], data['SIGNGUCODE'], data['HSMPNM'], data['RNADRES'],data['COMPETDE'], data['HSHLDCO'], data['SUPLYTYNM'], data['HEATMTHDDETAILNM'], data['BULDSTLENM'],data['HOUSETYNM'], data['ELVTRINSTLATNM'], data['PARKNGCO'],data['LATI'],data['LONGS']]
    cursor.execute(insertsql,val)
    cursor.close()
    conn.commit()
    conn.close()

#homelist = select("""SELECT * FROM HOMELIST""")
#homedetail = select("""SELECT * FROM HOMEDETAIL""")
#homedetail.columns


# In[192]:


def getLatiLng(addr):
    
    
    url = "https://api.vworld.kr/req/address"
    queryParams = '?' + urlencode({ quote_plus('service') : 'address', 
                                   quote_plus('request') : 'getcoord', 
                                   quote_plus('version') : '2.0', 
                                   quote_plus('crs') : 'epsg:4326', 
                                   quote_plus('address') : addr,
                                  quote_plus('refine'):'true',
                                  quote_plus('simple'):'false',
                                  quote_plus('format'):'json',
                                  quote_plus('type'):'road',
                                  quote_plus('key'):'0B982473-0F10-3E6C-803F-2AE6590D33D1'})
    request = Request(url + queryParams)
    request.get_method = lambda: 'GET'
    response_body = urlopen(request).read()
    resStr = response_body.decode('utf-8')

    result = json.loads(resStr)
    lati = result['response']['result']['point']['y']
    lngs = result['response']['result']['point']['x']
    return {'lati':lati,'lngs':lngs}


# In[ ]:

def getLHdata():
    homelist = select("""SELECT * FROM HOMELIST""")
    
    location = {
            '11':[110,140,170,200,215,230,260,290,305,320,350,380,410,440,470,5000,530,545,560,590,620,650,680,710,740],
            '26':[110,140,170,200,230,260,290,320,350,380,410,440,470,500,530,710],
            '27':[110,140,170,200,230,260,290,710],
            '28':[110,140,170,185,200,237,245,260,710,720],
            '29':[110,140,170,200,230],
            '30':[110,140,170,200,230],
            '31':[110,140,170,200,710],
            '36':[110],
            '41':[110,111,113,115,117,130,131,133,135,150,170,171,173,190,210,220,250,270,271,273,280,281,285,287,290,310,360,370,390,410,430,450,460,461,463,465,480,500,550,570,590,610,630,650,670,800,820,830],
            '42':[110,130,150,170,190,210,230,720,730,750,760,770,780,790,8000,810,820,830],
            '43':[110,111,112,113,114,130,150,720,730,740,745,750,760,770,800],
            '44':[130,131,133,150,180,200,210,230,250,270,710,760,770,790,800,810,825],
            '45':[110,111,113,130,140,180,190,210,710,720,730,740,750,770,790,800],
            '46':[110,130,150,170,230,710,720,730,770,780,790,800,810,820,830,840,860,870,880,890,900,910],
            '47':[110,111,113,130,150,170,190,210,230,250,280,290,720,730,750,760,770,820,830,840,850,900,920,930,940],
            '48':[120,121,123,125,127,129,170,220,240,250,270,310,330,720,730,740,820,840,850,860,870,880,890],
            '50':[110,130]
                }
    
    locationList = list(location.keys())
    resultList=[]
    
    for key in tqdm(locationList) :
        value = location.get(key)
        for v in value:
            i = 1
            while True:
    
                url = 'https://data.myhome.go.kr:443/rentalHouseList'
                queryParams = '?' + urlencode({ quote_plus('ServiceKey') : 'wzVGH0RoH4TBmxGKJY4GBkDozdkN0n6aQcP6R3RFMGoyjFZzW6wLW5XW1ikRufIwVjTGMxqlOguEoEMgTQUqVw==', 
                                               quote_plus('brtcCode') : key, 
                                               quote_plus('signguCode') : str(v), 
                                               quote_plus('numOfRows') : '100', 
                                               quote_plus('pageNo') : str(i) })
    
                request = Request(url + queryParams)
                request.get_method = lambda: 'GET'
                response_body = urlopen(request).read()
                resStr = response_body.decode('utf-8')
                
                result = json.loads(resStr)['hsmpList']
                
                if(len(result) == 0):
                    break
                else:
                    resultList.append(result)
                    i+=1
                    
    data = sum(resultList,[])
    apidata = pd.DataFrame.from_records(data)[['hsmpSn', 'insttNm', 'brtcCode', 'brtcNm', 'signguCode', 'signguNm',
           'hsmpNm', 'rnAdres', 'competDe', 'hshldCo', 'suplyTyNm', 'styleNm',
           'suplyPrvuseAr', 'suplyCmnuseAr', 'houseTyNm', 'heatMthdDetailNm',
           'buldStleNm', 'elvtrInstlAtNm', 'parkngCo', 'bassRentGtn',
           'bassMtRntchrg', 'bassCnvrsGtnLmt']]
    
    
    # In[174]:
    
    
    #apidata = pd.read_csv('data/lhdata(utf-8) - 복사본 (3).csv', encoding='utf-8-sig')
    # 컬럼맞추기(db랑)
    apidata.rename(columns={'hsmpSn':'HSMPSN','insttNm':'INSTTNM','brtcNm':'BRTCNM','signguCode':'SIGNGUCODE', 'signguNm':'SIGNGUNM',
                   'hsmpNm': 'HSMPNM', 'rnAdres':'RNADRES','competDe':'COMPETDE', 'hshldCo': 'HSHLDCO', 'suplyTyNm':'SUPLYTYNM',
                   'styleNm':'STYLENM','suplyPrvuseAr':'SUPLYPRVUSEAR', 'suplyCmnuseAr':'SUPLYCMNUSEAR', 'houseTyNm':'HOUSETYNM',
                    'heatMthdDetailNm' : 'HEATMTHDDETAILNM','buldStleNm':'BULDSTLENM', 'elvtrInstlAtNm':'ELVTRINSTLATNM',
                    'parkngCo' : 'PARKNGCO', 'bassRentGtn':'BASSRENTGTN','brtcCode':'BRTCCODE',
           'bassMtRntchrg':'BASSMTRNTCHRG', 'bassCnvrsGtnLmt':'BASSCNVRSGTNLMT'}, inplace=True)
    homelist_sv= apidata.drop_duplicates(['RNADRES' ] , keep='first').reset_index(drop=True)
    
    
    # In[175]:
    
    
    #apiRNADRES= list(homelist_sv['RNADRES'].unique()) #api전체 중복제거
    # api에 새로 생긴 주소
    newHomeADDR = list(homelist_sv[~homelist_sv['RNADRES'].isin(list(homelist['RNADRES'].unique()))]['RNADRES'])
    len(apiRNADRES),len(homelist_sv), len(newHomeADDR)
    
    
    # In[127]:
    
    
    ## 새로 생긴 값 HOMELIST에 넣기
    
    
    # In[178]:
    
    
    #list테이블 삽입
    newList = apidata[apidata['RNADRES'].isin(newHomeADDR)][['HSMPSN', 'INSTTNM', 'BRTCCODE', 'SIGNGUCODE', 'HSMPNM', 'RNADRES','COMPETDE', 'HSHLDCO', 'SUPLYTYNM', 'HEATMTHDDETAILNM', 'BULDSTLENM','HOUSETYNM', 'ELVTRINSTLATNM', 'PARKNGCO']]
    newList = newList.drop_duplicates(['RNADRES' ] , keep='first').reset_index(drop=True).to_json(orient = 'records')
    for n in json.loads(newList):
        latilngdata = getLatiLng(n['RNADRES'])
        n['LATI'] = latilngdata['lati']
        n['LONGS'] = latilngdata['lngs']
        insertHomeList(n)
    
    
    # In[177]:
    
    
    #detail 테이블 삽입
    detail = apidata[apidata['RNADRES'].isin(newHomeADDR)][['HSMPSN', 'STYLENM', 'SUPLYPRVUSEAR', 'SUPLYCMNUSEAR', 'HOUSETYNM',
           'BASSRENTGTN', 'BASSMTRNTCHRG', 'BASSCNVRSGTNLMT']].to_json(orient = 'records')
    for d in json.loads(detail):
        insertHomeDetail(d)
        
    print("end!")

getLHdata()
