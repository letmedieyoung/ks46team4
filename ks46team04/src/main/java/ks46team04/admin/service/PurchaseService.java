package ks46team04.admin.service;

import java.util.List;

import java.util.List;

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
	
	
	public List<Purchase> getTotalPurchaseList() {
		List<Purchase> totalPurchaseList = purchaseMapper.getTotalPurchaseList();
		log.info("totalPurchaseList: {}", totalPurchaseList);
		return totalPurchaseList;
	}
}
