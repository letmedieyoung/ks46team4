package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.constant.DeadlineCheck;
import ks46team04.admin.dto.UnionDonaFund;
import ks46team04.admin.mapper.SaleMapper;

@Service
@Transactional
public class SaleService {

	
	private static final Logger log = LoggerFactory.getLogger(SaleService.class);
	
	private final SaleMapper saleMapper;
	public SaleService(SaleMapper saleMapper) {
		this.saleMapper = saleMapper;
	}
	
	public List<UnionDonaFund> getTotalSaleList(){
		List<UnionDonaFund> totalSaleList = saleMapper.getTotalSaleList();
		//DeadlineCheck[] check = DeadlineCheck.values();
		//log.info("enum 배열 check1: {}", check[0].CLOSED.getCheck());
		log.info("enum 배열 check2: {}", DeadlineCheck.BEFORE_DEADLINE.getCheck());
		
		for(UnionDonaFund totalSale : totalSaleList) {
			String deadlineCheck = totalSale.getDeadlineCheck();
			log.info("deadlineCheck: {}", deadlineCheck);
			if(deadlineCheck.equals(DeadlineCheck.BEFORE_DEADLINE.getCheck())) {
				totalSale.setDeadlineCheck(DeadlineCheck.BEFORE_DEADLINE.getReplace());
			}else if(deadlineCheck.equals(DeadlineCheck.CLOSED.getCheck())) {
				totalSale.setDeadlineCheck(DeadlineCheck.CLOSED.getReplace());
			}else if(deadlineCheck.equals(DeadlineCheck.WAITING.getCheck())) {
				totalSale.setDeadlineCheck(DeadlineCheck.WAITING.getReplace());
			}
		}
		
		
		return totalSaleList;
	}
}
