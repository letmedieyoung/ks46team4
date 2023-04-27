package ks46team04.admin.dto;

public class DonationMonthPay {
	private String donationMonthPayCode;
	private String donationCode;
	private String donationMonthPayYear;
	private String donationMonthPayMonth;
	private String donationMonthPayAmount;
	private String donationMonthPayDeadlineGroup;
	
	public String getDonationMonthPayCode() {
		return donationMonthPayCode;
	}
	public void setDonationMonthPayCode(String donationMonthPayCode) {
		this.donationMonthPayCode = donationMonthPayCode;
	}
	public String getDonationCode() {
		return donationCode;
	}
	public void setDonationCode(String donationCode) {
		this.donationCode = donationCode;
	}
	public String getDonationMonthPayYear() {
		return donationMonthPayYear;
	}
	public void setDonationMonthPayYear(String donationMonthPayYear) {
		this.donationMonthPayYear = donationMonthPayYear;
	}
	public String getDonationMonthPayMonth() {
		return donationMonthPayMonth;
	}
	public void setDonationMonthPayMonth(String donationMonthPayMonth) {
		this.donationMonthPayMonth = donationMonthPayMonth;
	}
	public String getDonationMonthPayAmount() {
		return donationMonthPayAmount;
	}
	public void setDonationMonthPayAmount(String donationMonthPayAmount) {
		this.donationMonthPayAmount = donationMonthPayAmount;
	}
	public String getDonationMonthPayDeadlineGroup() {
		return donationMonthPayDeadlineGroup;
	}
	public void setDonationMonthPayDeadlineGroup(String donationMonthPayDeadlineGroup) {
		this.donationMonthPayDeadlineGroup = donationMonthPayDeadlineGroup;
	}
	
	@Override
	public String toString() {
		return "DonationMonthPay [donationMonthPayCode=" + donationMonthPayCode + ", donationCode=" + donationCode
				+ ", donationMonthPayYear=" + donationMonthPayYear + ", donationMonthPayMonth=" + donationMonthPayMonth
				+ ", donationMonthPayAmount=" + donationMonthPayAmount + ", donationMonthPayDeadlineGroup="
				+ donationMonthPayDeadlineGroup + "]";
	}
	
}
