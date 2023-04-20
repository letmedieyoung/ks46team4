package ks46team04.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/purchase_sale")
public class SaleController {

	@GetMapping("/sales_list")
	public String getTotalSaleList(Model model) {
		
		return "/admin/purchase_sale/sales_list";
	}
}
