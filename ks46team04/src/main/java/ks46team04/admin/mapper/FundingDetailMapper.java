package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ks46team04.admin.dto.FundingDetail;

@Mapper
public interface FundingDetailMapper {

	// 메인페이지 진행중 펀딩 진열
	public List<FundingDetail> getFundingMainList();
	// 메인페이지 종료 펀딩 진열
	public List<FundingDetail> getFundingCompleteList();
	// 펀딩 진열 목록
	public List<FundingDetail> getFundingDetailList();
	// 펀딩 상세페이지
    public FundingDetail getFundingDetailByCode(@Param("fundingCode") String fundingCode);

}
