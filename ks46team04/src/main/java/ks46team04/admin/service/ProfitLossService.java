package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.controller.ProfitLossController;
import ks46team04.admin.dto.ProfitLoss;
import ks46team04.admin.dto.TotalPurchaseSale;
import ks46team04.admin.mapper.ProfitLossMapper;

@Service
@Transactional
public class ProfitLossService {

private static final Logger log = LoggerFactory.getLogger(ProfitLossController.class);
	
	private final ProfitLossMapper profitLossMapper;
	public ProfitLossService(ProfitLossMapper profitLossMapper) {
		this.profitLossMapper = profitLossMapper;
	}
	
	public List<TotalPurchaseSale> getTotalPurchaseSale() {
		List<TotalPurchaseSale> totalPurchaseSale = profitLossMapper.getTotalPurchaseSale();
		log.info("totalPurchaseSale: {}", totalPurchaseSale);
		return totalPurchaseSale;
	}
	
	public List<ProfitLoss> getProfitLoss(){
		List<ProfitLoss> profitLoss = profitLossMapper.getProfitLoss();
		return profitLoss;
	}
}
