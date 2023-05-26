package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.FundingPay;
import ks46team04.admin.dto.ProfitLoss;
import ks46team04.admin.dto.Purchase;
import ks46team04.admin.dto.TotalPurchaseSale;

@Mapper
public interface ProfitLossMapper {

	public List<TotalPurchaseSale> getTotalPurchaseSale();
	public List<ProfitLoss> getProfitLoss();
	
	public int setWaiting(String tableName, String columnName, String group, String division);
	public int resetWaiting(String tableName, String columnName, String group, String division);
	
	public List<Purchase> monthPurchaseList(String yearMonth);
	public List<FundingPay> monthFundingPayList(String yearMonth);
	public List<DonationPayDetail> monthDonationPayList(String yearMonth);

	public int addToTotal(TotalPurchaseSale totalPurchaseSale);
	
	public List<TotalPurchaseSale> getTotalByYearMonth(String yearStr, String monthStr);
	public int addProfitLoss(ProfitLoss profitLoss);
}
