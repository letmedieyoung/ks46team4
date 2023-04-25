package ks46team04.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks46team04.admin.controller.UserController;
import ks46team04.admin.dto.DonationPayMethod;
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
	
	
	@GetMapping("/myPage_myAutoPm")
	public String getDonationPayMethod(Model model) {
		
		List<DonationPayMethod> getDonationPayMethod = donationService.getDonationPayMethod();
		log.info("getDonationPayMethod: {}", getDonationPayMethod);
		model.addAttribute("title", "마이페이지결제수단");
		model.addAttribute("getDonationPayMethod", getDonationPayMethod);
		
		return "/user/myPage_myAutoPm";
	}
	
	
	
	/*
	 * @PostMapping("/myPage_drop") public String
	 * mypageDrop(@RequestParam(name="userId") String userId
	 * ,@RequestParam(name="userPw") String userPw) {
	 * 
	 * String redirectURI = "redirect:/user/myPage_drop?userId=" + userId; // 비밀번호
	 * 확인 User user = userService.getUserInfoById(userId); if(user != null) { String
	 * checkPw = user.getUserPw();
	 * 
	 * if(checkPw.equals(userPw)) { // 서비스 호출 userService.removeUser(userId);
	 * redirectURI = "redirect:/user/mypage_index"; } }
	 * 
	 * 
	 * return redirectURI; }
	 */
	
	
	
	@GetMapping("/myPage_drop")
	public String removeUserById(Model model) {
		
		//model.addAttribute("title", "회원탈퇴");
		//model.addAttribute("userId", userId);
		
		return "user/myPage_drop";
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
