package ks46team04.admin.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks46team04.admin.dto.ActivityStatus;
import ks46team04.admin.dto.LoginLog;
import ks46team04.admin.dto.User;
import ks46team04.admin.dto.UserDrop;
import ks46team04.admin.dto.UserLevel;
import ks46team04.admin.dto.UserSleep;
import ks46team04.admin.mapper.UserMapper;

@Service
@Transactional

public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;


	public UserService() {
	}

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	

	public List<User> getUserDetailList(String userId) {

		List<User> userDetailList = userMapper.getUserDetailList(userId);

		return userDetailList;
	}

	/*
	 * public Map<String, Object> loginCheck(String userId, String userPw) {
	 * Map<String, Object> loginResultMap = new HashMap<String, Object>(); User user
	 * = userMapper.getUserInfoById(userId); boolean loginCheck = false; if (user !=
	 * null) { String checkPw = user.getUserPw(); if (userPw.equals(checkPw)) {
	 * loginCheck = true; loginResultMap.put("userInfo", user); } }
	 * loginResultMap.put("loginCheck", loginCheck); return loginResultMap; }
	 */

	public Map<String, Object> loginCheck(String userId, String userPw) {
		Map<String, Object> loginResultMap = new HashMap<String, Object>();
		try {
			User user = userMapper.getUserInfoById(userId);
			boolean loginCheck = false;
			if (user != null) {
				String checkPw = user.getUserPw();
				if (userPw.equals(checkPw)) {
					loginCheck = true;
					loginResultMap.put("userInfo", user);
				}
			}
			loginResultMap.put("loginCheck", loginCheck);
		} catch (Exception e) {
			// 예외 발생 시 로그 출력
			log.error("login: {}", e.getMessage());
			throw e;
		}
		return loginResultMap;
	}

	public String insertLoginLog(LoginLog loginLog) {
		userMapper.insertLoginLog(loginLog);
		return loginLog.getLoginLogCode();
	}

	public void updateLogoutLog(LoginLog loginLog) {
		String loginLogCode = loginLog.getLoginLogCode();
		if (loginLogCode != null) {
			userMapper.updateLogoutLog(loginLog);
		} else {

			System.out.println("loginLogCode is null!");
		}
	}

	/*
	 * public void removeUser(String userId, String userPw) { User userInfo =
	 * userMapper.getUserInfoById(userId); if (userInfo != null) { String checkPw =
	 * userInfo.getUserPw(); if (checkPw.equals(userPw)) {
	 * userMapper.removeUserById(userId); } } }
	 */

	/*
	 * public void removeUser(String userId, String userPw) { User userInfo =
	 * userMapper.getUserInfoById(userId); if (userInfo != null) { String checkPw =
	 * userInfo.getUserPw(); if (checkPw.equals(userPw)) {
	 * userMapper.removeUserById(userId); } } }
	 */
	public void removeUser(String userId) {
		userMapper.removeUserById(userId);
	}

	public boolean pwCheck(String userId, String userPw) {
		User userInfo = userMapper.getUserInfoById(userId);
		if (userInfo != null && userInfo.getUserPw().equals(userPw)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean modifyUser(User user) {
		return userMapper.modifyUser(user) > 0;
	}

	public User getUserInfoById(String userId) {
		User userInfo = userMapper.getUserInfoById(userId);
		log.info("userInfo: {}", userInfo);
		return userInfo;
	}

	public int addUser(User user) {
		int result = userMapper.addUser(user);

		return result;
	}

	public List<UserDrop> getUserDropList() {
		List<UserDrop> userDropList = userMapper.getUserDropList();

		return userDropList;
	}
	
	

	public List<UserSleep> getUserSleepList() {

		List<UserSleep> userSleepList = userMapper.getUserSleepList();

		return userSleepList;
	}

	public List<LoginLog> getLoginLogList(String userId) {
		List<LoginLog> loginLogList = userMapper.getLoginLogList(userId);

		return loginLogList;
	}

	public List<ActivityStatus> getActivityStatusList() {
		List<ActivityStatus> activityStatusList = userMapper.getActivityStatusList();

		return activityStatusList;
	}

	public List<UserLevel> getUserLevelList() {
		List<UserLevel> userLevelList = userMapper.getUserLevelList();

		return userLevelList;
	}

	/*
	 * public void updateLogDateCalcul(String userId) { Map<String, Object> paramMap
	 * = new HashMap<>(); paramMap.put("user_id", userId);
	 * userMapper.updateLogDateCalcul(userId); }
	 */

	/*
	 * public void updateLogDateCalcul(String userId) {
	 * userMapper.updateLogDateCalcul(userId); }
	 */

	public List<User> getUserListWithLogDateCalcul(String searchKey, String searchValue) {
		if (searchKey != null) {
			switch (searchKey) {
			case "userId":
				searchKey = "u.user_id";
				break;
			case "userName":
				searchKey = "u.user_name";
				break;
			default:
				searchKey = "u.user_email";
				break;
			}
		}
		List<User> userList = userMapper.getUserListWithLogDateCalcul(searchKey, searchValue);
		/*
		 * for (User user : userList) {
		 * user.setLogDateCalcul(Integer.toString(user.getLogDateCalcul())); }
		 */

		return userList;
	}
	
	      
	  
	/*
	 * public List<User> getUserList(String searchKey, String searchValue) { if
	 * (searchKey != null) { switch (searchKey) { case "userId": searchKey =
	 * "u.user_id"; break; case "userName": searchKey = "u.user_name"; break;
	 * default: searchKey = "u.user_email"; break; } } List<User> userList =
	 * userMapper.getUserList(searchKey, searchValue);
	 * 
	 * 
	 * return userList; }
	 */

}