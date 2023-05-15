package ks46team04.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.DonationMonthPay;
import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.DonationPayMethod;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.dto.DonationRefund;
import ks46team04.admin.dto.Payment;
import ks46team04.admin.service.DonationService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/donation")
@AllArgsConstructor
public class DonationController {
		
	private final DonationService donationService;
	
	/*
	 * 정기기부 콘텐츠 조회
	 */
	@GetMapping("/donation_list")
	public String getDonation(Model model, @RequestParam(name="searchKey", required = false) String searchKey
										, @RequestParam(name="searchValue", required = false) String searchValue
										, @RequestParam(value="startDate", required = false) String startDate
										, @RequestParam(value="endDate", required = false) String endDate){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<Donation> getDonation = donationService.getDonation(searchKey, searchValue, paramMap, startDate, endDate);
		
		model.addAttribute("title", "정기기부 콘텐츠 목록");
		model.addAttribute("getDonation", getDonation);

		return "admin/donation/donation_list";
	}

	/*
	 * 정기기부 콘텐츠 등록
	*/
	@PostMapping("/donation_add")
	public String addDonation(Donation donation, HttpSession session) {
		
		String donationRegId = (String) session.getAttribute("SID");
		donation.setDonationRegId(donationRegId);
		
		donationService.addDonation(donation);
	
	return "redirect:/admin/donation/donation_list";
	
		}
	
	@GetMapping("/donation_add")
	public String addDonation(Model model) {
		
		model.addAttribute("title", "정기기부 콘텐츠 등록");

		return "/admin/donation/donation_add";
	}
	
	/*
	 * 정기기부 콘텐츠 수정
	 */
	@PostMapping("/donation_modify")
	public String modifyDonation(Donation donation, HttpSession session) {
		
		String donationUpdateId = (String) session.getAttribute("SID");
		donation.setDonationUpdateId(donationUpdateId);
		
		donationService.modifyDonation(donation);
		
		return "redirect:/admin/donation/donation_list";
	}
	
	@GetMapping("/donation_modify")
	public String modifyDonation(Model model
							 ,@RequestParam(name="donationCode") String donationCode) {
		
		Donation donationInfo = donationService.getDonationInfoByCode(donationCode);
		
		model.addAttribute("title", "정기기부 콘텐츠 수정");
		model.addAttribute("donationInfo", donationInfo);
		
		return "admin/donation/donation_modify";
	}
	
	/*
	 * 정기기부 콘텐츠 삭제
	 * */
	@PostMapping("/donation_remove")
	@ResponseBody
	public List <String> removeDonation(@RequestParam(value="valueArr[]") List<String> valueArr) {
		donationService.removeDonation(valueArr);
		return valueArr;
	}
	
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
	public String addDonationPayMethod(DonationPayMethod donationPayMethod, HttpSession session) {
	
		String donationPayMethodUserId = (String) session.getAttribute("SID");
		donationPayMethod.setDonationPayMethodUserId(donationPayMethodUserId);
		
		donationService.addDonationPayMethod(donationPayMethod);
	
	return "redirect:/admin/donation/donationPayMethod_list";
	
		}
	
	@GetMapping("/donationPayMethod_add")
	public String addDonationPayMethod(Model model) {
		
		List<Payment> paymentCode = donationService.getpaymentCode();
		
		model.addAttribute("title", "등록된 회원 결제수단 등록");
		model.addAttribute("paymentCode", paymentCode);
		
		return "/admin/donation/donationPayMethod_add";
	}
	
	/*
	 * 등록된 회원 결제수단 수정
	 */
	@PostMapping("/donationPayMethod_modify")
	public String modifyDonationPayMethod(DonationPayMethod donationPayMethod, HttpSession session) {
		
		String donationPayMethodUserId = (String) session.getAttribute("SID");
		donationPayMethod.setDonationPayMethodUserId(donationPayMethodUserId);
		
		donationService.modifyDonationPayMethod(donationPayMethod);
		
		return "redirect:/admin/donation/donationPayMethod_list";
	}
	@GetMapping("/donationPayMethod_modify")
	public String modifyDonationPayMethod(Model model, @RequestParam(name="donationPayMethodCode") String donationPayMethodCode){
		
		DonationPayMethod donationPayMethodInfo = donationService.getDonationPayMethodInfoByCode(donationPayMethodCode);
		List<Payment> paymentCode = donationService.getpaymentCode();

		model.addAttribute("title", "등록된 회원 결제수단 수정");
		model.addAttribute("donationPayMethodInfo", donationPayMethodInfo);
		model.addAttribute("paymentCode", paymentCode);
		
		return "admin/donation/donationPayMethod_modify";
	}
	
	/*
	 * 등록된 회원 결제수단 삭제
	 * */
	@PostMapping("/donationPayMethod_remove")
	@ResponseBody
	public List <String> removeDonationPayMethod(@RequestParam(value="valueArr[]") List<String> valueArr) {
		donationService.removeDonationPayMethod(valueArr);
		return valueArr;
	}
	
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
	public String addDonationSub(DonationSub donationSub, HttpSession session) {
		
		String donationSubUserId = (String) session.getAttribute("SID");
		donationSub.setDonationSubUserId(donationSubUserId);
	
		donationService.addDonationSub(donationSub);
	
	return "redirect:/admin/donation/donationSub_list";
	
		}
	
	@GetMapping("/donationSub_add")
	public String addDonationSub(Model model) {
		
		List<Donation> donationCode = donationService.getdonationCode();
		List<DonationPayMethod> donationPayMethodCode = donationService.getdonationPayMethodCode();
		
		model.addAttribute("title", "정기기부 구독 신청 등록");
		model.addAttribute("donationCode", donationCode);
		model.addAttribute("donationPayMethodCode", donationPayMethodCode);
		
		return "/admin/donation/donationSub_add";
	}
	
	/*
	 * 정기기부 구독 해지 등록
	 */
	@PostMapping("/donationSub_cancel")
	public String cancelDonationSub(DonationSub donationSub, HttpSession session) {
		
		String donationSubUserId = (String) session.getAttribute("SID");
		donationSub.setDonationSubUserId(donationSubUserId);
		
		donationService.cancelDonationSub(donationSub);
		
		
		return "redirect:/admin/donation/donationSub_list";
	}
	@GetMapping("/donationSub_cancel")
	public String cancelDonationSub(Model model, String donationSubCode){
		
		DonationSub donationSubInfo = donationService.getDonationSubInfoByCode(donationSubCode);
		List<Donation> donationCode = donationService.getdonationCode();
		List<DonationPayMethod> donationPayMethodCode = donationService.getdonationPayMethodCode();

		model.addAttribute("title", "정기기부 구독 해지 등록");
		model.addAttribute("donationSubInfo", donationSubInfo);
		model.addAttribute("donationCode", donationCode);
		model.addAttribute("donationPayMethodCode", donationPayMethodCode);
		
		return "admin/donation/donationSub_cancel";
	}
	
	/*
	 * 정기기부 구독 신청 수정
	 */
	@PostMapping("/donationSub_modify")
	public String modifyDonationSub(DonationSub donationSub, HttpSession session) {
		
		String donationSubUserId = (String) session.getAttribute("SID");
		donationSub.setDonationSubUserId(donationSubUserId);
		
		donationService.modifyDonationSub(donationSub);
		
		
		return "redirect:/admin/donation/donationSub_list";
	}
	@GetMapping("/donationSub_modify")
	public String modifyDonationSub(Model model, @RequestParam(name="donationSubCode") String donationSubCode){
		
		DonationSub donationSubInfo = donationService.getDonationSubInfoByCode(donationSubCode);
		List<Donation> donationCode = donationService.getdonationCode();
		List<DonationPayMethod> donationPayMethodCode = donationService.getdonationPayMethodCode();

		model.addAttribute("title", "정기기부 구독 신청 수정");
		model.addAttribute("donationSubInfo", donationSubInfo);
		model.addAttribute("donationCode", donationCode);
		model.addAttribute("donationPayMethodCode", donationPayMethodCode);
		
		return "admin/donation/donationSub_modify";
	}
	
	/*
	 * 정기기부 구독 신청 삭제
	 * */
	@PostMapping("/donationSub_remove")
	@ResponseBody
	public List <String> removeDonationSub(@RequestParam(value="valueArr[]") List<String> valueArr) {
		donationService.removeDonationSub(valueArr);
		return valueArr;
	}
	
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
		
		List<Donation> donationCode = donationService.getdonationCode();
		List<DonationPayMethod> donationPayMethodCode = donationService.getdonationPayMethodCode();
		List<DonationSub> donationSubCode = donationService.getdonationSubCode();
		
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
		List<Donation> donationCode = donationService.getdonationCode();
		List<DonationPayMethod> donationPayMethodCode = donationService.getdonationPayMethodCode();
		List<DonationSub> donationSubCode = donationService.getdonationSubCode();

		model.addAttribute("title", "정기기부 구독 결제 상세 수정");
		model.addAttribute("donationPayDetailInfo", donationPayDetailInfo);
		model.addAttribute("donationCode", donationCode);
		model.addAttribute("donationPayMethodCode", donationPayMethodCode);
		model.addAttribute("donationSubCode", donationSubCode);
		
		return "admin/donation/donationPayDetail_modify";
	}
	
	/*
	 * 정기기부 구독 결제 상세 삭제
	 * */
	@PostMapping("/donationPayDetail_remove")
	@ResponseBody
	public List <String> removeDonationPayDetail(@RequestParam(value="valueArr[]") List<String> valueArr) {
		donationService.removeDonationPayDetail(valueArr);
		return valueArr;
	}
	
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
		
		List<Donation> donationCode = donationService.getdonationCode();
		
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
	@PostMapping("/donationMonthPay_remove")
	@ResponseBody
	public List <String> removeDonationMonthPay(@RequestParam(value="valueArr[]") List<String> valueArr) {
		donationService.removeDonationMonthPay(valueArr);
		return valueArr;
	}
	
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
	public String addDonationRefund(DonationRefund donationRefund, HttpSession session) {
	
		String donationRefundRegId = (String) session.getAttribute("SID");
		donationRefund.setDonationRefundRegId(donationRefundRegId);

		
		donationService.addDonationRefund(donationRefund);
	
	return "redirect:/admin/donation/donationRefund_list";
	
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
	public String modifyDonationRefund(DonationRefund donationRefund, HttpSession session) {
		
		String donationRefundUpdateId = (String) session.getAttribute("SID");
		donationRefund.setDonationRefundUpdateId(donationRefundUpdateId);
		
		donationService.modifyDonationRefund(donationRefund);
		
		return "redirect:/admin/donation/donationRefund_list";
	}
	
	@GetMapping("/donationRefund_modify")
	public String modifyDonationRefund(Model model, @RequestParam(name="donationRefundCode") String donationRefundCode){
		
		DonationRefund donationRefundInfo = donationService.getDonationRefundInfoByCode(donationRefundCode);
		List<DonationPayDetail> donationPayDetailCode = donationService.getdonationPayDetailCode();
		
		model.addAttribute("title", "정기기부 월별 결제 합계 수정");
		model.addAttribute("donationRefundInfo", donationRefundInfo);
		model.addAttribute("donationPayDetailCode", donationPayDetailCode);
		
		return "admin/donation/donationRefund_modify";
	}
	
	/*
	 * 정기기부 환불 삭제
	 * */
	@PostMapping("/donationRefund_remove")
	@ResponseBody
	public List <String> removeDonationRefund(@RequestParam(value="valueArr[]") List<String> valueArr) {
		donationService.removeDonationRefund(valueArr);
		return valueArr;
	}
	
	@GetMapping("/donationRefund_remove")
	public String removeDonationRefund(DonationRefund donationRefund) {
		donationService.removeDonationRefund(donationRefund);
		return "redirect:/admin/donation/donationRefund_list";
	}
}