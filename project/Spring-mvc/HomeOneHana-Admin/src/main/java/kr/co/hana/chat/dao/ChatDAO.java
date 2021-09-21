package kr.co.hana.chat.dao;

import kr.co.hana.chat.vo.LoanInfoVO;

public interface ChatDAO {
	LoanInfoVO getLoanInfo(String loanname);
}
