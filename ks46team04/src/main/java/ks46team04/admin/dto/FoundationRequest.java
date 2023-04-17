package ks46team04.admin.dto;

public class FoundationRequest {
	private String foundationRequestCode;
	private String foundationName;
	private String foundationManager;
	private String foundationPhone;
	private String foundationAddr;
	private String foundationRegId;
	private String foundationRegDate;
	private String foundationUpdateId;
	private String foundationUpdateDate;
	public String getFoundationRequestCode() {
		return foundationRequestCode;
	}
	public void setFoundationRequestCode(String foundationRequestCode) {
		this.foundationRequestCode = foundationRequestCode;
	}
	public String getFoundationName() {
		return foundationName;
	}
	public void setFoundationName(String foundationName) {
		this.foundationName = foundationName;
	}
	public String getFoundationManager() {
		return foundationManager;
	}
	public void setFoundationManager(String foundationManager) {
		this.foundationManager = foundationManager;
	}
	public String getFoundationPhone() {
		return foundationPhone;
	}
	public void setFoundationPhone(String foundationPhone) {
		this.foundationPhone = foundationPhone;
	}
	public String getFoundationAddr() {
		return foundationAddr;
	}
	public void setFoundationAddr(String foundationAddr) {
		this.foundationAddr = foundationAddr;
	}
	public String getFoundationRegId() {
		return foundationRegId;
	}
	public void setFoundationRegId(String foundationRegId) {
		this.foundationRegId = foundationRegId;
	}
	public String getFoundationRegDate() {
		return foundationRegDate;
	}
	public void setFoundationRegDate(String foundationRegDate) {
		this.foundationRegDate = foundationRegDate;
	}
	public String getFoundationUpdateId() {
		return foundationUpdateId;
	}
	public void setFoundationUpdateId(String foundationUpdateId) {
		this.foundationUpdateId = foundationUpdateId;
	}
	public String getFoundationUpdateDate() {
		return foundationUpdateDate;
	}
	public void setFoundationUpdateDate(String foundationUpdateDate) {
		this.foundationUpdateDate = foundationUpdateDate;
	}
	@Override
	public String toString() {
		return "FoundationRequest [foundationRequestCode=" + foundationRequestCode + ", foundationName="
				+ foundationName + ", foundationManager=" + foundationManager + ", foundationPhone=" + foundationPhone
				+ ", foundationAddr=" + foundationAddr + ", foundationRegId=" + foundationRegId + ", foundationRegDate="
				+ foundationRegDate + ", foundationUpdateId=" + foundationUpdateId + ", foundationUpdateDate="
				+ foundationUpdateDate + "]";
	}
	
}
