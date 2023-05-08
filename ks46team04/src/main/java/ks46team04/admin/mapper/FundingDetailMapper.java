package ks46team04.admin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingDetail;

@Mapper
public interface FundingDetailMapper {
    
    @Select("SELECT * FROM funding_detail WHERE funding_code = #{fundingCode}")
    FundingDetail getFundingDetailInfoByCode(String fundingCode);
    
    @Insert("INSERT INTO funding_detail "
            + "(funding_code, funding_name, funding_foundation, funding_goal_amount, funding_start_date, "
            + "funding_end_date) "
            + "VALUES "
            + "(#{fundingCode}, #{fundingName}, #{foundationName}, #{fundingGoalAmount}, #{fundingStartDate}, "
            + "#{fundingEndDate}")
    public void createFundingDetail(FundingDetail fundingDetail);

    public Funding selectFundingByCode(@Param("fundingCode") String fundingCode);
    
    
}

