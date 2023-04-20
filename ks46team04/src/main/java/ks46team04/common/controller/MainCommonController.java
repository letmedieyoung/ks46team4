package ks46team04.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCommonController {

	@GetMapping("/")
	public String mainHome(Model model) {
		
		return "funding_index";
	}
}
