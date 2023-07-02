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
	 * @param unusualStock
	 */
	public void modifyUnusualStock(UnusualStock unusualStock) {
		stockMapper.modifyUnusualStock(unusualStock);
	}
	
	/**
	 * 특정 상품 비정상재고 조회
	 * @param unusualStockCode
	 * @return
	 */
	public UnusualStock getUnusualStockInfoByCode(String unusualStockCode) {
		UnusualStock unusualStockInfo = stockMapper.getUnusualStockInfoByCode(unusualStockCode);
		return unusualStockInfo;
	}

	/**
	 * 상품 비정상재고 삭제
	 * @param valueArr
	 */
	public void removeUnusualStock(List<String> valueArr) {
		 for (int i = 0; i < valueArr.size(); i++) {
			 stockMapper.removeUnusualStock(valueArr.get(i));
		 }
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
	 * 상품 비정상재고 조회
	 * @return
	 */
	public List<UnusualStock> getUnsualStockList(){
		List<UnusualStock> unusualStockList = stockMapper.getUnusualStockList();
		return unusualStockList;
	}
	

	
	/**
	 * 상품 비정상재고 '유'인 경우 - 상품 비정상재고 등록
	 * @param unusualStock
	 * @return
	 */
	public int addUnusualStock(String regId, InOutcomingForm inOutcomingForm) {
		
		UnusualStock unusualStock = new UnusualStock();
		
		// 상품 비정상재고코드 - 공통 mapper를 사용하여 unusualStockCode 생성 및 설정
		String unusualStockCode = commonMapper.getPrimaryKeyVerTwo("unusual_stock_detail"
																,"unusual_stock_detail_code"
																,"discared_stock");
		log.info("unusualStockCode: {}", unusualStockCode);
		
		unusualStock.setUnusualStockCode(unusualStockCode);
		log.info("unusualStock: {}", unusualStock);
		
		int result = stockMapper.addUnusualStock(unusualStock);
		return result;
	}
	
	/**
	 * 상품 재고 수정 화면
	 * @param goodsStockCode
	 * @return
	 */
	public Stock getStockInfoByCode(String goodsStockCode) {
		Stock stockInfo = stockMapper.getStockInfoByCode(goodsStockCode);
		return stockInfo;
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
	 * 상품 재고 조회
	 * @return
	 */
	public List<Stock> getStockList(){
		List<Stock> stockList = stockMapper.getStockList();
		return stockList;
	}
	
	/**
	 * 상품 입출고 삭제
	 * @param valueArr
	 */
	public void removeInOutcoming(List<String> valueArr) {
		 for (int i = 0; i < valueArr.size(); i++) {
			 stockMapper.removeInOutcoming(valueArr.get(i));
		 }
	}
	
	
	
	/**
	 * 상품 출고인 경우 - 상품 출고 상세정보 수정
	 * @param sessionId
	 * @param inOutcomingCode
	 * @param inOutcomingForm
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
	 * @param inOutcoming
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
	 * @param inOutcomingCode
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
	 * 기존 상품 입출고일 경우 재고 수량 수정
	 * @param stock
	 */
	public void modifyStockInfo(InOutcomingForm inOutcomingForm) {
		
		String goodsCode = goodsMapper.getGoodsCodeByName(inOutcomingForm.getGoodsName());
		String goodsLotNumber = inOutcomingForm.getGoodsLotNumber();
		
		Stock stock = stockMapper.getStockInfo(goodsCode, goodsLotNumber);
		
		String inOutcomingType = inOutcomingForm.getInOutcomingType();
		
		if(inOutcomingType.equals("incoming") || inOutcomingType.equals("exchange")) {
			// 상품 입고 또는 교환인 경우, 해당 상품 수량만큼 현재 수량 증가
			stock.addCurrentStock(inOutcomingForm.getInOutcomingQuantity());
		}else { 
			// 상품 출고 또는 폐기인 경우, 해당 상품 수량만큼 현재 수량 차감
			stock.removeCurrentStock(inOutcomingForm.getInOutcomingQuantity());
		}
		// 현재 상품 수량에서 비정상재고수량을 뺀 최종 수량 계산
		int currentStockAmount = stock.getCurrentStockAmount();
		stock.calculFinalStock(currentStockAmount, stock.getUnusualStockAmount());
		
		log.info("stock: {}", stock);
		
		stockMapper.modifyStock(stock);
	}
	
	/**
	 * 상품 입출고 등록 시 새로운 상품 입고인 경우 재고 등록
	 * @param inOutcoming
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
	 * @param goodsName
	 * @param goodsLotNumber
	 * @return
	 */
	public boolean checkStockInfo(String goodsName, String goodsLotNumber) {
		
		String goodsCode = goodsMapper.getGoodsCodeByName(goodsName);
		
		boolean isNewStockInfo = stockMapper.checkNewStockInfo(goodsCode, goodsLotNumber);
		return isNewStockInfo;
	}
	
	/**
	 * 상품 출고인 경우 - 상품 출고 상세정보 등록
	 * @param sessionId
	 * @param inOutcomingCode
	 * @param inOutcomingForm
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
	 * @param sessionId
	 * @param inOutcomingForm
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
