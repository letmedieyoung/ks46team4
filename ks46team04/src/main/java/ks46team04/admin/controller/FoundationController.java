package ks46team04.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.FoundationRequest;
import ks46team04.admin.mapper.FoundationMapper;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.service.FoundationService;

@Controller
@RequestMapping("/admin/foundation")
public class FoundationController {

	private static final Logger log = LoggerFactory.getLogger(FoundationController.class);

	private final FoundationService foundationService;
	private final FoundationMapper foundationMapper;
	private final GoodsMapper goodsMapper;
	
	public FoundationController(FoundationService foundationService
								, FoundationMapper foundationMapper
								, GoodsMapper goodsMapper) {
		this.foundationService = foundationService;
		this.foundationMapper = foundationMapper;
		this.goodsMapper = goodsMapper;
	}

	/**
	 * 재단 요청사항 수정 @PostMapping
	 * @param foundationRequest
	 * @return
	 */
	@PostMapping("/modify_foundation_request")
	public String modifyFoundationRequest(FoundationRequest foundationRequest, HttpSession session) {
		
		String requestUpdId = (String) session.getAttribute("SID");
		log.info("requestUpdId: {}", requestUpdId);
		foundationRequest.setRequestUpdId(requestUpdId);
		
		foundationService.modifyFoundationRequest(foundationRequest);
		
		return "redirect:/admin/foundation/foundation_request_list";
	}
	
	/**
	 * 재단 요청사항 수정 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_foundation_request")
	public String modifyFoundationRequest(Model model
										, @RequestParam(name="foundationRequestCode") String foundationRequestCode){

		List<String> goodsNameList = goodsMapper.getGoodsNameList();
		log.info("goodsNameList: {}", goodsNameList);
		
		List<String> foundationNameList = foundationMapper.getFoundationNameList();
		log.info("foundationNameList: {}", foundationNameList);

		FoundationRequest foundationRequestInfo = foundationService.getFoundationRequestInfoByCode(foundationRequestCode);
		log.info("수정 전 foundationRequestInfo: {}", foundationRequestInfo);
		
		model.addAttribute("title", "재단 요청사항 수정");
		model.addAttribute("goodsNameList", goodsNameList);
		model.addAttribute("foundationNameList", foundationNameList);
		model.addAttribute("foundationRequestInfo", foundationRequestInfo);
		
		return "admin/foundation/modify_foundation_request";
	}
	
	/**
	 * 재단 요청사항 등록 @PostMapping
	 * @param foundationRequest
	 * @return
	 */
	@PostMapping("/add_foundation_request")
	public String addFoundationRequest(FoundationRequest foundationRequest, HttpSession session) {
		
		String requestRegId = (String) session.getAttribute("SID");
	    log.info("requestRegId: {}", requestRegId);
	    
	    foundationRequest.setRequestRegId(requestRegId);
		
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
		
		List<String> goodsNameList = goodsMapper.getGoodsNameList();
		log.info("goodsNameList: {}", goodsNameList);
		
		List<String> foundationNameList = foundationMapper.getFoundationNameList();
		log.info("foundationNameList: {}", foundationNameList);
		
		model.addAttribute("title", "재단 요청사항 등록");
		model.addAttribute("goodsNameList", goodsNameList);
		model.addAttribute("foundationNameList", foundationNameList);
		
		return "admin/foundation/add_foundation_request";
	}
	
	/**
	 * 재단 요청사항 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_foundation_request")
	@ResponseBody
	public Map<String, Object> removeFoundationRequest(@RequestParam(value="valueArr[]") List<String> valueArr) { 
		
		log.info("valueArr: {}", valueArr);
		
		// 삭제된 항목을 담을 리스트 초기화
        List<String> removedFoundationRequest = new ArrayList<>();
        List<String> notRemovedFoundationRequest = new ArrayList<>();

        for (String foundationRequestCode : valueArr) {
        	boolean isRemove = foundationService.removeFoundationRequest(foundationRequestCode);
            if (isRemove) {
            	// 삭제된 항목 리스트에 추가
            	removedFoundationRequest.add(foundationRequestCode);
            } else {
            	// 삭제되지 않은 항목 리스트에 추가
            	notRemovedFoundationRequest.add(foundationRequestCode);
            }
        }
        log.info("removedFoundationRequest: {}", removedFoundationRequest);
        log.info("notRemovedFoundationRequest: {}", notRemovedFoundationRequest);

        // 삭제된 항목과 삭제되지 않은 항목을 Map으로 전달
        Map<String, Object> response = new HashMap<>();
        response.put("removed", removedFoundationRequest);
        response.put("notRemoved", notRemovedFoundationRequest);
        log.info("response: {}", response);

        return response;
    }
	
	/**
	 * 재단 요청사항 검색 결과 조회
	 * @param searchKey
	 * @param searchValue
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/search_foundation_request_list")
	@ResponseBody
	public List<FoundationRequest> getFoundationRequestlistBySearch(@RequestParam(value="inputSearchKey", required = false) String inputSearchKey 
																	, @RequestParam(value="inputSearchValue", required = false) String inputSearchValue
																	, @RequestParam(value="contentKey", required = false) String contentKey
																	, @RequestParam(value="contentValue", required = false) String contentValue
																	, @RequestParam(value="progressKey", required = false) String progressKey
																	, @RequestParam(value="progressValue", required = false) String progressValue
																	, @RequestParam(value="dateSearchKey", required = false) String dateSearchKey
																	, @RequestParam(value="startDate", required = false) String startDate
																	, @RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("inputSearchKey: {}, inputSearchValue: {}, contentKey: {}, contentValue: {},"
				+ "progressKey: {},progressValue: {}, dateSearchKey: {}, startDate: {}, endDate: {}", 
				inputSearchKey, inputSearchValue, contentKey, contentValue, progressKey, progressValue, dateSearchKey, startDate, endDate);
		
		List<FoundationRequest> foundationRequestList = foundationService.getFoundationRequestlistBySearch(inputSearchKey
																										, inputSearchValue
																										, contentKey
																										, contentValue
																										, progressKey
																										, progressValue
																										, dateSearchKey
																										, startDate
																										, endDate);
		log.info("foundationRequestList: {}", foundationRequestList);
		
		return foundationRequestList;
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
	 * 재단 수정 @PostMapping
	 * @param foundation
	 * @return
	 */
	@PostMapping("/modify_foundation")
	public String modifyFoundation(Foundation foundation, HttpSession session) {
		
		String foundationUpdId = (String) session.getAttribute("SID");
	    log.info("foundationUpdId: {}", foundationUpdId);
	    
	    foundation.setFoundationUpdId(foundationUpdId);
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
	public String modifyFoundation(Model model
								, @RequestParam(name="foundationCode") String foundationCode) {
		
		Foundation foundationInfo = foundationService.getFoundationInfoByCode(foundationCode);
		log.info("foundationInfo: {}", foundationInfo);
		
		model.addAttribute("title", "재단 수정");
		model.addAttribute("foundationInfo", foundationInfo);
		
		return "admin/foundation/modify_foundation";
	}
	
	/**
	 * 재단명 중복체크
	 * @param foundationName
	 * @return
	 */
	@PostMapping("/check_foundation_name")
	@ResponseBody
	public boolean foundationNameCheck(@RequestParam(name="foundationName") String foundationName) {
		
		boolean isCheck = foundationMapper.foundationNameCheck(foundationName);
		
		return isCheck;
	}
	
	/**
	 * 재단 등록 @PostMapping
	 * @param foundation
	 * @return
	 */
	@PostMapping("/add_foundation")
	public String addFoundation(Foundation foundation, HttpSession session) {
		
		String foundationRegId = (String) session.getAttribute("SID");
		log.info("foundationRegId: {}", foundationRegId);
	    
	    foundation.setFoundationRegId(foundationRegId);
		
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
		
		model.addAttribute("title", "재단 등록");
		
		return "admin/foundation/add_foundation";
	}
	
	/**
	 * 재단 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_foundation")
	@ResponseBody
	public Map<String, Object> removeFoundation(@RequestParam(value="valueArr[]") List<String> valueArr) {
		
		log.info("valueArr: {}", valueArr);

		// 삭제된 항목을 담을 리스트 초기화
        List<String> removedFoundation = new ArrayList<>();
        List<String> notRemovedFoundation = new ArrayList<>();

        for (String foundationCode : valueArr) {
        	boolean isRemove = foundationService.removeFoundation(foundationCode);
            if (isRemove) {
            	// 삭제된 항목 리스트에 추가
            	removedFoundation.add(foundationCode);
            } else {
            	// 삭제되지 않은 항목 리스트에 추가
            	notRemovedFoundation.add(foundationCode);
            }
        }
        log.info("removedFoundation: {}", removedFoundation);
        log.info("notRemovedFoundation: {}", notRemovedFoundation);

        // 삭제된 항목과 삭제되지 않은 항목을 Map으로 전달
        Map<String, Object> response = new HashMap<>();
        response.put("removed", removedFoundation);
        response.put("notRemoved", notRemovedFoundation);
        log.info("response: {}", response);

        return response;
	}
	
	/**
	 * 재단 검색 결과 조회
	 * @param searchKey
	 * @param searchValue
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/search_foundation_list")
	@ResponseBody
	public List<Foundation> getFoundationListBySearch(@RequestParam(value="inputSearchKey", required = false) String inputSearchKey 
													, @RequestParam(value="inputSearchValue", required = false) String inputSearchValue
													, @RequestParam(value="startDate", required = false) String startDate
													, @RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("inputSearchKey: {}, inputSearchValue: {}, startDate: {}, endDate: {}", inputSearchKey, inputSearchValue, startDate, endDate);
		
		List<Foundation> foundationList = foundationService.getFoundationListBySearch(inputSearchKey
																					, inputSearchValue
																					, startDate
																					, endDate);
		log.info("foundationList: {}", foundationList);
		
		return foundationList;
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
