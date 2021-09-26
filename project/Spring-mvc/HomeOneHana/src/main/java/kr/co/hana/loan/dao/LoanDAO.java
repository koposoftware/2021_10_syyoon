package kr.co.hana.loan.dao;

import kr.co.hana.loan.vo.EnrollLoanVO;
import kr.co.hana.loan.vo.ReviewFileVO;
import kr.co.hana.mypage.vo.LoanContractVO;

public interface LoanDAO {
	void uploadFile(ReviewFileVO rfvo);
	void finishContractStatus(LoanContractVO loanvo);
	int contractLogProcedure(EnrollLoanVO enroll);
}
