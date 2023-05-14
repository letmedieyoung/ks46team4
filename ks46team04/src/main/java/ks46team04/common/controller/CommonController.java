package ks46team04.common.controller;

import java.time.LocalDateTime;
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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks46team04.admin.dto.ActivityStatus;
import ks46team04.admin.dto.Funding;
import ks46team04.admin.dto.FundingDetail;
import ks46team04.admin.dto.LoginLog;
import ks46team04.admin.dto.User;
import ks46team04.admin.dto.UserLevel;
import ks46team04.admin.mapper.UserMapper;
import ks46team04.admin.service.FundingDetailService;
import ks46team04.admin.service.FundingService;
import ks46team04.admin.service.UserService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);

	private final FundingService fundingService;
	private final UserService userService;
	private final UserMapper userMapper;
	private final FundingDetailService fundingDetailService;

	public CommonController(UserService userService, UserMapper userMapper,
							FundingService fundingService, FundingDetailService fundingDetailService) {
		this.userService = userService;
		this.userMapper = userMapper;
		this.fundingService = fundingService;
		this.fundingDetailService = fundingDetailService;
	}

		@GetMapping("/funding_index")
		public String MainHome(Model model) {
			
			List<Funding> fundingList = fundingService.getFundingList();
			
			model.addAttribute("fundingList", fundingList);
			
			return "common/funding_index";
		}		
		
		@GetMapping("/list")
		public String getFundingList(Model model) {
			
			List<FundingDetail> fundingDetailList = fundingDetailService.getFundingDetailList();
				
			model.addAttribute("title", "펀딩");
			model.addAttribute("fundingDetailList", fundingDetailList);
			
			return "common/funding/list";
		}
		
		
		@PostMapping("/register")
		public String register(User user) {
			log.info("화면에서 전달받은 데이터 : {}", user);
			userService.addUser(user);
			return "redirect:/";
		}
		
		@PostMapping("/useridCheck")
		@ResponseBody
		public boolean useridCheck(@RequestParam(name = "userId") String userId) {
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
		public String logout(HttpSession session, @CookieValue(value = "autoLogin", required = false) Cookie cookie,
				HttpServletResponse response, HttpServletRequest request) {
			if (cookie != null) {
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

			// 세션에서 사용자 ID와 로그인 시간을 가져옴
			String userId = (String) session.getAttribute("SID");
			String loginLogCode = (String) session.getAttribute("loginLogCode");
			LocalDateTime loginTime = (LocalDateTime) session.getAttribute("loginTime");
			LocalDateTime loginTimeNow = LocalDateTime.now();
			String loginIp = (String) session.getAttribute("loginIp");
			// 로그아웃 로그를 DB에 저장
			LoginLog loginLog = new LoginLog(loginLogCode, userId, loginTime, loginTimeNow, loginIp);
			loginLog.setLoginLogCode(loginLogCode);
			loginLog.setUserId(userId);
			loginLog.setLoginTime(loginTime);
			loginLog.setLogoutTime(LocalDateTime.now());
			loginLog.setLoginIp(loginIp);
			
			userService.updateLogoutLog(loginLog);

			// 세션에서 사용자 정보를 제거
			session.invalidate();
			return "redirect:/";
			// return "redirect:/common/login";
		}

		@PostMapping("/login")
		public String login(@RequestParam(name = "userId") String userId, @RequestParam(name = "userPw") String userPw,
				@RequestParam(name = "autoLogin", defaultValue = "false") boolean autoLogin, HttpSession session,
				RedirectAttributes reAttr, HttpServletRequest request, HttpServletResponse response) {
			String redirect = "redirect:/common/login";
			Map<String, Object> loginResultMap = userService.loginCheck(userId, userPw);
			boolean loginCheck = (boolean) loginResultMap.get("loginCheck");
			if (loginCheck) {
				String loginLogCode = null; // loginLogCode 변수 미리 선언
				
				// 로그인 로그를 남기는 코드 추가
				LoginLog loginLog = new LoginLog(loginLogCode, userId, LocalDateTime.now(), null, request.getRemoteAddr());
				userService.insertLoginLog(loginLog);
				loginLogCode = loginLog.getLoginLogCode(); // loginLogCode 변수 값 할당
				// 로그인 성공한 경우 세션에 정보 저장
				User userInfo = (User) loginResultMap.get("userInfo");
				String userLevel = userInfo.getUserLevel();
				String userName = userInfo.getUserName();
				
				session.setAttribute("SID", userId);
				session.setAttribute("SLEVEL", userLevel);
				session.setAttribute("SNAME", userName);
				session.setAttribute("loginLogCode", loginLogCode);
				session.setAttribute("loginTime", LocalDateTime.now());
				session.setAttribute("loginIp", request.getRemoteAddr());
				
				// 체크박스가 선택된 경우 쿠키 생성
				if (autoLogin) {
					Cookie cookie = new Cookie("autoLogin", "true");
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 7); // 60초 * 60분 * 24시간 * 7일
					response.addCookie(cookie);
				}
				redirect = "redirect:/";
			} else {
				// 로그인 실패한 경우
				session.invalidate(); // 세션 초기화
				reAttr.addFlashAttribute("result", "일치하는 회원의 정보가 없습니다.");

			}

			return redirect;
		}

		@GetMapping("/login")
		public String login(Model model, @RequestParam(name = "result", required = false) String result) {

			model.addAttribute("title", "로그인");
			if (result != null)
				model.addAttribute("result", result);

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

