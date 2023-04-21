package ks46team04.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.controller.PurchaseController;
import ks46team04.admin.dto.Purchase;
import ks46team04.admin.mapper.PurchaseMapper;

@Service
@Transactional
public class PurchaseService {
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

	private final PurchaseMapper purchaseMapper;
	public PurchaseService(PurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}
	
	
	public Purchase getTotalPurchaseList() {
		Purchase totalPurchaseList = purchaseMapper.getTotalPurchaseList();
		
		return totalPurchaseList;
	}
}
