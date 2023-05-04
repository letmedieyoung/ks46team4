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

import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.DonationMonthPay;
import ks46team04.admin.dto.DonationCode;
import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.DonationPayMethod;
import ks46team04.admin.dto.DonationPayMethodCode;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.dto.DonationSubCode;
import ks46team04.admin.dto.PaymentCode;
import ks46team04.admin.dto.DonationRefund;
import ks46team04.admin.service.DonationService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/donation")
@AllArgsConstructor
public class DonationController {
		
	private final DonationService donationService;
	
	/*
	 * 정기기부 단가 조회
	 */
	@GetMapping("/donation_list")
	public String getDonation(Model model, @RequestParam(name="searchKey", required = false) String searchKey
										, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<Donation> getDonation = donationService.getDonation(searchKey, searchValue);
				
		model.addAttribute("title", "정기기부 단가 목록");
		model.addAttribute("getDonation", getDonation);
		
		return "admin/donation/donation_list";
	}

	/*
	 * 정기기부 단가 등록
	*/
	@PostMapping("/donation_add")
	public String addDonation(Donation donation) {
	
	donationService.addDonation(donation);
	
	return "redirect:/admin/donation/donation_list";
	
		}
	
	@GetMapping("/donation_add")
	public String addDonation(Model model) {
		
		model.addAttribute("title", "정기기부 단가 등록");

		return "/admin/donation/donation_add";
	}
	
	/*
	 * 정기기부 단가 수정
	 */
	@PostMapping("/donation_modify")
	public String modifyDonation(Donation donation) {
		
		donationService.modifyDonation(donation);
		
		return "redirect:/admin/donation/donation_list";
	}
	
	@GetMapping("/donation_modify")
	public String modifyDonation(Model model
							 ,@RequestParam(name="donationCode") String donationCode) {
		
		Donation donationInfo = donationService.getDonationInfoByCode(donationCode);
		
		model.addAttribute("title", "정기기부 단가 수정");
		model.addAttribute("donationInfo", donationInfo);
		
		return "admin/donation/donation_modify";
	}
	
	/*
	 * 정기기부 단가 삭제
	 * */
	@GetMapping("/donation_remove")
	public String removeDonation(Donation donation) {
		donationService.removeDonation(donation);
		return "redirect:/admin/donation/donation_list";
	}
	
	/*
	 * 등록된 회원 결제수단 조회
	 */
	@GetMapping("/donationPayMethod_list")
	public String getDonationPayMethod(Model model, @RequestParam(name="searchKey", required = false) String searchKey
												, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<DonationPayMethod> getDonationPayMethod = donationService.getDonationPayMethod(searchKey, searchValue);
		
		model.addAttribute("title", "등록된 회원 결제수단 목록");
		model.addAttribute("getDonationPayMethod", getDonationPayMethod);
		
		return "admin/donation/donationPayMethod_list";
	}
	
	/*
	 * 등록된 회원 결제수단 등록
	 */
	@PostMapping("/donationPayMethod_add")
	public String addDonationPayMethod(DonationPayMethod donationPayMethod) {
	
	donationService.addDonationPayMethod(donationPayMethod);
	
	return "redirect:/admin/donation/donationPayMethod_list";
	
		}
	
	@GetMapping("/donationPayMethod_add")
	public String addDonationPayMethod(Model model) {
		
		model.addAttribute("title", "등록된 회원 결제수단 등록");
		
		return "/admin/donation/donationPayMethod_add";
	}
	
	/*
	 * 등록된 회원 결제수단 수정
	 */
	@PostMapping("/donationPayMethod_modify")
	public String modifyDonationPayMethod(DonationPayMethod donationPayMethod) {
		
		donationService.modifyDonationPayMethod(donationPayMethod);
		
		return "redirect:/admin/donation/donationPayMethod_list";
	}
	@GetMapping("/donationPayMethod_modify")
	public String modifyDonationPayMethod(Model model, @RequestParam(name="donationPayMethodCode") String donationPayMethodCode){
		
		DonationPayMethod donationPayMethodInfo = donationService.getDonationPayMethodInfoByCode(donationPayMethodCode);

		model.addAttribute("title", "등록된 회원 결제수단 수정");
		model.addAttribute("donationPayMethodInfo", donationPayMethodInfo);
		
		return "admin/donation/donationPayMethod_modify";
	}
	
	/*
	 * 등록된 회원 결제수단 삭제
	 * */
	@GetMapping("/donationPayMethod_remove")
	public String removeDonationPayMethod(DonationPayMethod donationPayMethod) {
		donationService.removeDonationPayMethod(donationPayMethod);
		return "redirect:/admin/donation/donationPayMethod_list";
	}
	
	/* 정기기부 구독 신청 조회
	 * 
	 */
	@GetMapping("/donationSub_list")
	public String getDonationSub(Model model, @RequestParam(name="searchKey", required = false) String searchKey
											, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<DonationSub> getDonationSub = donationService.getDonationSub(searchKey, searchValue);
		
		model.addAttribute("title", "정기기부 구독 신청 목록");
		model.addAttribute("getDonationSub", getDonationSub);
		
		return "admin/donation/donationSub_list";
	}
	
	/*
	 * 정기기부 구독 신청 등록
	 */
	@PostMapping("/donationSub_add")
	public String addDonationSub(DonationSub donationSub) {
	
	donationService.addDonationSub(donationSub);
	
	return "redirect:/admin/donation/donationSub_list";
	
		}
	
	@GetMapping("/donationSub_add")
	public String addDonationSub(Model model) {
		
		List<DonationCode> donationCode = donationService.getdonationCode();
		List<DonationPayMethodCode> donationPayMethodCode = donationService.getdonationPayMethodCode();
		
		model.addAttribute("title", "정기기부 구독 신청 등록");
		model.addAttribute("donationCode", donationCode);
		model.addAttribute("donationPayMethodCode", donationPayMethodCode);
		
		return "/admin/donation/donationSub_add";
	}
	
	/*
	 * 정기기부 구독 신청 수정
	 */
	@PostMapping("/donationSub_modify")
	public String modifyDonationSub(DonationSub donationSub) {
		
		donationService.modifyDonationSub(donationSub);
		
		return "redirect:/admin/donation/donationSub_list";
	}
	@GetMapping("/donationSub_modify")
	public String modifyDonationSub(Model model, @RequestParam(name="donationSubCode") String donationSubCode){
		
		DonationSub donationSubInfo = donationService.getDonationSubInfoByCode(donationSubCode);

		model.addAttribute("title", "정기기부 구독 신청 수정");
		model.addAttribute("donationSubInfo", donationSubInfo);
		
		return "admin/donation/donationSub_modify";
	}
	
	/*
	 * 정기기부 구독 신청 삭제
	 * */
	@GetMapping("/donationSub_remove")
	public String removeDonationSub(DonationSub donationSub) {
		donationService.removeDonationSub(donationSub);
		return "redirect:/admin/donation/donationSub_list";
	}
	
	/*
	 * 정기기부 구독 결제 상세 조회
	 */
	@GetMapping("/donationPayDetail_list")
	public String getDonationPayDetail(Model model, @RequestParam(name="searchKey", required = false) String searchKey
												, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<DonationPayDetail> getDonationPayDetail = donationService.getDonationPayDetail(searchKey, searchValue);
		
		model.addAttribute("title", "정기기부 구독 결제 상세 목록");
		model.addAttribute("getDonationPayDetail", getDonationPayDetail);
		
		return "admin/donation/donationPayDetail_list";
	}
	
	/*
	 * 정기기부 구독 결제 상세 등록
	 */
	@PostMapping("/donationPayDetail_add")
	public String addDonationPayDetail(DonationPayDetail donationPayDetail) {
	
	donationService.addDonationPayDetail(donationPayDetail);
	
	return "redirect:/admin/donation/donationPayDetail_list";
	
		}
	
	@GetMapping("/donationPayDetail_add")
	public String addDonationPayDetail(Model model) {
		
		List<DonationCode> donationCode = donationService.getdonationCode();
		List<DonationPayMethodCode> donationPayMethodCode = donationService.getdonationPayMethodCode();
		List<DonationSubCode> donationSubCode = donationService.getdonationSubCode();
		
		model.addAttribute("title", "정기기부 구독 결제 상세 등록");
		model.addAttribute("donationCode", donationCode);
		model.addAttribute("donationPayMethodCode", donationPayMethodCode);
		model.addAttribute("donationSubCode", donationSubCode);
		
		return "/admin/donation/donationPayDetail_add";
	}
	
	/*
	 * 정기기부 구독 결제 상세 수정
	 */
	@PostMapping("/donationPayDetail_modify")
	public String modifyDonationPayDetail(DonationPayDetail donationPayDetail) {
		
		donationService.modifyDonationPayDetail(donationPayDetail);
		
		return "redirect:/admin/donation/donationPayDetail_list";
	}
	@GetMapping("/donationPayDetail_modify")
	public String modifyDonationPayDetail(Model model, @RequestParam(name="donationPayDetailCode") String donationPayDetailCode){
		
		DonationPayDetail donationPayDetailInfo = donationService.getDonationPayDetailInfoByCode(donationPayDetailCode);

		model.addAttribute("title", "정기기부 구독 결제 상세 수정");
		model.addAttribute("donationPayDetailInfo", donationPayDetailInfo);
		
		return "admin/donation/donationPayDetail_modify";
	}
	
	/*
	 * 정기기부 구독 결제 상세 삭제
	 * */
	@GetMapping("/donationPayDetail_remove")
	public String removeDonationPayDetail(DonationPayDetail donationPayDetail) {
		donationService.removeDonationPayDetail(donationPayDetail);
		return "redirect:/admin/donation/donationPayDetail_list";
	}
	
	/*
	 * 정기기부 월별 결제 합계 조회
	 */
	@GetMapping("/donationMonthPay_list")
	public String getDonationMonthPay(Model model, @RequestParam(name="searchKey", required = false) String searchKey
												, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<DonationMonthPay> getDonationMonthPay = donationService.getDonationMonthPay(searchKey, searchValue);
		
		model.addAttribute("title", "정기기부 월별 결제 합계 목록");
		model.addAttribute("getDonationMonthPay", getDonationMonthPay);
		
		return "admin/donation/donationMonthPay_list";
	}
	
	/*
	 * 정기기부 월별 결제 합계 등록
	 */
	@PostMapping("/donationMonthPay_add")
	public String addDonationMonthPay(DonationMonthPay donationMonthPay) {
	
	donationService.addDonationMonthPay(donationMonthPay);
	
	return "redirect:/admin/donation/donationMonthPay_list";
	
		}
	
	@GetMapping("/donationMonthPay_add")
	public String addDonationMonthPay(Model model) {
		
		List<DonationCode> donationCode = donationService.getdonationCode();
		
		model.addAttribute("title", "정기기부 월별 결제 합계 등록");
		model.addAttribute("donationCode", donationCode);
		
		return "/admin/donation/donationMonthPay_add";
	}
	
	/*
	 * 정기기부 월별 결제 합계 수정
	 */
	@PostMapping("/donationMonthPay_modify")
	public String modifyDonationMonthPay(DonationMonthPay donationMonthPay) {
		
		donationService.modifyDonationMonthPay(donationMonthPay);
		
		return "redirect:/admin/donation/donationMonthPay_list";
	}
	@GetMapping("/donationMonthPay_modify")
	public String modifyDonationMonthPay(Model model, @RequestParam(name="donationMonthPayCode") String donationMonthPayCode){
		
		DonationMonthPay donationMonthPayInfo = donationService.getDonationMonthPayInfoByCode(donationMonthPayCode);

		model.addAttribute("title", "정기기부 월별 결제 합계 수정");
		model.addAttribute("donationMonthPayInfo", donationMonthPayInfo);
		
		return "admin/donation/donationMonthPay_modify";
	}
	
	/*
	 * 정기기부 월별 결제 합계 삭제
	 * */
	@GetMapping("/donationMonthPay_remove")
	public String removeDonationMonthPay(DonationMonthPay donationMonthPay) {
		donationService.removeDonationMonthPay(donationMonthPay);
		return "redirect:/admin/donation/donationMonthPay_list";
	}
	
	/*
	 * 정기기부 환불 조회
	 */
	@GetMapping("/donationRefund_list")
	public String getDonationRefund(Model model, @RequestParam(name="searchKey", required = false) String searchKey
												, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<DonationRefund> getDonationRefund = donationService.getDonationRefund(searchKey, searchValue);
		
		model.addAttribute("title", "정기기부 환불 목록");
		model.addAttribute("getDonationRefund", getDonationRefund);
		
		return "admin/donation/donationRefund_list";
	}
	
	/*
	 * 정기기부 환불 등록
	 */
	@PostMapping("/donationRefund_add")
	public String addDonationRefund(DonationRefund donationRefund) {
	
	donationService.addDonationRefund(donationRefund);
	
	return "redirect:/admin/donation/donationdonationRefund_list";
	
		}
	
	@GetMapping("/donationRefund_add")
	public String addDonationRefund(Model model) {
		
		List<DonationPayDetail> donationPayDetailCode = donationService.getdonationPayDetailCode();
		
		model.addAttribute("title", "정기기부 환불 등록");
		model.addAttribute("donationPayDetailCode", donationPayDetailCode);
		
		return "/admin/donation/donationRefund_add";
	}
	
	/*
	 * 정기기부 환불 수정
	 */
	@PostMapping("/donationRefund_modify")
	public String modifyDonationRefund(DonationRefund donationRefund) {
		
		donationService.modifyDonationRefund(donationRefund);
		
		return "redirect:/admin/donation/donationRefund_list";
	}
	
	@GetMapping("/donationRefund_modify")
	public String modifyDonationRefund(Model model, @RequestParam(name="donationRefundCode") String donationRefundCode){
		
		DonationRefund donationRefundInfo = donationService.getDonationRefundInfoByCode(donationRefundCode);
		
		model.addAttribute("title", "정기기부 월별 결제 합계 수정");
		model.addAttribute("donationRefundInfo", donationRefundInfo);
		
		return "admin/donation/donationRefund_modify";
	}
	
	/*
	 * 정기기부 환불 삭제
	 * */
	@GetMapping("/donationRefund_remove")
	public String removeDonationRefund(DonationRefund donationRefund) {
		donationService.removeDonationRefund(donationRefund);
		return "redirect:/admin/donation/donationRefund_list";
	}
}