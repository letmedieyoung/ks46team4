package ks46team04.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {

	public String getPrimaryKey(String tableName, String columnName);
	public String getPrimaryKeyVerTwo(String tableName, String columnName, String codeName);
	
	public String getPurchaseGroupCode(String tableName, String columnName, String PKkey, String codeName);
	
	public String getSaleGroupCode(String codeName);
}
