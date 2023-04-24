package ks46team04.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.ProfitLoss;
import ks46team04.admin.dto.TotalPurchaseSale;
import ks46team04.admin.service.ProfitLossService;

@Controller
@RequestMapping("/admin/purchase_sale")
public class ProfitLossController {
		
	private static final Logger log = LoggerFactory.getLogger(ProfitLossController.class);
	
	private final ProfitLossService profitLossService;
	public ProfitLossController(ProfitLossService profitLossService) {
		this.profitLossService = profitLossService;
	}
	
	
	@GetMapping("/month_profit_loss")
	public String getTotalPurchseSale(Model model) {
		
		List<TotalPurchaseSale> totalPurchaseSale = profitLossService.getTotalPurchaseSale();
		List<ProfitLoss> profitLoss = profitLossService.getProfitLoss();
		
		log.info("totalPurchaseSale: {}", totalPurchaseSale);
		model.addAttribute("title", "Pilling Good - 관리 - 매입·매출 종합 수익 조회");
		model.addAttribute("totalPurchaseSale", totalPurchaseSale);
		model.addAttribute("profitLoss", profitLoss);
		return "/admin/purchase_sale/month_profit_loss";
	}
}
