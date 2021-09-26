package kr.co.hana.mypage.dao;

import java.util.List;

import kr.co.hana.loan.vo.EnrollLoanVO;
import kr.co.hana.mypage.vo.AccountVO;
import kr.co.hana.mypage.vo.LoanContractVO;
import kr.co.hana.schedule.vo.FavoriteScheduleVO;

public interface MypageDAO {
	
	List<FavoriteScheduleVO> getAllFavoriteNoti(String id);
	List<LoanContractVO> getContract(String id);
	List<AccountVO> getAccount(String id);
	EnrollLoanVO getContractInfo(int contractcode);
	List<AccountVO> getLoanAccount(String id);
}
