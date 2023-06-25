package ks46team04.admin.dto;

import ks46team04.exception.NotEnoughStockException;

public class Stock {
	private String goodsStockCode;
	private String goodsCode;
	private String goodsLotNumber;
	private int currentStockAmount;
	private Boolean stocktakingCheck;
	private String stocktakingDate;
	private String goodsExpiryDate;
	private int finalStockAmount;
	private int unusualStockAmount;
	private Boolean unusualStockCheck;
	
	private Goods goodsInfo;
	
	private String goodsName;

	/**
	 * 재고조사 후 최종 재고 수량 계산
	 * @param currentStock
	 * @param unusualStock
	 */
	public void calculFinalStock(int currentStockAmount, int unusualStockAmount) {
		int finalStockAmount = currentStockAmount - unusualStockAmount;
		if(finalStockAmount < 0) {
			throw new NotEnoughStockException("해당 상품의 재고가 부족합니다.");
		}
		this.finalStockAmount = finalStockAmount;
	}
	
	/**
	 * 재고 자동 증가
	 */
	public void addCurrentStock(int quantity) {
		this.currentStockAmount += quantity;
	}
	
	/**
	 * 재고 자동 감소
	 */
	public void removeCurrentStock(int quantity) {
		int restStock = this.currentStockAmount - quantity;
		if(restStock < 0) {
			throw new NotEnoughStockException("해당 상품의 재고가 부족합니다.");
		}
		this.currentStockAmount = restStock;
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

	public Boolean getStocktakingCheck() {
		return stocktakingCheck;
	}

	public void setStocktakingCheck(Boolean stocktakingCheck) {
		this.stocktakingCheck = stocktakingCheck;
	}

	public String getStocktakingDate() {
		return stocktakingDate;
	}

	public void setStocktakingDate(String stocktakingDate) {
		this.stocktakingDate = stocktakingDate;
	}

	public String getGoodsExpiryDate() {
		return goodsExpiryDate;
	}

	public void setGoodsExpiryDate(String goodsExpiryDate) {
		this.goodsExpiryDate = goodsExpiryDate;
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

	public Boolean getUnusualStockCheck() {
		return unusualStockCheck;
	}

	public void setUnusualStockCheck(Boolean unusualStockCheck) {
		this.unusualStockCheck = unusualStockCheck;
	}

	public Goods getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(Goods goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Override
	public String toString() {
		return "Stock [goodsStockCode=" + goodsStockCode + ", goodsCode=" + goodsCode + ", goodsLotNumber="
				+ goodsLotNumber + ", currentStockAmount=" + currentStockAmount + ", stocktakingCheck="
				+ stocktakingCheck + ", stocktakingDate=" + stocktakingDate + ", goodsExpiryDate=" + goodsExpiryDate
				+ ", finalStockAmount=" + finalStockAmount + ", unusualStockAmount=" + unusualStockAmount
				+ ", unusualStockCheck=" + unusualStockCheck + ", goodsInfo=" + goodsInfo + ", goodsName=" + goodsName
				+ "]";
	}
	
}
