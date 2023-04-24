package ks46team04.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks46team04.admin.dto.Goods;
import ks46team04.admin.service.GoodsService;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	/**
	 * 상품 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/goods_list")
	public String getGoodsList(Model model) {
		
		List<Goods> goodsList = goodsService.getGoodsList();
				
		model.addAttribute("title", "상품 목록");
		model.addAttribute("goodsList", goodsList);
		
		return "admin/goods/goods_list";
	}
	
	/**
	 * 상품 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/add_goods")
	public String addGoods(Model model) {
		
		model.addAttribute("title", "상품 등록");
		
		return "admin/goods/add_goods";
	}
	
	/**
	 * 상품 수정
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_goods")
	public String modifyGoods(Model model) {
		
		model.addAttribute("title", "상품 수정");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/goods/modify_goods";
	}
	
	/**
	 * 상품 삭제
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_goods")
	public String removeGoods(Model model) {
		
		model.addAttribute("title", "상품 삭제");
		model.addAttribute("content", "thymeleaf layout 완성");
		
		return "admin/goods/remove_goods";
	}
	
}
