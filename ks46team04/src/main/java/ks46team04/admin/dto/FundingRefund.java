package ks46team04.admin.dto;

import java.util.List;

import lombok.Data;

@Data
public class FundingRefund {
	private String fundingRefundCode;
	private String refundUserId;
	private String fundingPayCode;
	private String refundRequestDate;
	private String requestAmount;
	private String refundBank;
	private String refundAccount;
	private String requestReason;
	private String refundStatus;
	private String approvalDate;
	private String rejectionDate;	
	private String fundingPaymentDate;
	private String pmName;
	
	List<FundingRefund> refundList;
}
