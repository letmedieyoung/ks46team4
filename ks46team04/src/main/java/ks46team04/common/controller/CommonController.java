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
