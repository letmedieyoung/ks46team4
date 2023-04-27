package ks46team04.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks46team04.admin.dto.Vat;
import ks46team04.admin.service.VatService;

@Controller
@RequestMapping("/admin/purchase_sale")
public class VatController {
	
	
	private static final Logger log = LoggerFactory.getLogger(VatController.class);

	private final VatService vatService;
	public VatController(VatService vatService) {
		this.vatService = vatService;
	}
	

	/*수수료 조회 --------------------------------*/
	/**
	 * 조회·수정만 가능하며, 삭제·등록은 불가능
	 * 파라미터 없음. 오로지 하나의 행만 단순 조회
	*/
	@GetMapping("/payment_vat_list")
	public String getVatRow(Model model) {
		Vat getVatRow = vatService.getVatRow();
		log.info("getVatRow: {}", getVatRow);
		
		model.addAttribute("title", "Pilling Good - 관리 - 수수료 조회");
		model.addAttribute("getVatRow", getVatRow);
		return "admin/purchase_sale/payment_vat_list";
	}
	

	
	/*수수료 수정 --------------------------------*/
	/**
	 * 화면에서 0~100 사이 정수로 걸러진 값을 *0.01로 비율 수정하여 캐스트 후 insert
	 * */
	@GetMapping("/payment_vat_update")
	public String getModifyVat(Model model) {
		
		return "admin/purchase_sale/payment_vat_update";
	}
	
	@PostMapping("/payment_vat_update")
	public String modifyVat(Vat vat) {
		log.info("vat: {}", vat);
		vatService.modifyVat(vat);
		
		return "redirect:/admin/purchase_sale/payment_vat_list";
	}
}
