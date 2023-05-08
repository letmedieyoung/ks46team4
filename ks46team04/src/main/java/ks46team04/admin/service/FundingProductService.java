package ks46team04.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks46team04.admin.dto.FundingProduct;
import ks46team04.admin.mapper.FundingProductMapper;

@Service
public class FundingProductService {
	
	@Autowired
	private FundingProductMapper fundingProductMapper;

	public List<FundingProduct> listFundingProduct() {
		return fundingProductMapper.listFundingProduct();
	}
	
	public FundingProduct detailFunding(String fundingCode) {
		return fundingProductMapper.detailFunding(fundingCode);
	}

}
