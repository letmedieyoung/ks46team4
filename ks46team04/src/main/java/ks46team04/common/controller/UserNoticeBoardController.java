package ks46team04.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.NoticeBoard;
import ks46team04.admin.mapper.NoticeBoardMapper;
import ks46team04.admin.service.NoticeBoardService;

@Controller
@RequestMapping("/common/user_notice_board")
public class UserNoticeBoardController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserNoticeBoardController.class);
	
	private final NoticeBoardService noticeBoardService;
	private final NoticeBoardMapper noticeBoardMapper;
	
	public UserNoticeBoardController(NoticeBoardService noticeBoardService, NoticeBoardMapper noticeBoardMapper) {
		this.noticeBoardService = noticeBoardService;
		this.noticeBoardMapper = noticeBoardMapper;
	}
	
	/**
	 * 공지사항 삭제
	 * @return
	 */
	@PostMapping("/remove_notice_board")
	@ResponseBody
	public List<String> removeNoticeBoard(@RequestParam(value="valueArr[]") List<String> valueArr){
		 log.info("valueArr: {}", valueArr);
		 noticeBoardService.removeNoticeBoard(valueArr);
		 
		 return valueArr;
	}
	
	/**
	 * 공지사항 수정 @PostMapping
	 * @param noticeBoard
	 * @param session
	 * @return
	 */
	@PostMapping("/modify_notice_board")
	public String modifyNoticeBoard(NoticeBoard noticeBoard, HttpSession session) {
		
		String noticeBoardUpdId = (String) session.getAttribute("SID");
		log.info("noticeBoardUpdId: {}", noticeBoardUpdId);
		
		noticeBoard.setNoticeBoardUpdId(noticeBoardUpdId);
		log.info("noticeBoard: {}", noticeBoard);
		
		noticeBoardService.modifyNoticeBoard(noticeBoard);
		
		return "redirect: /common/user_notice_board/notice_board_list";
	}
	
	/**
	 * 공지사항 수정 @GetMapping
	 * @param model
	 * @param noticeBoardCode
	 * @return
	 */
	@GetMapping("/modify_notice_board")
	public String modifyNoticeBoard(Model model, @RequestParam(name="noticeBoardCode") String noticeBoardCode) {
		
		NoticeBoard noticeBoardInfo = noticeBoardService.getNoticeBoardInfoByCode(noticeBoardCode);
		log.info("noticeBoardInfo: {}", noticeBoardInfo);
		
		model.addAttribute("title", "공지사항 수정");
		model.addAttribute("noticeBoardInfo", noticeBoardInfo);
		
		return "common/user_notice_board/modify_notice_board";
	}
	
	/**
	 * 공지사항 등록 @PostMapping
	 * @param noticeBoard
	 * @param session
	 * @return
	 */
	@PostMapping("/add_notice_board")
	public String addNoticeBoard(NoticeBoard noticeBoard, HttpSession session) {
		
		String noticeBoardRegId = (String) session.getAttribute("SID");
		log.info("noticeBoardRegId: {}", noticeBoardRegId);
		
		noticeBoard.setNoticeBoardRegId(noticeBoardRegId);
		log.info("noticeBoard: {}", noticeBoard);
		
		noticeBoardService.addNoticeBoard(noticeBoard);
		
		return "redirect:/common/user_notice_board/notice_board_list";
	}
	
	/**
	 * 공지사항 등록 @GetMapping
	 * @param model
	 * @return
	 */
	@GetMapping("/add_notice_board")
	public String addNoticeBoard(Model model) {
		
		log.info("model: {}", model);
		
		model.addAttribute("title", "상품 등록");
		
		return "common/user_notice_board/add_notice_board";
	}
	
	/**
	 * 공지사항 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/notice_board_list")
	public String getNoticeBoardList(Model model) {
		
		List<NoticeBoard> noticeBoardList = noticeBoardService.getNoticeBoardList();
		log.info("noticeBoardList: {}", noticeBoardList);
		
		model.addAttribute("title", "공지사항 목록");
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		return "common/user_notice_board/notice_board_list";
	}
}
