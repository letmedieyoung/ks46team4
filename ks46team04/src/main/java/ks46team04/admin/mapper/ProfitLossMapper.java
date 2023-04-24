package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.ProfitLoss;
import ks46team04.admin.dto.TotalPurchaseSale;

@Mapper
public interface ProfitLossMapper {

	public List<TotalPurchaseSale> getTotalPurchaseSale();
	public List<ProfitLoss> getProfitLoss();
}
