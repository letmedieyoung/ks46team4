package ks46team04.admin.controller;





import java.util.List;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.User;
import ks46team04.admin.dto.UserLevel;
import ks46team04.admin.mapper.UserMapper;
import ks46team04.admin.service.UserService;



@Controller
@RequestMapping("/view/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;
	private final UserMapper userMapper;

	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/view/user/login";
	}
	
	
	@PostMapping("/login")
	public String login( @RequestParam(name="userId") String userId
			  			,@RequestParam(name="userPw") String userPw
			  			,HttpSession session
			  			,RedirectAttributes reAttr) {
		String redirect = "redirect:/view/user/login";
		Map<String, Object> loginResultMap = userService.loginCheck(userId, userPw);
		boolean loginCheck = (boolean) loginResultMap.get("loginCheck");
		if(loginCheck) {
			User userInfo = (User) loginResultMap.get("userInfo");
			String userName = userInfo.getUserName();
			String userLevel = userInfo.getUserLevel();
			session.setAttribute("SID", 	userId);
			session.setAttribute("SLEVEL", 	userLevel);
			session.setAttribute("SNAME", 	userName);
			redirect = "redirect:/";
		}else {
			reAttr.addAttribute("result", "일치하는 회원의 정보가 없습니다.");
		}
		
		return redirect;
	}
	
	@GetMapping("/login")
	public String login( Model model
						,@RequestParam(name="result", required = false) String result) {
		
		model.addAttribute("title", "로그인");
		if(result != null) model.addAttribute("result", result);
		
		return "view/login/login";
	}
	
	
	@PostMapping("/removeUser")
	public String removeUser(@RequestParam(name="userId") String userId
							  ,@RequestParam(name="userPw") String userPw) {
		
		String redirectURI = "redirect:/user/removeUser?userId=" + userId;
		// 비밀번호 확인
		User user = userService.getUserInfoById(userId);
		if(user != null) {
			String checkPw = user.getUserPw();
			
			if(checkPw.equals(userPw)) {
				// 서비스 호출
				userService.removeUser(userId);
				redirectURI = "redirect:/view/user/userList";
			}
		}
		
		
		return redirectURI;
	}
	
	
	@GetMapping("/remove_user")
	public String removeUser(@RequestParam(name="userId") String userId
							  ,Model model) {
		
		model.addAttribute("title", "회원탈퇴");
		model.addAttribute("userId", userId);
		
		return "view/user/remove_user";
	}
	
	@PostMapping("/modify_user")
	public String modifyUser(User user) {
		
		userMapper.modifyUser(user);
		
		return "redirect:/user/userList";
	}
	
	@GetMapping("/modify_user")
	public String modifyUser(
				@RequestParam(name="userId") String userId
				,Model model) {
		User userInfo = userService.getUserInfoById(userId);
		List<UserLevel> userLevelList =
				userService.getUserLevelList();
		model.addAttribute("title", "회원수정");
		model.addAttribute("memberLevelList", userLevelList);
		model.addAttribute("memberInfo", userInfo);
		
		return "view/user/modify_user";
	}
	
	@PostMapping("/addUser")
	public String addUser(User user) {
		log.info("화면에서 전달받은 데이터 : {}", user);
		//userService.addUser(user);
		return "redirect:/view/user/userList";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(name="userId") String userId) {
		boolean checked = true;
		//아이디 중복체크
		checked = userMapper.idCheck(userId);
		
		return checked;
	}
	
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		List<UserLevel> userLevelList = userService.getUserLevelList();
		
		model.addAttribute("title", "회원가입");
		model.addAttribute("userLevelList", userLevelList);
		
		return "view/user/addUser";
	}
	
	@GetMapping("/userList")
	public String getUserList( Model model
								,@RequestParam(name="searchKey", required = false) String searchKey
								,@RequestParam(name="searchValue", required = false) String searchValue) {
		
		List<User> userList = userService.getUserList(searchKey, searchValue);
		  
		model.addAttribute("title", "회원목록조회");
		model.addAttribute("userList", userList);
		 
		
		return "view/user/userList";
	}
	
	
	
	
}