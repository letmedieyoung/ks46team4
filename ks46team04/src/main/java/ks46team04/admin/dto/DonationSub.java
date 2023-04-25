package ks46team04.admin.dto;

public class DonationSub {

	private String donationSubCode;
	private String donationSubUserId;
	private String donationCode;
	private String donationPayMethodCode;
	private String donationSubStartDate;
	private String donationSubEndDate;
	
	public String getDonationSubCode() {
		return donationSubCode;
	}
	public void setDonationSubCode(String donationSubCode) {
		this.donationSubCode = donationSubCode;
	}
	public String getDonationSubUserId() {
		return donationSubUserId;
	}
	public void setDonationSubUserId(String donationSubUserId) {
		this.donationSubUserId = donationSubUserId;
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
	public String getDonationSubStartDate() {
		return donationSubStartDate;
	}
	public void setDonationSubStartDate(String donationSubStartDate) {
		this.donationSubStartDate = donationSubStartDate;
	}
	public String getDonationSubEndDate() {
		return donationSubEndDate;
	}
	public void setDonationSubEndDate(String donationSubEndDate) {
		this.donationSubEndDate = donationSubEndDate;
	}
	@Override
	public String toString() {
		return "DonationSub [donationSubCode=" + donationSubCode + ", donationSubUserId=" + donationSubUserId
				+ ", donationCode=" + donationCode + ", donationPayMethodCode=" + donationPayMethodCode
				+ ", donationSubStartDate=" + donationSubStartDate + ", donationSubEndDate=" + donationSubEndDate + "]";
	}
	
	
}
