package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.FoundationRequest;

@Mapper
public interface FoundationMapper {

	//재단 조회
	public List<Foundation> getFoundationList();
	
	//재단 등록
	public int addFoundation(Foundation foundation);
	
	//특정 재단 조회
	public Foundation getFoundationByCode(String foundationCode);
	
	//재단 수정
	public int modifyFoundation(Foundation foundation);
	
	//재단 요청사항 조회
	public List<FoundationRequest> getFoundationRequestList();
	
	//재단 요청사항 등록
	public int addFoundationRequest(FoundationRequest foundationRequest);
	
	//특정 재단 요청사항 조회
	public FoundationRequest getFoundationRequestInfoByCode(String foundationRequestCode);
	
	//재단 요청사항 수정
	public int modifyFoundationRequest(FoundationRequest foundationRequest);
	
}
