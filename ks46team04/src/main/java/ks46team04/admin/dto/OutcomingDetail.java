package ks46team04.admin.dto;

public class OutcomingDetail {
	private String outcomingDetailCode;
	private String inOutcomingCode;
	private String outcomingGoods;
	private int outcomingQuantity;
	private String outcomingDate;
	private String outcomingId;
	private String foundationCode;
	private String outcomingDetailRegId;
	private String outcomingDetailRegDate;
	private String outcomingDetailUpdId;
	private String outcomingDetailUpdDate;
	
	private String goodsName;
	private String foundationName;
	
	public String getFoundationName() {
		return foundationName;
	}
	public void setFoundationName(String foundationName) {
		this.foundationName = foundationName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getOutcomingDetailCode() {
		return outcomingDetailCode;
	}
	public void setOutcomingDetailCode(String outcomingDetailCode) {
		this.outcomingDetailCode = outcomingDetailCode;
	}
	public String getInOutcomingCode() {
		return inOutcomingCode;
	}
	public void setInOutcomingCode(String inOutcomingCode) {
		this.inOutcomingCode = inOutcomingCode;
	}
	public String getOutcomingGoods() {
		return outcomingGoods;
	}
	public void setOutcomingGoods(String outcomingGoods) {
		this.outcomingGoods = outcomingGoods;
	}
	public int getOutcomingQuantity() {
		return outcomingQuantity;
	}
	public void setOutcomingQuantity(int outcomingQuantity) {
		this.outcomingQuantity = outcomingQuantity;
	}
	public String getOutcomingDate() {
		return outcomingDate;
	}
	public void setOutcomingDate(String outcomingDate) {
		this.outcomingDate = outcomingDate;
	}
	public String getOutcomingId() {
		return outcomingId;
	}
	public void setOutcomingId(String outcomingId) {
		this.outcomingId = outcomingId;
	}
	public String getFoundationCode() {
		return foundationCode;
	}
	public void setFoundationCode(String foundationCode) {
		this.foundationCode = foundationCode;
	}
	public String getOutcomingDetailRegId() {
		return outcomingDetailRegId;
	}
	public void setOutcomingDetailRegId(String outcomingDetailRegId) {
		this.outcomingDetailRegId = outcomingDetailRegId;
	}
	public String getOutcomingDetailRegDate() {
		return outcomingDetailRegDate;
	}
	public void setOutcomingDetailRegDate(String outcomingDetailRegDate) {
		this.outcomingDetailRegDate = outcomingDetailRegDate;
	}
	public String getOutcomingDetailUpdId() {
		return outcomingDetailUpdId;
	}
	public void setOutcomingDetailUpdId(String outcomingDetailUpdId) {
		this.outcomingDetailUpdId = outcomingDetailUpdId;
	}
	public String getOutcomingDetailUpdDate() {
		return outcomingDetailUpdDate;
	}
	public void setOutcomingDetailUpdDate(String outcomingDetailUpdDate) {
		this.outcomingDetailUpdDate = outcomingDetailUpdDate;
	}
	@Override
	public String toString() {
		return "OutcomingDetail [outcomingDetailCode=" + outcomingDetailCode + ", inOutcomingCode=" + inOutcomingCode
				+ ", outcomingGoods=" + outcomingGoods + ", outcomingQuantity=" + outcomingQuantity + ", outcomingDate="
				+ outcomingDate + ", outcomingId=" + outcomingId + ", foundationCode=" + foundationCode
				+ ", outcomingDetailRegId=" + outcomingDetailRegId + ", outcomingDetailRegDate="
				+ outcomingDetailRegDate + ", outcomingDetailUpdId=" + outcomingDetailUpdId
				+ ", outcomingDetailUpdDate=" + outcomingDetailUpdDate + ", goodsName=" + goodsName
				+ ", foundationName=" + foundationName + "]";
	}
	
}
