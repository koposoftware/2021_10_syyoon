package kr.co.hana.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hana.login.service.LoginService;
import kr.co.hana.login.vo.LoginVO;

@Controller
public class MainController {
	
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/main")
	public String homeLogin(LoginVO login, Model model, HttpSession session) {
		System.out.println(login.toString());
		LoginVO loginVO = loginService.login(login);
		
		String msg = "";
		if(loginVO ==null) {
			//로그인실패시 화면
			msg = "유효하지 않은 정보입니다.";
			model.addAttribute("msg",msg);
			return "index";
			
		}else {
			session.setAttribute("loginVO", loginVO);
			LoginVO lg = (LoginVO) session.getAttribute("loginVO");
			model.addAttribute("loginVO", loginVO);
			System.out.println("세션등록완료 : "+lg.toString());
			return "main/main";			
		}
		
	}
	
	
	@GetMapping("/main")
	public String dashMain(HttpSession session, Model model) {
		System.out.println("대쉬보드메인");
		
		return "main/main";
	}
}