package ks46team04.admin.dto;

public class Foundation {
	private String listNo;
	private String foundationCode;
	private String foundationName;
	private String foundationManager;
	private String foundationPhone;
	private String foundationAddr;
	private String foundationRegId;
	private String foundationRegDate;
	private String foundationUpdId;
	private String foundationUpdDate;
	
	public String getListNo() {
		return listNo;
	}
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
	public String getFoundationCode() {
		return foundationCode;
	}
	public void setFoundationCode(String foundationCode) {
		this.foundationCode = foundationCode;
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
	public String getFoundationUpdId() {
		return foundationUpdId;
	}
	public void setFoundationUpdId(String foundationUpdId) {
		this.foundationUpdId = foundationUpdId;
	}
	public String getFoundationUpdDate() {
		return foundationUpdDate;
	}
	public void setFoundationUpdDate(String foundationUpdDate) {
		this.foundationUpdDate = foundationUpdDate;
	}
	@Override
	public String toString() {
		return "Foundation [listNo=" + listNo + ", foundationCode=" + foundationCode + ", foundationName="
				+ foundationName + ", foundationManager=" + foundationManager + ", foundationPhone=" + foundationPhone
				+ ", foundationAddr=" + foundationAddr + ", foundationRegId=" + foundationRegId + ", foundationRegDate="
				+ foundationRegDate + ", foundationUpdId=" + foundationUpdId + ", foundationUpdDate="
				+ foundationUpdDate + "]";
	}
}
