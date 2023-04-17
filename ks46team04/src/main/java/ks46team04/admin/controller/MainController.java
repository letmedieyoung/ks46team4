package ks46team04.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String mainaPage(Model model) {
		model.addAttribute("title", "pillingGood 메인화면");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "main_index";
	}
}
