package ks46team04.admin.dto;

import ks46team04.exception.NotEnoughStockException;

public class Stock {
	private String goodsStockCode;
	private String goodsCode;
	private String goodsLotNumber;
	private int currentStockAmount;
	private String stocktakingCheck;
	private String stocktakingDate;
	private String goodsExprityDate;
	private int finalStockAmount;
	private int unusualStockAmount;
	private String unusualStockCheck;
	
	private Goods goodsInfo;
	
	/**
	 * 재고 자동 증가
	 */
	public void addStock(int quantity) {
		this.currentStockAmount += quantity;
	}
	
	/**
	 * 재고 자동 감소
	 */
	public void removeStock(int quantity) {
		int restStock = this.currentStockAmount - quantity;
		if(restStock < 0) {
			throw new NotEnoughStockException("해당 상품의 재고가 부족합니다.");
		}
		this.currentStockAmount = restStock;
	}
	
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
	public int getCurrentStockAmount() {
		return currentStockAmount;
	}
	public void setCurrentStockAmount(int currentStockAmount) {
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
	public int getFinalStockAmount() {
		return finalStockAmount;
	}
	public void setFinalStockAmount(int finalStockAmount) {
		this.finalStockAmount = finalStockAmount;
	}
	public int getUnusualStockAmount() {
		return unusualStockAmount;
	}
	public void setUnusualStockAmount(int unusualStockAmount) {
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
