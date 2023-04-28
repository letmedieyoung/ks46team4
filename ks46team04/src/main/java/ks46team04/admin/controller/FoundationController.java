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
import org.springframework.web.bind.annotation.ResponseBody;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.FoundationRequest;
import ks46team04.admin.service.FoundationService;

@Controller
@RequestMapping("/admin/foundation")
public class FoundationController {

	private static final Logger log = LoggerFactory.getLogger(FoundationController.class);

	private final FoundationService foundationService;
	
	public FoundationController(FoundationService foundationService) {
		this.foundationService = foundationService;
	}
	
	
	
	/**
	 * 재단 요청사항 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_foundation_request")
	@ResponseBody
	public List<String> removeFoundationRequest(@RequestParam(value="valueArr[]") List<String> valueArr) { 
		
		log.info("valueArr: {}", valueArr);
		foundationService.removeFoundationRequest(valueArr);
		
		return valueArr;
	}
	
	/**
	 * 재단 요청사항 수정 @PostMapping
	 * @param foundationRequest
	 * @return
	 */
	@PostMapping("/modify_foundation_request")
	public String modifyFoundationRequest(FoundationRequest foundationRequest) {
		
		log.info("foundationRequest: {}", foundationRequest);
		
		foundationService.modifyFoundationRequest(foundationRequest);;
		
		return "redirect:/admin/foundation/foundation_request_list";
	}
	
	/**
	 * 재단 요청사항 수정 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_foundation_request")
	public String modifyFoundationRequest(Model model, @RequestParam(name="foundationRequestCode") String foundationRequestCode){
		
		FoundationRequest foundationRequestInfo = foundationService.getFoundationRequestInfoByCode(foundationRequestCode);
		log.info("foundationRequestInfo: {}", foundationRequestInfo);
		
		model.addAttribute("title", "재단 요청사항 수정");
		model.addAttribute("foundationRequestInfo", foundationRequestInfo);
		
		return "admin/foundation/modify_foundation_request";
	}
	
	/**
	 * 재단 요청사항 등록 @PostMapping
	 * @param foundationRequest
	 * @return
	 */
	@PostMapping("/add_foundation_request")
	public String addFoundationRequest(FoundationRequest foundationRequest) {
		
		log.info("foundationRequest: {}", foundationRequest);
		foundationService.addFoundationRequest(foundationRequest);
		
		return "redirect:/admin/foundation/foundation_request_list";
	}
	
	/**
	 * 재단 요청사항 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_foundation_request")
	public String addFoundationRequest(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "재단 요청사항 등록");
		
		return "admin/foundation/add_foundation_request";
	}
	
	/**
	 * 재단 요청사항 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/foundation_request_list")
	public String getFoundationRequestList(Model model) {
		
		List<FoundationRequest> foundationRequestList = foundationService.getFoundationRequestlist();
		
		log.info("foundationRequestList: {}", foundationRequestList);
		
		model.addAttribute("title", "재단 요청사항 조회");
		model.addAttribute("foundationRequestList", foundationRequestList);
		
		return "admin/foundation/foundation_request_list";
	}
	
	/**
	 * 재단 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_foundation")
	@ResponseBody
	public List<String> removeFoundation(@RequestParam(value="valueArr[]") List<String> valueArr) {
		
		log.info("valueArr: {}", valueArr);
		foundationService.removeFoundation(valueArr);
		
		return valueArr;
	}
	
	/**
	 * 재단 수정 @PostMapping
	 * @param foundation
	 * @return
	 */
	@PostMapping("/modify_foundation")
	public String modifyFoundation(Foundation foundation) {
		
		log.info("foundation: {}", foundation);
		
		foundationService.modifyFoundation(foundation);;
		
		return "redirect:/admin/foundation/foundation_list";
	}
	
	/**
	 * 재단 수정 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_foundation")
	public String modifyFoundation(Model model, @RequestParam(name="foundationCode") String foundationCode) {
		
		Foundation foundationInfo = foundationService.getFoundationInfoByCode(foundationCode);
		
		log.info("foundationInfo: {}", foundationInfo);
		
		model.addAttribute("title", "재단 수정");
		model.addAttribute("foundationInfo", foundationInfo);
		
		return "admin/foundation/modify_foundation";
	}
	
	/**
	 * 재단 등록 @PostMapping
	 * @param foundation
	 * @return
	 */
	@PostMapping("/add_foundation")
	public String addFoundation(Foundation foundation) {
		
		log.info("foundation: {}", foundation);
		foundationService.addFoundation(foundation);
		
		return "redirect:/admin/foundation/foundation_list";
	}
	
	/**
	 * 재단 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_foundation")
	public String addFoundation(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "재단 등록");
		
		return "admin/foundation/add_foundation";
	}
	
	/**
	 * 재단 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/foundation_list")
	public String getFoundationList(Model model) {
		
		List<Foundation> foundationList = foundationService.getFoundationList();
		log.info("foundationList: {}", foundationList);

		model.addAttribute("title", "재단 목록");
		model.addAttribute("foundationList", foundationList);
		
		return "admin/foundation/foundation_list";
	}
	
}
