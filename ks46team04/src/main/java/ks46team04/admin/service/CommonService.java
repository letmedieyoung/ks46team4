package ks46team04.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.mapper.FundingDetailMapper;

@Service
public class CommonService {
	
	@Autowired
	private final FundingDetailMapper fundingDetailMapper;
	
	public CommonService(FundingDetailMapper fundingDetailMapper) {
		this.fundingDetailMapper = fundingDetailMapper;
	}
	

	
	/**
	 * 펀딩 진열
	 * @return
	 */
	public List<FundingDetail> getFundingDetailList() {
		List<FundingDetail> fundingDetailList = fundingDetailMapper.getFundingDetailList();
		return fundingDetailList;
	}
}
