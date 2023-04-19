package ks46team04.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.service.FoundationService;

@Controller
@RequestMapping("/foundation")
public class FoundationController {

	private static final Logger log = LoggerFactory.getLogger(FoundationController.class);

	private final FoundationService founationService;
	
	public FoundationController(FoundationService foundationService) {
		this.founationService = foundationService;
	}
	
	/**
	 * 재단 정보 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/foundation_list")
	public String getFoundationList(Model model) {
		
		List<Foundation> foundationList = founationService.getFoundationList();

		model.addAttribute("title", "재단 목록");
		model.addAttribute("foundationList", foundationList);
		
		return "view/foundation/foundation_list";
	}
	
	/**
	 * 재단 정보 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_foundation")
	public String addFoundation(Model model) {
		
		model.addAttribute("title", "재단 등록");
		
		return "view/foundation/add_foundation";
	}
	
	/**
	 * 재단 정보 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_foundation")
	public String modifyFoundation(Model model) {
		
		model.addAttribute("title", "재단 수정");
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
