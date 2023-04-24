package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.InOutcoming;
import ks46team04.admin.dto.OutcomingDetail;
import ks46team04.admin.dto.Stock;
import ks46team04.admin.dto.UnusualStock;

@Mapper
public interface StockMapper {

	//상품 재고 조회
	public List<Stock> getStockList();
	
	//상품 입출고 조회
	public List<InOutcoming> getInOutcomingList();
	
	//상품 입출고 등록
	public int addInOutcoming(InOutcoming inOutcoming);
	
	//특정 상품 입출고 조회
	public InOutcoming getInOutcomingInfoByCode(String inOutcomingCode);
	
	//상품 입출고 수정
	public int modifyInOutcoming(InOutcoming inOutcoming);
	
	//상품 출고 상세정보 조회
	public List<OutcomingDetail> getOutcomingDetailList();
	
	//상품 비정상재고 조회
	public List<UnusualStock> getUnusualStockList();
}
