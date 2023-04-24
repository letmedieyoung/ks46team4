package ks46team04.admin.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks46team04.admin.dto.FoundationName;
import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.mapper.FundingMapper;
import ks46team04.admin.service.FoundationService;
import ks46team04.admin.service.FundingService;

@Controller
@RequestMapping("/funding")
public class FundingController {
	
	
	private static final Logger log = LoggerFactory.getLogger(FundingController.class);


	private final FundingService fundingService;
	private final FundingMapper fundingMapper;
	private final FoundationService foundationService;
	

	public FundingController(FundingService fundingService,
							 FundingMapper fundingMapper,
							 FoundationService foundationService) {
		this.fundingService = fundingService;
		this.fundingMapper = fundingMapper;
		this.foundationService = foundationService;		
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
		
		return "redirect:/funding/manage";
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
		
		return "admin/funding/modifyFunding";
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
		
		return "admin/funding/manage";
	}			
	
	@PostMapping("/getSearchFundingList")
	@ResponseBody //http요청 body를 자바 객체로 전달받을 수 있다.
	public List<Funding> getSearchFundingList(@RequestBody Map<String, Object> searchMap){ //HTTP 요청 body를 Map객체로 전달받는다. 배열 Map에 검색 조건과 값들을 담는다. (key:String, value: 최상위 클래스 Object)
		Set<String> searchKey = searchMap.keySet(); // 
		List<Map<String, Object>> searchList = new ArrayList<>();
		for(String key : searchKey) {
			Map<String, Object> search = new HashMap<>();
			search.put("key", "f."+key);
			search.put("value", searchMap.get(key));
			searchList.add(search);			
		}
		
		List<Funding> searchFundingList = fundingMapper.getFundingList(searchList);
		
		return searchFundingList;
	}
	
	
	/**
	 * 펀딩 삭제
	 * @param fundingCode
	 * @return
	 */	
	@GetMapping("/deleteFunding")	
	public String deleteFunding(Funding funding) {
		
		fundingService.deleteFunding(funding);
		
		return "redirect:admin/funding/manage";
	}	
		
	
	/**
	 * 신규 펀딩 등록
	 * @param funding
	 * @return
	 */
	@PostMapping("/register") 
	public String registFunding(Funding funding) { 
		log.info("화면에서 전달받은 데이터 : {}", funding);
		fundingService.registFunding(funding);
		return "redirect:admin/funding/manage"; 
	}		
	
	@GetMapping("/register")
	public String registFunding(Model model){
	
		model.addAttribute("title", "registFunding");
		
		return "admin/funding/register";
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
		
		return "admin/funding/current_amount";
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
		
		return "admin/funding/payments";
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
		
		return "admin/funding/refund";
	}
	
	
	
}
