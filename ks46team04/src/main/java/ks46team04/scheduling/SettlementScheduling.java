package ks46team04.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ks46team04.admin.service.ProfitLossService;

@Component
public class SettlementScheduling {

	private final ProfitLossService profitLossService;
	
	public SettlementScheduling(ProfitLossService profitLossService) {
		this.profitLossService = profitLossService;
	}
	
	private static final Logger log = LoggerFactory.getLogger(SettlementScheduling.class);

	
	//@Scheduled(cron = "0 0 0 4 * ?")		//정해진 마감일
	//@Scheduled(cron = "40 * * * * ?")		//마감 테스트 스케줄 - 매 분의 10초에 실행(1분 간격)
	//@Scheduled(cron = "*/10 0 0 0 * ?")	//마감 테스트 스케줄 - 10초마다 실행(10초 간격)
	
	//@Scheduled(cron = "40 * * * * ?")		//마감 테스트 스케줄 - 매 분의 10초에 실행(1분 간격)
	public void settlementProcess() throws Exception {
		log.info("매 분의 40초마다 실행(1분 간격)");
		//profitLossService.MonthProfitLossLogic();
	}
}
