package ks46team04.admin.dto;

public class Vat {
	private String vatCode;		
	private String vatRatio;
	private String vatRegId;		
	private String vatRegDate;		
	private String vatUpdateId;		
	private String vatUpdateDate;
	
	
	public String getVatCode() {
		return vatCode;
	}
	public void setVatCode(String vatCode) {
		this.vatCode = vatCode;
	}
	public String getVatRatio() {
		return vatRatio;
	}
	public void setVatRatio(String vatRatio) {
		this.vatRatio = vatRatio;
	}
	public String getVatRegId() {
		return vatRegId;
	}
	public void setVatRegId(String vatRegId) {
		this.vatRegId = vatRegId;
	}
	public String getVatRegDate() {
		return vatRegDate;
	}
	public void setVatRegDate(String vatRegDate) {
		this.vatRegDate = vatRegDate;
	}
	public String getVatUpdateId() {
		return vatUpdateId;
	}
	public void setVatUpdateId(String vatUpdateId) {
		this.vatUpdateId = vatUpdateId;
	}
	public String getVatUpdateDate() {
		return vatUpdateDate;
	}
	public void setVatUpdateDate(String vatUpdateDate) {
		this.vatUpdateDate = vatUpdateDate;
	}
	
	@Override
	public String toString() {
		return "Vat [vatCode=" + vatCode + ", vatRatio=" + vatRatio + ", vatRegId=" + vatRegId + ", vatRegDate="
				+ vatRegDate + ", vatUpdateId=" + vatUpdateId + ", vatUpdateDate=" + vatUpdateDate + "]";
	}	
	
	
}
