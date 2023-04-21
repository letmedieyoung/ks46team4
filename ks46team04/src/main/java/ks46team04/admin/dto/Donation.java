package ks46team04.admin.dto;

public class Donation {
	private String donationCode;
	private String donationName;
	private String donationPrice;
	private String donationDescription;
	private String donationRegId;
	private String donationRegDate;
	private String donationUpdateId;
	private String donationUpdateDate;
	
	public String getDonationCode() {
		return donationCode;
	}
	public void setDonationCode(String donationCode) {
		this.donationCode = donationCode;
	}
	public String getDonationName() {
		return donationName;
	}
	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}
	public String getDonationPrice() {
		return donationPrice;
	}
	public void setDonationPrice(String donationPrice) {
		this.donationPrice = donationPrice;
	}
	public String getDonationDescription() {
		return donationDescription;
	}
	public void setDonationDescription(String donationDescription) {
		this.donationDescription = donationDescription;
	}
	public String getDonationRegId() {
		return donationRegId;
	}
	public void setDonationRegId(String donationRegId) {
		this.donationRegId = donationRegId;
	}
	public String getDonationRegDate() {
		return donationRegDate;
	}
	public void setDonationRegDate(String donationRegDate) {
		this.donationRegDate = donationRegDate;
	}
	public String getDonationUpdateId() {
		return donationUpdateId;
	}
	public void setDonationUpdateId(String donationUpdateId) {
		this.donationUpdateId = donationUpdateId;
	}
	public String getDonationUpdateDate() {
		return donationUpdateDate;
	}
	public void setDonationUpdateDate(String donationUpdateDate) {
		this.donationUpdateDate = donationUpdateDate;
	}
	
	@Override
	public String toString() {
		return "Donation [donationCode=" + donationCode + ", donationName=" + donationName + ", donationPrice="
				+ donationPrice + ", donationDescription=" + donationDescription + ", donationRegId=" + donationRegId
				+ ", donationRegDate=" + donationRegDate + ", donationUpdateId=" + donationUpdateId
				+ ", donationUpdateDate=" + donationUpdateDate + "]";
	}
	
}
