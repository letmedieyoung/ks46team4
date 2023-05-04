package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.dto.Goods;
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
	 * 펀딩 삭제
	 * @param valueArr
	 */
	public void deleteFunding(List<String> valueArr) {
		for(int i=0; i<valueArr.size(); i++) {
			fundingMapper.deleteFunding(valueArr.get(i));
		}
	  }
	
	/**
	 * 펀딩 수정 처리
	 * @param funding
	 */
	public void modifyFunding(Funding funding) {
		fundingMapper.modifyFunding(funding);
	}
	/**
	 * 펀딩 수정화면 - 진행상태 불러오기
	 * @return List<Fuding>
	 */
	public List<Funding> getFundingProgressList(){
		List<Funding> fundingProgressList = fundingMapper.getFundingProgressList();
		return fundingProgressList;
	}	
	/**
	 * 펀딩 수정화면 - 상품명 불러오기
	 * @return List<GoodsName>
	 */
	public List<Goods> getGoodsNameList(){
		List<Goods> goodsNameList = fundingMapper.getGoodsNameList();
		return goodsNameList;
	}
	/**
	 * 펀딩 수정화면 - 상품코드 불러오기
	 * @return List<GoodsName>
	 */
	public List<Goods> getGoodsCodeList(){
		List<Goods> goodsCodeList = fundingMapper.getGoodsCodeList();
		return goodsCodeList;
	}	
	/**
	 * 펀딩 수정화면 - 재단명 불러오기
	 * @return List<Foundation>
	 */
	public List<Foundation> getFoundationNameList(){
		List<Foundation> foundationNameList = fundingMapper.getFoundationNameList();
		return foundationNameList;
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
	 * 펀딩 전체 목록 조회
	 * @param fundingCode
	 * @return
	 */	
	 public List<Funding> getFundingList(){        
		 return fundingMapper.getFundingList(null);
	 }		

	/**
	 * 신규 펀딩 등록
	 * @param funding
	 * @return
	 */
	public int registFunding(Funding funding) {
		int result = fundingMapper.registFunding(funding);
		return result;
	}
	
	/**
	 * 펀딩 진행상황 - 진행 중 펀딩 현재 모금액의 합계
	 * @param currentSum
	 * @return
	 */	
    public int currentSum() {
    	return fundingMapper.sumOfCurrentAmount();
    }
	/**
	 * 펀딩 진행상황 - 진행 중 펀딩 목표액의 합계
	 * @param targetSum
	 * @return
	 */	
    public int getTargetAmount() {
    	return fundingMapper.getTargetSum();
    }
	

	
	
	/**
	 * 펀딩 결제내역 상세 정보
	 * @param fundingPay
	 */
	public void detailFundingPay(FundingPay fundingpay) {
		fundingMapper.detailFundingPay(fundingpay);
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
	
	/**
	 * 환불내역 수정 처리
	 * @param fundingRefund
	 */
	public void modifyFundingRefund(FundingRefund fundingRefund) {
		fundingMapper.modifyFundingRefund(fundingRefund);
	}	
	/**
	 * 펀딩 수정화면 - 진행상태 불러오기
	 * @return List<RefundStatus>
	 */
	public List<FundingRefund> getRefundStatusList(){
		List<FundingRefund> refundStatusList = fundingMapper.getRefundStatusList();
		return refundStatusList;
	}	
	/**
	 * 특정 펀딩 환불내역 조회
	 * @param fundingRefundCode
	 * @return
	 */
	public FundingRefund getFundingRefundInfoByCode(String fundingRefundCode) {
		FundingRefund fundingRefundInfo = fundingMapper.getFundingRefundInfoByCode(fundingRefundCode);
		log.info("fundingRefundInfo: {}", fundingRefundCode);
		return fundingRefundInfo;
	}
	/**
	 * 버튼으로 환불 처리
	 * @param refundArr
	 */
	public void updateFundingRefundStatus(List<String> refundArr) {
	    for (String value : refundArr) {
	        fundingMapper.updateFundingRefundStatus(value, "환불완료");
	    }
	}

	//펀딩 환불내역 조회
	public List<FundingRefund> getRefundList(){
		List<FundingRefund> refundList = fundingMapper.getRefundList();		
		return refundList;
	}
	
	
	//펀딩 진행현황 - 목표 금액 합계 조회
	//public int getFundingGoalAmountSum() {
	//       return fundingMapper.getFundingGoalAmountSum();
	//}

	
	
	
}
