package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ks46team04.admin.dto.FundingProduct;

@Mapper
public interface FundingProductMapper {

	@Select("SELECT * FROM each_funding_info")
	List<FundingProduct> listFundingProduct();
		
	@Select("SELECT * FROM funding WHERE funding_code = #{fundingCode}")
    FundingProduct detailFunding(@Param("fundingCode") String fundingCode);

}
