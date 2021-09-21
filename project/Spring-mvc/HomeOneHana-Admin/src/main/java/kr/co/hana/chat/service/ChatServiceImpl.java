package kr.co.hana.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hana.chat.dao.ChatDAO;
import kr.co.hana.chat.vo.LoanInfoVO;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatDAO chatdao;
	
	public LoanInfoVO getLoanInfo(String loanname) {
		LoanInfoVO result = chatdao.getLoanInfo(loanname);
		return result;
	}

}
