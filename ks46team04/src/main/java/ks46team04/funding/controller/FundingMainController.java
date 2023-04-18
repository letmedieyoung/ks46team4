package ks46team04.funding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funding")
public class FundingMainController {

	@GetMapping("funding_index")
	public String fungdingMain() {
		
		return "funding/funding_index";	
	}
	
	
}
