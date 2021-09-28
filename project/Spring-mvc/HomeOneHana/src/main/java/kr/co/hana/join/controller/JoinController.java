package kr.co.hana.join.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hana.join.Service.JoinService;
import kr.co.hana.join.vo.JoinVO;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	@GetMapping("/signup")
	public String signup(){
		//System.out.println("회원가입동의");
		return "join/signup";
	}
	

	
	@GetMapping("/join")
	public String join() {
		//System.out.println("회원가입폼");
		return "join/joinForm";
	}
	
	@PostMapping("/join")
	public String joinInsert(JoinVO joinVO) {
		return "join/joinForm";
	}
	
	
	@ResponseBody
	@PostMapping("/join/idCheck")
	public int idCheck(String userId) {
		int cnt = joinService.userIdCheck(userId);	
		return cnt;
	}

	
	@ResponseBody
	@GetMapping("/check/sendSMS/{phoneNumber}")
    public String sendSMS(@PathVariable("phoneNumber") String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        //System.out.println("입력전화번호: " + phoneNumber);
        //System.out.println("랜덤숫자 : " + numStr);
        //joinService.certifiedPhoneNumber(phoneNumber,numStr);
        return "0000";
    }
	
	
	
	
	
	
}
