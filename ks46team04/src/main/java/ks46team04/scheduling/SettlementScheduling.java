package ks46team04.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ks46team04.admin.service.SaleService;

@Component
public class SettlementScheduling {

	private final SaleService saleService;
	
	public SettlementScheduling(SaleService saleService) {
		this.saleService = saleService;
	}
	
	private static final Logger log = LoggerFactory.getLogger(SettlementScheduling.class);

	
	//@Scheduled(cron = "0 0 0 1 * ?")
	public void settlementProcess() {
		log.info("3초마다 실행");
	}
}
