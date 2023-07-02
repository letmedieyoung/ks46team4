package ks46team04.admin.dto;

public class InOutcomingForm {
	/* 입출고 정보 */
	private String inOutcomingCode;
	private String goodsName;
	private String goodsLotNumber;
	private String goodsCompany;
	private String inOutcomingType;
	private int inOutcomingQuantity;
	private String inOutcomingDate;
	
	/* 입고 상세 정보 정보 */
	private String goodsExpiryDate;
	
	/* 출고 상세 정보 */
	private String outcomingId;
	private String foundationName;
	public String getInOutcomingCode() {
		return inOutcomingCode;
	}
	public void setInOutcomingCode(String inOutcomingCode) {
		this.inOutcomingCode = inOutcomingCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsLotNumber() {
		return goodsLotNumber;
	}
	public void setGoodsLotNumber(String goodsLotNumber) {
		this.goodsLotNumber = goodsLotNumber;
	}
	public String getGoodsCompany() {
		return goodsCompany;
	}
	public void setGoodsCompany(String goodsCompany) {
		this.goodsCompany = goodsCompany;
	}
	public String getInOutcomingType() {
		return inOutcomingType;
	}
	public void setInOutcomingType(String inOutcomingType) {
		this.inOutcomingType = inOutcomingType;
	}
	public int getInOutcomingQuantity() {
		return inOutcomingQuantity;
	}
	public void setInOutcomingQuantity(int inOutcomingQuantity) {
		this.inOutcomingQuantity = inOutcomingQuantity;
	}
	public String getInOutcomingDate() {
		return inOutcomingDate;
	}
	public void setInOutcomingDate(String inOutcomingDate) {
		this.inOutcomingDate = inOutcomingDate;
	}
	public String getGoodsExpiryDate() {
		return goodsExpiryDate;
	}
	public void setGoodsExpiryDate(String goodsExpiryDate) {
		this.goodsExpiryDate = goodsExpiryDate;
	}
	public String getOutcomingId() {
		return outcomingId;
	}
	public void setOutcomingId(String outcomingId) {
		this.outcomingId = outcomingId;
	}
	public String getFoundationName() {
		return foundationName;
	}
	public void setFoundationName(String foundationName) {
		this.foundationName = foundationName;
	}
	@Override
	public String toString() {
		return "InOutcomingForm [inOutcomingCode=" + inOutcomingCode + ", goodsName=" + goodsName + ", goodsLotNumber="
				+ goodsLotNumber + ", goodsCompany=" + goodsCompany + ", inOutcomingType=" + inOutcomingType
				+ ", inOutcomingQuantity=" + inOutcomingQuantity + ", inOutcomingDate=" + inOutcomingDate
				+ ", goodsExpiryDate=" + goodsExpiryDate + ", outcomingId=" + outcomingId + ", foundationName="
				+ foundationName + "]";
	}

	
}
