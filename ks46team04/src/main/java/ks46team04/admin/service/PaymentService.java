package ks46team04.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Payment;
import ks46team04.admin.mapper.PaymentMapper;

@Service
@Transactional
public class PaymentService {
	
private final PaymentMapper paymentMapper;
	
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}
	
	/*
	 * 정기기부 단가 조회
	 * */
	public List<Payment> getPayment(){
		
		List<Payment> getPayment = paymentMapper.getPayment();
		
		return getPayment;
	}

}
