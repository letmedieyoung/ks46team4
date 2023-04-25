package ks46team04.admin.dto;

public class DonationPayMethod {

	private String donationPayMethodCode;
	private String donationPayMethodUserId;
	private String donationPayCode;
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
	public String getDonationPayCode() {
		return donationPayCode;
	}
	public void setDonationPayCode(String donationPayCode) {
		this.donationPayCode = donationPayCode;
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
				+ donationPayMethodUserId + ", donationPayCode=" + donationPayCode + ", donationPayMethodBank="
				+ donationPayMethodBank + ", donationPayMethodAccount=" + donationPayMethodAccount
				+ ", donationPayMethodRegDate=" + donationPayMethodRegDate + ", donationPayMethodUpdateDate="
				+ donationPayMethodUpdateDate + "]";
	}
}
