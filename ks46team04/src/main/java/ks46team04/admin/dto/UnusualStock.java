package ks46team04.admin.dto;

public class UnusualStock {
	private String unusualStockCode;
	private String goodsCode;
	private String goodsStockCode;
	private int unusualStockQuantity;
	private String unusualStockDate;
	private String unusualStockReason;
	private String unusualStockRegId;
	private String unusualStockRegDate;
	private String unusualStockUpdId;
	private String unusualStockUpdDate;
	
	private Goods goodsInfo;
	private Stock stockInfo;
	
	private String goodsName;
	private String goodsLotNumber;
	
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
	public Stock getStockInfo() {
		return stockInfo;
	}
	public void setStockInfo(Stock stockInfo) {
		this.stockInfo = stockInfo;
	}
	public Goods getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(Goods goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
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
	public int getUnusualStockQuantity() {
		return unusualStockQuantity;
	}
	public void setUnusualStockQuantity(int unusualStockQuantity) {
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
	public String getUnusualStockUpdId() {
		return unusualStockUpdId;
	}
	public void setUnusualStockUpdId(String unusualStockUpdId) {
		this.unusualStockUpdId = unusualStockUpdId;
	}
	public String getUnusualStockUpdDate() {
		return unusualStockUpdDate;
	}
	public void setUnusualStockUpdDate(String unusualStockUpdDate) {
		this.unusualStockUpdDate = unusualStockUpdDate;
	}
	@Override
	public String toString() {
		return "UnusualStock [unusualStockCode=" + unusualStockCode + ", goodsCode=" + goodsCode + ", goodsStockCode="
				+ goodsStockCode + ", unusualStockQuantity=" + unusualStockQuantity + ", unusualStockDate="
				+ unusualStockDate + ", unusualStockReason=" + unusualStockReason + ", unusualStockRegId="
				+ unusualStockRegId + ", unusualStockRegDate=" + unusualStockRegDate + ", unusualStockUpdId="
				+ unusualStockUpdId + ", unusualStockUpdDate=" + unusualStockUpdDate + ", goodsInfo=" + goodsInfo
				+ ", stockInfo=" + stockInfo + ", goodsName=" + goodsName + ", goodsLotNumber=" + goodsLotNumber + "]";
	}
	
	
}
