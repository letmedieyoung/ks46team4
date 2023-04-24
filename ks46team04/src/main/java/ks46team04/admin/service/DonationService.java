package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Donation;
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
	 * */
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
}
