package ks46team04.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/purchase_sale")
public class PurchaseController {

	@GetMapping("/purchase_delete")
	public String DeletePuchase(Model model) {
		
		return "/admin/purchase_sale/purchase_delete";
	}
	
	
	@GetMapping("/purchase_insert")
	public String addPurchse(Model model) {
		
		return "/admin/purchase_sale/purchase_insert";
	}
	
	
	@GetMapping("/purchase_list")
	public String getTotalPurchseList(Model model) {
		
		return "/admin/purchase_sale/purchase_list";
	}
	
	
	@GetMapping("/purchase_update")
	public String ModifyPurchase(Model model) {
		
		return "/admin/purchase_sale/purchase_update";
	}
}
