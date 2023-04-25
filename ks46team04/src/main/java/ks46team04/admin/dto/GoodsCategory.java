package ks46team04.admin.dto;

public class GoodsCategory {
	private String goodsCategoryCode;
	private String goodsCategory;
	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}
	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
	}
	public String getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	@Override
	public String toString() {
		return "GoodsCategory [goodsCategoryCode=" + goodsCategoryCode + ", goodsCategory=" + goodsCategory + "]";
	}
	
}
