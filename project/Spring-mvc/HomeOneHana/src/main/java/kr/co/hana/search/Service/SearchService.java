package kr.co.hana.search.Service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import kr.co.hana.search.vo.BrtcSignguVO;
import kr.co.hana.search.vo.FavoriteVO;
import kr.co.hana.search.vo.SearchHomeVO;

public interface SearchService {

	List<SearchHomeVO> getHomeDetail(SearchHomeVO searchInfo);
	List<SearchHomeVO> getNearHomeAll(SearchHomeVO searchInfo, List<BrtcSignguVO> list);

	
	List<BrtcSignguVO> getCodeList(String rnadres);
	
	List<BrtcSignguVO> getBrtcSigCode(String[] spAddress);

	
	SearchHomeVO getLatiLongs(String rnadres)
			 throws IOException, ParserConfigurationException, SAXException, XPathExpressionException;
	String getAddress(SearchHomeVO latilongInfo) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException ;
	double distance(String latt1, String lont1, String latt2, String lont2, String unit);
	

	
	int addFavoriteHome(FavoriteVO favorite);
	int delFavoriteHome(FavoriteVO favorite);
	List<FavoriteVO> getFavoriteHome(String id);
	

}
