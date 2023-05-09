package ks46team04.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingCurrentAmount;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.dto.Goods;

@Mapper
public interface FundingMapper {
	// 펀딩 등록	
	public int registFunding(Funding funding);	
	
	// 펀딩 수정 - 진행상태 
	public List<Funding> getFundingProgressList();		
	// 펀딩 수정 - 재단명 조회
	public List<Foundation> getFoundationNameList();	
	// 펀딩 수정 - 상품명 조회
	public List<Goods> getGoodsNameList();	
	// 펀딩 수정 - 상품코드 조회
	public List<Goods> getGoodsCodeList();	
	// 펀딩 정보 수정
	public int modifyFunding(Funding funding);
	// 특정 펀딩 조회
	public Funding getFundingInfoByCode(String fundingCode);
	// 펀딩 정보 조회
	public List<Funding> getFundingList(List<Map<String, Object>> searchList);		
	
	// 펀딩 삭제
	public int deleteFunding(String fundingCode);	
	
	// 결제내역 상세 정보 확인
	public int detailFundingPay(FundingPay fundingPay);
	// 특정 펀딩 결제내역 조회
	public FundingPay getFundingPayInfoByCode(String fundingPayCode);
	// 펀딩 결제내역 조회
	public List<FundingPay> getFundingPayList();
	
	// 환불내역 수정 - 진행상태 
	public List<FundingRefund> getRefundStatusList();
	// 환불내역 수정
	public int modifyFundingRefund(FundingRefund fundingRefund);
	// 특정 펀딩 환불내역 조회
	public FundingRefund getFundingRefundInfoByCode(String fundingRefundCode);
	// 체크박스 선택된 펀딩 환불 처리	
	public int updateFundingRefundStatus(@Param("fundingRefundCode") String fundingCode, @Param("refundStatus") String refundStatus);
	// 펀딩 환불내역 조회
	public List<FundingRefund> getRefundList(List<Map<String, Object>> searchList);
   
	// 펀딩 진행상황 - 진행 펀딩 현재 모금 합계액
	public int sumOfCurrentAmount();
	// 펀딩 진행상황 - 진행 펀딩 총 목표 금액
	public int getTargetSum();
	// 펀딩 진행상황 - 진행 펀딩 전체 달성률
	public int allAccomplishmentRate();
	// 펀딩 진행상황 - 개별 펀딩 달성률
	public String accomplishmentRate();
	public List<FundingCurrentAmount> getFundingProgressStatus(String searchKey, String searchValue);
	
}
