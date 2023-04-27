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

import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.GoodsCategory;
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
	 * 상품 삭제
	 * @param model
	 * @return
	 */
	@PostMapping("/remove_goods")
	public String removeGoods(Model model,
							@RequestParam(name="goodsCode") String goodsCode) {
		model.addAttribute("goosdCode", goodsCode);
		goodsService.removeGoods(goodsCode);
		return "redirect:/admin/goods/goods_list";
	}
	/**
	 * 상품수정 @PostMapping
	 * @param goods
	 * @return
	 */
	@PostMapping("/modify_goods")
	public String modifyGoods(Goods goods) {
		
		log.info("goods: {}", goods);
		
		goodsService.modifyGoods(goods);
		
		return "redirect:/admin/goods/goods_list";
	}
	
	/**
	 * 상품 수정 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/modify_goods")
	public String modifyGoods(Model model, @RequestParam(name="goodsCode") String goodsCode) {
		
		Goods goodsInfo = goodsService.getGoodsInfoByCode(goodsCode);
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();

		log.info("goodsInfo: {}", goodsInfo);
		log.info("goodsCategoryList: {}", goodsCategoryList);
		
		model.addAttribute("title", "상품 수정");
		model.addAttribute("goodsInfo", goodsInfo);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "admin/goods/modify_goods";
	}
	
	/**
	 * 상품 등록 @PostMapping
	 * @param goods
	 * @return
	 */
	@PostMapping("/add_goods")
	public String addGoods(Goods goods) {
		log.info("goods: {}", goods);
		goodsService.addGoods(goods);
		return "redirect:/admin/goods/goods_list";
	}
	
	/**
	 * 상품 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_goods")
	public String addGoods(Model model) {

		log.info("model: {}", model);
		
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		log.info("goodsCategoryList: {}", goodsCategoryList);
		
		
		model.addAttribute("title", "상품 등록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "admin/goods/add_goods";
	}
	
	/**
	 * 상품 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/goods_list")
	public String getGoodsList(Model model) {
		
		List<Goods> goodsList = goodsService.getGoodsList();
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		
		log.info("goodsList: {}", goodsList);
		log.info("goodsCategoryList: {}", goodsCategoryList);
		
		model.addAttribute("title", "상품 목록");
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "admin/goods/goods_list";
	}
	
}
