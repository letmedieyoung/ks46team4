package ks46team04.common.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {

	public String getPrimaryKey(String tableName, String columnName);
}