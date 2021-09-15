package trash;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import kr.co.hana.search.Service.SearchService;
import kr.co.hana.search.vo.BrtcSignguVO;
import kr.co.hana.search.vo.SearchHomeVO;


public class SearchController2 {
	
	@Autowired
	private SearchService searchservice;

	
	@GetMapping("/search")
	public String searchHome(Model model){
		System.out.println("쥬택메인");
		return "search/searchHome";
	}
	
	/*
	@PostMapping("/search")
	public String searchHomeProcess(String rnadres, Model model) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		Gson gson = new Gson();
		SearchHomeVO searchvo = searchservice.getLatiLongs(rnadres); 
		searchvo.setRnadres(rnadres);
		
		String searchvostring = gson.toJson(searchvo);
		model.addAttribute("searchvo", searchvostring);
		model.addAttribute("addr", rnadres);
		
		SearchVO searchone = searchservice.searchOne(rnadres);
		List<SearchVO> nearhomelist = new ArrayList<SearchVO>();
		
		if(searchone != null) { 
			nearhomelist = searchservice.nearHome(searchone);
			model.addAttribute("homelist", nearhomelist);

			
		    String json = gson.toJson(searchone);
			model.addAttribute("addrInfo", json); 

		}else { 
			model.addAttribute("addrInfo", null);
			//nearhomelist = searchservice.nearHome(searchvo);
			//model.addAttribute("homelist", nearhomelist);
		}
		return "search/searchHome";
	}
	*/
	

	@GetMapping("/search/address")
	public String searchAddress(String rnadres, Model model) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		
		Gson gson = new Gson();
		System.out.println(rnadres);
		model.addAttribute("addr",rnadres);
		
		//검색한 주소정보로 위도경도 구하기
		SearchHomeVO searchInfo = searchservice.getLatiLongs(rnadres);
		
		if(searchInfo != null) { // 좌표가 있는 주소 일때
			searchInfo.setRnadres(rnadres);
			String json = gson.toJson(searchInfo);
			model.addAttribute("searchvo",json);
			
			String[] spAddress = rnadres.split(" ");
			List<BrtcSignguVO> codeList = searchservice.getBrtcSigCode(spAddress);
			
			if(codeList == null) {// 좌표는 나오는데 주소가 아니면 도로명주소 다시검색해서 반환후 시군구코드로 변환
				String address = searchservice.getAddress(searchInfo);
				
				String[] spaddress = address.split(" ");
				codeList = searchservice.getBrtcSigCode(spaddress);
			}

			List<SearchHomeVO> nearHomeA = searchservice.getNearHomeAll(searchInfo, codeList);
			System.out.println(nearHomeA.size());
			if( nearHomeA.size() == 0) {
				//근처에 주택없음
				model.addAttribute("msg","주택이 존재하지 않습니다.");
				model.addAttribute("nearHome", null);
			}else {
				model.addAttribute("msg",null);
				model.addAttribute("nearHome", nearHomeA); 				
			}

		}else {
			//주소가 없으면
			System.out.println("주소없엉!");
			model.addAttribute("msg","유효하지 않은 주소입니다.");
			model.addAttribute("searchvo", null);
			model.addAttribute("nearHome", null); 
		}
		
		return "search/searchHome";
	}
	
	
	@GetMapping("/search/Detail/{rnadres}")
	public String searchHome(@PathVariable("rnadres") String rnadres, Model model) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException{
		System.out.println("쥬택상세 : "+rnadres);
		
		Gson gson = new Gson();

		//검색한 주소정보로 위도경도 구하기
		SearchHomeVO searchInfo = searchservice.getLatiLongs(rnadres);
		searchInfo.setRnadres(rnadres);
		String json = gson.toJson(searchInfo);
		model.addAttribute("searchvo",searchInfo);
		model.addAttribute("searchjson",json);
		
		String[] spAddress = rnadres.split(" ");
		List<BrtcSignguVO> codeList = searchservice.getBrtcSigCode(spAddress);
		List<SearchHomeVO> homeDetail = searchservice.getHomeDetail(searchInfo);
		
		model.addAttribute("homeDetail",homeDetail);

		return "search/searchHomeDetail";
	}
	
	
}
