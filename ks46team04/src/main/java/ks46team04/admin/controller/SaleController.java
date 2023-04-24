package ks46team04.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.UnionDonaFund;
import ks46team04.admin.service.SaleService;

@Controller
@RequestMapping("/admin/purchase_sale")
public class SaleController {
	
	private final SaleService saleService;
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}
	
	
	@GetMapping("/sales_list")
	public String getTotalSaleList(Model model) {
		
		List<UnionDonaFund> totalSaleList = saleService.getTotalSaleList();
		
		model.addAttribute("title", "Pilling Good - 관리 - 매출 기록 조회");
		model.addAttribute("totalSaleList", totalSaleList);
		
		return "admin/purchase_sale/sales_list";
	}
}
