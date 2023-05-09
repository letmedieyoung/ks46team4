package ks46team04.admin.dto;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private String goodsCompany;
	private String goodsCategory;
	private String goodsPrice;
	private String goodsRegId;
	private String goodsRegDate;
	private String goodsUpdId;
	private String goodsUpdDate;
	private String goodsIsDelete;
	
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
	public String getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
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
	public String getGoodsUpdId() {
		return goodsUpdId;
	}
	public void setGoodsUpdId(String goodsUpdId) {
		this.goodsUpdId = goodsUpdId;
	}
	public String getGoodsUpdDate() {
		return goodsUpdDate;
	}
	public void setGoodsUpdDate(String goodsUpdDate) {
		this.goodsUpdDate = goodsUpdDate;
	}
	
	public String getGoodsIsDelete() {
		return goodsIsDelete;
	}
	public void setGoodsIsDelete(String goodsIsDelete) {
		this.goodsIsDelete = goodsIsDelete;
	}
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsCompany=" + goodsCompany
				+ ", goodsCategory=" + goodsCategory + ", goodsPrice=" + goodsPrice + ", goodsRegId=" + goodsRegId
				+ ", goodsRegDate=" + goodsRegDate + ", goodsUpdId=" + goodsUpdId + ", goodsUpdDate=" + goodsUpdDate
				+ ", goodsIsDelete=" + goodsIsDelete + "]";
	}
	
}
