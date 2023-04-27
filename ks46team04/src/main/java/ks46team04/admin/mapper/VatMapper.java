package ks46team04.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Vat;

@Mapper
public interface VatMapper {

	public Vat getVatRow();
	public void modifyVat(String vatRatio);
}
