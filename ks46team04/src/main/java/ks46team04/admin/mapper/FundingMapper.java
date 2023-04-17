package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import ks46team04.admin.dto.Funding;


@Mapper
public interface FundingMapper {
	// 펀딩 정보 조회
	public List<Funding> getFundingList();
}
