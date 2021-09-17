package kr.co.hana.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hana.login.dao.LoginDAO;
import kr.co.hana.login.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;
	
	public LoginVO login(LoginVO loginvo) {
		LoginVO loginVO = loginDAO.login(loginvo);
		return loginVO;
	}
	

}