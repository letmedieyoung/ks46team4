package ks46team04.admin.dto;

public class UnusualStock {

	private String unusualStockCode;
	private String goodsCode;
	private String goodsStockCode;
	private String unusualStockQuantity;
	private String unusualStockDate;
	private String unusualStockReason;
	private String unusualStockRegId;
	private String unusualStockRegDate;
	private String unusualStockUpdateId;
	private String unusualStockUpdateDate;
	public String getUnusualStockCode() {
		return unusualStockCode;
	}
	public void setUnusualStockCode(String unusualStockCode) {
		this.unusualStockCode = unusualStockCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsStockCode() {
		return goodsStockCode;
	}
	public void setGoodsStockCode(String goodsStockCode) {
		this.goodsStockCode = goodsStockCode;
	}
	public String getUnusualStockQuantity() {
		return unusualStockQuantity;
	}
	public void setUnusualStockQuantity(String unusualStockQuantity) {
		this.unusualStockQuantity = unusualStockQuantity;
	}
	public String getUnusualStockDate() {
		return unusualStockDate;
	}
	public void setUnusualStockDate(String unusualStockDate) {
		this.unusualStockDate = unusualStockDate;
	}
	public String getUnusualStockReason() {
		return unusualStockReason;
	}
	public void setUnusualStockReason(String unusualStockReason) {
		this.unusualStockReason = unusualStockReason;
	}
	public String getUnusualStockRegId() {
		return unusualStockRegId;
	}
	public void setUnusualStockRegId(String unusualStockRegId) {
		this.unusualStockRegId = unusualStockRegId;
	}
	public String getUnusualStockRegDate() {
		return unusualStockRegDate;
	}
	public void setUnusualStockRegDate(String unusualStockRegDate) {
		this.unusualStockRegDate = unusualStockRegDate;
	}
	public String getUnusualStockUpdateId() {
		return unusualStockUpdateId;
	}
	public void setUnusualStockUpdateId(String unusualStockUpdateId) {
		this.unusualStockUpdateId = unusualStockUpdateId;
	}
	public String getUnusualStockUpdateDate() {
		return unusualStockUpdateDate;
	}
	public void setUnusualStockUpdateDate(String unusualStockUpdateDate) {
		this.unusualStockUpdateDate = unusualStockUpdateDate;
	}
	@Override
	public String toString() {
		return "UnusualStock [unusualStockCode=" + unusualStockCode + ", goodsCode=" + goodsCode + ", goodsStockCode="
				+ goodsStockCode + ", unusualStockQuantity=" + unusualStockQuantity + ", unusualStockDate="
				+ unusualStockDate + ", unusualStockReason=" + unusualStockReason + ", unusualStockRegId="
				+ unusualStockRegId + ", unusualStockRegDate=" + unusualStockRegDate + ", unusualStockUpdateId="
				+ unusualStockUpdateId + ", unusualStockUpdateDate=" + unusualStockUpdateDate + "]";
	}
	
}
