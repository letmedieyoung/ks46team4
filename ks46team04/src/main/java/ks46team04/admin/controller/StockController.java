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

import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.OutcomingDetail;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;
import ks46team04.admin.service.StockService;

@Controller
@RequestMapping("/admin/stock")
public class StockController {

	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	private final StockService stockService;
	
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 상품 출고 상세정보 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/outcoming_detail_list")
	public String getOutcomingDetailList(Model model) {
		
		List<OutcomingDetail> outcomingDetailList = stockService.getOutcomingDetailList();
		
		model.addAttribute("title", "상품 출고 상세정보 조회");
		model.addAttribute("outcomingDetailList", outcomingDetailList);
		
		return "admin/stock/outcoming_detail_list";
	}
	
	
	
	
	
	
	/**
	 * 상품 비정상재고 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_unusual_stock_detail")
	public String removeUnusualStock(Model model) {
		
		model.addAttribute("title", "remove_unusual_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/stock/remove_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_unusual_stock_detail")
	public String modifyUnusualStock(Model model) {
		
		model.addAttribute("title", "modify_unusual_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/stock/modify_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_unusual_stock_detail")
	public String addUnusualStock(Model model) {
		
		model.addAttribute("title", "add_unusual_stock_detail");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/stock/add_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/unusual_stock_detail_list")
	public String getUnusualStockList(Model model) {
		
		List<UnusualStock> unusualStockList = stockService.getUnsualStockList();
		
		model.addAttribute("title", "unusual_stock_detail_list");
		model.addAttribute("unusualStockList", unusualStockList);
		
		return "admin/stock/unusual_stock_detail_list";
	}

	/**
	 * 상품 입출고 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_in_outcoming")
	public String removeInOutcoming(Model model) {
		
		model.addAttribute("title", "상품 입출고 삭제");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/stock/remove_in_outcoming";
	}
	
	/**
	 * 상품 입출고 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_in_outcoming")
	public String modifyInOutcoming(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "상품 입출고 수정");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/stock/modify_in_outcoming";
	}
	
	/**
	 * 상품 입출고 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_in_outcoming")
	public String addInOutcoming(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "상품 입출고 등록");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/stock/add_in_outcoming";
	}
	
	/**
	 * 상품 입출고 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/in_outcoming_list")
	public String getInOutcomingList(Model model) {
		
		List<InOutcoming> inOutcomingList = stockService.getInOutcomingList();
		log.info("inOutcomingList: {}", inOutcomingList);
		
		model.addAttribute("title", "상품 입출고 조회");
		model.addAttribute("inOutcomingList", inOutcomingList);
		
		return "admin/stock/in_outcoming_list";
	}
	
	/**
	 * 상품 재고 수정 @PostMapping
	 * @param stock
	 * @return
	 */
	@PostMapping("/modify_stock")
	public String modifyStock(Stock stock) {
		
		log.info("stock: {}", stock);
		
		stockService.modifyStock(stock);
		
		return "redirect:/admin/stock/stock_list";
	}
	
	/**
	 * 상품 재고 수정 @GetMapping
	 * @param model
	 * @param goodsStockCode
	 * @return
	 */
	@GetMapping("/modify_stock")
	public String modifyStock(Model model, @RequestParam(name="goodsStockCode") String goodsStockCode) {
		
		Stock stockInfo = stockService.getStockInfoByCode(goodsStockCode);
		log.info("stock: {}", stockInfo);
		
		model.addAttribute("title", "상품 재고 수정");
		model.addAttribute("stockInfo", stockInfo);
		
		return "admin/stock/modify_stock";
	}
	
	/**
	 * 상품 재고 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/stock_list")
	public String getStockList(Model model) {
		
		List<Stock> stockList = stockService.getStockList();
		log.info("stockList: {}", stockList);
		
		model.addAttribute("title", "상품 재고 조회");
		model.addAttribute("stockList", stockList);
		
		return "admin/stock/stock_list";
	}
}
