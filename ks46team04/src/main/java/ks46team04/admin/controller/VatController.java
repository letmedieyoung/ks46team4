package ks46team04.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/purchase_sale")
public class VatController {

	@GetMapping("/payment_vat_list")
	public String getVat(Model model) {
		
		return "/view/purchase_sale/payment_vat_list";
	}
	
	
	@GetMapping("/payment_vat_update")
	public String ModifyVat(Model model) {
		
		return "/view/purchase_sale/payment_vat_update";
	}
}
