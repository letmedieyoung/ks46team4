package ks46team04.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.controller.UserController;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.User;
import ks46team04.admin.mapper.UserMapper;
import ks46team04.admin.service.DonationService;
import ks46team04.admin.service.FundingService;
import ks46team04.admin.service.UserService;

@Controller
@RequestMapping("/user")
public class UserMainController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;
	private final FundingService fundingService;
	private final UserMapper userMapper;
	private final DonationService donationService;

	public UserMainController(UserService userService, UserMapper userMapper, FundingService fundingService, DonationService donationService) {
		this.userService = userService;
		this.userMapper = userMapper;
		this.fundingService = fundingService;
		this.donationService = donationService;
	}
	
	@GetMapping("/myPage_myDonation")
	public String mypageDonation(Model model) {
		List<DonationSub> getDonationSub = donationService.getDonationSub();
		
		model.addAttribute("title", "마이페이지정기후원내역");
		model.addAttribute("getDonationSub", getDonationSub);
		
		return "user/myPage_myDonation";
	}
	
	
	@GetMapping("/myPage_myFunding")
	public String mypageFunding(Model model) {
		List<FundingPay> fundingPayList = fundingService.getFundingPayList();
		log.info("fundingPayList_Service: {}", fundingPayList);
		model.addAttribute("title", "마이페이지펀딩내역");
		model.addAttribute("fundingPayList", fundingPayList);
		
		return "user/myPage_myFunding";
	}
	
	@PostMapping("/myPage_myInfoModify")
	public String  mypageInfoModify(User user) {
		
		return "redirect:/user/userList";
	}
	
	
	@GetMapping("/myPage_myInfoModify")
	public String mypageInfoModify() {
		
		return "user/myPage_myInfoModify";
	}
	
	
	@GetMapping("/myPage_myInfo")
	public String getUserInfoById(Model model) {
		
		/*
		 * User userInfo = userService.getUserInfoById(userId);
		 * log.info("userInfo: {}",userInfo); model.addAttribute("userInfo", userInfo);
		 */
		return "user/myPage_myInfo";
	}
	
	@GetMapping("/mypage_index")
	public String mypageMain(Model model) {
		
		return "user/mypage_index";
	}
	
}
