package ks46team04.admin.dto;

public class DonationPayMethod {

	private String donationPayMethodCode;
	private String donationPayMethodUserId;
	private String paymentCode;
	private String donationPayMethodBank;
	private String donationPayMethodAccount;
	private String donationPayMethodRegDate;
	private String donationPayMethodUpdateDate;
	
	public String getDonationPayMethodCode() {
		return donationPayMethodCode;
	}
	public void setDonationPayMethodCode(String donationPayMethodCode) {
		this.donationPayMethodCode = donationPayMethodCode;
	}
	public String getDonationPayMethodUserId() {
		return donationPayMethodUserId;
	}
	public void setDonationPayMethodUserId(String donationPayMethodUserId) {
		this.donationPayMethodUserId = donationPayMethodUserId;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getDonationPayMethodBank() {
		return donationPayMethodBank;
	}
	public void setDonationPayMethodBank(String donationPayMethodBank) {
		this.donationPayMethodBank = donationPayMethodBank;
	}
	public String getDonationPayMethodAccount() {
		return donationPayMethodAccount;
	}
	public void setDonationPayMethodAccount(String donationPayMethodAccount) {
		this.donationPayMethodAccount = donationPayMethodAccount;
	}
	public String getDonationPayMethodRegDate() {
		return donationPayMethodRegDate;
	}
	public void setDonationPayMethodRegDate(String donationPayMethodRegDate) {
		this.donationPayMethodRegDate = donationPayMethodRegDate;
	}
	public String getDonationPayMethodUpdateDate() {
		return donationPayMethodUpdateDate;
	}
	public void setDonationPayMethodUpdateDate(String donationPayMethodUpdateDate) {
		this.donationPayMethodUpdateDate = donationPayMethodUpdateDate;
	}
	
	@Override
	public String toString() {
		return "DonationPayMethod [donationPayMethodCode=" + donationPayMethodCode + ", donationPayMethodUserId="
				+ donationPayMethodUserId + ", paymentCode=" + paymentCode + ", donationPayMethodBank="
				+ donationPayMethodBank + ", donationPayMethodAccount=" + donationPayMethodAccount
				+ ", donationPayMethodRegDate=" + donationPayMethodRegDate + ", donationPayMethodUpdateDate="
				+ donationPayMethodUpdateDate + "]";
	}
	public void setDonationId(String donationId) {
		// TODO Auto-generated method stub
		
	}
}
