package ks46team04.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

		@GetMapping("/funding_index")
		public String MainHome(Model model) {
			
			return "common/funding_index";
		}
		
		@GetMapping("/funding_detail")
		public String nowFunding1(Model model) {
			
			return "common/funding_detail";
		}
		
		@GetMapping("/funding_detail2")
		public String nowFunding2(Model model) {
			
			return "common/funding_detail2";
		}
		
		@GetMapping("/funding_detail3")
		public String nowFunding3(Model model) {
			
			return "common/funding_detail3";
		}
		
		@GetMapping("/register")
		public String register(Model model) {
			
			return "common/register";
		}
		
		
		@GetMapping("/login")
		public String login(Model model) {
			
			return "common/login";
		}
		
		
		@GetMapping("/forgot-password")
		public String forgotPassword(Model model) {
			
			return "common/forgot-password";
		}
		@GetMapping("/password-reset")
		public String PasswordReset(Model model) {
			
			return "common/password-reset";
		}
}
