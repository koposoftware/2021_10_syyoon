package kr.co.hana.subscription.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubscriptionController {

	@GetMapping("/subscription")
	public String subscription() {
		
		return "subscription/subscription";
	}
	
}
