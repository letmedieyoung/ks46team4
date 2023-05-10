package ks46team04.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.Purchase;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.mapper.PurchaseMapper;
import ks46team04.admin.service.PurchaseService;

@Controller
@RequestMapping("/admin/purchase_sale")
public class PurchaseController {

	
	private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

	private final PurchaseService purchaseService;
	private final GoodsMapper goodsMapper;
	public PurchaseController(PurchaseService purchaseService, GoodsMapper goodsMapper) {
		this.purchaseService = purchaseService;
		this.goodsMapper = goodsMapper;
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
		//goods_reg_info에서 goodsName을 가져온다
		List<Goods> goodsList = goodsMapper.getGoodsList();
		
		model.addAttribute("title", "Pilling Good - 관리 - 매입 등록");
		model.addAttribute("goodsList", goodsList);
		
		return "admin/purchase_sale/purchase_insert";
	}
	
	@GetMapping("/purchase_price")
	@ResponseBody
	public String getGoodsPrice(@RequestParam(name="goodsCode") String goodsCode) {
		log.info("goodsCode: {}", goodsCode);
		Goods goodsInfo = goodsMapper.getGoodsInfoByCode(goodsCode);
		log.info("goodsInfo: {}", goodsInfo);
		String goodsPrice = goodsInfo.getGoodsPrice();
		
		return goodsPrice;
	}
	
	@PostMapping("/purchase_insert")
	public String addPurchase(Purchase purchase, HttpSession session) {
		log.info("purchaseC1: {}", purchase);
		String regId = (String) session.getAttribute("SID");
		String regLevel = (String) session.getAttribute("SLEVEL");
		if(regLevel.equals("1")) {
			log.info("purchaseC2: {}", purchase);
			purchaseService.addPurchase(purchase, regId);
		}
		return "redirect:/admin/purchase_sale/purchase_list";
	}
	
	
	@GetMapping("/purchase_update")
	public String ModifyPurchase(Model model,
								@RequestParam(name="purchaseCode") String purchaseCode,
								@RequestParam(name="goodsCode") String goodsCode) {		
	
		log.info("purchaseCode: {}", purchaseCode);
		log.info("goodsCode: {}", goodsCode);
		Purchase purchaseInfo = purchaseService.getPurchaseByCode(purchaseCode, goodsCode);
	
		log.info("purchaseInfo: {}", purchaseInfo);
		model.addAttribute("title", "Pilling Good - 관리 - 매입 수정");
		model.addAttribute("purchaseInfo", purchaseInfo);
		return "admin/purchase_sale/purchase_update";
	}
	
	@PostMapping("/purchase_update")
	public String ModifyPurchase(Purchase purchase,
								HttpSession session) {
		String updateRegId = (String) session.getAttribute("SID");
		String regLevel = (String) session.getAttribute("SLEVEL");
		if(regLevel.equals("1")) {
			log.info("purchaseC: {}", purchase);
			purchaseService.modifyPurchase(purchase, updateRegId);
		}
		return "redirect:/admin/purchase_sale/purchase_list";
	}
	
	@GetMapping("/purchase_delete")
	public String DeletePuchase(Model model) {
		
		return "redirect:/admin/purchase_sale/purchase_list";
	}
	
}
