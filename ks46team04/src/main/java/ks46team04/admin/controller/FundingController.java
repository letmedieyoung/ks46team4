package ks46team04.admin.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.service.FundingService;

@Controller
@RequestMapping("/funding")
public class FundingController {
	
	private final FundingService fundingService;
	

	public FundingController(FundingService fundingService) {
		this.fundingService = fundingService;
	}
	
	@GetMapping("/home")
	public String fundinghome(Model model) {
		
		model.addAttribute("title", "home");
		model.addAttribute("content", "펀딩진열페이지");
		
		return "view/funding/home";
	}
	
	
	/**
	 * 펀딩 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/manage")
	public String getFundingList(Model model) {			
		List<Funding> fundingList = fundingService.getFundingList();
		
		model.addAttribute("title", "펀딩목록조회");
		model.addAttribute("fundingList", fundingList);
		
		return "view/funding/manage";
	}
	
	/**
	 * 신규 펀딩 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/register")
	public String exam1(Model model){
	
		model.addAttribute("title", "register");
		model.addAttribute("content", "펀딩 등록");
		
		return "view/funding/register";
	}
	
	/**
	 * 펀딩 컨텐츠 별 진행현황
	 * @param model
	 * @return
	 */
	@GetMapping("/current_amount")
	public String exam2(Model model){
	
		model.addAttribute("title", "current_amount");
		model.addAttribute("content", "컨텐츠 별 진행 현황");
		
		return "view/funding/current_amount";
	}
	
	/**
	 * 펀딩 결제 내역
	 * @param model
	 * @return
	 */
	@GetMapping("/payments")
	public String payments(Model model){
	
		model.addAttribute("title", "funding_payments");
		model.addAttribute("content", "결제 내역");
		
		return "view/funding/payments";
	}
	
	/**
	 * 펀딩 환불 관리
	 * @param model
	 * @return
	 */
	@GetMapping("/refund")
	public String exam4(Model model){
	
		model.addAttribute("title", "refund");
		model.addAttribute("content", "환불 관리");
		
		return "view/funding/refund";
	}
	
	
	
}
