package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.DonationCode;
import ks46team04.admin.dto.DonationMonthPay;
import ks46team04.admin.dto.DonationPayDetail;
import ks46team04.admin.dto.DonationPayMethod;
import ks46team04.admin.dto.DonationPayMethodCode;
import ks46team04.admin.dto.DonationRefund;
import ks46team04.admin.dto.DonationSub;
import ks46team04.admin.dto.DonationSubCode;
import ks46team04.admin.dto.PaymentCode;

@Mapper
public interface DonationMapper {
	
	/*정기기부 단가 조회*/
	public List<Donation> getDonation(String searchKey, String searchValue);
	
	/*정기기부 단가 등록*/
	public int addDonation(Donation donation);
	
	/* 특정 정기기부 단가 조회 */
 	public Donation getDonationInfoByCode(String donationCode);
 	
	/* 정기기부 단가 수정 */
	public int modifyDonation(Donation donation);
	
	/* 정기기부 단가 삭제 */
	public int removeDonation(Donation donation);
	
	/* 등록된 회원 결제수단 조회 */
	public List<DonationPayMethod> getDonationPayMethod(String searchKey, String searchValue);
	
	/* 등록된 회원 결제수단 등록 */
	public int addDonationPayMethod(DonationPayMethod donationPayMethod);
	
	/* 특정 등록된 회원 결제수단 조회 */
 	public DonationPayMethod getDonationPayMethodInfoByCode(String donationPayMethodCode);
 	
	/* 등록된 회원 결제수단 수정 */
	public int modifyDonationPayMethod(DonationPayMethod donationPayMethod);
	
	/* 등록된 회원 결제수단 삭제 */
	public int removeDonationPayMethod(DonationPayMethod donationPayMethod);
	
	/* 정기기부 구독 신청 조회 */
	public List<DonationSub> getDonationSub(String searchKey, String searchValue);
	
	/* 정기기부 구독 신청 등록 */
	public int addDonationSub(DonationSub donationSub);
	
	/* 특정 정기기부 구독 신청 조회 */
 	public DonationSub getDonationSubInfoByCode(String donationSubCode);
 	
	/* 정기기부 구독 신청 수정 */
	public int modifyDonationSub(DonationSub donationSub);
	
	/* 정기기부 구독 신청 삭제 */
	public int removeDonationSub(DonationSub donationSub);
	
	/* 정기기부 구독 결제 상세 조회 */
	public List<DonationPayDetail> getDonationPayDetail(String searchKey, String searchValue);
	
	/* 정기기부 구독 결제 상세 등록 */
	public int addDonationPayDetail(DonationPayDetail donationPayDetail);
	
	/* 특정 정기기부 구독 결제 상세 조회 */
 	public DonationPayDetail getDonationPayDetailInfoByCode(String donationPayDetailCode);
 	
	/* 정기기부 구독 결제 상세 수정 */
	public int modifyDonationPayDetail(DonationPayDetail donationPayDetail);
	
	/* 정기기부 구독 결제 상세 삭제 */
	public int removeDonationPayDetail(DonationPayDetail donationPayDetail);

	/* 정기기부 월별 결제 합계 조회 */
	public List<DonationMonthPay> getDonationMonthPay(String searchKey, String searchValue);
	
	/* 정기기부 월별 결제 합계 등록 */
	public int addDonationMonthPay(DonationMonthPay donationMonthPay);
	
	/* 특정 정기기부 월별 결제 합계 조회 */
 	public DonationMonthPay getDonationMonthPayInfoByCode(String donationMonthPayCode);
 	
	/* 정기기부 월별 결제 합계 수정 */
	public int modifyDonationMonthPay(DonationMonthPay DonationMonthPay);
	
	/* 정기기부 월별 결제 합계 삭제 */
	public int removeDonationMonthPay(DonationMonthPay DonationMonthPay);
	
	/* 정기기부 환불 조회 */
	public List<DonationRefund> getDonationRefund(String searchKey, String searchValue);
	
	/* 정기기부 환불 등록 */
	public int addDonationRefund(DonationRefund donationRefund);
	
	/* 특정 정기기부 환불 조회 */
 	public DonationRefund getDonationRefundInfoByCode(String donationRefundCode);
 	
	/* 정기기부 환불 수정 */
	public int modifyDonationRefund(DonationRefund donationRefund);
	
	/* 정기기부 환불 삭제 */
	public int removeDonationRefund(DonationRefund donationRefund);
	
	/* DonationCode 값 가져오기 */
	public List<DonationCode> getdonationCode();
	
	/* DonationPayMethodCode 값 가져오기 */
	public List<DonationPayMethodCode> getdonationPayMethodCode();
	
	/* DonationSubCode 값 가져오기 */
	public List<DonationSubCode> getdonationSubCode();
	
	/* PaymentCode 값 가져오기 */
	public List<PaymentCode> getpaymentCode();
	
	/* DonationPayDetailCode 값 가져오기 */
	public List<DonationPayDetail> getdonationPayDetailCode();

}
