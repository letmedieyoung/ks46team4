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
	
	//상품 비정상재고 등록
	public int addUnusualStock(UnusualStock unusualStock);
	
	//상품 비정상재고 삭제
	public int removeUnusualStock(String unusualStockCode);
	
	//상품 비정상재고 검색 결과 조회
	public List<UnusualStock> getUnusualStockListBySearch(Map<String, Object> searchMap);
	
	//상품 비정상재고 조회
	public List<UnusualStock> getUnusualStockList();
	
	//상품 입출고 수정
	public int modifyInOutcoming(InOutcoming inOutcoming);
	
	//특정 상품 출고 상세정보 조회
	public OutcomingDetail getOutcomingDetailInfoByCode(String outcomingDetailCode);
	
	//특정 상품 입출고 조회
	public InOutcoming getInOutcomingInfoByCode(String inOutcomingCode);
	
	//상품 재고 등록
	public int addStock(Map<String, Object> stockMap);
	
	//상품 출고 상세정보 등록
	public int addOutcomingDetail(Map<String, Object> outcomingDetailMap);

	//등록된 입출고 정보 가져오기
	public InOutcoming getLastInOutcomingInfo();
	
	//상품 입출고 등록
	public int addInOutcoming(InOutcoming inOutcoming);
	
	//상품 입출고 삭제
	public int removeInOutcoming(String inOutcomingCode);
	
	//상품 입출고 검색 결과 조회
	public List<InOutcoming> getInOutcomingListBySearch(Map<String, Object> searchMap);
	
	//상품 입출고 조회
	public List<InOutcoming> getInOutcomingList();
	
	//상품 재고 수정 - 재고조사, 비정상재고 등록 
	public int modifyStock(Stock stock);
	
	//특정 상품 재고 조회
	public Stock getStockInfoByCode(String goodsStockCode);
	
	//삭제 상품 재고 유무 확인
	public boolean removeStockCheck(String goodsCode);
	
	//상품 재고 검색 결과 조회
	public List<Stock> getStockListBySearch(Map<String, Object> searchMap);

	//상품 재고 조회
	public List<Stock> getStockList();
	
}
