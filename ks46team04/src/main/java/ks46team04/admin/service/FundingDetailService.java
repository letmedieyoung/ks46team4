package ks46team04.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.mapper.FundingDetailMapper;

@Service
public class FundingDetailService {
	
	@Autowired
	private FundingDetailMapper fundingDetailMapper;
	
	public FundingDetailService(FundingDetailMapper fundingDetailMapper) {
		this.fundingDetailMapper = fundingDetailMapper;
	}
	
	/**
	 * 메인페이지 진행중 펀딩 진열
	 * @return
	 */
	public List<FundingDetail> getFundingMainList() {
		List<FundingDetail> fundingMainList = fundingDetailMapper.getFundingMainList();
		return fundingMainList;
	}
	
	/**
	 * 메인페이지 완료 펀딩 진열
	 * @return
	 */
	public List<FundingDetail> getFundingCompleteList() {
		List<FundingDetail> fundingCompleteList = fundingDetailMapper.getFundingCompleteList();
		return fundingCompleteList;
	}
	/**
	 * 펀딩 진열
	 * @return
	 */
	public List<FundingDetail> getFundingDetailList() {
		List<FundingDetail> fundingDetailList = fundingDetailMapper.getFundingDetailList();
		return fundingDetailList;
	}
	
	/**
	 * 펀딩 상세페이지 연결
	 * @param fundingCode
	 * @return
	 */
	public FundingDetail getFundingDetailByCode(String fundingCode) {
		FundingDetail fundingDetail = fundingDetailMapper.getFundingDetailByCode(fundingCode);
		return fundingDetail;
	}

//	public FundingProduct FundingCode(String fundingCode) {
//        return fundingProductMapper.fundingCode(fundingCode);
//    }
}
