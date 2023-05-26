package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.Payment;

@Mapper
public interface PaymentMapper {

	/* 결제방식 조회 */
	public List<Payment> getPayment();
}
