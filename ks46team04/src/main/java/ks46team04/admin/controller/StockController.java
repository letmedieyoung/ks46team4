package ks46team04.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {

	/**
	 * 상품 입고 내역 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/incoming_stock_list")
	public String getIncomingStockList(Model model) {
		
		model.addAttribute("title", "incoming_stock_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/incoming_stock_list";
	}
	
	/**
	 * 상품 입고 내역 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_incoming_stock")
	public String addIncomingStock(Model model) {
		
		model.addAttribute("title", "add_incoming_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/add_incoming_stock";
	}
	
	/**
	 * 상품 입고 내역 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_incoming_stock")
	public String modifyIncomingStock(Model model) {
		
		model.addAttribute("title", "modify_incoming_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/modify_incoming_stock";
	}
	
	/**
	 * 상품 입고 내역 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_incoming_stock")
	public String removeIncomingStock(Model model) {
		
		model.addAttribute("title", "remove_incoming_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/remove_incoming_stock";
	}
	
	/**
	 * 상품 재고 현황 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/stock_list")
	public String getStockList(Model model) {
		
		model.addAttribute("title", "stock_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/stock_list";
	}
	
	/**
	 * 상품 재고 현황 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_stock")
	public String modifyStock(Model model) {
		
		model.addAttribute("title", "modify_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/modify_stock";
	}
	
	/**
	 * 상품 재고 현황 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_stock")
	public String removeStock(Model model) {
		
		model.addAttribute("title", "remove_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/remove_stock";
	}
	
	/**
	 * 상품 비정상재고 상세정보 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/unusual_stock_detail_list")
	public String getUnusualStockList(Model model) {
		
		model.addAttribute("title", "unusual_stock_detail_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/unusual_stock_detail_list";
	}
	
	/**
	 * 상품 비정상재고 상세정보 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_unusual_stock_detail")
	public String addUnusualStock(Model model) {
		
		model.addAttribute("title", "add_unusual_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/add_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 상세정보 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_unusual_stock_detail")
	public String modifyUnusualStock(Model model) {
		
		model.addAttribute("title", "modify_unusual_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/modify_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 상세정보 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_unusual_stock_detail")
	public String removeUnusualStock(Model model) {
		
		model.addAttribute("title", "remove_unusual_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/remove_unusual_stock_detail";
	}
	
	/**
	 * 상품 출고 내역 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/outcoming_stock_list")
	public String getOutcomingStockList(Model model) {
		
		model.addAttribute("title", "outcoming_stock_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/outcoming_stock_list";
	}
	
	/**
	 * 상품 출고 내역 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_outcoming_stock")
	public String addOutcomingStock(Model model) {
		
		model.addAttribute("title", "add_outcoming_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/add_outcoming_stock";
	}
	
	/**
	 * 상품 출고 내역 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_outcoming_stock")
	public String modifyOutcomingStock(Model model) {
		
		model.addAttribute("title", "modify_outcoming_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/modify_outcoming_stock";
	}
	
	/**
	 * 상품 출고 내역 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_outcoming_stock")
	public String removeOutcomingStock(Model model) {
		
		model.addAttribute("title", "remove_outcoming_stock");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/remove_outcoming_stock";
	}
	
	/**
	 * 상품 출고 상세정보 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/outcoming_stock_detail_list")
	public String getOutcomingStockDetailList(Model model) {
		
		model.addAttribute("title", "outcoming_stock_detail_list");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/outcoming_stock_detail_list";
	}
	
	/**
	 * 상품 출고 상세정보 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_outcoming_stock_detail")
	public String addOutcomingStockDetail(Model model) {
		
		model.addAttribute("title", "add_outcoming_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/add_outcoming_stock_detail";
	}
	
	/**
	 * 상품 출고 상세정보 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_outcoming_stock_detail")
	public String modifyOutcomingStockDetail(Model model) {
		
		model.addAttribute("title", "modify_outcoming_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/modify_outcoming_stock_detail";
	}
	
	/**
	 * 상품 출고 상세정보 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_outcoming_stock_detail")
	public String removeOutcomingStockDetail(Model model) {
		
		model.addAttribute("title", "remove_outcoming_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "view/stock/remove_outcoming_stock_detail";
	}
}
