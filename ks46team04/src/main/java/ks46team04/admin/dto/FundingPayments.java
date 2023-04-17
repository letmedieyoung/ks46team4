package ks46team04.admin.dto;

import java.util.List;

public class FundingPayments {

	private String fundingPaymentCode;
	private String userId;
	private String fundingCode;
	private String pmCode;
	private String fundingPaymentDate;
	private String fundingPaymentAmount;
	private String salesCommission;
	private String purchaseBudget;
	private boolean fundingRefundRequest;
	private String fundingGroupCode;
	private String deadlineStatus;
	
	private List<FundingPayments> fundingPaymentsList;

	public String getFundingPaymentCode() {
		return fundingPaymentCode;
	}

	public void setFundingPaymentCode(String fundingPaymentCode) {
		this.fundingPaymentCode = fundingPaymentCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFundingCode() {
		return fundingCode;
	}

	public void setFundingCode(String fundingCode) {
		this.fundingCode = fundingCode;
	}

	public String getPmCode() {
		return pmCode;
	}

	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}

	public String getFundingPaymentDate() {
		return fundingPaymentDate;
	}

	public void setFundingPaymentDate(String fundingPaymentDate) {
		this.fundingPaymentDate = fundingPaymentDate;
	}

	public String getFundingPaymentAmount() {
		return fundingPaymentAmount;
	}

	public void setFundingPaymentAmount(String fundingPaymentAmount) {
		this.fundingPaymentAmount = fundingPaymentAmount;
	}

	public String getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(String salesCommission) {
		this.salesCommission = salesCommission;
	}

	public String getPurchaseBudget() {
		return purchaseBudget;
	}

	public void setPurchaseBudget(String purchaseBudget) {
		this.purchaseBudget = purchaseBudget;
	}

	public boolean isFundingRefundRequest() {
		return fundingRefundRequest;
	}

	public void setFundingRefundRequest(boolean fundingRefundRequest) {
		this.fundingRefundRequest = fundingRefundRequest;
	}

	public String getFundingGroupCode() {
		return fundingGroupCode;
	}

	public void setFundingGroupCode(String fundingGroupCode) {
		this.fundingGroupCode = fundingGroupCode;
	}

	public String getDeadlineStatus() {
		return deadlineStatus;
	}

	public void setDeadlineStatus(String deadlineStatus) {
		this.deadlineStatus = deadlineStatus;
	}

	public List<FundingPayments> getFundingPaymentsList() {
		return fundingPaymentsList;
	}

	public void setFundingPaymentsList(List<FundingPayments> fundingPaymentsList) {
		this.fundingPaymentsList = fundingPaymentsList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FundingPayments [fundingPaymentCode=");
		builder.append(fundingPaymentCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", fundingCode=");
		builder.append(fundingCode);
		builder.append(", pmCode=");
		builder.append(pmCode);
		builder.append(", fundingPaymentDate=");
		builder.append(fundingPaymentDate);
		builder.append(", fundingPaymentAmount=");
		builder.append(fundingPaymentAmount);
		builder.append(", salesCommission=");
		builder.append(salesCommission);
		builder.append(", purchaseBudget=");
		builder.append(purchaseBudget);
		builder.append(", fundingRefundRequest=");
		builder.append(fundingRefundRequest);
		builder.append(", fundingGroupCode=");
		builder.append(fundingGroupCode);
		builder.append(", deadlineStatus=");
		builder.append(deadlineStatus);
		builder.append(", fundingPaymentsList=");
		builder.append(fundingPaymentsList);
		builder.append("]");
		return builder.toString();
	}
}
