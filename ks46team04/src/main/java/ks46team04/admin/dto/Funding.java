package ks46team04.admin.dto;

import java.util.List;

public class Funding {
	private String fundingCode;
	private String fundingName;
	private String fundingDescription;
	private String fundingFoundation;
	private String goodsCode;
	private String fundingGoalAmount;
	private String fundingStartDate;
	private String fundingEndDate;
	private String fundingProgress;
	private String fundingRegId;
	private String fundingRegDate;
	private String fundingUpdateId;
	private String fundingUpdateDate;
	
	private List<Funding> fundingList;
	
	public String getFundingCode() {
		return fundingCode;
	}
	public void setFundingCode(String fundingCode) {
		this.fundingCode = fundingCode;
	}
	public String getFundingName() {
		return fundingName;
	}
	public void setFundingName(String fundingName) {
		this.fundingName = fundingName;
	}
	public String getFundingDescription() {
		return fundingDescription;
	}
	public void setFundingDescription(String fundingDescription) {
		this.fundingDescription = fundingDescription;
	}
	public String getFundingFoundation() {
		return fundingFoundation;
	}
	public void setFundingFoundation(String fundingFoundation) {
		this.fundingFoundation = fundingFoundation;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getFundingGoalAmount() {
		return fundingGoalAmount;
	}
	public void setFundingGoalAmount(String fundingGoalAmount) {
		this.fundingGoalAmount = fundingGoalAmount;
	}
	public String getFundingStartDate() {
		return fundingStartDate;
	}
	public void setFundingStartDate(String fundingStartDate) {
		this.fundingStartDate = fundingStartDate;
	}
	public String getFundingEndDate() {
		return fundingEndDate;
	}
	public void setFundingEndDate(String fundingEndDate) {
		this.fundingEndDate = fundingEndDate;
	}
	public String getFundingProgress() {
		return fundingProgress;
	}
	public void setFundingProgress(String fundingProgress) {
		this.fundingProgress = fundingProgress;
	}
	public String getFundingRegId() {
		return fundingRegId;
	}
	public void setFundingRegId(String fundingRegId) {
		this.fundingRegId = fundingRegId;
	}
	public String getFundingRegDate() {
		return fundingRegDate;
	}
	public void setFundingRegDate(String fundingRegDate) {
		this.fundingRegDate = fundingRegDate;
	}
	public String getFundingUpdateId() {
		return fundingUpdateId;
	}
	public void setFundingUpdateId(String fundingUpdateId) {
		this.fundingUpdateId = fundingUpdateId;
	}
	public String getFundingUpdateDate() {
		return fundingUpdateDate;
	}
	public void setFundingUpdateDate(String fundingUpdateDate) {
		this.fundingUpdateDate = fundingUpdateDate;
	}
	
	public List<Funding> getFundingList() {
		return fundingList;
	}
	public void setFundingList(List<Funding> fundingList) {
		this.fundingList = fundingList;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funding [fundingCode=");
		builder.append(fundingCode);
		builder.append(", fundingName=");
		builder.append(fundingName);
		builder.append(", fundingDescription=");
		builder.append(fundingDescription);
		builder.append(", fundingFoundation=");
		builder.append(fundingFoundation);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", fundingGoalAmount=");
		builder.append(fundingGoalAmount);
		builder.append(", fundingStartDate=");
		builder.append(fundingStartDate);
		builder.append(", fundingEndDate=");
		builder.append(fundingEndDate);
		builder.append(", fundingProgress=");
		builder.append(fundingProgress);
		builder.append(", fundingRegId=");
		builder.append(fundingRegId);
		builder.append(", fundingRegDate=");
		builder.append(fundingRegDate);
		builder.append(", fundingUpdateId=");
		builder.append(fundingUpdateId);
		builder.append(", fundingUpdateDate=");
		builder.append(fundingUpdateDate);
		builder.append(", fundingList=");
		builder.append(fundingList);
		builder.append("]");
		return builder.toString();
	}
}
