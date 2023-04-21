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
import ks46team04.admin.service.DonationService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/donation")
@AllArgsConstructor
public class DonationController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DonationController.class);

	
	private final DonationService donationService;
	
	/*
	 * 정기기부 단가 조회
	 */
	@GetMapping("/donation_list")
	public String getDonation(Model model) {
		
		List<Donation> getDonation = donationService.getDonation();
				
		model.addAttribute("title", "정기기부 단가 목록");
		model.addAttribute("getDonation", getDonation);
		
		return "/admin/donation/donation_list";
	}

	/*
	 * 정기기부 단가 등록
	 */
	@PostMapping("/donation_add")
	public String addDonation(Donation donation) {
		
	log.info("화면에서 전달받은 데이터 : {}", donation);
	
	donationService.addDonation(donation);
	
	return "redirect:/donation/donation_list";
	
		}
	
	@GetMapping("/donation_add")
	public String addDonation(Model model) {
		
		model.addAttribute("title", "정기기부 단가 등록");
		
		return "admin/donation/donation_add";
	}
	
	/*
	 * 정기기부 단가 수정
	 */
	@PostMapping("/donation_modify")
	public String modifyDonation(Donation donation) {
		
		donationService.modifyDonation(donation);
		
		return "redirect:/donation/donation_list";
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
		return "redirect:/donation/donation_list";
	}
}