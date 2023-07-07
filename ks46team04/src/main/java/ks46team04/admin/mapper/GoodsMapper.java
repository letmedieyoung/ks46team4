package ks46team04.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Goods;
import ks46team04.admin.dto.GoodsCategory;


@Mapper
public interface GoodsMapper {
	
	//상품 수정
	public int modifyGoods(Goods goods);
	
	//특정 상품 조회
	public Goods getGoodsInfoByCode(String goodsCode);
	
	//상품명으로 상품코드 조회
	public String getGoodsCodeByName(String goodsName);

	//등록된 상품명 조회
	public List<String> getGoodsNameList();
	
	//상품명 중복체크
	public boolean goodsNameCheck(String goodsName);
	
	//상품 등록 
	public int addGoods(Goods goods);
	
	//상품 분류 조회
	public List<String> getGoodsCategoryList();
	
	//상품 삭제
	public int removeGoods(String goodsCode);
	
	//상품 검색 결과 조회
	public List<Goods> getGoodsListBySearch(Map<String, Object> searchMap);
	
	//상품 조회
	public List<Goods> getGoodsList();
	
}
