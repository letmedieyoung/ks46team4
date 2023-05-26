package ks46team04.admin.dto;

public class Foundation {
	private String foundationCode;
	private String foundationName;
	private String foundationManager;
	private String foundationPhone;
	private String foundationZipcode;
	private String foundationAddr;
	private String foundationExtraAddr;
	private String foundationDetailAddr;
	private String foundationRegId;
	private String foundationRegDate;
	private String foundationUpdId;
	private String foundationUpdDate;
	private String foundationIsDelete;
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
	public String getFoundationZipcode() {
		return foundationZipcode;
	}
	public void setFoundationZipcode(String foundationZipcode) {
		this.foundationZipcode = foundationZipcode;
	}
	public String getFoundationAddr() {
		return foundationAddr;
	}
	public void setFoundationAddr(String foundationAddr) {
		this.foundationAddr = foundationAddr;
	}
	public String getFoundationExtraAddr() {
		return foundationExtraAddr;
	}
	public void setFoundationExtraAddr(String foundationExtraAddr) {
		this.foundationExtraAddr = foundationExtraAddr;
	}
	public String getFoundationDetailAddr() {
		return foundationDetailAddr;
	}
	public void setFoundationDetailAddr(String foundationDetailAddr) {
		this.foundationDetailAddr = foundationDetailAddr;
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
	public String getFoundationIsDelete() {
		return foundationIsDelete;
	}
	public void setFoundationIsDelete(String foundationIsDelete) {
		this.foundationIsDelete = foundationIsDelete;
	}
	@Override
	public String toString() {
		return "Foundation [foundationCode=" + foundationCode + ", foundationName=" + foundationName
				+ ", foundationManager=" + foundationManager + ", foundationPhone=" + foundationPhone
				+ ", foundationZipcode=" + foundationZipcode + ", foundationAddr=" + foundationAddr
				+ ", foundationExtraAddr=" + foundationExtraAddr + ", foundationDetailAddr=" + foundationDetailAddr
				+ ", foundationRegId=" + foundationRegId + ", foundationRegDate=" + foundationRegDate
				+ ", foundationUpdId=" + foundationUpdId + ", foundationUpdDate=" + foundationUpdDate
				+ ", foundationIsDelete=" + foundationIsDelete + "]";
	}
}
