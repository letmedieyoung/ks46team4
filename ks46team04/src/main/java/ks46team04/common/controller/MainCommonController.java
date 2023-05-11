package ks46team04.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.service.FundingDetailService;

@Controller
public class MainCommonController {

	private final FundingDetailService fundingDetailService;
	
	public MainCommonController(FundingDetailService fundingDetailService) {
		this.fundingDetailService = fundingDetailService;
	}
	
		@GetMapping("/")
		public String mainHome(Model model) {
			
			List<FundingDetail> fundingMainList = fundingDetailService.getFundingMainList();
			List<FundingDetail> fundingCompleteList = fundingDetailService.getFundingCompleteList();
			
			model.addAttribute("fundingMainList", fundingMainList);
			model.addAttribute("fundingCompleteList", fundingCompleteList);
			
			return "common/funding_index";
		}
}
