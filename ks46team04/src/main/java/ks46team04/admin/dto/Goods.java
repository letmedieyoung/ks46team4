package ks46team04.admin.dto;

public class Goods {

	private String goodsCode;
	private String goodsName;
	private String goodsCompany;
	private String goodsCate;
	private String goodsPrice;
	private String goodsRegId;
	private String goodsRegDate;
	private String goodsUpdateId;
	private String goodsUpdateDate;
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsCompany() {
		return goodsCompany;
	}
	public void setGoodsCompany(String goodsCompany) {
		this.goodsCompany = goodsCompany;
	}
	public String getGoodsCate() {
		return goodsCate;
	}
	public void setGoodsCate(String goodsCate) {
		this.goodsCate = goodsCate;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsRegId() {
		return goodsRegId;
	}
	public void setGoodsRegId(String goodsRegId) {
		this.goodsRegId = goodsRegId;
	}
	public String getGoodsRegDate() {
		return goodsRegDate;
	}
	public void setGoodsRegDate(String goodsRegDate) {
		this.goodsRegDate = goodsRegDate;
	}
	public String getGoodsUpdateId() {
		return goodsUpdateId;
	}
	public void setGoodsUpdateId(String goodsUpdateId) {
		this.goodsUpdateId = goodsUpdateId;
	}
	public String getGoodsUpdateDate() {
		return goodsUpdateDate;
	}
	public void setGoodsUpdateDate(String goodsUpdateDate) {
		this.goodsUpdateDate = goodsUpdateDate;
	}
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsCompany=" + goodsCompany
				+ ", goodsCate=" + goodsCate + ", goodsPrice=" + goodsPrice + ", goodsRegId=" + goodsRegId
				+ ", goodsRegDate=" + goodsRegDate + ", goodsUpdateId=" + goodsUpdateId + ", goodsUpdateDate="
				+ goodsUpdateDate + "]";
	}
	
}
