package ks46team04.common.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.ActivityStatus;
import ks46team04.admin.dto.User;
import ks46team04.admin.dto.UserLevel;
import ks46team04.admin.mapper.UserMapper;
import ks46team04.admin.service.UserService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);

	private final UserService userService;
	private final UserMapper userMapper;

	public CommonController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}

		@GetMapping("/funding_index")
		public String MainHome(Model model) {
			
			return "common/funding_index";
		}
		
		@GetMapping("/funding_detail")
		public String nowFunding1(Model model) {
			
			return "common/funding_detail";
		}
		
		@GetMapping("/funding_detail2")
		public String nowFunding2(Model model) {
			
			return "common/funding_detail2";
		}
		
		@GetMapping("/funding_detail3")
		public String nowFunding3(Model model) {
			
			return "common/funding_detail3";
		}
		
		@PostMapping("/register")
		public String register(User user) {
			log.info("화면에서 전달받은 데이터 : {}", user);
			userService.addUser(user);
			return "redirect:/";
		}
		
		@PostMapping("/idCheck")
		@ResponseBody
		public boolean idCheck(@RequestParam(name = "userId") String userId) {
			boolean checked = true;
			// 아이디 중복체크
			checked = userMapper.idCheck(userId); // 중복된 값이 없고 사용가능하면 true

			return checked;
		}
		
		@GetMapping("/register")
		public String register(Model model) {
			List<UserLevel> userLevelList = userService.getUserLevelList();
			List<ActivityStatus> activityStatusList = userService.getActivityStatusList();
			
			model.addAttribute("title", "Pilling Good - 회원 가입");
			model.addAttribute("userLevelList", userLevelList);
			model.addAttribute("activityStatusList", activityStatusList);
			
			return "common/register";
		}
		
		
		@GetMapping("/logout")
	    public String logout(HttpSession session
	            ,@CookieValue(value="autoLogin", required = false) Cookie cookie
	            ,HttpServletResponse response) {
	        if(cookie != null) {
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            response.addCookie(cookie);
	        }
	        session.invalidate();
	        return "redirect:/";
	        //return "redirect:/common/login";
	    }
		
		
		@PostMapping("/login")
		public String login(@RequestParam(name = "userId") String userId
							,@RequestParam(name = "userPw") String userPw
				  			,@RequestParam(name = "autoLogin", defaultValue = "false") boolean autoLogin
				  			,HttpSession session
				  			,RedirectAttributes reAttr
				  			,HttpServletResponse response) {
			String redirect = "redirect:/common/login";
			Map<String, Object> loginResultMap = userService.loginCheck(userId, userPw);
			boolean loginCheck = (boolean) loginResultMap.get("loginCheck");
			if(loginCheck) {
				// 로그인 성공한 경우 세션에 정보 저장
				User userInfo = (User) loginResultMap.get("userInfo");
				String userLevel = userInfo.getUserLevel();
				String userName = userInfo.getUserName();
				session.setAttribute("SID", 	userId);
				session.setAttribute("SLEVEL", 	userLevel);
				session.setAttribute("SNAME", 	userName);
				
				// 체크박스가 선택된 경우 쿠키 생성
		        if (autoLogin) {
				Cookie cookie = new Cookie("autoLogin", "true");
	            cookie.setPath("/");
	            cookie.setMaxAge(60*60*24*7); //60초 * 60분 * 24시간 * 7일
	            response.addCookie(cookie);
		    }
				redirect = "redirect:/";
			}else {
				// 로그인 실패한 경우
			    session.invalidate();  // 세션 초기화
				reAttr.addAttribute("result", "일치하는 회원의 정보가 없습니다.");
				
			}
			
			return redirect;
		}
		
		
		@GetMapping("/login")
		public String login( Model model
							,@RequestParam(name = "result", required = false) String result) {
			
			model.addAttribute("title", "로그인");
			if(result != null) model.addAttribute("result", result);

			return "common/login";
		}
		
		
		@GetMapping("/forgot-password")
		public String forgotPassword(Model model) {
			
			return "common/forgot-password";
		}
		@GetMapping("/password-reset")
		public String PasswordReset(Model model) {
			
			return "common/password-reset";
		}
}
