package ks46team04.common.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.mapper.FundingMapper;
import ks46team04.admin.service.FundingDetailService;
import ks46team04.admin.service.FundingService;


@Controller
@RequestMapping("/common/detail")
public class FundingDetailController {

	private final FundingDetailService fundingDetailService; 
	private final FundingService fundingService; 
	private final FundingMapper fundingMapper;
	
	public FundingDetailController(FundingDetailService fundingDetailService,
								   FundingService fundingService,
								   FundingMapper fundingMapper) {
		this.fundingDetailService = fundingDetailService;
		this.fundingService = fundingService;
		this.fundingMapper = fundingMapper;
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
		String accomplishmentRate = fundingMapper.accomplishmentRate();
		
		model.addAttribute("fundingDetail", fundingDetail);
		model.addAttribute("fundingDetailList", fundingDetailList);
		model.addAttribute("fundingDetail", fundingDetail);
		model.addAttribute("accomplishmentRate", accomplishmentRate);
		return "common/detail/fundingdetail";
	}
	
	
	@RequestMapping("/list")
	public String fundingDetail(Model model) {
		List<Funding> fundingList = fundingService.getFundingList();
		String accomplishmentRate = fundingMapper.accomplishmentRate();
		
		model.addAttribute("title", "펀딩");
		model.addAttribute("fundingList", fundingList);
		model.addAttribute("accomplishmentRate", accomplishmentRate);
		
		return "common/funding/list";
	}
	
	
	
}


	