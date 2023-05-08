package ks46team04.admin.dto;

import lombok.Data;

@Data
public class FundingDetail {
	private String fundingCode;
	private String fundingName;
	private String fundingFoundation;
	private int fundingGoalAmount;
	private String fundingStartDate;
	private String fundingEndDate;
	private String fundingProgress;
}
