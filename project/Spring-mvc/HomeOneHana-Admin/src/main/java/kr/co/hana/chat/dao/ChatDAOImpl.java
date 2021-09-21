package kr.co.hana.chat.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hana.chat.vo.LoanInfoVO;

@Repository
public class ChatDAOImpl implements ChatDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 대출금리가져오기
	 */
	public LoanInfoVO getLoanInfo(String loanname) {
		LoanInfoVO result = sqlSessionTemplate.selectOne("chat.dao.chatDAO.getLoanInfo",loanname);
		return result;
	}

}
