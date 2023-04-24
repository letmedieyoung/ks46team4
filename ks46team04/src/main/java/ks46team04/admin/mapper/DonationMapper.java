package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Donation;
import ks46team04.admin.dto.Goods;

@Mapper
public interface DonationMapper {
	
	/*정기기부 단가 조회*/
	public List<Donation> getDonation();
	
	/*정기기부 단가 등록*/
	public int addDonation(Donation donation);
	
	/* 특정 정기기부 단가 조회 */
 	public Donation getDonationInfoByCode(String donationCode);
 	
	/* 정기기부 단가 수정 */
	public int modifyDonation(Donation donation);
	
	/* 정기기부 단가 삭제 */
	public int removeDonation(Donation donation);
}
