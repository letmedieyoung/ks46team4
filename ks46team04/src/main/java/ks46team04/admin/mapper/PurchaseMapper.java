package ks46team04.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Purchase;

@Mapper
public interface PurchaseMapper {
	
	public Purchase getTotalPurchaseList();

}
