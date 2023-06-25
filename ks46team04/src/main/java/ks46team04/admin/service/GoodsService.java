package ks46team04.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.GoodsCategory;
import ks46team04.admin.mapper.GoodsMapper;
import ks46team04.admin.mapper.StockMapper;

@Service
@Transactional
public class GoodsService {
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsService.class);

	private final GoodsMapper goodsMapper;
	private final StockMapper stockMapper;
	
	public GoodsService(GoodsMapper goodsMapper, StockMapper stockMapper) {
		this.goodsMapper = goodsMapper;
		this.stockMapper = stockMapper;
	}
	
	/**
	 * 상품 수정
	 * @param goods
	 */
	public void modifyGoods(Goods goods) {
		goodsMapper.modifyGoods(goods);
	}
	
	/**
	 * 특정 상품정보 조회
	 * @param goodsCode
	 * @return
	 */
	public Goods getGoodsInfoByCode(String goodsCode) {
		Goods goodsInfo = goodsMapper.getGoodsInfoByCode(goodsCode);
		return goodsInfo;
	}
	
	/**
	 * 상품 등록
	 * @param goods
	 * @return
	 */
	public int addGoods(Goods goods) {
		int result = goodsMapper.addGoods(goods);
		return result;
	}
	
	/**
     * 상품 삭제
     * @param goodsCode
     */
    public boolean removeGoods(String goodsCode) {
    	boolean isRemove = true; 
    	isRemove = stockMapper.removeStockCheck(goodsCode);
    	if (isRemove) {
    		goodsMapper.removeGoods(goodsCode);
    		return true;
        }
        return false;
    }
	
	/**
	 * 상품 검색 결과 조회
	 * @param paramMap
	 * @return
	 */
	public List<Goods> getGoodsListBySearch(String inputSearchKey
											, String inputSearchValue
											, String startDate
											, String endDate){
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		if(inputSearchKey != null && inputSearchValue != null) {
			switch (inputSearchKey) {
			case "goodsName":
				inputSearchKey = "goods_name";
				break;
			case "goodsCategory":
				inputSearchKey = "goods_category";					
				break;
			case "goodsCompany":
				inputSearchKey = "goods_company";					
				break;
			}
			
			searchMap.put("inputSearchKey", inputSearchKey);
			searchMap.put("inputSearchValue", inputSearchValue);
		}
		
		if(startDate != null && endDate != null) {
			searchMap.put("startDate", startDate);
			searchMap.put("endDate", endDate);
		}
		
		log.info("searchMap: {}", searchMap);
		List<Goods> goodsList = goodsMapper.getGoodsListBySearch(searchMap);
		return goodsList;
	}
	
	/**
	 * 상품 조회
	 * @return List<Goods>
	 */
	public List<Goods> getGoodsList(){
		List<Goods> goodsList = goodsMapper.getGoodsList();
		return goodsList;
	}
}
