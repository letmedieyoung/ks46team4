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
	
	//--------------- 기본 조회 start
	public List<TotalPurchaseSale> getTotalPurchaseSale() {
		List<TotalPurchaseSale> totalPurchaseSale = profitLossMapper.getTotalPurchaseSale();
		log.info("totalPurchaseSale: {}", totalPurchaseSale);
		return totalPurchaseSale;
	}
	
	public List<ProfitLoss> getProfitLoss(){
		List<ProfitLoss> profitLoss = profitLossMapper.getProfitLoss();
		return profitLoss;
	}
	//--------------- 기본 조회 end
	
	//마감 완료 로직 ---------------
		//정기기부 건 마감 완료로 전환 ---------------
		//펀딩 건 마감 완료로 전환 ---------------
		//매입 건 마감 완료로 전환 ---------------

	
	//매입,매출 종합 삽입 ---------------
		/*
			1)
			123이 먼저 삽입
			펀딩, 기부 각각의 테이블에서 해당 년월의 매출 그룹 코드가 있는지 탐색
			있으면 매출 구분(4) 삽입 후 그룹코드(5) 삽입, 매출 구분(9) 삽입
			678 합산해서 삽입
				//마감 완료된 정기기부 금액 합산 및 삽입 ---------------
				//마감 완료된 펀딩 금액 합산 및 삽입 ---------------
				//마감 완료된 매입 금액 합산 및 삽입 ---------------
			
			2)
			그리고 매입 그룹 코드가 있는지 마찬가지로 탐색 후 삽입
			
			-- 1. 자동증가 PK
			-- 2. 기준 년도
			-- 3. 기준 월
			-- 4. 매입/매출 구분
			-- 5. 매입/매츨 구분 코드
			-- 6. 결제 금액
			-- 7. 매출 중 수수료
			-- 8. 매입예산
			-- 9. 매입/매출 모든 구분		
		*/
		
	
		
	//한달 재무 삽입 ---------------
		/*
			123 삽입
			total_purchse_sale 테이블의 payment_amount 칼럼 값 매출 구분으로 연산 후 삽입(4)
			payment_vat	합산 후 삽입(5)
			purchase_budget 합산 후 삽입(6)
			매입 구분으로 연산후 삽입(7) month_total_purchase
			(8) = (7)+(5)
			결산 확인 기본 FALSE
			확인일자 기본 null
			담당자 기본 null
			
		
			-- 1. 자동증가 PK
			-- 2. 기준 년도
			-- 3. 기준 월		
			-- 4. 월 총 매출액		
			-- 5. 월 수수료 합		
			-- 6. 월 매입예산 합		
			-- 7. 월 매입 합		
			-- 8. 월 손익(수수료제외)		
			-- 9. 월 최종 손익(수수료 포함)		
			-- 10. 결산 확인 여부		
			-- 11. 결산 확인 일자		
			-- 12. 결재 담당자 ID
		*/
	
	//재무 마감 ---------------
		/*
		 	마감이 담당자에 의해 완료되면 매입기록을 수정,삭제할 수 없고 (매출 기록을 삭제할 수 없음)
		 */
}
