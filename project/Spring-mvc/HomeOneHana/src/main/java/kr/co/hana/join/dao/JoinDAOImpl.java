package kr.co.hana.join.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDAOImpl implements JoinDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int userIdCheck(String userId) {		
		int result = sqlSessionTemplate.selectOne("join.dao.JoinDAO.userIdCheck", userId);
		return result;
	}

}
