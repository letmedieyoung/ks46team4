package ks46team04.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.OutcomingDetail;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;
import ks46team04.admin.mapper.StockMapper;

@Service
@Transactional
public class StockService {

	
	private static final Logger log = LoggerFactory.getLogger(StockService.class);

	private final StockMapper stockMapper;
	
	public StockService(StockMapper stockMapper) {
		this.stockMapper = stockMapper;
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
	 * 상품 비정상재고 등록
	 * @param unusualStock
	 * @return
	 */
	public int addUnusualStock(UnusualStock unusualStock) {
		int result = stockMapper.addUnusualStock(unusualStock);
		return result;
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
	 * 상품 입출고 삭제
	 * @param valueArr
	 */
	public void removeInOutcoming(List<String> valueArr) {
		 for (int i = 0; i < valueArr.size(); i++) {
			 stockMapper.removeInOutcoming(valueArr.get(i));
		 }
	}
	
	/**
	 * 상품 입출고 수정
	 * @param inOutcoming
	 */
	public void modifyInOutcoming(InOutcoming inOutcoming) {
		stockMapper.modifyInOutcoming(inOutcoming);
	}
	
	/**
	 * 특정 상품 출고 상세정보 조회
	 * @return
	 */
	public OutcomingDetail getOutcomingDetailInfoByCode(String outcomingDetailCode){
		OutcomingDetail outcomingDetailInfo = stockMapper.getOutcomingDetailInfoByCode(outcomingDetailCode);
		return outcomingDetailInfo;
	}
	
	/**
	 * 특정 상품 입출고 조회
	 * @param inOutcomingCode
	 * @return
	 */
	public InOutcoming getInOutcomingInfoByCode(String inOutcomingCode) {
		InOutcoming inOutcomingInfo = stockMapper.getInOutcomingInfoByCode(inOutcomingCode);
		return inOutcomingInfo;
	}
	
	/**
	 * 상품 재고 등록
	 * @param inOutcoming
	 * @return
	 */
	public int addStock(InOutcoming lastInOutcomingInfo) {
		Map<String, Object> stockMap = new HashMap<String, Object>();
		
		String goodsCode = lastInOutcomingInfo.getGoodsCode();
		String goodsLotNumber = lastInOutcomingInfo.getGoodsLotNumber();
		int currentStockAmount = lastInOutcomingInfo.getInOutcomingQuantity();
		String stocktakingCheck = "무";
		String stocktakingDate = lastInOutcomingInfo.getGoodsCode();
		String goodsExprityDate = lastInOutcomingInfo.getGoodsCode();
		String finalStockAmount = lastInOutcomingInfo.getGoodsCode();
		String unusualStockAmount = lastInOutcomingInfo.getGoodsCode();
		String unusualStockCheck = lastInOutcomingInfo.getGoodsCode();
		
		stockMap.put(unusualStockAmount, unusualStockCheck);
		
		int result = stockMapper.addStock(stockMap);
		return result;
	}
	
	/**
	 * 상품 출고 상세정보 등록
	 * @param outcomingDetail
	 * @return
	 */
	public int addOutcomingDetail(InOutcoming lastInOutcomingInfo) {
		
		Map<String, Object> outcomingDetailMap = new HashMap<String, Object>();
		
		String inOutcomingCode = lastInOutcomingInfo.getInOutcomingCode();
		String goodsCode = lastInOutcomingInfo.getGoodsCode();
		int outcomingQuantity = lastInOutcomingInfo.getInOutcomingQuantity();
		String outcomingDate = lastInOutcomingInfo.getInOutcomingDate();
		String outcomingId = lastInOutcomingInfo.getOutcomingId();
		String foundationName = lastInOutcomingInfo.getFoundationName();
		String outcomingDetailRegId = lastInOutcomingInfo.getInOutcomingRegId();
		
		outcomingDetailMap.put("inOutcomingCode", inOutcomingCode);
		outcomingDetailMap.put("goodsCode", goodsCode);
		outcomingDetailMap.put("outcomingQuantity", outcomingQuantity);
		outcomingDetailMap.put("outcomingDate", outcomingDate);
		outcomingDetailMap.put("outcomingId", outcomingId);
		outcomingDetailMap.put("foundationName", foundationName);
		outcomingDetailMap.put("outcomingDetailRegId", outcomingDetailRegId);
		log.info("outcomingDetailMap: {}", outcomingDetailMap);
		
		int result = stockMapper.addOutcomingDetail(outcomingDetailMap);
		return result;
	}
	
	/**
	 * 등록된 입출고 정보 가져오기
	 * @return
	 */
	public InOutcoming getLastInOutcomingInfo() {
		InOutcoming lastInOutcomingInfo = stockMapper.getLastInOutcomingInfo();
		return lastInOutcomingInfo;
    }
	
	/**
	 * 상품 입출고 등록
	 * @param inOutcoming
	 * @return
	 */
	public int addInOutcoming(InOutcoming inOutcoming) {
		int result = stockMapper.addInOutcoming(inOutcoming);
		return result;
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
	
	/**
	 * 상품 입출고 조회
	 * @return
	 */
	public List<InOutcoming> getInOutcomingList(){
		List<InOutcoming> inOutcomingList = stockMapper.getInOutcomingList();
		return inOutcomingList;
	}
	
	/**
	 * 상품 재고 수정 - 재고조사, 비정상재고 등록 
	 * @param stock
	 */
	public void modifyStock(Stock stock) {
		stockMapper.modifyStock(stock);
	}
	
	/**
	 * 특정 상품 재고 조회
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
			
			boolean isAll = stocktakingValue.equals("전체");
			if(isAll) stocktakingValue = "";
			searchMap.put("stocktakingValue", stocktakingValue);
		}
		
		if(unusualStockKey != null && unusualStockValue != null) {
			unusualStockKey = "s.unusual_stock_check";					
			searchMap.put("unusualStockKey", unusualStockKey);
			
			boolean isAll = unusualStockValue.equals("전체");
			if(isAll) unusualStockValue = "";
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
	
}
