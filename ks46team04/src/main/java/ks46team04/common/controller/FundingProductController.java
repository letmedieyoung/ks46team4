package ks46team04.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ks46team04.admin.service.FundingProductService;




@Controller
@RequestMapping("/common/detail")
public class FundingProductController {
	
	@Autowired
	FundingProductService fundingProductService;
	
	@GetMapping("/funding1")
	public String funding1(Model model) {
		
		return "common/detail/funding1";
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/common/funding/list");
		mav.addObject("list", fundingProductService.listFundingProduct());
		return mav;
	}
	

}