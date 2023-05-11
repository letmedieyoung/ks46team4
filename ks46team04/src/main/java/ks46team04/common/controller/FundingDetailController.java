package ks46team04.common.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.service.FundingDetailService;


@Controller
@RequestMapping("/common/detail")
public class FundingDetailController {

	private final FundingDetailService fundingDetailService; 
	
	public FundingDetailController(FundingDetailService fundingDetailService) {
		this.fundingDetailService = fundingDetailService;
	}
	
	/**
	 * 펀딩 상세 페이지
	 * @param fundingCode
	 * @param model
	 * @return
	 */
	@GetMapping("/fundingView")
	public String fundingView(@RequestParam(name="fundingCode") String fundingCode
							 ,Model model) {
		
		List<FundingDetail> fundingDetailList = fundingDetailService.getFundingDetailList();
		FundingDetail fundingDetail = fundingDetailService.getFundingDetailByCode(fundingCode);
		
		model.addAttribute("fundingDetail", fundingDetail);
		model.addAttribute("fundingDetailList", fundingDetailList);
		model.addAttribute("fundingDetail", fundingDetail);
		
		return "common/detail/fundingdetail";
	}
	
	
	@RequestMapping("/list")
	public String fundingDetail(Model model) {
		List<FundingDetail> fundingDetailList = fundingDetailService.getFundingDetailList();
		
		model.addAttribute("title", "펀딩");
		model.addAttribute("fundingDetailList", fundingDetailList);
		
		return "common/funding/list";
	}
	
	
	
}


	