package ks46team04.admin.dto;

public class Stock {
	private String goodsStockCode;
	private String goodsCode;
	private String goodsLotNumber;
	private String currentStockAmount;
	private String stocktakingCheck;
	private String stocktakingDate;
	private String goodsExprityDate;
	private String finalStockAmount;
	private String unusualStockAmount;
	private String unusualStockCheck;
	
	private Goods goodsInfo;
	
	public Goods getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(Goods goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public String getGoodsStockCode() {
		return goodsStockCode;
	}
	public void setGoodsStockCode(String goodsStockCode) {
		this.goodsStockCode = goodsStockCode;
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
	public String getCurrentStockAmount() {
		return currentStockAmount;
	}
	public void setCurrentStockAmount(String currentStockAmount) {
		this.currentStockAmount = currentStockAmount;
	}
	public String getStocktakingCheck() {
		return stocktakingCheck;
	}
	public void setStocktakingCheck(String stocktakingCheck) {
		this.stocktakingCheck = stocktakingCheck;
	}
	public String getStocktakingDate() {
		return stocktakingDate;
	}
	public void setStocktakingDate(String stocktakingDate) {
		this.stocktakingDate = stocktakingDate;
	}
	public String getGoodsExprityDate() {
		return goodsExprityDate;
	}
	public void setGoodsExprityDate(String goodsExprityDate) {
		this.goodsExprityDate = goodsExprityDate;
	}
	public String getFinalStockAmount() {
		return finalStockAmount;
	}
	public void setFinalStockAmount(String finalStockAmount) {
		this.finalStockAmount = finalStockAmount;
	}
	public String getUnusualStockAmount() {
		return unusualStockAmount;
	}
	public void setUnusualStockAmount(String unusualStockAmount) {
		this.unusualStockAmount = unusualStockAmount;
	}
	public String getUnusualStockCheck() {
		return unusualStockCheck;
	}
	public void setUnusualStockCheck(String unusualStockCheck) {
		this.unusualStockCheck = unusualStockCheck;
	}
	@Override
	public String toString() {
		return "Stock [goodsStockCode=" + goodsStockCode + ", goodsCode=" + goodsCode + ", goodsLotNumber="
				+ goodsLotNumber + ", currentStockAmount=" + currentStockAmount + ", stocktakingCheck="
				+ stocktakingCheck + ", stocktakingDate=" + stocktakingDate + ", goodsExprityDate=" + goodsExprityDate
				+ ", finalStockAmount=" + finalStockAmount + ", unusualStockAmount=" + unusualStockAmount
				+ ", unusualStockCheck=" + unusualStockCheck + ", goodsInfo=" + goodsInfo + "]";
	}
	
}
