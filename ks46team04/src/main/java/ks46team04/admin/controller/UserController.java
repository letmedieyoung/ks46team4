package ks46team04.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.ActivityStatus;
import ks46team04.admin.dto.LoginLog;
import ks46team04.admin.dto.User;
import ks46team04.admin.dto.UserDrop;
import ks46team04.admin.dto.UserLevel;
import ks46team04.admin.dto.UserSleep;
import ks46team04.admin.mapper.UserMapper;
import ks46team04.admin.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;
	private final UserMapper userMapper;

	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@GetMapping("/userDetailList")
	public String getUserDetailList(Model model, @RequestParam(name = "userId", required = false) String userId) {

		List<User> userDetailList = userService.getUserDetailList(userId);

		model.addAttribute("title", "회원상세조회");
		model.addAttribute("userDetailList", userDetailList);

		return "admin/user/userDetailList";
	}

	@GetMapping("/userDropList")
	public String getUserDropList(Model model) {

		List<UserDrop> userDropList = userService.getUserDropList();

		model.addAttribute("title", "탈퇴회원목록조회");
		model.addAttribute("userDropList", userDropList);

		return "admin/user/userDropList";
	}

	@GetMapping("/userSleepList")
	public String getUserSleepList(Model model) {

		List<UserSleep> userSleepList = userService.getUserSleepList();

		model.addAttribute("title", "휴면회원목록조회");
		model.addAttribute("userSleepList", userSleepList);

		return "admin/user/userSleepList";
	}

	@GetMapping("/loginLog")
	public String getLoginLogList(Model model, HttpSession session, HttpServletRequest request) {
		String userId = (String) session.getAttribute("SID");

		List<LoginLog> loginLogList = userService.getLoginLogList(userId);
		
		 
		model.addAttribute("title", "로그인기록");
		model.addAttribute("loginLogList", loginLogList);

		return "admin/user/loginLog";
	}
	
	@GetMapping("/activityStatus")
	public String getActivityStatusList(Model model) {

		List<ActivityStatus> activityStatusList = userService.getActivityStatusList();

		model.addAttribute("title", "회원활동상태기준");
		model.addAttribute("activityStatusList", activityStatusList);

		return "admin/user/activityStatus";
	}

	@GetMapping("/userLevel")
	public String getUserLevelList(Model model) {

		List<UserLevel> userLevelList = userService.getUserLevelList();

		model.addAttribute("title", "회원등급기준");
		model.addAttribute("userLevelList", userLevelList);

		return "admin/user/userLevel";
	}
	
	@PostMapping("/removeUser")
	@ResponseBody
	public Map<String, Object> removeUser(@RequestParam(name = "userId") String userId, @RequestParam(name = "userPw") String userPw) {
	    Logger logger = LoggerFactory.getLogger(getClass());
	    Map<String, Object> response = new HashMap<>();

	    try {
	        if (userService.pwCheck(userId, userPw)) {
	            userService.removeUser(userId);
	            response.put("success", true);
	            response.put("message", "삭제 성공");
	        } else {
	            response.put("success", false);
	            response.put("message", "비밀번호가 일치하지 않습니다.");
	        }
	    } catch (Exception e) {
	        logger.error("An error occurred while deleting user information.", e);
	        response.put("success", false);
	        response.put("message", "회원 정보 삭제 중 오류가 발생하였습니다.");
	    }

	    return response;
	}
	

	@PostMapping("/pwCheck")
	@ResponseBody
	public boolean pwCheck(@RequestParam(name = "userId") String userId, @RequestParam(name = "userPw") String userPw) {

		return userService.pwCheck(userId, userPw);
	}

	
	
	@GetMapping("/removeUser")
	public String removeUser(@RequestParam(name = "userId") String userId, Model model) {

		model.addAttribute("title", "회원탈퇴");
		model.addAttribute("userId", userId);
	

		return "admin/user/removeUser";
	}

	@PostMapping("/modifyUser")
	@ResponseBody
	public Map<String, Object> modifyUser(@RequestParam(name = "userId") String userId, @ModelAttribute User user) {
		try {
	        // 회원 정보 수정 처리 코드
	        boolean isSuccess = userService.modifyUser(user);

	        // 처리 결과 반환
	        Map<String, Object> modifyResultMap = new HashMap<>();
	        modifyResultMap.put("success", isSuccess);
	        return modifyResultMap;
	    } catch (Exception e) {
	        // Handle the exception
	        e.printStackTrace();
	        // You can return an error response or customize it according to your requirements
	        Map<String, Object> errorMap = new HashMap<>();
	        errorMap.put("success", false);
	        errorMap.put("message", "An error occurred during user modification.");
	        return errorMap;
	    }
	}

	    
	@GetMapping("/modifyUser")
	public String modifyUser(@RequestParam(name = "userId") String userId, Model model) {
		User userInfo = userService.getUserInfoById(userId);
		List<UserLevel> userLevelList = userService.getUserLevelList();
		model.addAttribute("title", "회원수정");
		model.addAttribute("userLevelList", userLevelList);
		model.addAttribute("userInfo", userInfo);

		return "admin/user/modifyUser";
	}

	@GetMapping("/addUser")
	public String addUser(Model model) {

		List<UserLevel> userLevelList = userService.getUserLevelList();
		List<ActivityStatus> activityStatusList = userService.getActivityStatusList();

		model.addAttribute("title", "Pilling Good - 회원 관리 - 회원 등록");
		model.addAttribute("userLevelList", userLevelList);
		model.addAttribute("activityStatusList", activityStatusList);

		return "admin/user/addUser";
	}

	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(name = "userId") String userId) {
		boolean checked = true;
		// 아이디 중복체크
		checked = userMapper.idCheck(userId); // 중복된 값이 없고 사용가능하면 true

		return checked;
	}

	@PostMapping("/addUser")
	public String addUser(User user) {
		log.info("화면에서 전달받은 데이터(user) : {}", user);
		userService.addUser(user);
		return "redirect:/admin/user/userList";
	}
	
	@GetMapping("/userList")
	public String getUserList(Model model, @RequestParam(name = "searchKey", required = false) String searchKey,
	        @RequestParam(name = "searchValue", required = false) String searchValue) {

	    List<User> userList = userService.getUserListWithLogDateCalcul(searchKey, searchValue);

	    model.addAttribute("title", "회원목록조회");
	    model.addAttribute("userList", userList);

	    return "admin/user/userList";
	}
	


}