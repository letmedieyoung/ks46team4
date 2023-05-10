package ks46team04.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.mapper.FundingDetailMapper;
import ks46team04.admin.mapper.FundingMapper;

@Service
public class FundingDetailService {
	
	@Autowired
	private FundingDetailMapper fundingDetailMapper;
	private FundingMapper fundingMapper;
	
	public FundingDetailService(FundingDetailMapper fundingDetailMapper, FundingMapper fundingMapper) {
		this.fundingDetailMapper = fundingDetailMapper;
		this.fundingMapper = fundingMapper;
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

	/**
	 * 펀딩 달성률
	 * @param accomplishmentRate
	 * @return
	 */	
    public String accomplishmentRate() {
    	return fundingMapper.accomplishmentRate();
    }
//	public FundingProduct FundingCode(String fundingCode) {
//        return fundingProductMapper.fundingCode(fundingCode);
//    }
}
