package ks46team04.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.Purchase;
import ks46team04.admin.service.PurchaseService;

@Controller
@RequestMapping("/admin/purchase_sale")
public class PurchaseController {

	
	private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

	private final PurchaseService purchaseService;
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@GetMapping("/purchase_list")
	public String getTotalPurchaseList(Model model) {
		List<Purchase> totalPurchaseList = purchaseService.getTotalPurchaseList();
		log.info("totalPurchaseList: {}", totalPurchaseList);
		
		model.addAttribute("title", "Pilling Good - 관리 - 매입 기록 조회");
		model.addAttribute("totalPurchaseList", totalPurchaseList);
		return "admin/purchase_sale/purchase_list";
	}
	
	
	@GetMapping("/purchase_insert")
	public String addPurchase(Model model) {
		
		return "admin/purchase_sale/purchase_insert";
	}
	
	
	@GetMapping("/purchase_update")
	public String ModifyPurchase(Model model) {
		
		return "admin/purchase_sale/purchase_update";
	}
	
	@GetMapping("/purchase_delete")
	public String DeletePuchase(Model model) {
		
		return "admin/purchase_sale/purchase_delete";
	}
	
}
