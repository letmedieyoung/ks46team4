package ks46team04.admin.dto;

import java.util.List;
import lombok.Data;

@Data
public class FundingPay {

	private String fundingPayCode;
	private String userId;
	private String fundingCode;
	private String pmCode;
	private String pmName;
	private String fundingPaymentDate;
	private String fundingPaymentAmount;
	private String salesCommission;
	private String purchaseBudget;
	private boolean fundingRefundRequest;
	private String fundingGroupCode;
	private String deadlineStatus;
	
	private List<FundingPay> fundingPayList;

}