package ks46team04.admin.dto;

import java.util.List;
import lombok.Data;

@Data
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
}
