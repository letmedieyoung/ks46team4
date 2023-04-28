package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.DonationMonthPay;
import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.DonationPayMethod;
import ks46team04.admin.dto.DonationRefund;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.mapper.DonationMapper;

@Service
@Transactional
public class DonationService {

	
	private static final Logger log = LoggerFactory.getLogger(DonationService.class);

	
	private final DonationMapper donationMapper;
	
	public DonationService(DonationMapper donationMapper) {
		this.donationMapper = donationMapper;
	}
	
	/*
	 * 정기기부 단가 조회
	 * */
	public List<Donation> getDonation(){

		List<Donation> getDonation = donationMapper.getDonation();
		
		return getDonation;
	}
	
	/*
	 * 정기기부 단가 등록
	 */
	public int addDonation(Donation donation) {
		
		log.info("화면에서 전달받은 데이터 : {}", addDonation(donation));
		
		int result = donationMapper.addDonation(donation);
		
		return result;
	}
	
	/*
	 * 특정 정기기부 단가 조회
	 * */
	public Donation getDonationInfoByCode(String donationCode) {
		Donation donationInfo = donationMapper.getDonationInfoByCode(donationCode);
		return donationInfo;
	}
	
	/*
	 * 정기기부 단가 수정
	 * */
	public void modifyDonation(Donation donation) {
		donationMapper.modifyDonation(donation);
	}
	
	/*
	 * 정기기부 단가 삭제
	 * */
	public void removeDonation(Donation donation) {
		donationMapper.removeDonation(donation);
	}
	
	/*
	 * 등록된 회원 결제수단 조회
	 * */
	public List<DonationPayMethod> getDonationPayMethod(){

		List<DonationPayMethod> getDonationPayMethod = donationMapper.getDonationPayMethod();
		
		return getDonationPayMethod;
	}
	
	/*
	 * 등록된 회원 결제수단 등록
	 * */
	public int addDonationPayMethod(DonationPayMethod donationPayMethod) {
		
		log.info("화면에서 전달받은 데이터 : {}", addDonationPayMethod(donationPayMethod));
		
		int result = donationMapper.addDonationPayMethod(donationPayMethod);
		return result;
	}
	
	/*
	 * 특정 등록된 회원 결제수단 조회
	 * */
	public DonationPayMethod getDonationPayMethodInfoByCode(String donationPayMethodCode) {
		DonationPayMethod donationPayMethodInfo = donationMapper.getDonationPayMethodInfoByCode(donationPayMethodCode);
		log.info("donationPayMethodInfo: {}", donationPayMethodInfo);
		return donationPayMethodInfo;
	}
	
	/*
	 * 등록된 회원 결제수단 수정
	 * */
	public void modifyDonationPayMethod(DonationPayMethod donationPayMethod) {
		donationMapper.modifyDonationPayMethod(donationPayMethod);
	}
	
	/*
	 * 등록된 회원 결제수단 삭제
	 * */
	public void removeDonationPayMethod(DonationPayMethod donationPayMethod) {
		donationMapper.removeDonationPayMethod(donationPayMethod);
	}
	
	/*
	 * 정기기부 구독 신청 조회
	 * */
	public List<DonationSub> getDonationSub(){

		List<DonationSub> getDonationSub = donationMapper.getDonationSub();
		
		return getDonationSub;
	}
	
	/*
	 * 정기기부 구독 신청 등록
	 * */
	public int addDonationSub(DonationSub donationSub) {
		
		log.info("화면에서 전달받은 데이터 : {}", addDonationSub(donationSub));
		
		int result = donationMapper.addDonationSub(donationSub);
		return result;
	}
	
	/*
	 * 특정 정기기부 구독 신청 조회
	 * */
	public DonationSub getDonationSubInfoByCode(String donationSubCode) {
		DonationSub donationSubInfo = donationMapper.getDonationSubInfoByCode(donationSubCode);
		log.info("donationSubInfo: {}", donationSubInfo);
		return donationSubInfo;
	}
	
	/*
	 * 정기기부 구독 신청 수정
	 * */
	public void modifyDonationSub(DonationSub donationSub) {
		donationMapper.modifyDonationSub(donationSub);
	}
	
	/*
	 * 정기기부 구독 신청 삭제
	 * */
	public void removeDonationSub(DonationSub donationSub) {
		donationMapper.removeDonationSub(donationSub);
	}

	/*
	 * 정기기부 구독 결제 상세 조회
	 * */
	public List<DonationPayDetail> getDonationPayDetail(){

		List<DonationPayDetail> getDonationPayDetail = donationMapper.getDonationPayDetail();
		
		return getDonationPayDetail;
	}
	
	/*
	 * 정기기부 구독 결제 상세 등록
	 * */
	public int addDonationPayDetail(DonationPayDetail donationPayDetail) {
		
		log.info("화면에서 전달받은 데이터 : {}", addDonationPayDetail(donationPayDetail));
		
		int result = donationMapper.addDonationPayDetail(donationPayDetail);
		return result;
	}
	
	/*
	 * 특정 정기기부 구독 결제 상세 조회
	 * */
	public DonationPayDetail getDonationPayDetailInfoByCode(String donationPayDetailCode) {
		DonationPayDetail donationPayDetailInfo = donationMapper.getDonationPayDetailInfoByCode(donationPayDetailCode);
		log.info("donationPayDetailInfo: {}", donationPayDetailInfo);
		return donationPayDetailInfo;
	}
	
	/*
	 * 정기기부 구독 결제 상세 수정
	 * */
	public void modifyDonationPayDetail(DonationPayDetail donationPayDetail) {
		donationMapper.modifyDonationPayDetail(donationPayDetail);
	}
	
	/*
	 * 정기기부 구독 결제 상세 삭제
	 * */
	public void removeDonationPayDetail(DonationPayDetail donationPayDetail) {
		donationMapper.removeDonationPayDetail(donationPayDetail);
	}
	
	/*
	 * 정기기부 월별 결제 합계 조회
	 * */
	public List<DonationMonthPay> getDonationMonthPay(){

		List<DonationMonthPay> getDonationMonthPay = donationMapper.getDonationMonthPay();
		
		return getDonationMonthPay;
	}
	
	/*
	 * 정기기부 월별 결제 합계 등록
	 * */
	public int addDonationMonthPay(DonationMonthPay donationMonthPay) {
		
		log.info("화면에서 전달받은 데이터 : {}", addDonationMonthPay(donationMonthPay));
		
		int result = donationMapper.addDonationMonthPay(donationMonthPay);
		return result;
	}
	
	/*
	 * 특정 정기기부 월별 결제 합계 조회
	 * */
	public DonationMonthPay getDonationMonthPayInfoByCode(String donationMonthPayCode) {
		DonationMonthPay donationMonthPayInfo = donationMapper.getDonationMonthPayInfoByCode(donationMonthPayCode);
		log.info("donationMonthPayInfo: {}", donationMonthPayInfo);
		return donationMonthPayInfo;
	}
	
	/*
	 * 정기기부 월별 결제 합계 수정
	 * */
	public void modifyDonationMonthPay(DonationMonthPay donationMonthPay) {
		donationMapper.modifyDonationMonthPay(donationMonthPay);
	}
	
	/*
	 * 정기기부 월별 결제 합계 삭제
	 * */
	public void removeDonationMonthPay(DonationMonthPay donationMonthPay) {
		donationMapper.removeDonationMonthPay(donationMonthPay);
	}
	
	/*
	 * 정기기부 환불 조회
	 * */
	public List<DonationRefund> getDonationRefund(){

		List<DonationRefund> getDonationRefund = donationMapper.getDonationRefund();
		
		return getDonationRefund;
	}
	
	/*
	 * 정기기부 환불 등록
	 * */
	public int addDonationRefund(DonationRefund donationRefund) {
		
		log.info("화면에서 전달받은 데이터 : {}", addDonationRefund(donationRefund));
		
		int result = donationMapper.addDonationRefund(donationRefund);
		return result;
	}
	
	/*
	 * 특정 정기기부 환불 조회
	 * */
	public DonationRefund getDonationRefundInfoByCode(String donationRefundCode) {
		DonationRefund donationRefundInfo = donationMapper.getDonationRefundInfoByCode(donationRefundCode);
		log.info("donationRefundInfo: {}", donationRefundInfo);
		return donationRefundInfo;
	}
	
	/*
	 * 정기기부 환불 수정
	 * */
	public void modifyDonationRefund(DonationRefund donationRefund) {
		donationMapper.modifyDonationRefund(donationRefund);
	}
	
	/*
	 * 정기기부 환불 삭제
	 * */
	public void removeDonationRefund(DonationRefund donationRefund) {
		donationMapper.removeDonationRefund(donationRefund);
	}
}
