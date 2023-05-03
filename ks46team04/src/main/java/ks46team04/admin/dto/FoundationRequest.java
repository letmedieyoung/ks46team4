package ks46team04.admin.dto;

public class FoundationRequest {
	private String foundationRequestCode;
	private String foundationCode;
	private String foundationName;
	private String contentCategory;
	private String requestGoodsName;
	private String initialGoodsAmount;
	private String finalGoodsAmount;
	private String deliveryRequestDate;
	private String requestRegId;
	private String requestRegDate;
	private String requestUpdId;
	private String requestUpdDate;
	private String requestProgressStatus;
	public String getFoundationRequestCode() {
		return foundationRequestCode;
	}
	public void setFoundationRequestCode(String foundationRequestCode) {
		this.foundationRequestCode = foundationRequestCode;
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
	public String getContentCategory() {
		return contentCategory;
	}
	public void setContentCategory(String contentCategory) {
		this.contentCategory = contentCategory;
	}
	public String getRequestGoodsName() {
		return requestGoodsName;
	}
	public void setRequestGoodsName(String requestGoodsName) {
		this.requestGoodsName = requestGoodsName;
	}
	public String getInitialGoodsAmount() {
		return initialGoodsAmount;
	}
	public void setInitialGoodsAmount(String initialGoodsAmount) {
		this.initialGoodsAmount = initialGoodsAmount;
	}
	public String getFinalGoodsAmount() {
		return finalGoodsAmount;
	}
	public void setFinalGoodsAmount(String finalGoodsAmount) {
		this.finalGoodsAmount = finalGoodsAmount;
	}
	public String getDeliveryRequestDate() {
		return deliveryRequestDate;
	}
	public void setDeliveryRequestDate(String deliveryRequestDate) {
		this.deliveryRequestDate = deliveryRequestDate;
	}
	public String getRequestRegId() {
		return requestRegId;
	}
	public void setRequestRegId(String requestRegId) {
		this.requestRegId = requestRegId;
	}
	public String getRequestRegDate() {
		return requestRegDate;
	}
	public void setRequestRegDate(String requestRegDate) {
		this.requestRegDate = requestRegDate;
	}
	public String getRequestUpdId() {
		return requestUpdId;
	}
	public void setRequestUpdId(String requestUpdId) {
		this.requestUpdId = requestUpdId;
	}
	public String getRequestUpdDate() {
		return requestUpdDate;
	}
	public void setRequestUpdDate(String requestUpdDate) {
		this.requestUpdDate = requestUpdDate;
	}
	public String getRequestProgressStatus() {
		return requestProgressStatus;
	}
	public void setRequestProgressStatus(String requestProgressStatus) {
		this.requestProgressStatus = requestProgressStatus;
	}
	@Override
	public String toString() {
		return "FoundationRequest [foundationRequestCode=" + foundationRequestCode + ", foundationCode="
				+ foundationCode + ", foundationName=" + foundationName + ", contentCategory=" + contentCategory
				+ ", requestGoodsName=" + requestGoodsName + ", initialGoodsAmount=" + initialGoodsAmount
				+ ", finalGoodsAmount=" + finalGoodsAmount + ", deliveryRequestDate=" + deliveryRequestDate
				+ ", requestRegId=" + requestRegId + ", requestRegDate=" + requestRegDate + ", requestUpdId="
				+ requestUpdId + ", requestUpdDate=" + requestUpdDate + ", requestProgressStatus="
				+ requestProgressStatus + "]";
	}
	
}
