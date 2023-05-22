package ks46team04.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Vat;
import ks46team04.admin.mapper.VatMapper;

@Service
@Transactional
public class VatService {
	
	private static final Logger log = LoggerFactory.getLogger(VatService.class);

	private final VatMapper vatMapper;
	public VatService(VatMapper vatMapper) {
		this.vatMapper = vatMapper;
	}
	
	public Vat getVatRow() {
		Vat getVatRow = vatMapper.getVatRow();
		log.info("getVatRow1: {}", getVatRow);
		
		 String vatRatio = getVatRow.getVatRatio(); 
		 System.out.println(vatRatio + "vatRatio1"); 
		 vatRatio = String.valueOf(Double.valueOf(vatRatio) * 100) + "%";
		 System.out.println(vatRatio + "vatRatio2"); 
		 getVatRow.setVatRatio(vatRatio);
		 log.info("getVatRow2: {}", getVatRow);
		
		return getVatRow;
	}
	
	public void modifyVat(Vat vat, String loginId) {
		log.info("vat: {}", vat);
		String vatRatio = vat.getVatRatio();
		
		if(vatRatio != null) {
			vatRatio = String.valueOf(Double.valueOf(vatRatio) / 100);
			System.out.println(vatRatio);
			vatMapper.modifyVat(vatRatio, loginId);
		}
	}
	
}
