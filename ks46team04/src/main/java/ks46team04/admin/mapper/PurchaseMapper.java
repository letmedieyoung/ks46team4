package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Purchase;

@Mapper
public interface PurchaseMapper {
	
	public List<Purchase> getTotalPurchaseList();

	public int addPurchase(Purchase purchase);

	public int modifyPurchase(String purchaseCode, String updateRegId);
	
	public Purchase getPurchaseByCode(String purchaseCode);
}
