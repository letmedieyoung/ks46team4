package ks46team04.admin.service;

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
	 * 상품 출고 상세정보 등록
	 * @param outcomingDetail
	 * @return
	 */
	public int addOutcomingDetail(OutcomingDetail outcomingDetail) {
		int result = stockMapper.addOutcomingDetail(outcomingDetail);
		return result;
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
	 * 상품 재고 조회
	 * @return
	 */
	public List<Stock> getStockList(){
		List<Stock> stockList = stockMapper.getStockList();
		return stockList;
	}
	
}
