package ks46team04.admin.dto;

public class UnionDonaFund {
	//펀딩과 도네이션 payment 유니온 데이터를 위한 DTO
	// admin/purchase_sale/sales_list 에서 사용
	
	private String userId;
	private String subscriptionCode;
	private int paymentAmount;
	private String paymentDate;
	private boolean refundRequested;
	private String deadlineCheck;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubscriptionCode() {
		return subscriptionCode;
	}
	public void setSubscriptionCode(String subscriptionCode) {
		this.subscriptionCode = subscriptionCode;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public boolean isRefundRequested() {
		return refundRequested;
	}
	public void setRefundRequested(boolean refundRequested) {
		this.refundRequested = refundRequested;
	}
	public String getDeadlineCheck() {
		return deadlineCheck;
	}
	public void setDeadlineCheck(String deadlineCheck) {
		this.deadlineCheck = deadlineCheck;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnionDF [userId=");
		builder.append(userId);
		builder.append(", subscriptionCode=");
		builder.append(subscriptionCode);
		builder.append(", paymentAmount=");
		builder.append(paymentAmount);
		builder.append(", paymentDate=");
		builder.append(paymentDate);
		builder.append(", refundRequested=");
		builder.append(refundRequested);
		builder.append(", deadlineCheck=");
		builder.append(deadlineCheck);
		builder.append("]");
		return builder.toString();
	}

}
