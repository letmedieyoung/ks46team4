package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingFoundation;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.dto.GoodsCode;
import ks46team04.admin.mapper.FundingMapper;

@Service
@Transactional
public class FundingService {
	
	private static final Logger log = LoggerFactory.getLogger(FundingService.class);
	
	@Autowired
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
		
	/**
	 * 펀딩 수정화면 - 상품코드 불러오기
	 * @return List<FudingFoundation>
	 */
	public List<GoodsCode> getGoodsCodeList(){
		List<GoodsCode> goodsCodeList = fundingMapper.getGoodsCodeList();
		return goodsCodeList;
	}	
	
	/**
	 * 펀딩 수정화면 - 재단명 불러오기
	 * @return List<FudingFoundation>
	 */
	public List<FundingFoundation> getFoundationNameList(){
		List<FundingFoundation> foundationNameList = fundingMapper.getFoundationNameList();
		return foundationNameList;
	}
	
	
	//펀딩 목록 조회	
	 public List<Funding> getFundingList(){        
		 return fundingMapper.getFundingList(null);
	 }	
	
	//펀딩 정보 삭제
	public void deleteFunding(Funding funding) {
		fundingMapper.deleteFunding(funding);
	}

	//펀딩 신규 등록
	public int registFunding(Funding funding) {
		int result = fundingMapper.registFunding(funding);
		return result;
	}
	

	/**
	 * 펀딩 결제내역 수정
	 * @param fundingPay
	 */
	public void modifyFundingPay(FundingPay fundingpay) {
		fundingMapper.modifyFundingPay(fundingpay);
	}
	/**
	 * 특정 펀딩 결제내역 조회
	 * @param fundingPayCode
	 * @return
	 */
	public FundingPay getFundingPayInfoByCode(String fundingPayCode) {
		FundingPay fundingPayInfo = fundingMapper.getFundingPayInfoByCode(fundingPayCode);
		return fundingPayInfo;
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
