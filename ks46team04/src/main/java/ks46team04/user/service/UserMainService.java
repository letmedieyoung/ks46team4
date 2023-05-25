package ks46team04.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.DonationPayMethod;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingCurrentAmount;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.dto.Goods;
import ks46team04.admin.mapper.DonationMapper;
import ks46team04.admin.mapper.FundingMapper;

@Service
@Transactional
public class UserMainService {

	private static final Logger log = LoggerFactory.getLogger(UserMainService.class);

	@Autowired
	private final FundingMapper fundingMapper;
	private final DonationMapper donationMapper;

	public UserMainService(FundingMapper fundingMapper, DonationMapper donationMapper) {
		this.fundingMapper = fundingMapper;
		this.donationMapper = donationMapper;
	}
	
	
	//정기기부 등록된 회원 결제수단 조회
	 
	public List<DonationPayMethod> getDonationPayMethodByUserId(String userId){
		
		List<DonationPayMethod> getDonationPayMethod = donationMapper.getDonationPayMethodByUserId(userId);
		
		return getDonationPayMethod;
	}
	
	
	//정기기부 구독 내역 조회
	public List<DonationSub> getDonationSubByUserId(String userId){
		List<DonationSub> getDonationSub = donationMapper.getDonationSubByUserId(userId);
		
		return getDonationSub;
	}

	

	// 펀딩 결제 내역 조회
	public List<FundingPay> getFundingPayListByUserId(String userId) {
		List<FundingPay> fundingPayList = fundingMapper.getFundingPayListByUserId(userId);
		log.info("fundingPayList_Service: {}", fundingPayList);
		return fundingPayList;
	}

	/*	
		*//**
			 * 환불내역 수정 처리
			 * 
			 * @param fundingRefund
			 */
	/*
	 * public void modifyFundingRefund(FundingRefund fundingRefund) {
	 * fundingMapper.modifyFundingRefund(fundingRefund); }
	 *//**
		 * 환불내역 수정화면 - 진행상태 불러오기
		 * 
		 * @return List<RefundStatus>
		 */
	/*
	 * public List<FundingRefund> getRefundStatusList(){ List<FundingRefund>
	 * refundStatusList = fundingMapper.getRefundStatusList(); return
	 * refundStatusList; }
	 *//**
		 * 특정 펀딩 환불내역 조회
		 * 
		 * @param fundingRefundCode
		 * @return
		 *//*
			 * public FundingRefund getFundingRefundInfoByCode(String fundingRefundCode) {
			 * FundingRefund fundingRefundInfo =
			 * fundingMapper.getFundingRefundInfoByCode(fundingRefundCode);
			 * log.info("fundingRefundInfo: {}", fundingRefundCode); return
			 * fundingRefundInfo; }
			 * 
			 * 
			 * // 펀딩 환불내역 조회 서비스 (검색 기능 추가) public List<FundingRefund> getRefundList() {
			 * return fundingMapper.getRefundList(null); }
			 * 
			 */

}
