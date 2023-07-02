package ks46team04.admin.dto;

public class InOutcoming {
	private String inOutcomingCode;
	private String goodsCode;
	private String goodsLotNumber;
	private int inOutcomingQuantity;
	private String inOutcomingType;
	private String inOutcomingDate;
	private String inOutcomingRegId;
	private String inOutcomingRegDate;
	private String inOutcomingUpdId;
	private String inOutcomingUpdDate;
	
	private OutcomingDetail outcomingDetailInfo;
	private Goods goodsInfo;
	private Foundation foundationInfo;
	public String getInOutcomingCode() {
		return inOutcomingCode;
	}
	public void setInOutcomingCode(String inOutcomingCode) {
		this.inOutcomingCode = inOutcomingCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsLotNumber() {
		return goodsLotNumber;
	}
	public void setGoodsLotNumber(String goodsLotNumber) {
		this.goodsLotNumber = goodsLotNumber;
	}
	public int getInOutcomingQuantity() {
		return inOutcomingQuantity;
	}
	public void setInOutcomingQuantity(int inOutcomingQuantity) {
		this.inOutcomingQuantity = inOutcomingQuantity;
	}
	public String getInOutcomingType() {
		return inOutcomingType;
	}
	public void setInOutcomingType(String inOutcomingType) {
		this.inOutcomingType = inOutcomingType;
	}
	public String getInOutcomingDate() {
		return inOutcomingDate;
	}
	public void setInOutcomingDate(String inOutcomingDate) {
		this.inOutcomingDate = inOutcomingDate;
	}
	public String getInOutcomingRegId() {
		return inOutcomingRegId;
	}
	public void setInOutcomingRegId(String inOutcomingRegId) {
		this.inOutcomingRegId = inOutcomingRegId;
	}
	public String getInOutcomingRegDate() {
		return inOutcomingRegDate;
	}
	public void setInOutcomingRegDate(String inOutcomingRegDate) {
		this.inOutcomingRegDate = inOutcomingRegDate;
	}
	public String getInOutcomingUpdId() {
		return inOutcomingUpdId;
	}
	public void setInOutcomingUpdId(String inOutcomingUpdId) {
		this.inOutcomingUpdId = inOutcomingUpdId;
	}
	public String getInOutcomingUpdDate() {
		return inOutcomingUpdDate;
	}
	public void setInOutcomingUpdDate(String inOutcomingUpdDate) {
		this.inOutcomingUpdDate = inOutcomingUpdDate;
	}
	public OutcomingDetail getOutcomingDetailInfo() {
		return outcomingDetailInfo;
	}
	public void setOutcomingDetailInfo(OutcomingDetail outcomingDetailInfo) {
		this.outcomingDetailInfo = outcomingDetailInfo;
	}
	public Goods getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(Goods goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public Foundation getFoundationInfo() {
		return foundationInfo;
	}
	public void setFoundationInfo(Foundation foundationInfo) {
		this.foundationInfo = foundationInfo;
	}
	@Override
	public String toString() {
		return "InOutcoming [inOutcomingCode=" + inOutcomingCode + ", goodsCode=" + goodsCode + ", goodsLotNumber="
				+ goodsLotNumber + ", inOutcomingQuantity=" + inOutcomingQuantity + ", inOutcomingType="
				+ inOutcomingType + ", inOutcomingDate=" + inOutcomingDate + ", inOutcomingRegId=" + inOutcomingRegId
				+ ", inOutcomingRegDate=" + inOutcomingRegDate + ", inOutcomingUpdId=" + inOutcomingUpdId
				+ ", inOutcomingUpdDate=" + inOutcomingUpdDate + ", outcomingDetailInfo=" + outcomingDetailInfo
				+ ", goodsInfo=" + goodsInfo + ", foundationInfo=" + foundationInfo + "]";
	}
	
	

}
