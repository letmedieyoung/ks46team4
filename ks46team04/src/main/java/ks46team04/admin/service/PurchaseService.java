package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.controller.PurchaseController;
import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.Purchase;
import ks46team04.admin.mapper.CommonMapper;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.mapper.PurchaseMapper;

@Service
@Transactional
public class PurchaseService {
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

	private final PurchaseMapper purchaseMapper;
	private final CommonMapper commonMapper;
	private final GoodsMapper goodsMapper;
	public PurchaseService(PurchaseMapper purchaseMapper, CommonMapper commonMapper, GoodsMapper goodsMapper) {
		this.purchaseMapper = purchaseMapper;
		this.commonMapper = commonMapper;
		this.goodsMapper = goodsMapper;
	}
	
	
	public List<Purchase> getTotalPurchaseList() {
		List<Purchase> totalPurchaseList = purchaseMapper.getTotalPurchaseList();
		for(Purchase item : totalPurchaseList) {
			//goodsIsDel 삭제 여부 확인
			boolean isGoodsDel = item.isGoodsIsDel();
			if(isGoodsDel == true) {
				String goodsName = item.getGoodsName();
				goodsName = goodsName + " (삭제 상품)";
				item.setGoodsName(goodsName);
			}
		}
			
		log.info("totalPurchaseList: {}", totalPurchaseList);
		return totalPurchaseList;
	}
	
	public int addPurchase(Purchase purchase, String regId) {
		String PKkey = commonMapper.getPrimaryKey("purchase_history", "purchase_history_code");	//PK키 자동증가
		purchase.setPurchaseCode(PKkey);
		purchase.setPurchaseRegId(regId); 	//session의 아이디
		
		//purchaseGroupCode 앞부분 String
		String purchaseStatus = purchase.getPurchaseStatus();
		log.info("purchaseS1: {}", purchase);
		if(purchaseStatus.equals("complete")){
			purchase.setPurchaseStatus("매입 입금 완료");
			
			//그룹 코드
			String purchaseGroup = commonMapper.getPurchaseGroupCode("purchase_history", "purchase_group_code", PKkey,"purchase");
			purchase.setPurchaseGroupCode(purchaseGroup);
			//DeadlindeCheck
			purchase.setUserPurchseDeadlindeCheck("마감전");
					
		}else if(purchaseStatus.equals("expected")){
			purchase.setPurchaseStatus("매입 예정");	
		}
		
		Goods goodsInfo = goodsMapper.getGoodsInfoByCode(purchase.getGoodsCode());
		purchase.setGoodsName(goodsInfo.getGoodsName());
		log.info("purchaseS2: {}", purchase);
		int result = purchaseMapper.addPurchase(purchase);
		return result;
	}
	
	public Purchase getPurchaseByCode(String purchaseCode, String goodsCode) {
		Purchase purchaseInfo = purchaseMapper.getPurchaseByCode(purchaseCode, goodsCode);
		log.info("purchaseInfo: {}", purchaseInfo);
		String status = purchaseInfo.getPurchaseStatus();
		if(status.equals("매입 예정")) {
			status = "expected";
		}else if(status.equals("매입 입금 완료")){
			status = "complete";
		}
		purchaseInfo.setPurchaseStatus(status);
		
		//goodsIsDel 삭제 여부 확인
		boolean isGoodsDel = purchaseInfo.isGoodsIsDel();
		if(isGoodsDel == true) {
			String goodsName = purchaseInfo.getGoodsName();
			goodsName = goodsName + " (현재 삭제된 상품)";
			purchaseInfo.setGoodsName(goodsName);
		}
		
		return purchaseInfo;
	}
	
	public int modifyPurchase(Purchase purchase, String updateRegId) {
		purchase.setPurchaseUpdateId(updateRegId);
		
		//매입 현황에 따라 그룹 코드와 마감상태 변경
		String purchaseStatus = purchase.getPurchaseStatus();
		if(purchaseStatus.equals("expected")) {	//예정이면 그룹 코드와 마감 상태 그대로 null update
			purchase.setPurchaseStatus("매입 예정");
		}else if(purchaseStatus.equals("complete")) {
			purchase.setPurchaseStatus("매입 입금 완료");
			
			String PKkey = purchase.getPurchaseCode();
			//그룹 코드
			String purchaseGroup = commonMapper.getPurchaseGroupCode("purchase_history", "purchase_group_code", PKkey, "purchase");
			purchase.setPurchaseGroupCode(purchaseGroup);
			//DeadlindeCheck
			purchase.setUserPurchseDeadlindeCheck("마감전");
		}
		
		log.info("purchaseS: {}", purchase);
		int modifyResult = purchaseMapper.modifyPurchase(purchase);
		return modifyResult;
	}
	
	public int deletePurchase(List<String> delPkValues) {
		int result = purchaseMapper.deletePurchase(delPkValues);
		
		return result; 
	}
}
