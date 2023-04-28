package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.GoodsCategory;
import ks46team04.admin.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsService.class);

	private final GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	/**
	 * 상품 삭제
	 * @param goodsCode
	 */
	public void removeGoods(List<String> valueArr) {
		for(int i=0; i<valueArr.size(); i++) {
			goodsMapper.removeGoods(valueArr.get(i));
		}
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
	 * 상품 분류 조회
	 * @return
	 */
	public List<GoodsCategory> getGoodsCategoryList(){
		List<GoodsCategory> goodsCategory = goodsMapper.getGoodsCategoryList();
		return goodsCategory;
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
