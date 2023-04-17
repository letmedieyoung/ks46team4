package ks46team04.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.mapper.FundingMapper;

@Service
@Transactional
public class FundingService {
	
	private final FundingMapper fundingMapper;
		
	public FundingService(FundingMapper fundingMapper) {
		this.fundingMapper = fundingMapper;
	}	
			
	public List<Funding> getFundingList(){
		List<Funding> fundingList = fundingMapper.getFundingList();
		return fundingList;
	}
	
	
}
