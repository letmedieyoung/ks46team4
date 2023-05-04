package ks46team04.admin.dto;

public class Payment {
	private String paymentCode;
	private String paymentName;
	private String paymentCompany;
	
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public String getPaymentCompany() {
		return paymentCompany;
	}
	public void setPaymentCompany(String paymentCompany) {
		this.paymentCompany = paymentCompany;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentCode=" + paymentCode + ", paymentName=" + paymentName + ", paymentCompany="
				+ paymentCompany + "]";
	}
}
