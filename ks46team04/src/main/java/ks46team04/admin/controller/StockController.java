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

import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.OutcomingDetail;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;
import ks46team04.admin.service.FoundationService;
import ks46team04.admin.service.GoodsService;
import ks46team04.admin.service.StockService;

@Controller
@RequestMapping("/admin/stock")
public class StockController {

	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	private final StockService stockService;
	private final GoodsService goodsService;
	private final FoundationService foundationService;
	
	public StockController(StockService stockService, GoodsService goodsService, FoundationService foundationService) {
		this.stockService = stockService;
		this.goodsService = goodsService;
		this.foundationService = foundationService;
	}
	
	
	/**
	 * 상품 비정상재고 삭제
	 * @param model
	 * @return
	 */
	@PostMapping("/remove_unusual_stock_detail")
	@ResponseBody
	public List<String> removeUnusualStock(@RequestParam(value="valueArr[]") List<String> valueArr) {
		
		log.info("valueArr: {}", valueArr);
		stockService.removeUnusualStock(valueArr);
		
		return valueArr;
	}
	
	/**
	 * 상품 비정상재고 수정 @PostMapping
	 * @param unusualStock
	 * @param session
	 * @return
	 */
	@PostMapping("/modify_unusual_stock_detail")
	public String modifyUnusualStock(UnusualStock unusualStock, HttpSession session) {
		
		String unusualStockUpdId = (String) session.getAttribute("SID");
		log.info("unusualStockUpdId: {}", unusualStockUpdId);
		
		unusualStock.setUnusualStockUpdId(unusualStockUpdId);
		log.info("unusualStock: {}", unusualStock);
		
		stockService.modifyUnusualStock(unusualStock);
		
		return "redirect:/admin/stock/unusual_stock_detail_list";
	}
	
	/**
	 * 상품 비정상재고 수정 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_unusual_stock_detail")
	public String modifyUnusualStock(Model model, @RequestParam(name="unusualStockCode") String unusualStockCode) {
		
		log.info("unusualStockCode: {}", unusualStockCode);
		
		UnusualStock unusualStockInfo = stockService.getUnusualStockInfoByCode(unusualStockCode);
		String goodsCode = unusualStockInfo.getGoodsCode();
		Goods goodsInfo = goodsService.getGoodsInfoByCode(goodsCode);
		unusualStockInfo.setGoodsInfo(goodsInfo);
		log.info("unusualStockInfo: {}", unusualStockInfo);
		
		model.addAttribute("title", "상품 비정상 재고 수정");
		model.addAttribute("unusualStockInfo", unusualStockInfo);
		
		return "admin/stock/modify_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 등록 @PostMapping
	 * @param unusualStock
	 * @param session
	 * @return
	 */
	@PostMapping("/add_unusual_stock_detail")
	public String addUnusualStock(UnusualStock unusualStock, HttpSession session) {
		
		String unusualStockRegId = (String) session.getAttribute("SID");
	    log.info("unusualStockRegId: {}", unusualStockRegId);
	    
	    unusualStock.setUnusualStockRegId(unusualStockRegId);
		log.info("unusualStock: {}", unusualStock);
		
		stockService.addUnusualStock(unusualStock);
		
		return "redirect:/admin/stock/unusual_stock_detail_list";
	}
	
	/**
	 * 상품 비정상재고 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_unusual_stock_detail")
	public String addUnusualStock(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "상품 비정상 재고 등록");
		
		return "admin/stock/add_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 검색 결과 조회
	 * @param inputSearchKey
	 * @param inputSearchValue
	 * @param dateSearchKey
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/search_unusual_stock_detail_list")
	@ResponseBody
	public List<UnusualStock> getUnusualStockListBySearch(@RequestParam(value="inputSearchKey", required = false) String inputSearchKey 
														, @RequestParam(value="inputSearchValue", required = false) String inputSearchValue
														, @RequestParam(value="dateSearchKey", required = false) String dateSearchKey
														, @RequestParam(value="startDate", required = false) String startDate
														, @RequestParam(value="endDate", required = false) String endDate) {
		log.info("inputSearchKey: {}, inputSearchValue: {}, stocktakingKey: {}, stocktakingValue: {},"
				+ "unusualStockKey: {},unusualStockValue: {}, dateSearchKey: {}, startDate: {}, endDate: {}", 
				inputSearchKey, inputSearchValue, dateSearchKey, startDate, endDate);

		
		
		List<UnusualStock> unusualStockList = stockService.getUnusualStockListBySearch(inputSearchKey
																					, inputSearchValue
																					, dateSearchKey
																					, startDate
																					, endDate);
		
		log.info("unusualStockList: {}", unusualStockList);
		
		return unusualStockList;
	}
	
	/**
	 * 상품 비정상재고 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/unusual_stock_detail_list")
	public String getUnusualStockList(Model model) {
		
		List<UnusualStock> unusualStockList = stockService.getUnsualStockList();
		
		model.addAttribute("title", "상품 비정상 재고 조회");
		model.addAttribute("unusualStockList", unusualStockList);
		
		return "admin/stock/unusual_stock_detail_list";
	}

	/**
	 * 상품 입출고 삭제
	 * @param model
	 * @return
	 */
	@PostMapping("/remove_in_outcoming")
	@ResponseBody
	public List<String> removeInOutcoming(@RequestParam(value="valueArr[]") List<String> valueArr) {
		
		log.info("valueArr: {}", valueArr);
		stockService.removeInOutcoming(valueArr);
		
		return valueArr;
	}
	
	/**
	 * 상품 입출고 수정 @PostMapping
	 * @param inOutcoming
	 * @param session
	 * @return
	 */
	@PostMapping("/modify_in_outcoming")
	public String modifyInOutcoming(InOutcoming inOutcoming, HttpSession session) {
		
		String inOutcomingUpdId = (String) session.getAttribute("SID");
	    log.info("inOutcomingUpdId: {}", inOutcomingUpdId);
	    
	    inOutcoming.setInOutcomingUpdId(inOutcomingUpdId);
	    log.info("inOutcoming: {}", inOutcoming);
	    
	    stockService.modifyInOutcoming(inOutcoming);
	    
	    return "redirect:/admin/stock/in_outcoming_list";
	}
	
	/**
	 * 상품 입출고 수정 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_in_outcoming")
	public String modifyInOutcoming(Model model, @RequestParam(name="inOutcomingCode") String inOutcomingCode) {
	    
		
		log.info("inOutcomingCode: {}", inOutcomingCode);
		
		InOutcoming inOutcomingInfo = stockService.getInOutcomingInfoByCode(inOutcomingCode);
		
		String goodsCode = inOutcomingInfo.getGoodsCode();
		Goods goodsInfo = goodsService.getGoodsInfoByCode(goodsCode);
		log.info("goodsInfo: {}", goodsInfo);
		inOutcomingInfo.setGoodsInfo(goodsInfo);
		
		if(inOutcomingInfo.getInOutcomingType().equals("outcoming")){
			OutcomingDetail outcomingDetailInfo = stockService.getOutcomingDetailInfoByCode(inOutcomingCode);
			String foundationCode = outcomingDetailInfo.getFoundationCode();
			Foundation foundationInfo = foundationService.getFoundationInfoByCode(foundationCode);
			log.info("foundationInfo: {}", foundationInfo);
		}
		
		log.info("inOutcomingInfo: {}", inOutcomingInfo);
		
		model.addAttribute("title", "상품 입출고 수정");
		model.addAttribute("inOutcomingInfo", inOutcomingInfo);
	    
	    return "admin/stock/modify_in_outcoming";
	}
	
	
	/**
	 * 상품 입출고 등록 @PostMapping
	 * @param InOutcoming
	 * @param session
	 * @return
	 */
	@PostMapping("/add_in_outcoming")
	public String addInOutcoming(InOutcoming inOutcoming, HttpSession session, Model model) {

		String inOutcomingRegId = (String) session.getAttribute("SID");
		log.info("inOutcomingRegId: {}", inOutcomingRegId);

		inOutcoming.setInOutcomingRegId(inOutcomingRegId);
	    log.info("inOutcoming: {}", inOutcoming);
	    
	    // 상품 입출고 등록
	    stockService.addInOutcoming(inOutcoming);
	    
	    // 등록된 입출고 정보 가져오기
	    InOutcoming lastInOutcomingInfo = stockService.getLastInOutcomingInfo();
	    log.info("lastInOutcomingInfo: {}", lastInOutcomingInfo);
	    
	    // 상품 출고가 등록된 경우 - 상품 출고상세 등록
	    String inOutcomingType = lastInOutcomingInfo.getInOutcomingType();
	    log.info("inOutcomingType: {}", inOutcomingType);
	    
	    boolean isOutcoming = inOutcomingType.equals("outcoming");
	    if(isOutcoming) {
	    	String foundationName = (String) model.getAttribute("foundationName");
	    	log.info("foundationName: {}", foundationName);
	    	lastInOutcomingInfo.setFoundationName(foundationName);
	    	
	    	String outcomingId = (String) model.getAttribute("outcomingId");
	    	log.info("outcomingId: {}", outcomingId);
	    	lastInOutcomingInfo.setOutcomingId(outcomingId);
	    	
	    	stockService.addOutcomingDetail(lastInOutcomingInfo);
	    }
	    
	    // 상품 재고 등록
	    stockService.addStock(lastInOutcomingInfo);
	    
		return "redirect:/admin/stock/in_outcoming_list";
	}
	
	/**
	 * 상품 입출고 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_in_outcoming")
	public String addInOutcoming(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "상품 입출고 등록");
		
		return "admin/stock/add_in_outcoming";
	}
	
	/**
	 * 상품 입출고 검색 결과 조회
	 * @param searchKey
	 * @param searchValue
	 * @param dateSearchKey
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/search_in_outcoming_list")
	@ResponseBody
	public List<InOutcoming> getInOutcomingListBySearch(@RequestParam(value="searchKey", required = false) String searchKey 
													, @RequestParam(value="searchValue", required = false) String searchValue
													, @RequestParam(value="dateSearchKey", required = false) String dateSearchKey
													, @RequestParam(value="startDate", required = false) String startDate
													, @RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("searchKey: {}, searchValue: {}, dateSearchKey: {}, startDate: {}, endDate: {}"
				, searchKey, searchValue, dateSearchKey, startDate, endDate);	
		
		List<InOutcoming> inOutcomingList = stockService.getInOutcomingListBySearch(searchKey, searchValue, dateSearchKey, startDate, endDate);
		log.info("inOutcomingList: {}", inOutcomingList);

		return inOutcomingList;
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
		
		log.info("goodsStockCode: {}", goodsStockCode);
		
		Stock stockInfo = stockService.getStockInfoByCode(goodsStockCode);
		String goodsCode = stockInfo.getGoodsCode();
		Goods goodsInfo = goodsService.getGoodsInfoByCode(goodsCode);
		stockInfo.setGoodsInfo(goodsInfo);
		log.info("stockInfo: {}", stockInfo);
		
		model.addAttribute("title", "상품 재고 수정");
		model.addAttribute("stockInfo", stockInfo);
		
		return "admin/stock/modify_stock";
	}
	
	/**
	 * 상품 재고 검색 결과 조회
	 * @param inputSearchKey
	 * @param inputSearchValue
	 * @param stocktakingKey
	 * @param stocktakingValue
	 * @param unusualStockKey
	 * @param unusualStockValue
	 * @param dateSearchKey
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/search_stock_list")
	@ResponseBody
	public List<Stock> getStockListBySearch(@RequestParam(value="inputSearchKey", required = false) String inputSearchKey 
										, @RequestParam(value="inputSearchValue", required = false) String inputSearchValue
										, @RequestParam(value="stocktakingKey", required = false) String stocktakingKey
										, @RequestParam(value="stocktakingValue", required = false) String stocktakingValue
										, @RequestParam(value="unusualStockKey", required = false) String unusualStockKey
										, @RequestParam(value="unusualStockValue", required = false) String unusualStockValue
										, @RequestParam(value="dateSearchKey", required = false) String dateSearchKey
										, @RequestParam(value="startDate", required = false) String startDate
										, @RequestParam(value="endDate", required = false) String endDate) {
		log.info("inputSearchKey: {}, inputSearchValue: {}, stocktakingKey: {}, stocktakingValue: {},"
				+ "unusualStockKey: {},unusualStockValue: {}, dateSearchKey: {}, startDate: {}, endDate: {}", 
				inputSearchKey, inputSearchValue, stocktakingKey, stocktakingValue, unusualStockKey, unusualStockValue, dateSearchKey, startDate, endDate);

		
		
		List<Stock> stockList = stockService.getStockListBySearch(inputSearchKey
																, inputSearchValue
																, stocktakingKey
																, stocktakingValue
																, unusualStockKey
																, unusualStockValue
																, dateSearchKey
																, startDate
																, endDate);
		
		log.info("stockList: {}", stockList);
		
		return stockList;
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
