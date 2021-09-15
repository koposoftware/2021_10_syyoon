package trash;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.hana.search.vo.BrtcSignguVO;


public class SearchDAOImpl2 {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;



	/**
	 * 지역, 시군구 코드 받기
	 */
	public BrtcSignguVO getBrtcSigCodeStatic(BrtcSignguVO brtcsig){
		BrtcSignguVO result = sqlSessionTemplate.selectOne("search.dao.SearchDAO.brtcSigCode", brtcsig);
		return result;
	}

	public List<String> getBrtcList() {
		List<String> result = sqlSessionTemplate.selectList("search.dao.SearchDAO.BrtcList");
		return result;
	}
	
}
