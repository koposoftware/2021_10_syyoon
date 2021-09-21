package kr.co.hana.chat.service;

import kr.co.hana.chat.vo.LoanInfoVO;

public interface ChatService {
	
	LoanInfoVO getLoanInfo(String loanname);

}
