package ks46team04.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foundation")
public class FoundationController {

	/**
	 * 재단 정보 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/foundation_list")
	public String getFoundationList(Model model) {
		
		model.addAttribute("title", "foundation_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/foundation_list";
	}
	
	/**
	 * 재단 정보 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_foundation")
	public String addFoundation(Model model) {
		
		model.addAttribute("title", "add_foundation");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/add_foundation";
	}
	
	/**
	 * 재단 정보 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_foundation")
	public String modifyFoundation(Model model) {
		
		model.addAttribute("title", "modify_foundation");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/modify_foundation";
	}
	
	/**
	 * 재단 정보 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_foundation")
	public String removeFoundation(Model model) {
		
		model.addAttribute("title", "remove_foundation");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/remove_foundation";
	}
	
	/**
	 * 재단 요청사항 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/foundation_request_list")
	public String getFoundationRequestList(Model model) {
		
		model.addAttribute("title", "foundation_request_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/foundation_request_list";
	}
	
	/**
	 * 재단 요청사항 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_foundation_request")
	public String addFoundationRequest(Model model) {
		
		model.addAttribute("title", "add_foundation_request");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/add_foundation_request";
	}
	
	/**
	 * 재단 요청사항 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_foundation_request")
	public String modifyFoundationRequest(Model model) {
		
		model.addAttribute("title", "modify_foundation_request");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/modify_foundation_request";
	}
	
	/**
	 * 재단 요청사항 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_foundation_request")
	public String removeFoundationRequest(Model model) {
		
		model.addAttribute("title", "remove_foundation_request");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/foundation/remove_foundation_request";
	}
}
