package kr.co.hana.dashboard.service;

import java.util.List;
import java.util.Map;

import kr.co.hana.dashboard.vo.UserDashBoardVO;

public interface DashboardService {
	
	List<UserDashBoardVO> getUsers(String managerid);
	Map<String, Integer> getUserCnt(String managerid);

}
