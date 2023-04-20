package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.mapper.FundingMapper;

@Service
@Transactional
public class FundingService {
	
	private static final Logger log = LoggerFactory.getLogger(FundingService.class);

	private final FundingMapper fundingMapper;
	
	public FundingService(FundingMapper fundingMapper) {
		this.fundingMapper = fundingMapper;
	}	
	
	/**
	 * 펀딩 정보 수정
	 * @param funding
	 */
	public void modifyFunding(Funding funding) {
		fundingMapper.modifyFunding(funding);
	}

	/**
	 * 특정 펀딩 정보 조회
	 * @param fundingCode
	 * @return
	 */
	public Funding getFundingInfoByCode(String fundingCode) {
		Funding fundingInfo = fundingMapper.getFundingInfoByCode(fundingCode);
		log.info("fundingInfo: {}", fundingCode);
		return fundingInfo;
	}
	
	//펀딩 목록 조회	
	public List<Funding> getFundingList(){
		List<Funding> fundingList = fundingMapper.getFundingList();
		return fundingList;
	}

	
	//펀딩 결제 내역 조회
	public List<FundingPay> getFundingPayList(){
		List<FundingPay> fundingPayList = fundingMapper.getFundingPayList();
		log.info("fundingPayList_Service: {}", fundingPayList);
		return fundingPayList;
	}
	
	//펀딩 환불 신청 내역 조회
	public List<FundingRefund> getFundingRefundList(){
		List<FundingRefund> refundList = fundingMapper.getRefundList();
		log.info("fundingRefundList_Service: {}", refundList);
		return refundList;
	}
}
