package ks46team04.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.DonationMonthPay;
import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.DonationPayMethod;
import ks46team04.admin.dto.DonationRefund;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.dto.Payment;
import ks46team04.admin.mapper.DonationMapper;

@Service
@Transactional
public class DonationService {
	
	private final DonationMapper donationMapper;
	
	public DonationService(DonationMapper donationMapper) {
		this.donationMapper = donationMapper;
	}
	
	/*
	 * 정기기부 콘텐츠 조회
	 * */
	public List<Donation> getDonation(String searchKey, String searchValue){
		
		if(searchKey != null) {
			switch (searchKey) {
			case "donationCode":
				searchKey = "regular_donation_code";
				break;
			case "donationName":
				searchKey = "regular_donation_name";
				break;
			default:
				searchKey = "regular_donation_price";
				break;
			}
		}
		
		List<Donation> getDonation = donationMapper.getDonation(searchKey, searchValue);
		
		return getDonation;
	}
	
	/*
	 * 정기기부 콘텐츠 등록
	 */
	public int addDonation(Donation donation) {
		
		int result = donationMapper.addDonation(donation);
		
		return result;
	}
	
	/*
	 * 특정 정기기부 콘텐츠 조회
	 * */
	public Donation getDonationInfoByCode(String donationCode) {
		Donation donationInfo = donationMapper.getDonationInfoByCode(donationCode);
		return donationInfo;
	}
	
	/*
	 * 정기기부 콘텐츠 수정
	 * */
	public void modifyDonation(Donation donation) {
		donationMapper.modifyDonation(donation);
	}
	
	/*
	 * 정기기부 콘텐츠 삭제
	 * */
	public void removeDonation(Donation donation) {
		donationMapper.removeDonation(donation);
	}
	
	/*
	 * 등록된 회원 결제수단 조회
	 * */
	public List<DonationPayMethod> getDonationPayMethod(String searchKey, String searchValue){
		
		if(searchKey != null) {
			switch (searchKey) {
			case "donationPayMethodCode":
				searchKey = "regular_donation_auto_pm_code";
				break;
			case "donationPayMethodUserId":
				searchKey = "user_id";
				break;
			case "paymentCode":
				searchKey = "pm_code";
				break;
			case "donationPayMethodBank":
				searchKey = "regular_donation_payment_bank";
				break;
			default:
				searchKey = "regular_donation_payment_account";
				break;
			}
		}

		List<DonationPayMethod> getDonationPayMethod = donationMapper.getDonationPayMethod(searchKey, searchValue);
		
		return getDonationPayMethod;
	}
	
	/*
	 * 등록된 회원 결제수단 등록
	 * */
	public int addDonationPayMethod(DonationPayMethod donationPayMethod) {

		int result = donationMapper.addDonationPayMethod(donationPayMethod);
		return result;
	}
	
	/*
	 * 특정 등록된 회원 결제수단 조회
	 * */
	public DonationPayMethod getDonationPayMethodInfoByCode(String donationPayMethodCode) {
		
		DonationPayMethod donationPayMethodInfo = donationMapper.getDonationPayMethodInfoByCode(donationPayMethodCode);

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
	public List<DonationSub> getDonationSub(String searchKey, String searchValue){
		
		if(searchKey != null) {
			switch (searchKey) {
			case "donationSubCode":
				searchKey = "user_regular_donation_subscription_code";
				break;
			case "donationSubUserId":
				searchKey = "user_id";
				break;
			case "donationCode":
				searchKey = "regular_donation_code";
				break;
			default:
				searchKey = "regular_donation_auto_pm_code";
				break;
			}
		}
		
		List<DonationSub> getDonationSub = donationMapper.getDonationSub(searchKey, searchValue);
		
		return getDonationSub;
	}
	
	/*
	 * 정기기부 구독 신청 등록
	 * */
	public int addDonationSub(DonationSub donationSub) {
		
		int result = donationMapper.addDonationSub(donationSub);
		
		return result;
	}
	
	/*
	 * 특정 정기기부 구독 신청 조회
	 * */
	public DonationSub getDonationSubInfoByCode(String donationSubCode) {
		
		DonationSub donationSubInfo = donationMapper.getDonationSubInfoByCode(donationSubCode);

		return donationSubInfo;
	}
	
	/*
	 * 정기기부 구독 해지 등록
	 * */
	public void cancelDonationSub(DonationSub donationSub) {
		donationMapper.cancelDonationSub(donationSub);
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
	public List<DonationPayDetail> getDonationPayDetail(String searchKey, String searchValue){
			
			if(searchKey != null) {
				switch (searchKey) {
				case "donationPayDetailCode":
					searchKey = "regular_donation_payment_code";
					break;
				case "donationPayUserId":
					searchKey = "user_id";
					break;
				case "donationSubCode":
					searchKey = "user_regular_donation_subscription_code";
					break;
				case "donationCode":
					searchKey = "regular_donation_code";
					break;
				case "donationPayMethodCode":
					searchKey = "regular_donation_auto_pm_code";
					break;
				case "donationPayRefundRequest":
					searchKey = "user_regular_donation_payment_refund_requested";
					break;
				default:
					searchKey = "user_regular_donation_deadline_check";
					break;
				}
			}

		List<DonationPayDetail> getDonationPayDetail = donationMapper.getDonationPayDetail(searchKey, searchValue);
		
		return getDonationPayDetail;
	}
	
	/*
	 * 정기기부 구독 결제 상세 등록
	 * */
	public int addDonationPayDetail(DonationPayDetail donationPayDetail) {
		
		int result = donationMapper.addDonationPayDetail(donationPayDetail);
		return result;
	}
	
	/*
	 * 특정 정기기부 구독 결제 상세 조회
	 * */
	public DonationPayDetail getDonationPayDetailInfoByCode(String donationPayDetailCode) {
		
		DonationPayDetail donationPayDetailInfo = donationMapper.getDonationPayDetailInfoByCode(donationPayDetailCode);

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
	public List<DonationMonthPay> getDonationMonthPay(String searchKey, String searchValue){
		
		if(searchKey != null) {
			switch (searchKey) {
			case "donationMonthPayCode":
				searchKey = "month_regular_donation_payment_code";
				break;
			case "donationCode":
				searchKey = "regular_donation_code";
				break;
			case "donationMonthPayYear":
				searchKey = "payment_year";
				break;
			case "donationMonthPayMonth":
				searchKey = "payment_month";
				break;
			default:
				searchKey = "donation_monthly_deadline_group";
				break;
			}
		}
		
		List<DonationMonthPay> getDonationMonthPay = donationMapper.getDonationMonthPay(searchKey, searchValue);
		
		return getDonationMonthPay;
	}
	
	/*
	 * 정기기부 월별 결제 합계 등록
	 * */
	public int addDonationMonthPay(DonationMonthPay donationMonthPay) {
		
		int result = donationMapper.addDonationMonthPay(donationMonthPay);
		
		return result;
	}
	
	/*
	 * 특정 정기기부 월별 결제 합계 조회
	 * */
	public DonationMonthPay getDonationMonthPayInfoByCode(String donationMonthPayCode) {
		
		DonationMonthPay donationMonthPayInfo = donationMapper.getDonationMonthPayInfoByCode(donationMonthPayCode);

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
	public List<DonationRefund> getDonationRefund(String searchKey, String searchValue){

		if(searchKey != null) {
			switch (searchKey) {
			case "donationRefundCode":
				searchKey = "regular_donation_payment_refund_code";
				break;
			case "donationRefundUserId":
				searchKey = "user_id";
				break;
			case "donationPayDetailCode":
				searchKey = "regular_donation_payment_code";
				break;
			case "donationRefundBank":
				searchKey = "regular_donation_refund_bank_name";
				break;
			case "donationRefundAccount":
				searchKey = "regular_donation_refund_account";
				break;
			default:
				searchKey = "regular_donation_refund_status";
				break;
			}
		}
		
		List<DonationRefund> getDonationRefund = donationMapper.getDonationRefund(searchKey, searchValue);
		
		return getDonationRefund;
	}
	
	/*
	 * 정기기부 환불 등록
	 * */
	public int addDonationRefund(DonationRefund donationRefund) {
		
		int result = donationMapper.addDonationRefund(donationRefund);
		
		return result;
	}
	
	/*
	 * 특정 정기기부 환불 조회
	 * */
	public DonationRefund getDonationRefundInfoByCode(String donationRefundCode) {
		
		DonationRefund donationRefundInfo = donationMapper.getDonationRefundInfoByCode(donationRefundCode);

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
	
	/*
	 * DonationCode 값 가져오기
	 * */
	public List<Donation> getdonationCode(){
		List<Donation> donationCode = donationMapper.getdonationCode();
		return donationCode;
	}
	
	/*
	 * DonationPayMethodCode 값 가져오기
	 * */
	public List<DonationPayMethod> getdonationPayMethodCode(){
		List<DonationPayMethod> donationPayMethodCode = donationMapper.getdonationPayMethodCode();
		return donationPayMethodCode;
	}
	
	/*
	 * DonationSubCode 값 가져오기
	 * */
	public List<DonationSub> getdonationSubCode(){
		List<DonationSub> donationSubCode = donationMapper.getdonationSubCode();
		return donationSubCode;
	}
	
	/*
	 * PaymentCode 값 가져오기
	 * */
	public List<Payment> getpaymentCode(){
		List<Payment> paymentCode = donationMapper.getpaymentCode();
		return paymentCode;
	}
	
	/*
	 * DonationPayDetailCode 값 가져오기
	 * */
	public List<DonationPayDetail> getdonationPayDetailCode(){
		List<DonationPayDetail> donationPayDetailCode = donationMapper.getdonationPayDetailCode();
		return donationPayDetailCode;
	}
}
