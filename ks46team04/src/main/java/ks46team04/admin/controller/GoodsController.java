package ks46team04.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import ks46team04.admin.dto.GoodsCategory;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.service.GoodsService;
import ks46team04.admin.service.StockService;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

	private final GoodsService goodsService;
	private final GoodsMapper goodsMapper;
	
	public GoodsController(GoodsService goodsService, GoodsMapper goodsMapper, StockService stockService) {
		this.goodsService = goodsService;
		this.goodsMapper = goodsMapper;
	}
	
	/**
     * 상품 삭제
     * @param model
     * @return
     */
    @PostMapping("/remove_goods")
    @ResponseBody
    public Map<String, Object> removeGoods(@RequestParam(value="valueArr[]") List<String> valueArr) {
    	
    	log.info("valueArr: {}", valueArr);
    	
    	Map<String, Object> response = new HashMap<>();

        List<String> deletedGoods = new ArrayList<>();
        List<String> failedGoods = new ArrayList<>();

        for (String goodsCode : valueArr) {
        	boolean isRemove = goodsService.removeGoods(goodsCode);
            if (isRemove) {
                deletedGoods.add(goodsCode);
            } else {
                failedGoods.add(goodsCode);
            }
        }
        log.info("deletedGoods: {}", deletedGoods);
        log.info("failedGoods: {}", failedGoods);

        response.put("deleted", deletedGoods);
        response.put("failed", failedGoods);
        log.info("response: {}", response);

        return response;
    }
	
	/**
	 * 상품 수정 @PostMapping
	 * @param goods
	 * @return
	 */
	@PostMapping("/modify_goods")
	public String modifyGoods(Goods goods, HttpSession session) {
		
		String goodsUpdId = (String) session.getAttribute("SID");
	    log.info("goodsUpdId: {}", goodsUpdId);
		
	    goods.setGoodsUpdId(goodsUpdId);
	    log.info("goodsInfo: {}", goods);
	    
		goodsService.modifyGoods(goods);
		
		return "redirect:/admin/goods/goods_list";
	}
	
	/**
	 * 상품 수정 @GetMapping
	 * @param model
	 * @param goodsCode
	 * @return
	 */
	@GetMapping("/modify_goods")
	public String modifyGoods(Model model, @RequestParam(name="goodsCode") String goodsCode) {
	    
		Goods goodsInfo = goodsService.getGoodsInfoByCode(goodsCode);
		log.info("goodsInfo: {}", goodsInfo);
		
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		log.info("goodsCategoryList: {}", goodsCategoryList);
		
		model.addAttribute("title", "상품 수정");
		model.addAttribute("goodsInfo", goodsInfo);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "admin/goods/modify_goods";
	}
	
	/**
	 * 상품 제조사 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/modal_goods_company_search")
	public String getGoodsCompanyList(Model model) {
		
		List<String> goodsCompanyList = goodsService.getGoodsCompanyList();
		log.info("goodsCompanyList: {}", goodsCompanyList);
		
		model.addAttribute("title", "상품 제조사 조회");
		model.addAttribute("goodsCompanyList", goodsCompanyList);
		
		return "admin/goods/modal_goods_company_search";
	}
	
	/**
	 * 상품명 중복체크
	 * @param goodsName
	 * @return
	 */
	@PostMapping("/check_goods_name")
	@ResponseBody
	public boolean goodsNameCheck(@RequestParam(name="goodsName") String goodsName) {
		
		boolean isCheck = goodsMapper.goodsNameCheck(goodsName);
		
		return isCheck;
	}
	
	/**
	 * 상품 등록 @PostMapping
	 * @param goods
	 * @return
	 */
	@PostMapping("/add_goods")
	public String addGoods(Goods goods, HttpSession session) {
		
		String goodsRegId = (String) session.getAttribute("SID");
	    log.info("goodsRegId: {}", goodsRegId);

	    goods.setGoodsRegId(goodsRegId); // 등록자 아이디 필드에 goodsRegId 설정
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

		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		log.info("goodsCategoryList: {}", goodsCategoryList);
		
		List<String> goodsCompanyList = goodsService.getGoodsCompanyList();
		log.info("goodsCompanyList: {}", goodsCompanyList);
		
		model.addAttribute("title", "상품 등록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		model.addAttribute("goodsCompanyList", goodsCompanyList);
		
		return "admin/goods/add_goods";
	}
	
	/**
	 * 상품 검색 결과 조회
	 * @param model
	 * @param searchKey
	 * @param searchValue
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/search_goods_list")
	@ResponseBody
	public List<Goods> search(@RequestParam(value="searchKey", required = false) String searchKey 
							, @RequestParam(value="searchValue", required = false) String searchValue
							, @RequestParam(value="startDate", required = false) String startDate
							, @RequestParam(value="endDate", required = false) String endDate) {
		
		log.info("searchKey: {}, searchValue: {}, startDate: {}, endDate: {}", searchKey, searchValue, startDate, endDate);
		
		List<Goods> goodsList = goodsService.getGoodsListBySearch(searchKey, searchValue, startDate, endDate);
		log.info("goodsList: {}", goodsList);
		
		return goodsList;
	}
	  
	/**
	 * 상품 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/goods_list")
	public String getGoodsList(Model model) {
		
		List<Goods> goodsList = goodsService.getGoodsList();
		log.info("goodsList: {}", goodsList);
		
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		log.info("goodsCategoryList: {}", goodsCategoryList);
		
		model.addAttribute("title", "상품 목록");
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		return "admin/goods/goods_list";
	}
	
	
}
