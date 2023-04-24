package ks46team04.admin.dto;

public class ProfitLoss {
	private String profitLossCode;		
	private int paymentYear;		
	private int paymentMonth;		
	private int monthTotalSales;		
	private int monthTotalVat;		
	private int monthTotalBudge;		
	private int monthTotalPurchase;		
	private int monthProfitLoss;		
	private int finalMonthProfitLoss;		
	private boolean settlementCheck;		
	private String settlementDate;		
	private String settlementCheckId;
	
	
	public String getProfitLossCode() {
		return profitLossCode;
	}
	public void setProfitLossCode(String profitLossCode) {
		this.profitLossCode = profitLossCode;
	}
	public int getPaymentYear() {
		return paymentYear;
	}
	public void setPaymentYear(int paymentYear) {
		this.paymentYear = paymentYear;
	}
	public int getPaymentMonth() {
		return paymentMonth;
	}
	public void setPaymentMonth(int paymentMonth) {
		this.paymentMonth = paymentMonth;
	}
	public int getMonthTotalSales() {
		return monthTotalSales;
	}
	public void setMonthTotalSales(int monthTotalSales) {
		this.monthTotalSales = monthTotalSales;
	}
	public int getMonthTotalVat() {
		return monthTotalVat;
	}
	public void setMonthTotalVat(int monthTotalVat) {
		this.monthTotalVat = monthTotalVat;
	}
	public int getMonthTotalBudge() {
		return monthTotalBudge;
	}
	public void setMonthTotalBudge(int monthTotalBudge) {
		this.monthTotalBudge = monthTotalBudge;
	}
	public int getMonthTotalPurchase() {
		return monthTotalPurchase;
	}
	public void setMonthTotalPurchase(int monthTotalPurchase) {
		this.monthTotalPurchase = monthTotalPurchase;
	}
	public int getMonthProfitLoss() {
		return monthProfitLoss;
	}
	public void setMonthProfitLoss(int monthProfitLoss) {
		this.monthProfitLoss = monthProfitLoss;
	}
	public int getFinalMonthProfitLoss() {
		return finalMonthProfitLoss;
	}
	public void setFinalMonthProfitLoss(int finalMonthProfitLoss) {
		this.finalMonthProfitLoss = finalMonthProfitLoss;
	}
	public boolean isSettlementCheck() {
		return settlementCheck;
	}
	public void setSettlementCheck(boolean settlementCheck) {
		this.settlementCheck = settlementCheck;
	}
	public String getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getSettlementCheckId() {
		return settlementCheckId;
	}
	public void setSettlementCheckId(String settlementCheckId) {
		this.settlementCheckId = settlementCheckId;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfitLoss [profitLossCode=");
		builder.append(profitLossCode);
		builder.append(", paymentYear=");
		builder.append(paymentYear);
		builder.append(", paymentMonth=");
		builder.append(paymentMonth);
		builder.append(", monthTotalSales=");
		builder.append(monthTotalSales);
		builder.append(", monthTotalVat=");
		builder.append(monthTotalVat);
		builder.append(", monthTotalBudge=");
		builder.append(monthTotalBudge);
		builder.append(", monthTotalPurchase=");
		builder.append(monthTotalPurchase);
		builder.append(", monthProfitLoss=");
		builder.append(monthProfitLoss);
		builder.append(", finalMonthProfitLoss=");
		builder.append(finalMonthProfitLoss);
		builder.append(", settlementCheck=");
		builder.append(settlementCheck);
		builder.append(", settlementDate=");
		builder.append(settlementDate);
		builder.append(", settlementCheckId=");
		builder.append(settlementCheckId);
		builder.append("]");
		return builder.toString();
	}	
}
