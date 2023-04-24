package ks46team04.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.UnionDonaFund;
import ks46team04.admin.mapper.SaleMapper;

@Service
@Transactional
public class SaleService {

	private final SaleMapper saleMapper;
	public SaleService(SaleMapper saleMapper) {
		this.saleMapper = saleMapper;
	}
	
	public List<UnionDonaFund> getTotalSaleList(){
		List<UnionDonaFund> totalSaleList = saleMapper.getTotalSaleList();
		
		return totalSaleList;
	}
}
