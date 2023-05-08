package ks46team04.admin.dto;

import lombok.Data;

@Data
public class FundingProduct {
    private String fundingCode;
    private String fundingName;
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
    private int targetSum;
    private int currentSum;
    
   
}
