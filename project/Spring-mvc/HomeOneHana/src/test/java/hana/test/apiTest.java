package hana.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import kr.co.hana.schedule.vo.ScheduleVO;
import kr.co.hana.search.vo.SearchHomeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class apiTest {
	
	
	@Ignore
	public void getNotice() throws IOException {
		
		List<ScheduleVO> resultList = new ArrayList<ScheduleVO>();
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552555/lhLeaseNoticeInfo1/lhLeaseNoticeInfo1"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=wzVGH0RoH4TBmxGKJY4GBkDozdkN0n6aQcP6R3RFMGoyjFZzW6wLW5XW1ikRufIwVjTGMxqlOguEoEMgTQUqVw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("PG_SZ","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("PAGE","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("PAN_NM","UTF-8") + "=" + URLEncoder.encode("모집", "UTF-8")); /*공고명으로 조회*/
        urlBuilder.append("&" + URLEncoder.encode("UPP_AIS_TP_CD","UTF-8") + "=" + URLEncoder.encode("06", "UTF-8")); /*공고유형코드*/
        urlBuilder.append("&" + URLEncoder.encode("CNP_CD","UTF-8") + "=" + URLEncoder.encode("41", "UTF-8")); /*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("PAN_SS","UTF-8") + "=" + URLEncoder.encode("공고중", "UTF-8")); /*공고상태코드*/
        urlBuilder.append("&" + URLEncoder.encode("PAN_NT_ST_DT","UTF-8") + "=" + URLEncoder.encode("2021.08.23", "UTF-8")); /*공고게시일*/
        urlBuilder.append("&" + URLEncoder.encode("CLSG_DT","UTF-8") + "=" + URLEncoder.encode("2021.09.30", "UTF-8")); /*공고마감일*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        //System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        String result = sb.toString();
        JSONArray jArray = new JSONArray(result);
        JSONObject jObject = (JSONObject) jArray.get(1);
        JSONArray dsList = jObject.getJSONArray("dsList");
        System.out.println(dsList.length());
        for(int i=0; i<dsList.length(); i++) {
        	JSONObject list = (JSONObject) dsList.get(i);
        	if(list != null) {
        		ScheduleVO sche = new ScheduleVO();
        		sche.setPan_ss(list.getString("PAN_SS"));
        		sche.setPan_nt_st_dt(list.getString("PAN_NT_ST_DT"));
        		sche.setAis_tp_cd(list.getString("AIS_TP_CD"));
        		sche.setSpl_inf_tp_cd(list.getString("SPL_INF_TP_CD"));
        		sche.setCnp_cd_nm(list.getString("CNP_CD_NM"));
        		sche.setPan_id(list.getString("PAN_ID"));
        		sche.setAis_tp_cd_nm(list.getString("AIS_TP_CD_NM"));
        		sche.setClsg_dt(list.getString("CLSG_DT"));
        		sche.setPan_dt(list.getString("PAN_DT"));
        		sche.setUpp_ais_tp_cd(list.getString("UPP_AIS_TP_CD"));
        		sche.setPan_nm(list.getString("PAN_NM"));
        		sche.setDtl_url(list.getString("DTL_URL"));
        		sche.setCcr_cnnt_sys_ds_cd(list.getString("CCR_CNNT_SYS_DS_CD"));
        		
        		resultList.add(sche);
        	}
        }
        
        System.out.println(resultList.get(0));
       
        

        
	}
	
	
	
	@Ignore
	public SearchHomeVO getLatiLong(String rnadres) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		
		SearchHomeVO search = new SearchHomeVO();
		

		StringBuilder urlBuilder = new StringBuilder("https://api.vworld.kr/req/address");
		urlBuilder.append("?" + URLEncoder.encode("service","UTF-8") +"=" +  URLEncoder.encode("address", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("request","UTF-8") +"=" +  URLEncoder.encode("getcoord", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("version","UTF-8") +"=" +  URLEncoder.encode("2.0", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("crs","UTF-8") +"=" +  URLEncoder.encode("epsg:4326", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("address","UTF-8") + "=" + URLEncoder.encode(rnadres, "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("refine","UTF-8") +"=" +  URLEncoder.encode("true", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("simple","UTF-8") +"=" +  URLEncoder.encode("false", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("format","UTF-8") +"=" +  URLEncoder.encode("json", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") +"=" +  URLEncoder.encode("road", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("key","UTF-8") +"=" +  URLEncoder.encode("0B982473-0F10-3E6C-803F-2AE6590D33D1", "UTF-8")); 


		
		URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        String result = sb.toString();
        System.out.println("위도경도 : "+result);
        JSONObject jObject = new JSONObject(result);
        
        JSONObject resp = jObject.getJSONObject("response").getJSONObject("result").getJSONObject("point");
        String lati = resp.getString("y");
        String longs = resp.getString("x");
        System.out.println(lati +", "+longs);
        search.setLati(lati);
        search.setLongs(longs);
        return search;
        
	}
	
	@Ignore
	@Test
	public void testAPI2() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		String latilng="127.046528406,37.689117008";//도봉산역
				//"126.7732956,37.5008505";
		StringBuilder urlBuilder = new StringBuilder("https://api.vworld.kr/req/address");
		urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=" + URLEncoder.encode("address", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("request", "UTF-8") + "=" + URLEncoder.encode("getAddress", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("version", "UTF-8") + "=" + URLEncoder.encode("2.0", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("crs", "UTF-8") + "=" + URLEncoder.encode("epsg:4326", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("point", "UTF-8") + "=" + URLEncoder.encode(latilng, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("format", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("both", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("zipcode", "UTF-8") + "=" + URLEncoder.encode("true", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("simple", "UTF-8") + "=" + URLEncoder.encode("false", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("key", "UTF-8") + "="
				+ URLEncoder.encode("0B982473-0F10-3E6C-803F-2AE6590D33D1", "UTF-8"));

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		//System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		String result = sb.toString();
		JSONObject jObject = new JSONObject(result);
		String resp = ((JSONObject) jObject.getJSONObject("response").getJSONArray("result").get(0)).getString("text");
		System.out.println(resp);
	}
	
	
	
	
	
	@Test
	public void gggg() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException{
		
		String searchAddr = "경기 안산시 상록구 석호로 226 감골실내체육관";
		SearchHomeVO searchInfo = getLatiLong(searchAddr);
		String lat1 = searchInfo.getLati();
		String lon1 = searchInfo.getLongs();
		
		List<SearchHomeVO> list = new ArrayList<SearchHomeVO>();
		
		SearchHomeVO inf1 = new SearchHomeVO();
		inf1.setBrtccode(41);
		inf1.setSigngucode(270);
		list.add(inf1);
		
		SearchHomeVO inf2 = new SearchHomeVO();
		inf2.setBrtccode(41);
		inf2.setSigngucode(271);
		list.add(inf2);
		
		SearchHomeVO inf3 = new SearchHomeVO();
		inf3.setBrtccode(41);
		inf3.setSigngucode(213);
		list.add(inf3);
		
		//주소집합만들기
		//HashSet<String> addrSet = new HashSet<String>();
		HashSet<SearchHomeVO> nearHome = new HashSet<SearchHomeVO>();
		
		for(int i = 0; i<list.size(); i++) {
			
			String brtc = Integer.toString(list.get(i).getBrtccode());
			String sig = Integer.toString(list.get(i).getSigngucode());
			int total = getTotalCnt(brtc, sig,"1");
			int page = (total/100)+1;
			if(total !=0) {
				for(int p=1; p<page+1; p++) {
					String result = getHomeData(brtc, sig, Integer.toString(p));
					JSONObject jObject = new JSONObject(result);
					JSONArray jArray = jObject.getJSONArray("hsmpList");
					for(int l = 0; l<jArray.length(); l++) {
						JSONObject home = (JSONObject) jArray.get(l);
						String rnadres = home.getString("rnAdres");
						int hsmpsn = home.getInt("hsmpSn");
						SearchHomeVO latlng = getLatiLong(rnadres);
						String lat2 = latlng.getLati();
						String lon2 = latlng.getLongs();
						double dist = distance(lat1, lon2, lat2, lon2,"meter");
						if(dist<800) {
							SearchHomeVO info = new SearchHomeVO();
							info.setRnadres(rnadres);
							info.setLati(lat2);
							info.setLongs(lon2);
							info.setInsttnm(home.getString("insttNm"));
							info.setSuplytynm(home.getString("suplyTyNm"));
							info.setBrtccode(home.getInt("brtcCode"));
							info.setSigngucode(home.getInt("signguCode"));
							
							
							
							nearHome.add(info);
						}
					}
					
					
				}
			}
			

		}
		Iterator<SearchHomeVO> iter = nearHome.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//System.out.println(list);
	}
	
	public int getTotalCnt(String brtc, String sig, String page) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		
        String result = getHomeData(brtc, sig, page);
        JSONObject jObject = new JSONObject(result);
		JSONArray jArray = jObject.getJSONArray("hsmpList");
		if(jArray.length() != 0) {
			JSONObject totalObj = (JSONObject) jArray.get(0);
			int total = totalObj.getInt("totalCount");
			return total;
		}else {
			return 0;
		}
	}
	
	
	public String getHomeData(String brtc, String sig, String page) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		StringBuilder urlBuilder = new StringBuilder("https://data.myhome.go.kr:443/rentalHouseList"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=wzVGH0RoH4TBmxGKJY4GBkDozdkN0n6aQcP6R3RFMGoyjFZzW6wLW5XW1ikRufIwVjTGMxqlOguEoEMgTQUqVw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("brtcCode","UTF-8") + "=" + URLEncoder.encode(brtc, "UTF-8")); /*광역시도 코드*/
        urlBuilder.append("&" + URLEncoder.encode("signguCode","UTF-8") + "=" + URLEncoder.encode(sig, "UTF-8")); /*시군구 코드*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*조회될 목록의 페이지당 데이터 개수 (기본값:10)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode( page, "UTF-8")); /*조회될 페이지의 번호 (기본값:1)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        //System.out.println(sb.toString());
        
        String result = sb.toString();
        
        return result;
	}
	
	private static double distance(String latt1, String lont1, String latt2, String long2, String unit) {
        
		double lat1 = Double.parseDouble(latt1);
		double lon1 = Double.parseDouble(lont1);
		double lat2 = Double.parseDouble(latt2);
		double lon2 = Double.parseDouble(long2);
		
		
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        } 
 
        return (dist);
    }
	
	private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
	     
    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
	


	
	
	
	

}
