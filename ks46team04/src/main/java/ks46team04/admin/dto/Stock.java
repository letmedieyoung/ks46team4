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
	
	/**
	 * 최종 재고 수량 계산
	 * @param currentStock
	 * @param unusualStock
	 */
	public void calculFinalStock(int currentStockAmount, int unusualStockAmount) {
		int finalStockAmount = currentStockAmount - unusualStockAmount;
		if(finalStockAmount < 0) {
			throw new NotEnoughStockException("해당 상품의 재고가 부족합니다. (현재 최종 재고 수량 : " + this.finalStockAmount + ")");
		}
		this.finalStockAmount = finalStockAmount;
	}
	
	/**
	 * 비정상 재고 자동 증가
	 */
	public void addUnusualStock(int quantity) {
		this.unusualStockAmount += quantity;
	}
	
	/**
	 * 비정상 재고 자동 감소
	 */
	public void removeUnusualStock(int quantity) {
		int restStock = this.unusualStockAmount - quantity;
		if(restStock < 0) {
			throw new NotEnoughStockException("해당 상품의 비정상재고수량이 없습니다.");
		}
		this.unusualStockAmount = restStock;
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
			throw new NotEnoughStockException("해당 상품의 재고가 부족합니다. (현재 재고 수량 : " + this.currentStockAmount + ")");
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

	@Override
	public String toString() {
		return "Stock [goodsStockCode=" + goodsStockCode + ", goodsCode=" + goodsCode + ", goodsLotNumber="
				+ goodsLotNumber + ", currentStockAmount=" + currentStockAmount + ", stocktakingCheck="
				+ stocktakingCheck + ", stocktakingDate=" + stocktakingDate + ", goodsExpiryDate=" + goodsExpiryDate
				+ ", finalStockAmount=" + finalStockAmount + ", unusualStockAmount=" + unusualStockAmount
				+ ", unusualStockCheck=" + unusualStockCheck + ", goodsInfo=" + goodsInfo + "]";
	}
	
}
