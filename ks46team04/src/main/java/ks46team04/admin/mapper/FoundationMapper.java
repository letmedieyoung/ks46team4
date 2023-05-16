package ks46team04.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.FoundationRequest;

@Mapper
public interface FoundationMapper {

	
	
	//재단 요청사항 삭제
	public int removeFoundationRequest(String foundationRequestCode);
	
	//재단 요청사항 수정
	public int modifyFoundationRequest(FoundationRequest foundationRequest);
	
	//특정 재단 요청사항 조회
	public FoundationRequest getFoundationRequestInfoByCode(String foundationRequestCode);
	
	//재단 요청사항 등록
	public int addFoundationRequest(FoundationRequest foundationRequest);
	
	//재단 요청사항 검색 결과 조회
	public List<FoundationRequest> getFoundationRequestListBySearch(Map<String, Object> searchMap);
	
	//재단 요청사항 조회
	public List<FoundationRequest> getFoundationRequestList();
	
	//재단 삭제
	public int removeFoundation(String foudationCode);
	
	//삭제 재단 진행 중 컨텐츠 유무 확인
	public boolean removeFoundationCheck(String foundationCode);
	
	//재단 수정
	public int modifyFoundation(Foundation foundation);
	
	//특정 재단 조회
	public Foundation getFoundationByCode(String foundationCode);
	
	//재단명 중복체크
	public boolean foundationNameCheck(String foundationCode);
	
	//재단 등록
	public int addFoundation(Foundation foundation);
	
	//재단 검색 결과 조회
	public List<Foundation> getFoundationListBySearch(Map<String, Object> searchMap);
	
	//재단 조회
	public List<Foundation> getFoundationList();
}
