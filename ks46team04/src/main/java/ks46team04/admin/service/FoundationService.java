package ks46team04.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.Foundation;
import ks46team04.admin.dto.FoundationRequest;
import ks46team04.admin.mapper.FoundationMapper;

@Service
@Transactional
public class FoundationService {

	
	private static final Logger log = LoggerFactory.getLogger(FoundationService.class);

	private final FoundationMapper foundationMapper;
	
	public FoundationService(FoundationMapper foundationMapper) {
		this.foundationMapper = foundationMapper;
	}
	
	
	/**
	 * 재단 요청사항 삭제
	 * @param foundationRequestCode
	 * @return
	 */
	public boolean removeFoundationRequest(String foundationRequestCode) {
		boolean isRemove = foundationMapper.removeFoundationRequestCheck(foundationRequestCode);
		if(isRemove){
			foundationMapper.removeFoundationRequest(foundationRequestCode);
			return true;
		}
		return false;
	}
	
	/**
	 * 재단 요청사항 수정
	 * @param foundationRequest
	 */
	public void modifyFoundationRequest(FoundationRequest foundationRequest) {
		foundationMapper.modifyFoundationRequest(foundationRequest);
	}
	
	/**
	 * 특정 재단 요청사항 조회
	 * @param foundationRequestCode
	 * @return
	 */
	public FoundationRequest getFoundationRequestInfoByCode(String foundationRequestCode) {
		FoundationRequest foundationRequestInfo = foundationMapper.getFoundationRequestInfoByCode(foundationRequestCode);
		return foundationRequestInfo;
	}
	
	/**
	 * 재단 요청사항 등록
	 * @param foundationRequest
	 * @return
	 */
	public int addFoundationRequest(FoundationRequest foundationRequest) {
		int result = foundationMapper.addFoundationRequest(foundationRequest);
		return result;
	}
	
	/**
	 * 재단 요청사항 검색 결과 조회
	 * @param paramMap
	 * @return
	 */
	public List<FoundationRequest> getFoundationRequestlistBySearch(List<String> searchKey
																	,List<String> searchValue
																	,String dateSearchKey
																	,String startDate
																	,String endDate){
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		if(searchKey != null && searchValue != null) {
			for(int i=0; i < searchKey.size(); i++) {
				String key = searchKey.get(i);
				switch (key) {
				case "foundationName":
					key = "foundation_name";
					break;
				case "requestGoodsName":
					key = "request_goods_name";					
					break;
				case "contentCategory":
					key = "content_category";					
					break;
				case "requestProgressStatus":
					key = "request_progress_status";					
					break;
				}
				searchKey.set(i, key);
			}
			searchMap.put("searchKey", searchKey);
			
			for(int i=0; i < searchValue.size(); i++) {
				String value = searchValue.get(i);
				if(value.equals("전체")) value = "";
				searchValue.set(i, value);
			}
			searchMap.put("searchValue", searchValue);
		}
		
		if(dateSearchKey != null && startDate != null && endDate != null) {
			searchMap.put("dateSearchKey", dateSearchKey);
			searchMap.put("startDate", startDate);
			searchMap.put("endDate", endDate);
		}
		
		log.info("searchMap: {}", searchMap);
		
		List<FoundationRequest> foundationRequestList = foundationMapper.getFoundationRequestListBySearch(searchMap);
		return foundationRequestList;
	}
	
	/**
	 * 재단 요청사항 조회
	 * @return
	 */
	public List<FoundationRequest> getFoundationRequestlist(){
		List<FoundationRequest> foundationRequestList = foundationMapper.getFoundationRequestList();
		return foundationRequestList;
	}
	
	/**
	 * 재단 삭제
	 * @param foundationCode
	 */
	public boolean removeFoundation(String foundationCode) {
		boolean isRemove = foundationMapper.removeFoundationCheck(foundationCode);
		if(isRemove) {
			foundationMapper.removeFoundation(foundationCode);
			return true;
		}
		return false;
	}
	
	/**
	 * 재단 수정
	 * @param foundation
	 */
	public void modifyFoundation(Foundation foundation) {
		foundationMapper.modifyFoundation(foundation);
	}
	
	/**
	 * 특정 재단 정보 조회
	 * @param foundationCode
	 * @return
	 */
	public Foundation getFoundationInfoByCode(String foundationCode) {
		Foundation foundationInfo = foundationMapper.getFoundationByCode(foundationCode);
		return foundationInfo;
				
	}
	
	/**
	 * 재단 등록
	 * @param foundation
	 * @return
	 */
	public int addFoundation(Foundation foundation) {
		
		int result = foundationMapper.addFoundation(foundation);
		return result;
	}
	
	/**
	 * 재단 검색 결과 조회
	 * @param searchMap
	 * @return
	 */
	public List<Foundation> getFoundationListBySearch(String searchKey
													, String searchValue
													, String startDate
													, String endDate){
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		if(searchKey != null && searchValue != null) {
			switch (searchKey) {
			case "foundationName":
				searchKey = "foundation_name";
				break;
			case "foundationManager":
				searchKey = "foundation_manager";					
				break;
			}
			searchMap.put("searchKey", searchKey);
			searchMap.put("searchValue", searchValue);
		}
		if(startDate != null && endDate != null) {
			searchMap.put("startDate", startDate);
			searchMap.put("endDate", endDate);
		}
		log.info("searchMap: {}", searchMap);
		
		List<Foundation> foundationList = foundationMapper.getFoundationListBySearch(searchMap);
		return foundationList;
	}
	
	/**
	 * 재단 조회
	 * @return List<Foundation>
	 */
	public List<Foundation> getFoundationList(){
		List<Foundation> foundationList = foundationMapper.getFoundationList();
		return foundationList;
	}
	
}
