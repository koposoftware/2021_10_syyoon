package kr.co.hana.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanController {
	@GetMapping("/loan")
	public String loanMain() {
		System.out.println("대출신청페이지(관리자)");
		return "loan/loanForm";
	}
}
