package ks46team04.admin.dto;

public class PaymentCode {
	private String PaymentCode;

	public String getPaymentCode() {
		return PaymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		PaymentCode = paymentCode;
	}

	@Override
	public String toString() {
		return "PaymentCode [PaymentCode=" + PaymentCode + "]";
	}

}
