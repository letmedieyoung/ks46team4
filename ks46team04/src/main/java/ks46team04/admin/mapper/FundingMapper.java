package ks46team04.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingFoundation;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.FundingRefund;
import ks46team04.admin.dto.GoodsCode;

@Mapper
public interface FundingMapper {
	// 펀딩 등록	
	public int registFunding(Funding funding);	
	// 펀딩 수정 - 재단명 조회
	public List<FundingFoundation> getFoundationNameList();	
	// 펀딩 수정 - 상품코드 조회
	public List<GoodsCode> getGoodsCodeList();	
	// 펀딩 정보 수정
	public int modifyFunding(Funding funding);
	// 펀딩 삭제
	public int deleteFunding(Funding funding);
	// 특정 펀딩 조회
	public Funding getFundingInfoByCode(String fundingCode);
	// 펀딩 정보 조회
	public List<Funding> getFundingList(List<Map<String, Object>> searchList);
	// 펀딩 결제내역 조회
	public List<FundingPay> getFundingPayList();
	// 펀딩 환불신청내역 조회
	public List<FundingRefund> getRefundList();
	

}
