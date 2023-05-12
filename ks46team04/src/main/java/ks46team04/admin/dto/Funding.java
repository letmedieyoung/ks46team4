package ks46team04.admin.dto;

import java.util.List;
import lombok.Data;

@Data
public class Funding {
	private String fundingCode;
	private String fundingName;
	private String fundingSummary;
	private String fundingDescription;
	private String foundationName;
	private String goodsCode;
	private int fundingGoalAmount;
	private String fundingStartDate;
	private String fundingEndDate;
	private String fundingProgress;
	private String fundingRegId;
	private String fundingRegDate;
	private String fundingUpdateId;
	private String fundingUpdateDate;
	private String goodsName;
	private int accomplishmentRate;	
	
	private List<Funding> fundingList;
}
