package ks46team04.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.InOutcomingForm;
import ks46team04.admin.dto.OutcomingDetail;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;
import ks46team04.admin.mapper.CommonMapper;
import ks46team04.admin.mapper.FoundationMapper;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.mapper.StockMapper;

@Service
@Transactional
public class StockService {

	
	private static final Logger log = LoggerFactory.getLogger(StockService.class);

	private final StockMapper stockMapper;
	private final CommonMapper commonMapper;
	private final GoodsMapper goodsMapper;
	private final FoundationMapper foundationMapper;
	
	public StockService(StockMapper stockMapper
						, CommonMapper commonMapper
						, GoodsMapper goodsMapper
						, FoundationMapper foundationMapper) {
		this.stockMapper = stockMapper;
		this.commonMapper = commonMapper;
		this.goodsMapper = goodsMapper;
		this.foundationMapper = foundationMapper;
		
	}
	
	/**
	 * 상품 비정상재고 수정
	 * @param unusualStock 비정상재고 정보
	 */
	public void modifyUnusualStock(UnusualStock unusualStock) {
		stockMapper.modifyUnusualStock(unusualStock);
	}
	
	/**
	 * 특정 상품 비정상재고 조회
	 * @param unusualStockCode 비정상재고 코드
	 * @return
	 */
	public UnusualStock getUnusualStockInfoByCode(String unusualStockCode) {
		UnusualStock unusualStockInfo = stockMapper.getUnusualStockInfoByCode(unusualStockCode);
		return unusualStockInfo;
	}
	
	/**
	 * 상품 비정상 재고 삭제
	 * @param removeUnusualStockMap 비정상재고 삭제 맵
	 */
	public void removeUnusualStock(Map<String, String> removeUnusualStockMap) {
		String removeUnusualStockKey = removeUnusualStockMap.get("removeKey");
		String removeUnusualStockValue = removeUnusualStockMap.get("removeValue");
		
		if(removeUnusualStockKey != null && removeUnusualStockValue != null) {
			switch(removeUnusualStockKey) {
			case "goodsCode":
				removeUnusualStockKey = "goods_code";
				break;
			case "goodsStockCode":
				removeUnusualStockKey = "goods_stock_code";
				break;
			case "unusualStockCode":
				removeUnusualStockKey = "unusual_stock_detail_code";					
				break;
			}
			removeUnusualStockMap.put("removeUnusualStockKey", removeUnusualStockKey);
			removeUnusualStockMap.put("removeUnusualStockValue", removeUnusualStockValue);
		}
		log.info("removeUnusualStockMap: {}", removeUnusualStockMap);
		
		stockMapper.removeUnusualStock(removeUnusualStockMap);
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
	public List<UnusualStock> getUnusualStockListBySearch(String inputSearchKey
														, String inputSearchValue
														, String dateSearchKey
														, String startDate
														, String endDate){
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		if(inputSearchKey != null && inputSearchValue != null) {
			switch (inputSearchKey) {
			case "goodsName":
				inputSearchKey = "i.goods_name";
				break;
			case "unusualStockReason":
				inputSearchKey = "u.unusual_stock_reason";					
				break;
			}
			searchMap.put("inputSearchKey", inputSearchKey);
			searchMap.put("inputSearchValue", inputSearchValue);
		}
		

		if(startDate != null && endDate != null) {
			searchMap.put("dateSearchKey", dateSearchKey);
			searchMap.put("startDate", startDate);
			searchMap.put("endDate", endDate);
		}
		log.info("searchMap: {}", searchMap);
		
		List<UnusualStock> unusualStockList = stockMapper.getUnusualStockListBySearch(searchMap);
		return unusualStockList;
	}
	
	/**
	 * 재고 테이블의 비정상재고 유무 수정
	 * @param goodsStockCode 상품재고코드
	 * @param unusualStockCheck 비정상재고유무 (유:true,무:false)
	 */
	public void modifyUnusualStockCheck(String goodsStockCode, boolean unusualStockCheck) {
		
		Map<String, Object> unusualStockCheckMap = new HashMap<>();
		unusualStockCheckMap.put("goodsStockCode", goodsStockCode);
		if(unusualStockCheck) {
			unusualStockCheckMap.put("unusualStockCheck", 1);
		}else {
			unusualStockCheckMap.put("unusualStockCheck", 0);
		}
		log.info("unusualStockCheckMap: {}", unusualStockCheckMap);
		
		stockMapper.modifyUnusualStockCheck(unusualStockCheckMap);
	}
	
	/**
	 * 비정상재고 수량만큼 기존 최종 재고 수량 증가
	 * @param unusualStock 비정상재고 정보
	 */
	public void increaseUnusualStock(UnusualStock unusualStock) {
		
		Stock stock = getStockInfoByCode(unusualStock.getGoodsStockCode());
	    
		stock.addUnusualStock(unusualStock.getUnusualStockQuantity());
	    
	    stock.calculFinalStock(stock.getCurrentStockAmount(), stock.getUnusualStockAmount());
	    
	    // 증가 후 상품 비정상재고 수량
	    log.info("unusualStockAmount: {}", stock.getUnusualStockAmount());
	    
	    // 증가 후 최종 상품 수량
	    log.info("finalStockAmount: {}", stock.getFinalStockAmount());
	    
	    log.info("stock: {}", stock);
	    
	    stockMapper.modifyStockAmount(stock);
	}

	/**
	 * 비정상재고 수량만큼 기존 최종 재고 수량 감소
	 * @param unusualStock 비정상재고 정보
	 * @return
	 */
	public int decreaseUnusualStock(UnusualStock unusualStock) {
	    
	    Stock stock = getStockInfoByCode(unusualStock.getGoodsStockCode());
	    
	    stock.removeUnusualStock(unusualStock.getUnusualStockQuantity());
	    
	    stock.calculFinalStock(stock.getCurrentStockAmount(), stock.getUnusualStockAmount());
	    
	    // 차감 후 상품 비정상재고 수량
	    log.info("unusualStockAmount: {}", stock.getUnusualStockAmount());
	   
	    // 증가 후 최종 상품 수량
	    log.info("finalStockAmount: {}", stock.getFinalStockAmount());
	    
	    log.info("stock: {}", stock);
	    
	    stockMapper.modifyStockAmount(stock);
	    
	    return stock.getFinalStockAmount();
	}
	
	/**
	 * 상품 비정상재고 등록
	 * @param unusualStock 비정상재고 정보
	 * @return
	 */
	public int addUnusualStock(UnusualStock unusualStock) {
		
		// 상품 비정상재고코드 - 공통 mapper를 사용하여 unusualStockCode 생성 및 설정
		String unusualStockCode = commonMapper.getPrimaryKeyVerTwo("unusual_stock_detail"
																,"unusual_stock_detail_code"
																,"discared_stock");
		log.info("unusualStockCode: {}", unusualStockCode);
		unusualStock.setUnusualStockCode(unusualStockCode);
		
		String goodsCode = goodsMapper.getGoodsCodeByName(unusualStock.getGoodsName());
		log.info("goodsCode: {}", goodsCode);
		unusualStock.setGoodsCode(goodsCode);
		
		log.info("unusualStock: {}", unusualStock);
		
		int result = stockMapper.addUnusualStock(unusualStock);
		return result;
	}
	
	/**
	 * 상품 재고조사 정보 수정
	 * @param stock 재고 정보
	 * @return
	 */
	public void modifyStocktaking(Stock stock) {
		
		Map<String, Object> stocktakingMap = new HashMap<>();
		boolean stocktakingCheck = stock.getStocktakingCheck();
		if(stocktakingCheck) {
			stocktakingMap.put("stocktakingCheck", 1);
			stocktakingMap.put("stocktakingDate", stock.getStocktakingDate());
		}else {
			stocktakingMap.put("stocktakingCheck", 0);
			stocktakingMap.put("stocktakingDate", null);
		}
		stocktakingMap.put("goodsStockCode", stock.getGoodsStockCode());
		stocktakingMap.put("goodsExpiryDate", stock.getGoodsExpiryDate());
		
		log.info("stocktakingMap: {}", stocktakingMap);
		stockMapper.modifyStocktaking(stocktakingMap);
	}
	
	/**
	 * 특정 상품 재고 조회 
	 * @param goodsStockCode 상품재고코드
	 * @return
	 */
	public Stock getStockInfoByCode(String goodsStockCode) {
		Stock stockInfo = stockMapper.getStockInfoByCode(goodsStockCode);
		return stockInfo;
	}
	
	/**
	 * 상품재고코드로 재고 정보 삭제
	 * @param goodsStockCode 상품재고코드
	 * @return 삭제 여부 (최종 상품 재고 수량이 0으로 재고 삭제 완료한 경우 true, 아니면 false)
	 */
	public boolean removeStockByCode(String goodsStockCode) {
		Stock stockInfo = getStockInfoByCode(goodsStockCode);
		
		// 최종 상품 재고 수량이 0인 경우 재고 정보 삭제
		if(stockInfo.getFinalStockAmount() == 0) {
			
			Map<String, Object> goodsInfoMap = new HashMap<String, Object>();
			goodsInfoMap.put("goodsCode", stockInfo.getGoodsCode());
			goodsInfoMap.put("goodsLotNumber", stockInfo.getGoodsLotNumber());
			
			// 해당 재고의 모든 입출고코드 조회
    		List<String> inOutcomingCodeList = stockMapper.getInOutcomingCodeList(goodsInfoMap);
    		log.info("inOutcomingCodeList: {}", inOutcomingCodeList);
    		
    		for(String inOutcomingCode : inOutcomingCodeList) {
    			// 입출고 정보 삭제
    			removeInOutcoming(inOutcomingCode);
    		}
    		
    		Map<String, String> removeMap = new HashMap<String, String>();
    		removeMap.put("removeKey", "goodsStockCode");
    		removeMap.put("removeValue", goodsStockCode);
    		
    		// 상품재고의 모든 비정상재고 정보 삭제
    		removeUnusualStock(removeMap);
    		// 상품재고 삭제
			removeStock(removeMap);
			
			return true;
		}
		return false;
	}
	
	/**
	 * 상품코드로 재고 정보 삭제
	 * @param goodsCode 상품코드
	 * @return 삭제 여부 (재고 테이블에 삭제될 상품코드의 최종재고량이 모두 0으로 삭제 완료한 경우 true, 아니면 false)
	 */
	public boolean removeStockByGoods(String goodsCode) {
		// 삭제 상품 재고 유무 확인 - 재고 테이블에 삭제될 상품코드의 최종재고량이 모두 0인 경우 true 반환
		boolean isEmpty = stockMapper.removeStockCheck(goodsCode);
		
		if(isEmpty) {
			Map<String, Object> goodsInfoMap = new HashMap<String, Object>();
			goodsInfoMap.put("goodsCode", goodsCode);
			
			// 해당 상품코드의 모든 입출고코드 조회
    		List<String> inOutcomingCodeList = stockMapper.getInOutcomingCodeList(goodsInfoMap);
    		log.info("inOutcomingCodeList: {}", inOutcomingCodeList);
    		
    		// 상품코드의 모든 입출고 정보 삭제
    		for(String inOutcomingCode : inOutcomingCodeList) {
    			// 입출고 정보 삭제
    			removeInOutcoming(inOutcomingCode);
    		}
			
			Map<String, String> removeMap = new HashMap<String, String>();
			removeMap.put("removeKey", "goodsCode");
			removeMap.put("removeValue", goodsCode);
			
			// 상품재고의 모든 비정상재고 정보 삭제
			removeUnusualStock(removeMap);
			
			// 상품재고 삭제
			removeStock(removeMap);
			
			return true;
    	}
		return false;
	}
	
	/**
	 * removeStockMap 삭제 맵으로 상품 재고 삭제
	 * @param removeStockMap 삭제 맵 (removeKey: 삭제 키, removeValue: 삭제 값)
	 */
	public void removeStock(Map<String, String> removeStockMap) {
		String removeStockKey = removeStockMap.get("removeKey");
		String removeStockValue = removeStockMap.get("removeValue");
		
		if(removeStockKey != null) {
			switch(removeStockKey) {
			case "goodsCode":
				removeStockKey = "goods_code";					
				break;
			case "goodsStockCode":
				removeStockKey = "goods_stock_code";
				break;
			}
			removeStockMap.put("removeStockKey", removeStockKey);
			removeStockMap.put("removeStockValue", removeStockValue);
		}
		log.info("removeStockMap: {}", removeStockMap);
		
		stockMapper.removeStock(removeStockMap);
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
	public List<Stock> getStockListBySearch(String inputSearchKey
											, String inputSearchValue
											, String stocktakingKey
											, String stocktakingValue
											, String unusualStockKey
											, String unusualStockValue
											, String dateSearchKey
											, String startDate
											, String endDate){
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		if(inputSearchKey != null && inputSearchValue != null) {
			switch (inputSearchKey) {
			case "goodsName":
				inputSearchKey = "i.goods_name";
				break;
			case "goodsLotNumber":
				inputSearchKey = "s.goods_lot_number";					
				break;
			case "goodsCompany":
				inputSearchKey = "i.goods_company";					
				break;
			}
			searchMap.put("inputSearchKey", inputSearchKey);
			searchMap.put("inputSearchValue", inputSearchValue);
		}
		
		if(stocktakingKey != null && stocktakingValue != null) {
			stocktakingKey = "s.stocktaking_check";					
			searchMap.put("stocktakingKey", stocktakingKey);
			
			switch (stocktakingValue) {
			case "전체":
				stocktakingValue = "";
				break;
			case "완료":
				stocktakingValue = "1";					
				break;
			case "미완료":
				stocktakingValue = "0";					
				break;
			}
			searchMap.put("stocktakingValue", stocktakingValue);
		}
		
		if(unusualStockKey != null && unusualStockValue != null) {
			unusualStockKey = "s.unusual_stock_check";					
			searchMap.put("unusualStockKey", unusualStockKey);
			
			switch (unusualStockValue) {
			case "전체":
				unusualStockValue = "";
				break;
			case "유":
				unusualStockValue = "1";					
				break;
			case "무":
				unusualStockValue = "0";					
				break;
			}
			searchMap.put("unusualStockValue", unusualStockValue);
		}
		
		if(dateSearchKey != null && startDate != null && endDate != null) {
			switch (dateSearchKey) {
			case "goodsExprityDate":
				dateSearchKey = "s.goods_expiry_date";
				break;
			case "stocktakingDate":
				dateSearchKey = "s.stocktaking_date";					
				break;
			}
			searchMap.put("dateSearchKey", dateSearchKey);
			searchMap.put("startDate", startDate);
			searchMap.put("endDate", endDate);
		}
		log.info("searchMap: {}", searchMap);
		
		List<Stock> stockList = stockMapper.getStockListBySearch(searchMap);
		return stockList;
	}
	
	/**
	 * 상품 출고인 경우 - 상품 출고 상세정보 수정
	 * @param sessionId 세션에 등록된 로그인아이디 정보
	 * @param inOutcomingCode 입출고코드
	 * @param inOutcomingForm 입출고등록폼 정보
	 * @return
	 */
	public void modifyOutcomingDetail(String sessionId, String inOutcomingCode, InOutcomingForm inOutcomingForm) {
		
		OutcomingDetail outcomingDetail = new OutcomingDetail();
		
		String outcomingDetailCode = stockMapper.getOutcomingDetailCode(inOutcomingCode);
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
		String foundationCode = foundationMapper.getFoundationCodeByName(inOutcomingForm.getFoundationName());
		
		
		outcomingDetail.setOutcomingDetailCode(outcomingDetailCode);
		outcomingDetail.setOutcomingGoods(goodsCode);
		outcomingDetail.setOutcomingQuantity(inOutcomingForm.getInOutcomingQuantity());;
		outcomingDetail.setOutcomingDate(inOutcomingForm.getInOutcomingDate());
		outcomingDetail.setOutcomingId(inOutcomingForm.getOutcomingId());;
		outcomingDetail.setFoundationCode(foundationCode);
		outcomingDetail.setOutcomingDetailUpdId(sessionId);
		
		log.info("outcomingDetail: {}", outcomingDetail);
		
		stockMapper.modifyOutcomingDetail(outcomingDetail);
	}
	
	/**
	 * 상품 입출고 수정
	 * @param sessionId 세션에 등록된 로그인아이디 정보
	 * @param inOutcomingForm 입출고등록폼 정보
	 * @return
	 */
	public String modifyInOutcoming(String sessionId, InOutcomingForm inOutcomingForm) {
		
		InOutcoming inOutcoming = new InOutcoming();
		
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
		
		inOutcoming.setInOutcomingCode(inOutcomingForm.getInOutcomingCode());
		inOutcoming.setGoodsCode(goodsCode);
		inOutcoming.setGoodsLotNumber(inOutcomingForm.getGoodsLotNumber());
		inOutcoming.setInOutcomingQuantity(inOutcomingForm.getInOutcomingQuantity());
		inOutcoming.setInOutcomingType(inOutcomingForm.getInOutcomingType());
		inOutcoming.setInOutcomingDate(inOutcomingForm.getInOutcomingDate());
		inOutcoming.setInOutcomingUpdId(sessionId);
		
		log.info("inOutcoming: {}", inOutcoming);
		
		stockMapper.modifyInOutcoming(inOutcoming);
		
		return inOutcomingForm.getInOutcomingCode();
	}
	
	/**
	 * 특정 상품 입출고 조회
	 * @param inOutcomingCode 입출고코드
	 * @return
	 */
	public InOutcomingForm getInOutcomingFormByCode(String inOutcomingCode) {
		
		InOutcoming inOutcomingInfo = stockMapper.getInOutcomingInfoByCode(inOutcomingCode);
		
		log.info("inOutcomingInfo: {}", inOutcomingInfo);
		
		String goodsCode = inOutcomingInfo.getGoodsCode();
		String goodsLotNumber = inOutcomingInfo.getGoodsLotNumber();
		
		String inOutcomingType = inOutcomingInfo.getInOutcomingType();
		
		InOutcomingForm inOutcomingForm = new InOutcomingForm();
		
		inOutcomingForm.setInOutcomingCode(inOutcomingCode);
		inOutcomingForm.setGoodsName(inOutcomingInfo.getGoodsInfo().getGoodsName());
		inOutcomingForm.setGoodsLotNumber(goodsLotNumber);
		inOutcomingForm.setGoodsCompany(inOutcomingInfo.getGoodsInfo().getGoodsCompany());
		inOutcomingForm.setInOutcomingType(inOutcomingType);
		inOutcomingForm.setInOutcomingQuantity(inOutcomingInfo.getInOutcomingQuantity());
		inOutcomingForm.setInOutcomingDate(inOutcomingInfo.getInOutcomingDate());
		if(inOutcomingType.equals("incoming")) {
			Stock stockInfo = stockMapper.getStockInfo(goodsCode, goodsLotNumber);
			log.info("stockInfo: {}", stockInfo);
			inOutcomingForm.setGoodsExpiryDate(stockInfo.getGoodsExpiryDate());
		}else if(inOutcomingType.equals("outcoming")) {
			inOutcomingForm.setOutcomingId(inOutcomingInfo.getOutcomingDetailInfo().getOutcomingId());
			inOutcomingForm.setFoundationName(inOutcomingInfo.getFoundationInfo().getFoundationName());
		}
		
		return inOutcomingForm;
	}
	
	/**
	 * 입출고 수량만큼 기존 재고 수량 증가
	 * @param inOutcomingForm 입출고등록폼 정보
	 */
	public void increaseCurrentStock(InOutcomingForm inOutcomingForm) {
		
		Stock stock = getStockInfo(inOutcomingForm);
	    
		stock.addCurrentStock(inOutcomingForm.getInOutcomingQuantity());
	    
	    stock.calculFinalStock(stock.getCurrentStockAmount(), stock.getUnusualStockAmount());
	    
	    // 증가 후 상품 재고 수량
	    log.info("currentStockAmount: {}", stock.getCurrentStockAmount());
	    
	    // 증가 후 최종 상품 수량
	    log.info("finalStockAmount: {}", stock.getFinalStockAmount());
	    
	    log.info("stock: {}", stock);
	    
	    stockMapper.modifyStockAmount(stock);
	}

	/**
	 * 입출고 수량만큼 기존 재고 수량 감소 - 감소 후 최종 상품 재고 수량 반환
	 * @param inOutcomingForm 입출고등록폼 정보
	 */
	public void decreaseCurrentStock(InOutcomingForm inOutcomingForm) {
	    
	    Stock stock = getStockInfo(inOutcomingForm);
	    
	    stock.removeCurrentStock(inOutcomingForm.getInOutcomingQuantity());
	    
	    stock.calculFinalStock(stock.getCurrentStockAmount(), stock.getUnusualStockAmount());
	    
	    // 차감 후 상품 재고 수량
	    log.info("currentStockAmount: {}", stock.getCurrentStockAmount());
	   
	    // 증가 후 최종 상품 재고 수량
	    log.info("finalStockAmount: {}", stock.getFinalStockAmount());
	    
	    log.info("stock: {}", stock);
	    
	    stockMapper.modifyStockAmount(stock);
	}
	
	/**
	 * 특정 상품 재고 정보 조회
	 * @param inOutcomingForm 입출고등록폼 정보
	 * @return
	 */
	public Stock getStockInfo(InOutcomingForm inOutcomingForm) {
		
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
	    String goodsLotNumber = inOutcomingForm.getGoodsLotNumber();
	    
	    Stock stock = stockMapper.getStockInfo(goodsCode, goodsLotNumber);
	    
	    return stock;
	}
	
	/**
	 * 상품 입출고 등록 시 새로운 상품 입고인 경우 재고 등록
	 * @param inOutcomingForm 입출고등록폼 정보
	 * @return
	 */
	public int addStockInfo(InOutcomingForm inOutcomingForm) {
		
		Stock stock = new Stock();
		
		// 상품 재고코드 - 공통 mapper를 사용하여 goodsStockCode 생성 및 설정
		String goodsStockCode = commonMapper.getPrimaryKeyVerTwo("goods_stock"
																, "goods_stock_code"
																, "goods_stock");
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
				
		stock.setGoodsStockCode(goodsStockCode);
		stock.setGoodsCode(goodsCode);
		stock.setGoodsLotNumber(inOutcomingForm.getGoodsLotNumber());
		stock.setCurrentStockAmount(inOutcomingForm.getInOutcomingQuantity());
		stock.setGoodsExpiryDate(inOutcomingForm.getGoodsExpiryDate());
		stock.setFinalStockAmount(inOutcomingForm.getInOutcomingQuantity());
		
		log.info("stock: {}", stock);
		
		int result = stockMapper.addStock(stock);
		return result;
	}
	
	/**
	 * 등록된 상품 재고 정보인지 확인
	 * @param goodsName 상품명
	 * @param goodsLotNumber 제조번호
	 * @return
	 */
	public boolean checkStockInfo(String goodsName, String goodsLotNumber) {
		
		String goodsCode = goodsMapper.getGoodsCodeByName(goodsName);
		
		boolean isNewStockInfo = stockMapper.checkNewStockInfo(goodsCode, goodsLotNumber);
		return isNewStockInfo;
	}
	
	/**
	 * 상품 출고 상세정보 등록
	 * @param sessionId 세션에 등록된 로그인아이디 정보
	 * @param inOutcomingCode 입출고코드
	 * @param inOutcomingForm 입출고등록폼 정보
	 * @return
	 */
	public int addOutcomingDetail(String sessionId, String inOutcomingCode, InOutcomingForm inOutcomingForm) {
		
		OutcomingDetail outcomingDetail = new OutcomingDetail();
		
		// 상품 출고상세코드 - 공통 mapper를 사용하여 outcomingDetailCode 생성 및 설정
		String outcomingDetailCode = commonMapper.getPrimaryKeyVerTwo("outcoming_detail"
																	, "outcoming_detail_code"
																	, "outcoming_detail_code");
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
		String foundationCode = foundationMapper.getFoundationCodeByName(inOutcomingForm.getFoundationName());
		
		outcomingDetail.setOutcomingDetailCode(outcomingDetailCode);
		outcomingDetail.setInOutcomingCode(inOutcomingCode);
		outcomingDetail.setOutcomingGoods(goodsCode);
		outcomingDetail.setOutcomingQuantity(inOutcomingForm.getInOutcomingQuantity());;
		outcomingDetail.setOutcomingDate(inOutcomingForm.getInOutcomingDate());
		outcomingDetail.setOutcomingId(inOutcomingForm.getOutcomingId());;
		outcomingDetail.setFoundationCode(foundationCode);
		outcomingDetail.setOutcomingDetailRegId(sessionId);
		
		log.info("outcomingDetail: {}", outcomingDetail);
		
		int result = stockMapper.addOutcomingDetail(outcomingDetail);
		return result;
	}
	
	/**
	 * 상품 입출고 등록
	 * @param sessionId 세션에 등록된 로그인아이디 정보
	 * @param inOutcomingForm 입출고등록폼 정보
	 * @return
	 */
	public String addInOutcoming(String sessionId, InOutcomingForm inOutcomingForm) {
		
		InOutcoming inOutcoming = new InOutcoming();
		
		// 상품 입출고이력코드 - 공통 mapper를 사용하여 inOutcomingCode 생성 및 설정
		String inOutcomingCode = commonMapper.getPrimaryKeyVerTwo("incoming_outcoming_history"
																,"incoming_outcoming_history_code"
																,"incoming_outcoming_history");
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
		
		inOutcoming.setInOutcomingCode(inOutcomingCode);
		inOutcoming.setGoodsCode(goodsCode);
		inOutcoming.setGoodsLotNumber(inOutcomingForm.getGoodsLotNumber());
		inOutcoming.setInOutcomingQuantity(inOutcomingForm.getInOutcomingQuantity());
		inOutcoming.setInOutcomingType(inOutcomingForm.getInOutcomingType());
		inOutcoming.setInOutcomingDate(inOutcomingForm.getInOutcomingDate());
		inOutcoming.setInOutcomingRegId(sessionId);
		
		log.info("inOutcoming: {}", inOutcoming);
		
		stockMapper.addInOutcoming(inOutcoming);
		
		return inOutcomingCode;
	}
	
	/**
	 * 입출고코드로 상품 입출고 삭제
	 * @param inOutcomingCode 입출고코드
	 */
	public void removeInOutcomingByCode(String inOutcomingCode) {
		InOutcomingForm inOutcomingFormInfo = getInOutcomingFormByCode(inOutcomingCode);
		if (inOutcomingFormInfo != null) {
        	String inOutcomingType = inOutcomingFormInfo.getInOutcomingType();
        	
        	// 입출고 정보 삭제
        	removeInOutcoming(inOutcomingCode);
            
            //삭제된 입출고의 재고 수량 수정
            if (inOutcomingType.equals("incoming") || inOutcomingType.equals("exchange")) {
                // 삭제된 입출고 정보가 입고 또는 교환인 경우, 삭제한 입출고 수량만큼 현재 수량 차감
            	decreaseCurrentStock(inOutcomingFormInfo);
            } else { 
                // 삭제된 입출고 정보가 출고 또는 폐기인 경우, 삭제한 입출고 수량만큼 현재 수량 증가
                increaseCurrentStock(inOutcomingFormInfo);
            }
        }
	}
	
	/**
	 * 상품 입출고정보 삭제
	 * @param inOutcomingCode 입출고코드
	 */
	public void removeInOutcoming(String inOutcomingCode) {
		InOutcomingForm inOutcomingFormInfo = getInOutcomingFormByCode(inOutcomingCode);
		if (inOutcomingFormInfo != null) {
        	String inOutcomingType = inOutcomingFormInfo.getInOutcomingType();
           
        	// 입출고 정보가 출고인 경우 출고 및 출고 상세 정보 삭제
            if (inOutcomingType.equals("outcoming")) {
                // 출고 상세 정보 삭제
            	stockMapper.removeOutcomingDetail(inOutcomingCode);
                // 출고 정보 삭제
            	stockMapper.removeInOutcoming(inOutcomingCode);
            } else {
                // 입출고 정보 삭제
            	stockMapper.removeInOutcoming(inOutcomingCode);
            }
        }
	}
	
	/**
	 * 상품 입출고 검색 결과 조회
	 * @param searchKey
	 * @param searchValue
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<InOutcoming> getInOutcomingListBySearch(String inputSearchKey
														, String inputSearchValue
														, String dateSearchKey
														, String startDate
														, String endDate){
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		if(inputSearchKey != null && inputSearchValue != null) {
			switch (inputSearchKey) {
			case "goodsName":
				inputSearchKey = "i.goods_name";
				break;
			case "goodsCompany":
				inputSearchKey = "i.goods_company";					
				break;
			case "goodsLotNumber":
				inputSearchKey = "h.goods_lot_number";					
				break;
			case "inOutcomingType":
				inputSearchKey = "h.incoming_outcoming_type";					
				break;
			}
			
			switch (inputSearchValue) {
			case "입고":
				inputSearchValue = "incoming";
				break;
			case "출고":
				inputSearchValue = "outcoming";					
				break;
			case "교환":
				inputSearchValue = "exchange";					
				break;
			case "폐기":
				inputSearchValue = "disposal";					
				break;
			}
			searchMap.put("inputSearchKey", inputSearchKey);
			searchMap.put("inputSearchValue", inputSearchValue);
		}
		
		if(dateSearchKey != null && startDate != null && endDate != null) {
			searchMap.put("dateSearchKey", dateSearchKey);
			searchMap.put("startDate", startDate);
			searchMap.put("endDate", endDate);
		}
		
		log.info("searchMap: {}", searchMap);

		List<InOutcoming> inOutcomingList = stockMapper.getInOutcomingListBySearch(searchMap);
		return inOutcomingList;
	}
}
