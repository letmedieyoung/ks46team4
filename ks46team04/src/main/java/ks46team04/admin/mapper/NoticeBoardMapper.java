package ks46team04.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.NoticeBoard;

@Mapper
public interface NoticeBoardMapper {

	// 공지사항 삭제
	public int removeNoticeBoard(String noticeBoardCode);
	
	// 공지사항 수정
	public int modifyNoticeBoard(NoticeBoard noticeBoard);
	
	// 특정 공지사항 조회
	public NoticeBoard getNoticeBoardInfoByCode(String noticeBoardCode);
	
	// 공지사항 등록
	public int addNoticeBoard(NoticeBoard noticeBoard);
	
	// 공지사항 조회
	public List<NoticeBoard> getNoticeBoardList();
}
