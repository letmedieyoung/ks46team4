package ks46team04.admin.dto;

public class DonationPayDetail {

	private String donationPayDetailCode;
	private String donationPayUserId;
	private String donationSubCode;
	private String donationCode;
	private String donationPayMethodCode;
	private String donationPayAmount;
	private String donationPaySalesCommission;
	private String donationPayPurchaseBudget;
	private String donationPayDate;
	private String donationPayRefundRequest;
	private String donationPaySalesGroup;
	private String donationPayDeadlineCheck;
	
	public String getDonationPayDetailCode() {
		return donationPayDetailCode;
	}
	public void setDonationPayDetailCode(String donationPayDetailCode) {
		this.donationPayDetailCode = donationPayDetailCode;
	}
	public String getDonationPayUserId() {
		return donationPayUserId;
	}
	public void setDonationPayUserId(String donationPayUserId) {
		this.donationPayUserId = donationPayUserId;
	}
	public String getDonationSubCode() {
		return donationSubCode;
	}
	public void setDonationSubCode(String donationSubCode) {
		this.donationSubCode = donationSubCode;
	}
	public String getDonationCode() {
		return donationCode;
	}
	public void setDonationCode(String donationCode) {
		this.donationCode = donationCode;
	}
	public String getDonationPayMethodCode() {
		return donationPayMethodCode;
	}
	public void setDonationPayMethodCode(String donationPayMethodCode) {
		this.donationPayMethodCode = donationPayMethodCode;
	}
	public String getDonationPayAmount() {
		return donationPayAmount;
	}
	public void setDonationPayAmount(String donationPayAmount) {
		this.donationPayAmount = donationPayAmount;
	}
	public String getDonationPaySalesCommission() {
		return donationPaySalesCommission;
	}
	public void setDonationPaySalesCommission(String donationPaySalesCommission) {
		this.donationPaySalesCommission = donationPaySalesCommission;
	}
	public String getDonationPayPurchaseBudget() {
		return donationPayPurchaseBudget;
	}
	public void setDonationPayPurchaseBudget(String donationPayPurchaseBudget) {
		this.donationPayPurchaseBudget = donationPayPurchaseBudget;
	}
	public String getDonationPayDate() {
		return donationPayDate;
	}
	public void setDonationPayDate(String donationPayDate) {
		this.donationPayDate = donationPayDate;
	}
	public String getDonationPayRefundRequest() {
		return donationPayRefundRequest;
	}
	public void setDonationPayRefundRequest(String donationPayRefundRequest) {
		this.donationPayRefundRequest = donationPayRefundRequest;
	}
	public String getDonationPaySalesGroup() {
		return donationPaySalesGroup;
	}
	public void setDonationPaySalesGroup(String donationPaySalesGroup) {
		this.donationPaySalesGroup = donationPaySalesGroup;
	}
	public String getDonationPayDeadlineCheck() {
		return donationPayDeadlineCheck;
	}
	public void setDonationPayDeadlineCheck(String donationPayDeadlineCheck) {
		this.donationPayDeadlineCheck = donationPayDeadlineCheck;
	}
	
	@Override
	public String toString() {
		return "DonationPayDetail [donationPayDetailCode=" + donationPayDetailCode + ", donationPayUserId="
				+ donationPayUserId + ", donationSubCode=" + donationSubCode + ", donationCode=" + donationCode
				+ ", donationPayMethodCode=" + donationPayMethodCode + ", donationPayAmount=" + donationPayAmount
				+ ", donationPaySalesCommission=" + donationPaySalesCommission + ", donationPayPurchaseBudget="
				+ donationPayPurchaseBudget + ", donationPayDate=" + donationPayDate + ", donationPayRefundRequest="
				+ donationPayRefundRequest + ", donationPaySalesGroup=" + donationPaySalesGroup
				+ ", donationPayDeadlineCheck=" + donationPayDeadlineCheck + "]";
	}
	
	
}
