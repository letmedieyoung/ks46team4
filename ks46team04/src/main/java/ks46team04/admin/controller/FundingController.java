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

import jakarta.servlet.http.HttpServletRequest;
import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.dto.Goods;
import ks46team04.admin.mapper.FundingMapper;
import ks46team04.admin.service.FundingService;


@Controller
@RequestMapping("/admin/funding")
public class FundingController {
	
	private static final Logger log = LoggerFactory.getLogger(FundingController.class);

	private final FundingService fundingService;
	private final FundingMapper fundingMapper;
	
	public FundingController(FundingService fundingService, FundingMapper fundingMapper) {
		this.fundingService = fundingService;
		this.fundingMapper = fundingMapper;	
	}
	
	
	/**
	 * 펀딩 삭제
	 * @param model
	 * @return
	 */	
	@PostMapping("/deleteFunding")	
	@ResponseBody
	public List<String> deleteFunding(@RequestParam(value="valueArr[]") List<String> valueArr) {

		log.info("valueArr: {}", valueArr);
		fundingService.deleteFunding(valueArr);
		
		return valueArr;
	}
		
	/**
	 * 펀딩 수정 처리 
	 * @param funding
	 * @return
	 */
	@PostMapping("/modifyFunding")
	public String modifyFunding(Funding funding) {
		log.info("funding: {}", funding);
		fundingService.modifyFunding(funding);
		
		return "redirect:/admin/funding/manage";
	}
	
	
	/**
	 * 펀딩 수정 화면
	 * @param fundingCode
	 * @param model
	 * @return
	 */
	@GetMapping("/modifyFunding")
	public String modifyFunding(Model model,
								@RequestParam(name="fundingCode") String fundingCode) {
		
		Funding fundingInfo = fundingService.getFundingInfoByCode(fundingCode);
		 
		log.info("fundingModify: {}", fundingInfo);

		List<Foundation> foundationNameList = fundingService.getFoundationNameList();
		List<Goods> goodsNameList = fundingService.getGoodsNameList();
		List<Goods> goodsCodeList = fundingService.getGoodsCodeList();
		List<Funding> fundingProgressList = fundingService.getFundingProgressList();
	
		model.addAttribute("title", "펀딩 정보 수정");	
		model.addAttribute("foundationNameList", foundationNameList);
		model.addAttribute("goodsNameList", goodsNameList);
		model.addAttribute("goodsCodeList", goodsCodeList);
		model.addAttribute("fundingProgressList", fundingProgressList);
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
			
		model.addAttribute("title", "펀딩 관리");
		model.addAttribute("fundingList", fundingList);
		
		return "admin/funding/manage";
	}			
	
	@PostMapping("/getSearchFundingList")
	@ResponseBody 
	public List<Funding> getSearchFundingList(@RequestBody Map<String, Object> searchMap){ 
		Set<String> searchKey = searchMap.keySet(); 
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
	 * 신규 펀딩 등록
	 * @param funding
	 * @return
	 */
	@PostMapping("/register") 
	public String registFunding(Funding funding,
								HttpServletRequest request) { 
		log.info("화면에서 전달받은 데이터 : {}", funding);	
		
		fundingService.registFunding(funding);
		return "redirect:/admin/funding/manage"; 
	}		
	
	@GetMapping("/register")
	public String registFunding(Model model){
		List<Foundation> foundationNameList = fundingService.getFoundationNameList();
		List<Goods> goodsNameList = fundingService.getGoodsNameList();
		List<Goods> goodsCodeList = fundingService.getGoodsCodeList();
	
		model.addAttribute("title", "신규펀딩등록");
		model.addAttribute("foundationNameList", foundationNameList);
		model.addAttribute("goodsNameList", goodsNameList);
		model.addAttribute("goodsCodeList", goodsCodeList);
		
		return "admin/funding/register";
	}

	
	
	
	/**
	 * 펀딩 컨텐츠 별 진행현황
	 * @param model
	 * @return
	 */
	@GetMapping("/current_amount")
	public String currentProgress(Model model) {	
		
		int targetSum = fundingMapper.getTargetSum();
		int currentSum = fundingMapper.sumOfCurrentAmount();
		int accomplishmentRate = fundingMapper.accomplishmentRate();
		
		model.addAttribute("title", "펀딩 컨텐츠 별 진행현황");
		model.addAttribute("content", "펀딩 컨텐츠 별 진행현황");
		model.addAttribute("targetSum", targetSum);
		model.addAttribute("currentSum", currentSum);
		model.addAttribute("accomplishmentRate", accomplishmentRate);
	    
	    return "admin/funding/current_amount";
	}
	


	
	
	/**
	 * 펀딩 결제내역 상세 확인 처리
	 * @param fundingPay
	 * @return
	 */
	@PostMapping("/detailFundingPay")
	public String detailFundingPay(FundingPay fundingPay) {		
		
		fundingMapper.detailFundingPay(fundingPay);
		
		return "redirect:/admin/funding/payments";
	}
	/**
	 * 펀딩 결제내역 상세 정보 화면
	 * @param fundingPayCode
	 * @param model
	 * @return
	 */
	@GetMapping("/detailFundingPay")
	public String detailFundingPay(@RequestParam(name="fundingPayCode") String fundingPayCode, Model model) {
		
		FundingPay fundingPayInfo = fundingService.getFundingPayInfoByCode(fundingPayCode);		
		
		model.addAttribute("title", "펀딩 결제내역 상세정보");		
		model.addAttribute("fundingPayInfo", fundingPayInfo);		
		
		return "admin/funding/detailFundingPay";
	}	
	/**
	 * 펀딩 결제내역 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/payments")
	public String payments(Model model){
		List<FundingPay> fundingPayList = fundingService.getFundingPayList();
		log.info("fundingPayList_Service: {}", fundingPayList);
		model.addAttribute("title", "펀딩 결제내역");
		model.addAttribute("fundingPayList", fundingPayList);
		
		return "admin/funding/payments";
	}
	
	
	
	/**
	 * 환불내역 수정 처리
	 * @param fundingRefund
	 * @return
	 */
	@PostMapping("/modifyFundingRefund")
	public String modifyFundingRefund(FundingRefund FundingRefund) {		
		
		log.info("funding: {}", FundingRefund);
		fundingMapper.modifyFundingRefund(FundingRefund);		
		
		return "redirect:/admin/funding/refund";
	}
	
	/**
	 * 펀딩 환불내역 수정화면
	 * @param fundingRefundCode
	 * @param model
	 * @return
	 */
	@GetMapping("/modifyFundingRefund")
	public String modifyFundingRefund(@RequestParam(name="fundingRefundCode") String fundingRefundCode, Model model) {
						
		FundingRefund fundingRefundInfo = fundingService.getFundingRefundInfoByCode(fundingRefundCode);	
		List<FundingRefund> refundStatusList = fundingService.getRefundStatusList();
		
		model.addAttribute("title", "펀딩 환불내역 수정");
		model.addAttribute("refundStatusList", refundStatusList);
		model.addAttribute("fundingRefundInfo", fundingRefundInfo);
		
		return "admin/funding/modifyFundingRefund";
	}
	/**
	 * 버튼으로 환불 처리
	 * @param refundArr
	 */
	@PostMapping("/updateFundingRefundStatus")
	@ResponseBody
	public List<String> updateFundingRefundStatus(@RequestParam(value="refundArr[]") List<String> refundArr) {
	    log.info("refundArr: {}", refundArr);
	    String refundStatus = "환불완료";
	    for(String fundingRefundCode : refundArr) {
	        fundingService.updateFundingRefundStatus(fundingRefundCode, refundStatus);
	    }
	    return refundArr;
	}
	
	/**
	 * 펀딩 환불 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/refund")
	public String refund(Model model) {
		List<FundingRefund> refundList = fundingService.getRefundList();
		model.addAttribute("title", "펀딩 환불관리");
		model.addAttribute("refundList", refundList);		
		
		return "admin/funding/refund";
	}
	/**
	 * 펀딩 환불 목록 검색
	 * @param searchMap 검색 조건이 담긴 Map 객체
	 * @return 검색된 결과를 담은 List 객체
	 */
	@PostMapping("/refund")
	@ResponseBody
	public List<FundingRefund> getSearchRefundList(@RequestBody Map<String, Object> searchMap){ 
		Set<String> searchKey = searchMap.keySet(); 
		List<Map<String, Object>> searchList = new ArrayList<>();
		for(String key : searchKey) {
			Map<String, Object> search = new HashMap<>();
			search.put("key", "fr."+key);
			search.put("value", searchMap.get(key));
			searchList.add(search);			
		}
		
		List<FundingRefund> getSearchRefundList = fundingMapper.getRefundList(searchList);		
		return getSearchRefundList;
	}
}
