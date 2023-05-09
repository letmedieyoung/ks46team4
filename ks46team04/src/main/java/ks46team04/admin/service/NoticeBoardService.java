package ks46team04.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.NoticeBoard;
import ks46team04.admin.mapper.NoticeBoardMapper;

@Service
@Transactional
public class NoticeBoardService {

	private static final Logger log = LoggerFactory.getLogger(NoticeBoardService.class);

	private final NoticeBoardMapper noticeBoardMapper;
	
	public NoticeBoardService(NoticeBoardMapper noticeBoardMapper) {
		this.noticeBoardMapper = noticeBoardMapper;
	}
	
	/** 
	 * 공지사항 삭제
	 * @param valueArr
	 */
	public void removeNoticeBoard(List<String> valueArr) {
		for (int i = 0; i < valueArr.size(); i++) {
			noticeBoardMapper.removeNoticeBoard(valueArr.get(i));
		}
	}
	
	/**
	 * 공지사항 수정
	 * @param noticeBoard
	 */
	public void modifyNoticeBoard(NoticeBoard noticeBoard) {
		noticeBoardMapper.modifyNoticeBoard(noticeBoard);
	}
	
	/**
	 * 특정 공지사항 조회
	 * @param noticeBoardCode
	 * @return
	 */
	public NoticeBoard getNoticeBoardInfoByCode(String noticeBoardCode) {
		NoticeBoard noticeBoardInfo = noticeBoardMapper.getNoticeBoardInfoByCode(noticeBoardCode);
		return noticeBoardInfo;
	}
	
	/**
	 * 공지사항 등록
	 * @param noticeBoard
	 * @return
	 */
	public int addNoticeBoard(NoticeBoard noticeBoard) {
		int result = noticeBoardMapper.addNoticeBoard(noticeBoard);
		return result;
	}
	
	/**
	 * 공지사항 조회
	 * @return
	 */
	public List<NoticeBoard> getNoticeBoardList(){
		List<NoticeBoard> noticeBoardList = noticeBoardMapper.getNoticeBoardList();
		return noticeBoardList;
	}
}
