package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Stock;

@Mapper
public interface StockMapper {

	//상품 재고 조회
	public List<Stock> getStockList();
	
	//재고 
}
