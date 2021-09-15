package hana.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.hana.join.vo.JoinVO;
import kr.co.hana.search.vo.BrtcSignguVO;
import kr.co.hana.search.vo.SearchHomeVO;
import kr.co.hana.search.vo.SearchVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class DAOtest {
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Test
	public void getLatLngDB() {
		Set<String> set = new HashSet<String>();
		set.add("서울특별시 동대문구 답십리로64길 85-3");
		set.add("서울특별시 동대문구 무학로20길 22");
		set.add("서울특별시 동대문구 무학로20길 22");
		set.add("서울특별시 동대문구 무학로20길 22");
		set.add("0");
		
		List<String> adList= new ArrayList<String>(set);

		System.out.println(adList.toString());

		
		List<SearchHomeVO> addrslatlng = sqlSessionTemplate.selectList("search.dao.SearchDAO.getLatLng", adList);
		System.out.println(addrslatlng.size());
	}
	
	@Ignore
	@Test
	public void getHomeDetail() {
		List<SearchHomeVO> lst = sqlSessionTemplate.selectList("search.dao.SearchDAO.getHomeDetail", "경기도 광명시 오리로963번길 43");
		System.out.println(lst);
	}
	
	
	@Ignore
	@Test
	public void getHomeList() {
		BrtcSignguVO b = new BrtcSignguVO();
		b.setBrtccode(11);
		b.setSigngucode(110);
		List<SearchHomeVO> lst = sqlSessionTemplate.selectList("search.dao.SearchDAO.getHomelist", b);
		System.out.println(lst.get(0).getRnadres());
		
	}
	
	
	
	@Ignore
	@Test
	public void login() {
		
		int loginVO = sqlSessionTemplate.selectOne("join.dao.JoinDAO.userIdCheck", "aaaa");
		System.out.println("dfdsfdsfdsf"+loginVO);
	}
	
	
	@Ignore
	@Test
	public void joinInsert() {
		JoinVO joinVO = new JoinVO();
		joinVO.setId("abcedfs");
		joinVO.setPassword("aaa");
		joinVO.setName("");
		joinVO.setEmail("abcd@naver.com");
		joinVO.setAddr1("");
		joinVO.setAddr2("");
		System.out.println(joinVO);
		int res = sqlSessionTemplate.insert("join.dao.JoinDAO.joinInsert",joinVO);
		System.out.println(res);

	}
	
	@Ignore
	@Test
	public void searchAll() {
		List<SearchVO> allst = new ArrayList<SearchVO>();
		allst = sqlSessionTemplate.selectList("search.dao.SearchDAO.searchAll");

		
		for( int i = 0 ; i<10; i++) {
			String longs = allst.get(i).getLongs();
			String lati = allst.get(i).getLati();
			System.out.println(lati+" , "+longs);
		}
		
	}
	
	@Ignore
	@Test
	public void searchOne() {
		SearchVO allst = new SearchVO();
		String rnadres = "";
		allst = sqlSessionTemplate.selectOne("search.dao.SearchDAO.searchOne", rnadres);
		System.out.println(allst);

		System.out.println(allst);
	}
	
	@Ignore
	@Test 
	public void brtcSig() {
		BrtcSignguVO brtc = new BrtcSignguVO();
		brtc.setBrtcnm("경기도");
		brtc.setSigngunm("용인시");
		
		List<BrtcSignguVO> res = sqlSessionTemplate.selectList("search.dao.SearchDAO.searchBrtcSigungu",brtc);
		System.out.println(res);
	
	}
	@Ignore
	@Test
	public void brtcsigall() {
		List<String> result = sqlSessionTemplate.selectList("search.dao.SearchDAO.searchBrtcSigunguAll");
		for(int i=0; i<10; i++) {
			System.out.println(result.get(i));
		}
	}
	

}
