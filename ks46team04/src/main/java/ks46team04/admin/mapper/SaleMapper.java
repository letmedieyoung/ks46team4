package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.UnionDonaFund;

@Mapper
public interface SaleMapper {

	public List<UnionDonaFund> getTotalSaleList();
}
