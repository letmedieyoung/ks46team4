package ks46team04.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funding")
public class UserFundingController {

	@GetMapping("/funding_index")
	public String fungdingMain() {
		
		return "funding/funding_index";	
	}
	
	@GetMapping("/funding_detail")
	public String fundingDetail() {
		
		return "funding/funding_detail";
	}
	
}
