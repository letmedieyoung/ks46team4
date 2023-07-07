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
import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.InOutcomingForm;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;
import ks46team04.admin.mapper.FoundationMapper;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.mapper.StockMapper;
import ks46team04.admin.service.StockService;

@Controller
@RequestMapping("/admin/stock")
public class StockController {

	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);

	private final StockMapper stockMapper;
	private final StockService stockService;
	private final GoodsMapper goodsMapper;
	private final FoundationMapper foundationMapper;
	
	
	public StockController(StockMapper stockMapper
						, StockService stockService
						, GoodsMapper goodsMapper
						, FoundationMapper foundationMapper) {
		this.stockMapper = stockMapper;
		this.stockService = stockService;
		this.goodsMapper = goodsMapper;
		this.foundationMapper = foundationMapper;
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
		
		// 비정상재고 정보 수정
		stockService.modifyUnusualStock(unusualStock);
		
		// 해당 상품의 재고 정보 가져와서 비정상재고 수량 setting, 최종재고수량 계산
		Stock stockInfo = stockService.getStockInfoByCode(unusualStock.getGoodsStockCode());
		stockInfo.setUnusualStockAmount(unusualStock.getUnusualStockQuantity());
		stockInfo.calculFinalStock(stockInfo.getCurrentStockAmount(), stockInfo.getUnusualStockAmount());
		log.info("stockInfo: {}", stockInfo);
		
		// 상품 재고 수량 수정
		stockMapper.modifyStockAmount(stockInfo);
		
		return "redirect:/admin/stock/unusual_stock_detail_list";
	}
	
	/**
	 * 상품 비정상재고 수정 @GetMapping
	 * @param model
	 * @param unusualStockCode
	 * @return
	 */
	@GetMapping("/modify_unusual_stock_detail")
	public String modifyUnusualStock(Model model, @RequestParam(name="unusualStockCode") String unusualStockCode) {
		
		log.info("unusualStockCode: {}", unusualStockCode);
		
		UnusualStock unusualStockInfo = stockService.getUnusualStockInfoByCode(unusualStockCode);
		log.info("수정 전 unusualStockInfo: {}", unusualStockInfo);
		
		model.addAttribute("title", "상품 비정상 재고 수정");
		model.addAttribute("unusualStockInfo", unusualStockInfo);
		
		return "admin/stock/modify_unusual_stock_detail";
	}
	
	/**
	 * 상품 비정상재고 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_unusual_stock_detail")
	@ResponseBody
	public Map<String, Object> removeUnusualStock(@RequestParam(value="valueArr[]") List<String> valueArr) {
		
		log.info("valueArr: {}", valueArr);
		
		// 삭제된 항목을 담을 리스트 초기화
        List<String> removedUnusualStock = new ArrayList<>();
        
        for (String unusualStockCode : valueArr) {
        	
        	UnusualStock unusualStockInfo = stockService.getUnusualStockInfoByCode(unusualStockCode);
        	log.info("unusualStockInfo: {}", unusualStockInfo);
        	
        	// 삭제한 비정상재고 수량만큼 재고정보의 비정상 재고 수량 감소, 재고 수정 후 비정상재고 수량 반환 
        	int unusualStockAmount = stockService.decreaseUnusualStock(unusualStockInfo);
        	
        	// 상품의 비정상재고가 0인 경우 재고테이블의 비정상재고유무 false로 수정
        	if(unusualStockAmount == 0) {
        		stockService.modifyUnusualStockCheck(unusualStockInfo.getGoodsStockCode(), false);
        	}

    		// 비정상재고 정보 삭제
        	Map<String, String> removeMap = new HashMap<String, String>();
    		removeMap.put("removeKey", "unusualStockCode");
    		removeMap.put("removeValue", unusualStockCode);
    		stockService.removeUnusualStock(removeMap);
            
    		// 삭제된 항목 리스트에 추가
        	removedUnusualStock.add(unusualStockCode);
        }
        log.info("removedUnusualStock: {}", removedUnusualStock);
		
        // 삭제된 항목을 Map으로 전달
        Map<String, Object> response = new HashMap<>();
        response.put("removed", removedUnusualStock);
        log.info("response: {}", response);
        
		return response;
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
		
		List<UnusualStock> unusualStockList = stockMapper.getUnusualStockList();
		
		model.addAttribute("title", "상품 비정상 재고 조회");
		model.addAttribute("unusualStockList", unusualStockList);
		
		return "admin/stock/unusual_stock_detail_list";
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
		
	    // 비정상재고 정보 등록
		stockService.addUnusualStock(unusualStock);
		
		// 등록한 비정상재고 수량만큼 재고정보의 비정상 재고 수량 추가, 최종 재고 수량 수정
		stockService.increaseUnusualStock(unusualStock);
		
		// 재고 테이블의 비정상재고 유무를 업데이트
		stockService.modifyUnusualStockCheck(unusualStock.getGoodsStockCode(), true);
		
		return "redirect:/admin/stock/unusual_stock_detail_list";
	}
	
	
	/**
	 * 상품 비정상재고 등록 @GetMapping
	 * @param model
	 * @param goodsStockCode
	 * @return
	 */
	@GetMapping("/add_unusual_stock_detail")
	public String addUnusualStock(Model model
								, @RequestParam(name="goodsStockCode") String goodsStockCode
								, @RequestParam(name="goodsName") String goodsName
								, @RequestParam(name="goodsLotNumber") String goodsLotNumber) {
		
		model.addAttribute("title", "상품 비정상 재고 등록");
		model.addAttribute("goodsStockCode", goodsStockCode);
		model.addAttribute("goodsName", goodsName);
		model.addAttribute("goodsLotNumber", goodsLotNumber);
		
		List<UnusualStock> unusualStockListInfo = stockMapper.getUnsualStockListByStock(goodsStockCode);
		log.info("unusualStockListInfo: {}", unusualStockListInfo);
		
		if (unusualStockListInfo.size() > 0) {
	        model.addAttribute("unusualStockListInfo", unusualStockListInfo);
	    } else {
	        model.addAttribute("unusualStockListInfo", null);
	    }
		
		return "admin/stock/add_unusual_stock_detail";
	}
	
	
	/**
	 * 상품 재고조사 정보 수정 @PostMapping
	 * @param stock
	 * @return
	 */
	@PostMapping("/modify_stocktaking")
	public String modifyStocktaking(Stock stock) {
		
		log.info("stock: {}", stock);
		
		stockService.modifyStocktaking(stock);
		
		return "redirect:/admin/stock/stock_list";
	}
	
	/**
	 * 상품 재고 수정 @GetMapping
	 * @param model
	 * @param goodsStockCode
	 * @return
	 */
	@GetMapping("/modify_stocktaking")
	public String modify_stocktaking(Model model, @RequestParam(name="goodsStockCode") String goodsStockCode) {
		
		log.info("goodsStockCode: {}", goodsStockCode);
		
		Stock stockInfo = stockService.getStockInfoByCode(goodsStockCode);
		log.info("stockInfo: {}", stockInfo);
		
		model.addAttribute("title", "상품 재고조사 정보 수정");
		model.addAttribute("stockInfo", stockInfo);
		
		return "admin/stock/modify_stocktaking";
	}
	
	/**
	 * 상품 재고 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_stock")
	@ResponseBody
	public Map<String, Object> removeStock(@RequestParam(value="valueArr[]") List<String> valueArr) {
		
		log.info("valueArr: {}", valueArr);
		
		// 삭제된 항목을 담을 리스트 초기화
        List<String> removedStock = new ArrayList<>(); 
        List<String> notRemovedStock = new ArrayList<>();
        
        for (String goodsStockCode : valueArr) {
        	// 최종 상품 재고 수량이 0인 경우 재고 정보 삭제
        	boolean isRemove = stockService.removeStockByCode(goodsStockCode);
        	if(isRemove) {
        		// 삭제된 항목 리스트에 추가
        		removedStock.add(goodsStockCode);
        	}else {
        		// 삭제되지 않은 항목 리스트에 추가
        		notRemovedStock.add(goodsStockCode);
        	}
        }
        log.info("removedStock: {}", removedStock);
        log.info("notRemovedStock: {}", notRemovedStock);

        // 삭제된 항목과 삭제되지 않은 항목을 Map으로 전달
        Map<String, Object> response = new HashMap<>();
        response.put("removed", removedStock);
        response.put("notRemoved", notRemovedStock);
        log.info("response: {}", response);

        return response;
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
		
		List<Stock> stockList = stockMapper.getStockList();
		log.info("stockList: {}", stockList);
		
		model.addAttribute("title", "상품 재고 조회");
		model.addAttribute("stockList", stockList);
		
		return "admin/stock/stock_list";
	}

	/**
	 * 상품 입출고 수정 @PostMapping
	 * @param inOutcoming
	 * @param session
	 * @return
	 */
	@PostMapping("/modify_in_outcoming")
	public String modifyInOutcoming(InOutcomingForm inOutcomingForm, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
	    log.info("sessionId: {}", sessionId);
	    
	    String inOutcomingType = inOutcomingForm.getInOutcomingType();
	    
    	if(inOutcomingType.equals("incoming") || inOutcomingType.equals("exchange")) {
			// 상품 입고 또는 교환인 경우, 해당 상품 수량만큼 현재 수량 증가
    		stockService.increaseCurrentStock(inOutcomingForm);
		}else if(inOutcomingType.equals("outcoming") || inOutcomingType.equals("disposal")){ 
			// 상품 출고 또는 폐기인 경우, 해당 상품 수량만큼 현재 수량 차감
			stockService.decreaseCurrentStock(inOutcomingForm);
		}
    	
    	// 상품 입출고 이력 수정
		String inOutcomingCode = stockService.modifyInOutcoming(sessionId, inOutcomingForm);
	  
		// 상품 출고인 경우 - 상품 출고 상세정보 수정
	    if(inOutcomingType.equals("outcoming")) {
	    	stockService.modifyOutcomingDetail(sessionId, inOutcomingCode, inOutcomingForm);
	    }
	    
	    return "redirect:/admin/stock/in_outcoming_list";
	}
	
	/**
	 * 상품 입출고 수정 @GetMapping
	 * @param model
	 * @param inOutcomingCode
	 * @return
	 */
	@GetMapping("/modify_in_outcoming")
	public String modifyInOutcoming(Model model, @RequestParam(name="inOutcomingCode") String inOutcomingCode) {
		
		
		List<String> goodsNameList = goodsMapper.getGoodsNameList();
		log.info("goodsNameList: {}", goodsNameList);
		
		List<String> foundationNameList = foundationMapper.getFoundationNameList();
		log.info("foundationNameList: {}", foundationNameList);
		
		InOutcomingForm inOutcomingForm = stockService.getInOutcomingFormByCode(inOutcomingCode);
		
		log.info("inOutcomingForm: {}", inOutcomingForm);
		
		model.addAttribute("title", "상품 입출고 수정");
		model.addAttribute("goodsNameList", goodsNameList);
		model.addAttribute("foundationNameList", foundationNameList);
		model.addAttribute("inOutcomingForm", inOutcomingForm);
	    
	    return "admin/stock/modify_in_outcoming";
	}
	
	
	/**
	 * 상품 입출고 등록 @PostMapping
	 * @param inOutcomingForm
	 * @param session
	 * @return
	 */
	@PostMapping("/add_in_outcoming")
	public String addInOutcoming(InOutcomingForm inOutcomingForm, HttpSession session) {

		String sessionId = (String) session.getAttribute("SID");
		log.info("sessionId: {}", sessionId);
		
	    // 상품 입출고 수량만큼 재고 수량 업데이트 - 새로운 상품 입고인 경우 재고 등록, 기존 상품 입출고일 경우 재고 수량 증감
	    boolean isNewStockInfo = stockService.checkStockInfo(inOutcomingForm.getGoodsName()
	    													,inOutcomingForm.getGoodsLotNumber());
	    String inOutcomingType = inOutcomingForm.getInOutcomingType();
	    
	    if(inOutcomingType.equals("incoming") || inOutcomingType.equals("exchange")) {
	    	 if (isNewStockInfo) {
	    		 // 새로운 상품 입고인 경우 재고 등록
		         stockService.addStockInfo(inOutcomingForm);
		     } else {
		    	 // 상품 입고 또는 교환받은 상품인 경우, 해당 상품 수량만큼 현재 수량 증가
		    	 stockService.increaseCurrentStock(inOutcomingForm);
		     }
     		// 상품 입출고 이력 등록
     		stockService.addInOutcoming(sessionId, inOutcomingForm);
	    }else if(inOutcomingType.equals("outcoming") || inOutcomingType.equals("disposal")){
	        if (isNewStockInfo) {
	            // 출고,폐기인 경우 기존에 등록된 재고 정보가 없으면 오류 처리
	            throw new RuntimeException("등록된 재고 정보가 없습니다.");
	        } else {
    			// 상품 출고 또는 폐기인 경우, 해당 상품 수량만큼 현재 수량 차감
    			stockService.decreaseCurrentStock(inOutcomingForm);
	        	// 상품 입출고 이력 등록
	    		String inOutcomingCode = stockService.addInOutcoming(sessionId, inOutcomingForm);
	    	    // 상품 출고인 경우 - 상품 출고 상세정보 등록
	    	    if(inOutcomingType.equals("outcoming")) {
	    	    	stockService.addOutcomingDetail(sessionId, inOutcomingCode, inOutcomingForm);
	    	    }
	        }
	    }
	    
		return "redirect:/admin/stock/in_outcoming_list";
	}
	
	/**
	 * 상품 입출고 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_in_outcoming")
	public String addInOutcoming(Model model) {
		
		List<String> goodsNameList = goodsMapper.getGoodsNameList();
		log.info("goodsNameList: {}", goodsNameList);
		
		List<String> foundationNameList = foundationMapper.getFoundationNameList();
		log.info("foundationNameList: {}", foundationNameList);
		
		model.addAttribute("title", "상품 입출고 등록");
		model.addAttribute("goodsNameList", goodsNameList);
		model.addAttribute("foundationNameList", foundationNameList);
    	
		return "admin/stock/add_in_outcoming";
	}
	
	/**
	 * 상품 입출고 삭제
	 * @param valueArr
	 * @return
	 */
	@PostMapping("/remove_in_outcoming")
	@ResponseBody
	public Map<String, Object> removeInOutcoming(@RequestParam(value = "valueArr[]") List<String> valueArr) {

	    log.info("valueArr: {}", valueArr);

	    // 삭제된 항목을 담을 리스트 초기화
	    List<String> removedInOutcoming = new ArrayList<>();

	    // 입출고 정보 가져오기
	    for (String inOutcomingCode : valueArr) {
	    	// 입출고 정보 삭제
	    	stockService.removeInOutcomingByCode(inOutcomingCode);
	    
            // 삭제된 입출고 정보 리스트에 추가
            removedInOutcoming.add(inOutcomingCode);
	    }

	    log.info("removedInOutcoming: {}", removedInOutcoming);

	    // 삭제된 항목을 Map으로 전달
	    Map<String, Object> response = new HashMap<>();
	    response.put("removed", removedInOutcoming);
	    log.info("response: {}", response);

	    return response;
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
	public List<InOutcoming> getInOutcomingListBySearch(@RequestParam(value="inputSearchKey", required = false) String inputSearchKey 
													, @RequestParam(value="inputSearchValue", required = false) String inputSearchValue
													, @RequestParam(value="dateSearchKey", required = false) String dateSearchKey
													, @RequestParam(value="startDate", required = false) String startDate
													, @RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("inputSearchKey: {}, inputSearchValue: {}, dateSearchKey: {}, startDate: {}, endDate: {}"
				, inputSearchKey, inputSearchValue, dateSearchKey, startDate, endDate);	
		
		List<InOutcoming> inOutcomingList = stockService.getInOutcomingListBySearch(inputSearchKey
																					, inputSearchValue
																					, dateSearchKey
																					, startDate
																					, endDate);
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
		
		List<InOutcoming> inOutcomingList = stockMapper.getInOutcomingList();
		log.info("inOutcomingList: {}", inOutcomingList);
		
		model.addAttribute("title", "상품 입출고 조회");
		model.addAttribute("inOutcomingList", inOutcomingList);
		
		return "admin/stock/in_outcoming_list";
	}
	
}
