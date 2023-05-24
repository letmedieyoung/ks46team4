package ks46team04.admin.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.controller.ProfitLossController;
import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.ProfitLoss;
import ks46team04.admin.dto.Purchase;
import ks46team04.admin.dto.TotalPurchaseSale;
import ks46team04.admin.mapper.CommonMapper;
import ks46team04.admin.mapper.ProfitLossMapper;

@Service
@Transactional
public class ProfitLossService {

private static final Logger log = LoggerFactory.getLogger(ProfitLossController.class);
	
	private final ProfitLossMapper profitLossMapper;
	private final CommonMapper commonMapper;
	public ProfitLossService(ProfitLossMapper profitLossMapper, CommonMapper commonMapper) {
		this.profitLossMapper = profitLossMapper;
		this.commonMapper = commonMapper;
	}
	
	//--------------- 기본 조회 start
	public List<TotalPurchaseSale> getTotalPurchaseSale() {
		List<TotalPurchaseSale> totalPurchaseSale = profitLossMapper.getTotalPurchaseSale();
		//log.info("totalPurchaseSale: {}", totalPurchaseSale);
		return totalPurchaseSale;
	}
	
	public List<ProfitLoss> getProfitLoss(){
		List<ProfitLoss> profitLoss = profitLossMapper.getProfitLoss();
		return profitLoss;
	}
	//--------------- 기본 조회 end
	
	
	//월 재무손익 과정 종합 메소드
	@Transactional(rollbackFor = {Exception.class})
	public void MonthProfitLossLogic() throws Exception {
		//직전 달 매입 매출 건 status '마감대기중'으로 변경
		setWaiting();
		//'마감대기중인' 매입,매출 건 종합 테이블에 삽입
		addTotalPurchaseSale();
		//종합 테이블 직전 달 데이터 정산 후 재무 삽입
		addProfitLoss();
	}
	
	
	//직전 달 매입 매출 건 status '마감대기중'으로 변경 ---------------
	@Transactional(rollbackFor = {Exception.class})
	public void setWaiting() throws Exception {
		/*
		 * int x = 1; 
		 * if(x == 1) { throw new Exception(); }
		 */
		
		/*테스트는 바로 직전 달을 마감하므로 이번달-1 해서 한달 뺀다*/
		//String status = DeadlineCheck.WAITING.getReplace();
		
		//이번 달 정기기부 건 마감대기중으로 전환 ---------------
		profitLossMapper.setWaiting("user_regular_donation_payment", "user_regular_donation_deadline_check", "regular_donation_sales_group", "donation");	
		//이번 달 펀딩 건 마감대기중으로 전환 ---------------
		profitLossMapper.setWaiting("funding_payments", "deadline_status", "funding_group_code", "funding");	
		//이번 달 매입 건 마감대기중으로 전환 ---------------		
		profitLossMapper.setWaiting("purchase_history", "user_purchse_deadlinde_check", "purchase_group_code", "purchase");
	
	}
	
	public void resetWaiting() {
		/*테스트는 바로 직전 달을 마감하므로 이번달-1 해서 한달 뺀다*/
		//이번 달 정기기부 건 마감대기중으로 전환 ---------------
		profitLossMapper.resetWaiting("user_regular_donation_payment", "user_regular_donation_deadline_check", "regular_donation_sales_group", "donation");
		//이번 달 펀딩 건 마감대기중으로 전환 ---------------
		profitLossMapper.resetWaiting("funding_payments", "deadline_status", "funding_group_code", "funding");
		//이번 달 매입 건 마감대기중으로 전환 ---------------
		profitLossMapper.resetWaiting("purchase_history", "user_purchse_deadlinde_check", "purchase_group_code", "purchase");
	}
	
	
	//'마감대기중인' 매입,매출 건 종합 테이블에 삽입 ---------------
	@Transactional(rollbackFor = {Exception.class})
	public void addTotalPurchaseSale() throws Exception{
		//오늘 날짜
		LocalDate today = LocalDate.now(); 
		LocalDate lastMonth = today.minusMonths(1);
        String yearMonth = lastMonth.format(DateTimeFormatter.ofPattern("yyMM"));
        log.info("오늘 연월 yearMonth: {}", yearMonth);

        int year = lastMonth.getYear();
        int month = lastMonth.getMonthValue();

        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);

        // 숫자 앞에 0이 붙은 경우 0 제거
        if (monthStr.startsWith("0")) { monthStr = monthStr.substring(1); }
       
        String tempGroup = "";
        int payAmount = 0;
        int payVat = 0;
        int payBudget = 0;
		
        List<DonationPayDetail> monthDonationPayList = profitLossMapper.monthDonationPayList(yearMonth);
        log.info("달 기부 기록1: {}", monthDonationPayList);
            
        List<FundingPay> monthFundingPayList = profitLossMapper.monthFundingPayList(yearMonth);
        log.info("달 펀딩 기록2: {}", monthFundingPayList);
      
        List<Purchase> monthPurchaseList = profitLossMapper.monthPurchaseList(yearMonth);  
        log.info("달 매입 기록3: {}", monthPurchaseList);
     
        
	//정기 기부 이전 달 기록 탐색 후 삽입
		if(monthDonationPayList != null && monthDonationPayList.size() > 0) {
			TotalPurchaseSale totalPurchaseSale1= new TotalPurchaseSale();
			log.info("매입매출 정보 담을 객체 totalPurchaseSale1: {}", totalPurchaseSale1);
	        
			String temp = commonMapper.getPrimaryKeyVerTwo("user_regular_donation_payment", "regular_donation_payment_code", "donation_payment");
			log.info("temp: {}", temp);
			
			//1. 자동증가 PK dto에 할당
			totalPurchaseSale1.setMonthDonationPayCode(commonMapper.getPrimaryKeyVerTwo("total_purchse_sale", "month_donation_payment_code", "month_donation_payment"));		
			log.info("1. 자동증가 PK dto에 할당 totalPurchaseSale: {}", totalPurchaseSale1);
			
			//2. 기준 년도
			totalPurchaseSale1.setPaymentYear(yearStr);
			//3. 기준 월
			totalPurchaseSale1.setPaymentMonth(monthStr);
			log.info("3. 기준 월 totalPurchaseSale: {}", totalPurchaseSale1);
			
			//4. 매출 구분
			totalPurchaseSale1.setPurchaseSalesType("sales");
			log.info("4. 매출 구분 totalPurchaseSale: {}", totalPurchaseSale1);
			
			
			for(DonationPayDetail donaPay : monthDonationPayList) {
				//매출 그룹 코드 저장 변수
				tempGroup = donaPay.getDonationPaySalesGroup();			
				
				//List의 678 합산해서 삽입
				payAmount += Integer.valueOf(donaPay.getDonationPayAmount());
		        payVat += Integer.valueOf(donaPay.getDonationPaySalesCommission());
		        payBudget += Integer.valueOf(donaPay.getDonationPayPurchaseBudget());
			}
			
			//5. 매출 그룹 코드
			totalPurchaseSale1.setSalesGroupCode(tempGroup);
			log.info("5. 매출 그룹 코드 totalPurchaseSale1: {}", totalPurchaseSale1);
			
			//6.
			totalPurchaseSale1.setPaymentAmount(payAmount);	
			
			//7.
			totalPurchaseSale1.setPaymentVat(payVat);
			
			//8.
			totalPurchaseSale1.setPurchaseBudget(payBudget);
			
			//9. 매출 모든 구분	
			totalPurchaseSale1.setDivision("기부매출");
			log.info("9. totalPurchaseSale1: {}", totalPurchaseSale1);
			
			log.info("달 기부 기록 삽입 totalPurchaseSale1: {}", totalPurchaseSale1);
			
			//insert donation
			profitLossMapper.addToTotal(totalPurchaseSale1);
			
		}
		
		
	//펀딩 이전 달 기록 탐색 후 삽입
		if(monthFundingPayList != null && monthFundingPayList.size() > 0) {
			TotalPurchaseSale totalPurchaseSale2= new TotalPurchaseSale();
			log.info("매입매출 정보 담을 객체 totalPurchaseSale2: {}", totalPurchaseSale2);
	        
			payAmount = 0;
			payVat = 0;
			payBudget = 0;
			tempGroup = "";
			
			//1. 자동증가 PK dto에 할당
			totalPurchaseSale2.setMonthDonationPayCode(commonMapper.getPrimaryKeyVerTwo("total_purchse_sale", "month_donation_payment_code", "month_donation_payment"));		
			log.info("2-1. 자동증가 PK dto에 할당 totalPurchaseSale: {}", totalPurchaseSale2);
					
			//2. 기준 년도
			totalPurchaseSale2.setPaymentYear(yearStr);
			//3. 기준 월
			totalPurchaseSale2.setPaymentMonth(monthStr);
			//4. 매출 구분
			totalPurchaseSale2.setPurchaseSalesType("sales");

			
			for(FundingPay fundPay : monthFundingPayList) {
				//매출 그룹 코드 저장 변수
				tempGroup = fundPay.getFundingGroupCode();
				
				
				//List의 678 합산해서 삽입
				payAmount += Integer.valueOf(fundPay.getFundingPaymentAmount());
		        payVat += Integer.valueOf(fundPay.getSalesCommission());
		        payBudget += Integer.valueOf(fundPay.getPurchaseBudget());
			}
			
			//5. 매출 그룹 코드
			totalPurchaseSale2.setSalesGroupCode(tempGroup);
			//6.
			totalPurchaseSale2.setPaymentAmount(payAmount);		
			//7.
			totalPurchaseSale2.setPaymentVat(payVat);
			//8.
			totalPurchaseSale2.setPurchaseBudget(payBudget);
			//9. 매출 모든 구분	
			totalPurchaseSale2.setDivision("펀딩매출");
			
			log.info("달 펀딩 기록 삽입 totalPurchaseSale2: {}", totalPurchaseSale2);
			//insert funding
			profitLossMapper.addToTotal(totalPurchaseSale2);
		}
		payAmount = 0;
		payVat = 0;
		payBudget = 0;
		tempGroup = "";
			
	//매입 이전 달 기록 탐색 후 삽입
		if(monthPurchaseList != null && monthPurchaseList.size() > 0) {
			TotalPurchaseSale totalPurchaseSale3= new TotalPurchaseSale();
			log.info("매입매출 정보 담을 객체 totalPurchaseSale3: {}", totalPurchaseSale3);
			
			for(Purchase purchasePay : monthPurchaseList) {
				totalPurchaseSale3.setMonthDonationPayCode(commonMapper.getPrimaryKeyVerTwo("total_purchse_sale", "month_donation_payment_code", "month_donation_payment"));		
				log.info("3-1. 자동증가 PK dto에 할당 totalPurchaseSale: {}", totalPurchaseSale3);
				//2. 기준 년도
				totalPurchaseSale3.setPaymentYear(yearStr);
				//3. 기준 월
				totalPurchaseSale3.setPaymentMonth(monthStr);
				//4. 매출 구분
				totalPurchaseSale3.setPurchaseSalesType("purchase");
				//5. 매출 그룹 코드
				totalPurchaseSale3.setSalesGroupCode(purchasePay.getPurchaseGroupCode());
				//6.
				totalPurchaseSale3.setPaymentAmount(purchasePay.getTotalPurchasePrice());		
				//7.
				totalPurchaseSale3.setPaymentVat(0);
				//8.
				totalPurchaseSale3.setPurchaseBudget(0);
				//9. 매출 모든 구분	
				totalPurchaseSale3.setDivision("영양제매입");
				
				log.info("달 매입 건별 삽입 totalPurchaseSale3: {}", totalPurchaseSale3);
				//insert funding
				profitLossMapper.addToTotal(totalPurchaseSale3);
			}
		}
		
		/*
		1)
		펀딩, 기부 각각의 테이블에서 해당 년월의 매출 그룹 코드가 있는지 탐색
		있으면 
		순차적으로 삽입
		678은 합산해서 삽입
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
	}
		
	//종합 테이블 직전 달 데이터 정산 후 재무 삽입 ---------------	
	@Transactional(rollbackFor = {Exception.class})
	public void addProfitLoss() throws Exception{
		//오늘 날짜
		LocalDate today = LocalDate.now(); 
		LocalDate lastMonth = today.minusMonths(1);
        String yearMonth = lastMonth.format(DateTimeFormatter.ofPattern("yyMM"));
        log.info("오늘 연월 yearMonth: {}", yearMonth);

        int year = lastMonth.getYear();
        int month = lastMonth.getMonthValue();

        String yearStr = String.valueOf(year);
        String monthStr = String.valueOf(month);

        // 숫자 앞에 0이 붙은 경우 0 제거
        if (monthStr.startsWith("0")) { monthStr = monthStr.substring(1); }
       
        ProfitLoss profitLoss = new ProfitLoss();
        int saleAmount = 0;
		int purchaseAmount = 0;
		int vatAmount = 0;
		int budgetAmount = 0;
		int profitLossNotVat = 0;
		int profitLossVat = 0;	//수수료 합산
        
        //1. 자동증가 PK
		profitLoss.setProfitLossCode(commonMapper.getPrimaryKeyVerTwo("profit_n_loss", "profit_n_loss_code", "profit_n_loss_code"));		
		log.info("자동증가 PK dto에 할당 profitLoss: {}", profitLoss);
		
		//2. 기준 년도
		profitLoss.setPaymentYear(yearStr);
		//3. 기준 월
		profitLoss.setPaymentMonth(monthStr);
		
		List<TotalPurchaseSale> totalByYearMonth = profitLossMapper.getTotalByYearMonth(yearStr, monthStr);
		log.info("해당 달 매입 매출 추출 totalByYearMonth: {}", totalByYearMonth);
		
		for(TotalPurchaseSale purchaseSaleByYearMonth : totalByYearMonth) {
			String type = purchaseSaleByYearMonth.getPurchaseSalesType();

			if(type.equals("sales")) {
				saleAmount += purchaseSaleByYearMonth.getPaymentAmount();
				
			}else if(type.equals("purchase")) {
				purchaseAmount += purchaseSaleByYearMonth.getPaymentAmount();
			}
			
			vatAmount += purchaseSaleByYearMonth.getPaymentVat();
			budgetAmount += purchaseSaleByYearMonth.getPurchaseBudget();
		}
		
		//4. 월 총 매출액 = 한달 매출액 합산
		profitLoss.setMonthTotalSales(saleAmount);	
		//5. 월 수수료 합	=> payment_vat 합산 후 삽입
		profitLoss.setMonthTotalVat(vatAmount);
		//6. 월 매입예산 합 => purchase_budget 합산 후 삽입
		profitLoss.setMonthTotalBudge(budgetAmount);
		//7. 월 매입 합 => 한달 매입액 합산
		profitLoss.setMonthTotalPurchase(purchaseAmount);
		//8. 월 손익(수수료제외) => 매출액 합 - 매입액 합 => (4) - (7)
		profitLossNotVat = saleAmount - purchaseAmount;
		profitLoss.setMonthProfitLoss(profitLossNotVat);
		//9. 월 최종 손익(수수료 포함) => (8) + 수수료(5)
		profitLossVat = profitLossNotVat + vatAmount;
		profitLoss.setFinalMonthProfitLoss(profitLossVat);
		//10. 결산 확인 여부 default false
		//11. 결산 확인 일자 - 초기값 null
		//12. 결재 담당자 ID - 초기값 null
		
		//insert profitLoss
		profitLossMapper.addProfitLoss(profitLoss);
		
		
		/*
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
	}
	
	//재무 마감 ---------------
		/*
		 	마감이 담당자에 의해 완료되면
		 	마감대기중인 기록이 '마감완료'로 변환
		 	매입기록을 수정,삭제할 수 없고 (매출 기록을 삭제할 수 없음)
		 */
	
}
