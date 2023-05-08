package ks46team04.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {

	public String getPrimaryKey(String tableName, String columnName);
	
	public String getGroupCode(String tableName, String columnName, String codeName);
	
}
