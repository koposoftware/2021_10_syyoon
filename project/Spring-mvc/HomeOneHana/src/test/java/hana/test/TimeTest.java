package hana.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import kr.co.hana.search.Service.SearchService;
import kr.co.hana.search.dao.SearchDAO;
import kr.co.hana.search.vo.BrtcSignguVO;
import kr.co.hana.search.vo.SearchHomeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class TimeTest {
	
	@Autowired
	private SearchDAO searchdao;
	@Autowired
	private SearchService searchservice;

	
	@Test
	public void getTimeNormalDataBase() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		long beforeTime = System.currentTimeMillis(); // �ڵ� ���� ���� �ð� �޾ƿ���

		String rnadres = "서울특별시 광진구 면목로 103";
		SearchHomeVO searchInfo = searchservice.getLatiLongs(rnadres);

		if (searchInfo != null) { // ��ǥ�� �ִ� �ּ� �϶�
			searchInfo.setRnadres(rnadres);

			String[] spAddress = rnadres.split(" ");
			List<BrtcSignguVO> codeList = searchservice.getBrtcSigCode(spAddress);

			if (codeList == null) {// ��ǥ�� �����µ� �ּҰ� �ƴϸ� ���θ��ּ� �ٽð˻��ؼ� ��ȯ�� �ñ����ڵ�� ��ȯ
				String address = searchservice.getAddress(searchInfo);

				String[] spaddress = address.split(" ");
				codeList = searchservice.getBrtcSigCode(spaddress);
			}

			//List<SearchHomeVO> nearHomeA = searchservice.getNearHomeAll(searchInfo, codeList);
			List<SearchHomeVO> Home = searchdao.getHomeList(codeList.get(0));
			
			
			List<SearchHomeVO> result = new ArrayList<SearchHomeVO>();
			for(int h=0; h<Home.size();h++) {
				SearchHomeVO latlng = getLatiLongs(Home.get(h).getRnadres());
				if(latlng != null) { // �����浵�� ���ö���
					double dist = distance(searchInfo.getLati(), searchInfo.getLongs(), latlng.getLati(), latlng.getLongs(), "meter");
					if(dist<800) {
						Home.get(h).setLati(latlng.getLati());
						Home.get(h).setLongs(latlng.getLongs());
						result.add(Home.get(h));
					}
				}
				
			}
			
			

		}else {
			//�ּҰ� ������

		}

		
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime)/1000; //�� �ð��� �� ���
		System.out.println("정규화DB(m) : "+secDiffTime);

	}
	

	@Test
	public void getTimeUnNormalDataBase() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
		
		String rnadres = "서울특별시 광진구 면목로 103";
		SearchHomeVO searchInfo =  searchservice.getLatiLongs(rnadres);
		
		
		if(searchInfo != null) { // ��ǥ�� �ִ� �ּ� �϶�
			searchInfo.setRnadres(rnadres);
			
			String[] spAddress = rnadres.split(" ");
			List<BrtcSignguVO> codeList = searchservice.getBrtcSigCode(spAddress);
			
			if(codeList == null) {// ��ǥ�� �����µ� �ּҰ� �ƴϸ� ���θ��ּ� �ٽð˻��ؼ� ��ȯ�� �ñ����ڵ�� ��ȯ
				String address = searchservice.getAddress(searchInfo);
				
				String[] spaddress = address.split(" ");
				codeList = searchservice.getBrtcSigCode(spaddress);
			}

			List<SearchHomeVO> Home = searchdao.getHomeList2(codeList.get(0));
			
			
			List<SearchHomeVO> result = new ArrayList<SearchHomeVO>();
			for(int h=0; h<Home.size();h++) {
				SearchHomeVO latlng = getLatiLongs(Home.get(h).getRnadres());
				if(latlng != null) { // �����浵�� ���ö���
					double dist = distance(searchInfo.getLati(), searchInfo.getLongs(), latlng.getLati(), latlng.getLongs(), "meter");
					if(dist<800) {
						Home.get(h).setLati(latlng.getLati());
						Home.get(h).setLongs(latlng.getLongs());
						result.add(Home.get(h));
					}
				}
				
			}
			
	

		}else {

			System.out.println("??");
		}

		
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime)/1000; //�� �ð��� �� ���
		System.out.println("DB그냥저장(m) : "+secDiffTime);

	}

	
	@Test
	public void getTimeAPI() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {

		long beforeTime = System.currentTimeMillis(); // �ڵ� ���� ���� �ð� �޾ƿ���

		String rnadres = "서울특별시 광진구 면목로 103";
		SearchHomeVO searchInfo = searchservice.getLatiLongs(rnadres);

		if (searchInfo != null) { // ��ǥ�� �ִ� �ּ� �϶�
			searchInfo.setRnadres(rnadres);

			String[] spAddress = rnadres.split(" ");
			List<BrtcSignguVO> codeList = searchservice.getBrtcSigCode(spAddress);

			if (codeList == null) {// ��ǥ�� �����µ� �ּҰ� �ƴϸ� ���θ��ּ� �ٽð˻��ؼ� ��ȯ�� �ñ����ڵ�� ��ȯ
				String address = searchservice.getAddress(searchInfo);

				String[] spaddress = address.split(" ");
				codeList = searchservice.getBrtcSigCode(spaddress);
			}

			List<SearchHomeVO> nearHomeA = getNearHomeAll(searchInfo, codeList);
			System.out.println(nearHomeA.size());
			if (nearHomeA.size() == 0) {
				// ��ó�� ���þ���
				System.out.println("주소없지");
			} else {
				
			}

		} else {
			// �ּҰ� ������
			System.out.println("롸");
		}

		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime) / 1000; // �� �ð��� �� ���
		System.out.println("API(m) : " + secDiffTime);
		
	}
	
	
	
	

	public List<SearchHomeVO> getNearHomeAll(SearchHomeVO searchInfo, List<BrtcSignguVO> list)  throws IOException, ParserConfigurationException, SAXException, XPathExpressionException{

		Map<String,SearchHomeVO> nearHome = new HashMap<String,SearchHomeVO>();
		for (int i = 0; i < list.size(); i++) {
			String brtc = Integer.toString(list.get(i).getBrtccode());
			String sig = Integer.toString(list.get(i).getSigngucode());
			int total = getTotalCnt(brtc, sig, "1");
			int page = (total / 100) + 1;
			if (total != 0) {
				for (int p = 1; p < page + 1; p++) {
					String result = getHomeData(brtc, sig, Integer.toString(p));
					JSONObject jObject = new JSONObject(result);
					//System.out.println(result);
					JSONArray jArray = jObject.getJSONArray("hsmpList");
					for (int l = 0; l < jArray.length(); l++) {
						JSONObject home = (JSONObject) jArray.get(l);
						//System.out.println(home.toString());
						String searchA = searchInfo.getRnadres();
						if(!searchA.equals(home.getString("rnAdres"))) {
							//System.out.println("�ֿ��¾� : "+home.get("houseTyNm").toString());
							SearchHomeVO info = new SearchHomeVO();
							info.setRnadres(home.getString("rnAdres")); //���θ��ּ�
							info.setInsttnm(home.getString("insttNm")); // ���ޱ��
							info.setSuplytynm(home.getString("suplyTyNm")); // ��������
							info.setBrtccode(home.getInt("brtcCode")); // �����ڵ�
							info.setBrtcnm(home.getString("brtcNm")); // ������
							info.setSigngucode(home.getInt("signguCode")); // �ñ����ڵ�
							info.setSigngunm(home.getString("signguNm")); // �ñ�����

							info.setHousetynm(home.get("houseTyNm").toString()); // ��������(���ǽ���,...)								

							nearHome.put(home.getString("rnAdres"), info);
						
						}
					}
				}
			}
		}
		
		//2. �ߺ����� �ּ��� ���� �浵 ��ȯ
		Set<String> keySet = nearHome.keySet();
		//System.out.println("keySet ũ�� : "+keySet.size());
		List<SearchHomeVO> result = new ArrayList<SearchHomeVO>();
		for(String key: keySet) {
			SearchHomeVO homeI = nearHome.get(key);
			SearchHomeVO latlng = getLatiLongs(homeI.getRnadres());
			if(latlng != null) { // �����浵�� ���ö���
				double dist = distance(searchInfo.getLati(), searchInfo.getLongs(), latlng.getLati(), latlng.getLongs(), "meter");
				if(dist<800) {
					homeI.setLati(latlng.getLati());
					homeI.setLongs(latlng.getLongs());
					result.add(homeI);
				}
			}
		}
		return result;
	}
	
	
	
	
	/**
	 * ��ġ�ϴ� ���� �ڵ� ��������
	 */
	public List<BrtcSignguVO> getBrtcSigCode(String[] spAddress) {
		
		List<String> brtcList = searchdao.getBrtcList();
		List<BrtcSignguVO> codeList = new ArrayList<BrtcSignguVO>();
		
		if(brtcList.contains(spAddress[0])) {
			// �������� �����ϴ� �ּ��϶�
			BrtcSignguVO searchBrtc = new BrtcSignguVO();
			searchBrtc.setBrtcnm(spAddress[0]);
			searchBrtc.setSigngunm(spAddress[1]);
			BrtcSignguVO selectOne = searchdao.getBrtcSigCode(searchBrtc);
			codeList.add(selectOne);
			if(selectOne != null) { //���� ������
				searchBrtc.setSigngunm(spAddress[1]+" "+spAddress[2]); // �ڿ��ּҵ� �ٿ��� ���غ���
				BrtcSignguVO selectOne2 = searchdao.getBrtcSigCode(searchBrtc);
				if(selectOne2 !=null) {
					codeList.add(selectOne2);
				}
			}
			return codeList;
		}
		return null;
	}
	

	/**
	 �Ÿ����ϱ�
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @param unit
	 * @return
	 */
	public double distance(String latt1, String lont1, String latt2, String lont2, String unit) {
		
		double lat1 = Double.parseDouble(latt1);
		double lon1 = Double.parseDouble(lont1);
		double lat2 = Double.parseDouble(latt2);
		double lon2 = Double.parseDouble(lont2);
        
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
    
    
    
    
	/** API
	 * �ּҷ� ��,�浵 ��������
	 */
	public SearchHomeVO  getLatiLongs(String rnadres)
			 throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		
		SearchHomeVO latlngvo = new SearchHomeVO();
		
		StringBuilder urlBuilder = new StringBuilder("https://api.vworld.kr/req/address");
		urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=" + URLEncoder.encode("address", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("request", "UTF-8") + "=" + URLEncoder.encode("getcoord", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("version", "UTF-8") + "=" + URLEncoder.encode("2.0", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("crs", "UTF-8") + "=" + URLEncoder.encode("epsg:4326", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode( rnadres, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("refine", "UTF-8") + "=" + URLEncoder.encode("true", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("simple", "UTF-8") + "=" + URLEncoder.encode("false", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("format", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("road", "UTF-8"));
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
		//System.out.println(sb.toString());
		String result = sb.toString();
		JSONObject jObject = new JSONObject(result);
		//System.out.println("�����浵 : "+result);
		String status = jObject.getJSONObject("response").getString("status");
		if(status.equals("OK")) {
			JSONObject resp = jObject.getJSONObject("response").getJSONObject("result").getJSONObject("point");
			String lati = resp.getString("y");
			String longs = resp.getString("x");
			
			
			latlngvo.setLati(lati);
			latlngvo.setLongs(longs);
			//System.out.println(lati + ", " + longs);
			
			return latlngvo;
			
		}
		
		return null;

	}
	

	
	
	/** API
	 	���� �浵�� �ּҰ�������
	 */
	public String getAddress(SearchHomeVO latilongInfo) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException  {
		
		String latilng= latilongInfo.getLongs()+","+latilongInfo.getLati();
		
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
		//System.out.println(sb.toString());
		String result = sb.toString();
		JSONObject jObject = new JSONObject(result);
		String address = ((JSONObject) jObject.getJSONObject("response").getJSONArray("result").get(0)).getString("text");
		
		return address;
	}
	
	
	/**
	 * ���� ��ü 
	 */
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
	/**
	 * ���� �������� ���� ��ü ��ȸ
	 */
	public String getHomeData(String brtc, String sig, String page) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		StringBuilder urlBuilder = new StringBuilder("https://data.myhome.go.kr:443/rentalHouseList"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=wzVGH0RoH4TBmxGKJY4GBkDozdkN0n6aQcP6R3RFMGoyjFZzW6wLW5XW1ikRufIwVjTGMxqlOguEoEMgTQUqVw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("brtcCode","UTF-8") + "=" + URLEncoder.encode(brtc, "UTF-8")); /*�����õ� �ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("signguCode","UTF-8") + "=" + URLEncoder.encode(sig, "UTF-8")); /*�ñ��� �ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*��ȸ�� ����� �������� ������ ���� (�⺻��:10)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode( page, "UTF-8")); /*��ȸ�� �������� ��ȣ (�⺻��:1)*/
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
        //System.out.println(sb.toString());
        
        String result = sb.toString();
        
        return result;
	}
	
	



	

    
    
  

}
