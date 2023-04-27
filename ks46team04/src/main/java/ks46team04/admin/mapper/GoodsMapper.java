package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.GoodsCategory;


@Mapper
public interface GoodsMapper {
	
	//상품삭제
	public int removeGoodsByGoodsCode(String goodsCode);
	
	//상품수정
	public int modifyGoods(Goods goods);
	
	//특정 상품조회
	public Goods getGoodsInfoByCode(String goodsCode);
	
	//상품등록 
	public int addGoods(Goods goods);
		
	//상품 조회
	public List<Goods> getGoodsList();
	
	//상품 분류 조회
	public List<GoodsCategory> getGoodsCategoryList();
	
}
