package trash;

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
import org.xml.sax.SAXException;

import kr.co.hana.search.dao.SearchDAO;
import kr.co.hana.search.vo.BrtcSignguVO;
import kr.co.hana.search.vo.SearchHomeVO;


public class SearchServiceImpl2 {
	

	private SearchDAO searchdao;
	
	

	/**
	 근처 주택 구하기
	 * @throws JsonProcessingException 
	
	public List<SearchVO> nearHome(SearchVO searchone) throws JsonProcessingException {
		List<SearchVO> allst = searchdao.searchAll();
		String homeS = searchone.getRnadres();
		double homeSLati = Double.parseDouble(searchone.getLati());
		double homeSLong = Double.parseDouble(searchone.getLongs());
		
		List<SearchVO> nearList = new ArrayList<SearchVO>();
		for (int i = 0; i<allst.size(); i++) {
			SearchVO home = allst.get(i);
			String homeN = home.getRnadres();
			double homeNLati = Double.parseDouble(home.getLati());
			double homeNLong = Double.parseDouble(home.getLongs());
			double dist = 
		            distance(homeSLati, homeSLong, homeNLati, homeNLong, "meter");
			
			if(dist<800) {
				if(!homeS.equals(homeN)) {
					nearList.add(home);					
				}
			}
		}
		return nearList;
	}
	 */
	
	/**
	 * 지도에 보여줄 중복없는 주택 위치정보리스트 
	 * @param searchInfo 주소창에 검색한 주소
	 * @param list // 주소창에 검색한 주소의 시군구 코드리스트
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws XPathExpressionException
	 */
	public List<SearchHomeVO> getNearHomeAll(SearchHomeVO searchInfo, List<BrtcSignguVO> list)  throws IOException, ParserConfigurationException, SAXException, XPathExpressionException{
		//1. 주택 주소끼리 중복 제거하기 위해 Set에 담기
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
							//System.out.println("주우태액 : "+home.get("houseTyNm").toString());
							SearchHomeVO info = new SearchHomeVO();
							info.setRnadres(home.getString("rnAdres")); //도로명주소
							info.setInsttnm(home.getString("insttNm")); // 공급기관
							info.setSuplytynm(home.getString("suplyTyNm")); // 공급유형
							info.setBrtccode(home.getInt("brtcCode")); // 지역코드
							info.setBrtcnm(home.getString("brtcNm")); // 지역명
							info.setSigngucode(home.getInt("signguCode")); // 시군구코드
							info.setSigngunm(home.getString("signguNm")); // 시군구명

							info.setHousetynm(home.get("houseTyNm").toString()); // 주택유형(오피스텔,...)								

							nearHome.put(home.getString("rnAdres"), info);
						
						}
					}
				}
			}
		}
		
		//2. 중복없는 주소의 위도 경도 반환
		Set<String> keySet = nearHome.keySet();
		//System.out.println("keySet 크기 : "+keySet.size());
		List<SearchHomeVO> result = new ArrayList<SearchHomeVO>();
		for(String key: keySet) {
			SearchHomeVO homeI = nearHome.get(key);
			SearchHomeVO latlng = getLatiLongs(homeI.getRnadres());
			if(latlng != null) { // 위도경도가 나올때만
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
	 * 선택한 주택 상세정보.
	 */
	public List<SearchHomeVO> getHomeDetail(SearchHomeVO searchInfo, List<BrtcSignguVO> list) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		
		String searchAddress = searchInfo.getRnadres();
		List<SearchHomeVO> homeDetail = new ArrayList<SearchHomeVO>();
		
		for(int i = 0; i<list.size(); i++) {		
			String brtc = Integer.toString(list.get(i).getBrtccode());
			String sig = Integer.toString(list.get(i).getSigngucode());
			
			int total = getTotalCnt(brtc, sig,"1");
			int page = (total/100)+1; // page수계산
			if(total !=0) { // 해당 지역의 주택 전체 개수가 0이 아니면
				for(int p=1; p<page+1; p++) {
					String result = getHomeData(brtc, sig, Integer.toString(p));
					JSONObject jObject = new JSONObject(result);
					JSONArray jArray = jObject.getJSONArray("hsmpList");
					for(int l = 0; l<jArray.length()-1; l++) {
						JSONObject home = (JSONObject) jArray.get(l);
						String rnadres = home.getString("rnAdres");
						
						if(searchAddress.equals(rnadres)) { // 검색한 주소가 조회중인 주소랑 같으면 긁기
							SearchHomeVO info = new SearchHomeVO();
							
							info.setRnadres(home.getString("rnAdres"));   // 주소
							info.setInsttnm(home.getString("insttNm"));	  // 공급기관
							info.setSuplytynm(home.getString("suplyTyNm")); // 공급유형
							
							info.setCompetde(home.get("competDe").toString()); // 준공일
							info.setHousetynm(home.get("houseTyNm").toString()); // 건물유형
							info.setHshldco(home.getInt("hshldCo")); // 세대수
							info.setSuplyprevusear(home.get("suplyPrvuseAr").toString()); //공급전용면적
							info.setSuplycmnusear(home.get("suplyCmnuseAr").toString());  // 공급공용면적
							info.setStylenm(home.getString("styleNm")); // 형명
							info.setParkngco(home.getInt("parkngCo"));  // 주차수
							info.setBuldstlenm(home.get("buldStleNm").toString()); // 건물형태
							info.setHeatmthddetailnm(home.get("heatMthdDetailNm").toString()); //난방
							info.setElvtrlnstlatnm(home.get("elvtrInstlAtNm").toString());// 승강기설치
							info.setBassrentgtn(home.getInt("bassRentGtn")); // 기본임대보증금
							info.setBassmtrntchrg(home.getInt("bassMtRntchrg")); // 기본 월임대료
							info.setBasscnvrsgtnlmt(home.getInt("bassMtRntchrg")); // 기본 전환보증금
							
							homeDetail.add(info);
						}
					}

				}
			}

		}
		return homeDetail;
	}	
	
	
	/**
	 * 일치하는 지역 코드 가져오기
	 */
	public List<BrtcSignguVO> getBrtcSigCode(String[] spAddress) {
		
		List<String> brtcList = searchdao.getBrtcList();
		List<BrtcSignguVO> codeList = new ArrayList<BrtcSignguVO>();
		
		if(brtcList.contains(spAddress[0])) {
			// 지역으로 시작하는 주소일때
			BrtcSignguVO searchBrtc = new BrtcSignguVO();
			searchBrtc.setBrtcnm(spAddress[0]);
			searchBrtc.setSigngunm(spAddress[1]);
			BrtcSignguVO selectOne = searchdao.getBrtcSigCode(searchBrtc);
			codeList.add(selectOne);
			if(selectOne != null) { //값이 나오면
				searchBrtc.setSigngunm(spAddress[1]+" "+spAddress[2]); // 뒤에주소도 붙여서 비교해보기
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
	 거리구하기
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
	 * 주소로 위,경도 가져오기
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
		//System.out.println("위도경도 : "+result);
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
	 	위도 경도로 주소가져오기
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
	 * 지역 전체 
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
	 * 같은 지역내의 주택 전체 조회
	 */
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
