package ks46team04.admin.dto;

import java.util.List;

import lombok.Data;

@Data
public class FundingCurrentAmount {
	private String fundingCurrentAmountCode;
	private String fundingCode;
	private String fundingName;
	private String foundationName;
	private int fundingGoalAmount;
	private int currentAchievedAmount;
	private int fundingLackAmount;
	private String fundingProgress;
	private int targetSum;
	private int currentSum;
	private int achievedRate;
	
	private List<FundingCurrentAmount> fundingCurrentAmountList;
}
