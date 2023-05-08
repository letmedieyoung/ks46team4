package ks46team04.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ks46team04.admin.service.FundingProductService;



@Controller
@RequestMapping("common/funding/*")
public class FundingListController {
	
	@Autowired
	FundingProductService fundingProductService;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/common/funding/list");
		mav.addObject("list", fundingProductService.listFundingProduct());
		return mav;
	}

	
	
	@RequestMapping("/detail/{fundingCode}")
	public ModelAndView detail(@PathVariable("fundingCode") String fundingCode, ModelAndView mav) {
		mav.setViewName("/common/fundingDetail");
		mav.addObject("vo", fundingProductService.detailFunding(fundingCode));
		return mav;
	}
}

