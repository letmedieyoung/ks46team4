package ks46team04.admin.dto;

public class TotalPurchaseSale {
	//매입매출 종합
	
	private String monthDonationPayCode;		
	private String paymentYear;		
	private String paymentMonth;		
	private String purchaseSalesType;		
	private String salesGroupCode;		
	private int paymentAmount;		
	private int paymentVat;		
	private int purchaseBudget;		
	private String division;
	public String getMonthDonationPayCode() {
		return monthDonationPayCode;
	}
	public void setMonthDonationPayCode(String monthDonationPayCode) {
		this.monthDonationPayCode = monthDonationPayCode;
	}
	public String getPaymentYear() {
		return paymentYear;
	}
	public void setPaymentYear(String paymentYear) {
		this.paymentYear = paymentYear;
	}
	public String getPaymentMonth() {
		return paymentMonth;
	}
	public void setPaymentMonth(String paymentMonth) {
		this.paymentMonth = paymentMonth;
	}
	public String getPurchaseSalesType() {
		return purchaseSalesType;
	}
	public void setPurchaseSalesType(String purchaseSalesType) {
		this.purchaseSalesType = purchaseSalesType;
	}
	public String getSalesGroupCode() {
		return salesGroupCode;
	}
	public void setSalesGroupCode(String salesGroupCode) {
		this.salesGroupCode = salesGroupCode;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getPaymentVat() {
		return paymentVat;
	}
	public void setPaymentVat(int paymentVat) {
		this.paymentVat = paymentVat;
	}
	public int getPurchaseBudget() {
		return purchaseBudget;
	}
	public void setPurchaseBudget(int purchaseBudget) {
		this.purchaseBudget = purchaseBudget;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalPurchaseSale [monthDonationPayCode=");
		builder.append(monthDonationPayCode);
		builder.append(", paymentYear=");
		builder.append(paymentYear);
		builder.append(", paymentMonth=");
		builder.append(paymentMonth);
		builder.append(", purchaseSalesType=");
		builder.append(purchaseSalesType);
		builder.append(", salesGroupCode=");
		builder.append(salesGroupCode);
		builder.append(", paymentAmount=");
		builder.append(paymentAmount);
		builder.append(", paymentVat=");
		builder.append(paymentVat);
		builder.append(", purchaseBudget=");
		builder.append(purchaseBudget);
		builder.append(", division=");
		builder.append(division);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
