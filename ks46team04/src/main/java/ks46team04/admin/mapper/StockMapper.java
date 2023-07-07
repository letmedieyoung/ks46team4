package ks46team04.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.OutcomingDetail;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;

@Mapper
public interface StockMapper {

	//상품 비정상재고 수정
	public int modifyUnusualStock(UnusualStock unusualStock);
	
	//특정 상품 비정상재고 조회
	public UnusualStock getUnusualStockInfoByCode(String unusualStockCode);
	
	//재고 테이블의 비정상재고 유무 업데이트
	public int modifyUnusualStockCheck(Map<String, Object> unusualStockCheckMap);
	
	//상품 비정상재고 등록
	public int addUnusualStock(UnusualStock unusualStock);

	//상품 비정상재고 삭제
	public int removeUnusualStock(Map<String, String> removeUnusualStockMap);
	
	//상품 비정상재고 검색 결과 조회
	public List<UnusualStock> getUnusualStockListBySearch(Map<String, Object> searchMap);
	
	//상품 비정상재고 조회
	public List<UnusualStock> getUnusualStockList();

	//상품재고코드로 비정상재고 조회
	public List<UnusualStock> getUnsualStockListByStock(String goodsStockCode);
	
	//재고조사 정보 수정
	public int modifyStocktaking(Map<String, Object> stocktakingMap);
	
	//특정 상품 재고 조회
	public Stock getStockInfoByCode(String goodsStockCode);
	
	//상품 재고 삭제
	public int removeStock(Map<String, String> removeStockMap);
	
	//삭제 상품 재고 유무 확인 - 재고 테이블에 삭제될 상품코드의 모든 재고량이 0인 경우 true반환
	public boolean removeStockCheck(String goodsCode);
	
	//상품 재고 검색 결과 조회
	public List<Stock> getStockListBySearch(Map<String, Object> searchMap);
	
	//상품 재고 조회
	public List<Stock> getStockList();
	
	//상품 입출고 수정
	public int modifyInOutcoming(InOutcoming inOutcoming);
	
	//상품 출고 상세정보 수정
	public int modifyOutcomingDetail(OutcomingDetail outcomingDetail);
	
	//상품 출고 상세정보코드 조회
	public String getOutcomingDetailCode(String inOutcomingCode);
	
	//특정 상품 입출고 조회
	public InOutcoming getInOutcomingInfoByCode(String inOutcomingCode);
	
	//상품 출고 상세정보 등록
	public int addOutcomingDetail(OutcomingDetail outcomingDetail);
	
	//재고 수량 수정
	public int modifyStockAmount(Stock stock);
	
	//등록된 상품 재고 정보 조회
	public Stock getStockInfo(String goodsCode, String goodsLotNumber);
	
	//상품 입출고 등록 시 새로운 재고 정보일 경우 재고 등록
	public int addStock(Stock stock);
	
	//등록된 상품 재고 정보인지 확인
	public boolean checkNewStockInfo(String goodsCode, String goodsLotNumber);
	
	//상품 입출고 등록
	public int addInOutcoming(InOutcoming inOutcoming);
	
	//해당 재고의 모든 입출고코드 조회
	public List<String> getInOutcomingCodeList(Map<String, Object> goodsInfoMap);
		
	//상품입출고코드로 입출고 삭제
	public int removeInOutcoming(String inOutcomingCode);
	
	//상품 출고 상세 삭제
	public int removeOutcomingDetail(String inOutcomingCode);
	
	//상품 입출고 검색 결과 조회
	public List<InOutcoming> getInOutcomingListBySearch(Map<String, Object> searchMap);
	
	//상품 입출고 조회
	public List<InOutcoming> getInOutcomingList();
}
