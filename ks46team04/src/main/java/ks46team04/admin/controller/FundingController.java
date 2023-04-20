package ks46team04.admin.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.mapper.FundingMapper;
import ks46team04.admin.service.FundingService;

@Controller
@RequestMapping("/funding")
public class FundingController {
	
	
	private static final Logger log = LoggerFactory.getLogger(FundingController.class);


	private final FundingService fundingService;
	private final FundingMapper fundingMapper;
	

	public FundingController(FundingService fundingService, FundingMapper fundingMapper) {
		this.fundingService = fundingService;
		this.fundingMapper = fundingMapper;
	}
	
	@GetMapping("/home")
	public String fundinghome(Model model) {
		
		model.addAttribute("title", "home");
		model.addAttribute("content", "펀딩진열페이지");
		
		return "view/funding/home";
	}
	
	
	/**
	 * 펀딩 정보 수정
	 * @param funding
	 * @return
	 */
	@PostMapping("/modifyFunding")
	public String modifyFunding(Funding funding) {
		log.info("funding: {}", funding);
		fundingMapper.modifyFunding(funding);
		
		return "redirect:view/funding/fundingList";
	}	
	
	/**
	 * 펀딩수정화면
	 * @param fundingCode
	 * @param model
	 * @return
	 */
	@GetMapping("/modifyFunding")
	public String modifyFunding(@RequestParam(name="fundingCode") String fundingCode, Model model) {
		Funding fundingInfo = fundingService.getFundingInfoByCode(fundingCode);
		
		log.info("fundingModify: {}", fundingInfo);		
		
		model.addAttribute("title", "펀딩수정");	
		model.addAttribute("fundingInfo", fundingInfo);
		
		return "view/funding/modifyFunding";
	}
	
	/**
	 * 펀딩 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/manage")
	
	public String getFundingList(Model model) {			
		List<Funding> fundingList = fundingService.getFundingList();
		
		log.info("fundingList: {}", fundingList);
			
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
		List<FundingPay> fundingPayList = fundingService.getFundingPayList();
		log.info("fundingPayList_Service: {}", fundingPayList);
		model.addAttribute("title", "funding_payments");
		model.addAttribute("fundingPayList", fundingPayList);
		
		return "view/funding/payments";
	}
	
	/**
	 * 펀딩 환불 관리
	 * @param model
	 * @return
	 */
	@GetMapping("/refund")
	public String refund(Model model){
		List<FundingRefund> refundList = fundingService.getFundingRefundList();
		log.info("refundList_Service: {}", refundList);
		model.addAttribute("title", "refund");
		model.addAttribute("refundList", refundList);
		
		return "view/funding/refund";
	}
	
	
	
}
