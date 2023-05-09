package ks46team04.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.Payment;
import ks46team04.admin.service.PaymentService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/payment")
@AllArgsConstructor
public class PaymentController {
	
private final PaymentService paymentService;
	
	/*
	 * 결제수단 조회
	 */
	@GetMapping("/payment_list")
	public String getPayment(Model model) {
		
		List<Payment> getPayment = paymentService.getPayment();
				
		model.addAttribute("title", "결제수단 목록");
		model.addAttribute("getPayment", getPayment);
		
		return "admin/payment/payment_list";
	}

}
