package ks46team04.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

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
	@Autowired
	private DataSource dataSource;


	public UserService() {
	}

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserService(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	 

	public List<User> getUserDetailList(String userId) {

		List<User> userDetailList = userMapper.getUserDetailList(userId);

		return userDetailList;
	}

	public Map<String, Object> loginCheck(String userId, String userPw) {
		Map<String, Object> loginResultMap = new HashMap<String, Object>();
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
		return loginResultMap;
	}

	/*
	 * public void insertLoginLog(LoginLog loginLog) {
	 * 
	 * userMapper.insertLoginLog(loginLog); }
	 */

	
	public String insertLoginLog(LoginLog loginLog) {
	    userMapper.insertLoginLog(loginLog);
	    return loginLog.getLoginLogCode();
	}

	//public void updateLogoutLog(LoginLog loginLog) {
		//userMapper.updateLogoutLog(loginLog);
	//}
	
	
	//public LoginLog updateLogoutLog(LoginLog loginLog) {
	    //userMapper.updateLogoutLog(loginLog);
	    //return loginLog;
	//}
	
	public void updateLogoutLog(LoginLog loginLog) {
	    String loginLogCode = loginLog.getLoginLogCode();
	    if (loginLogCode != null) {
	        userMapper.updateLogoutLog(loginLog);
	    } else {
	       
	        System.out.println("loginLogCode is null!");
	    }
	}
	
	/*
	 * public void updateLogoutLog(LoginLog loginLog) { // 자동으로 생성된 로그인 로그 코드 값을
	 * 가져오는 SQL String sql =
	 * "INSERT INTO login_log (user_id, login_time, logout_time, login_ip) VALUES (?, ?, ?, ?)"
	 * ; try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt
	 * = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	 * pstmt.setString(1, loginLog.getUserId()); pstmt.setObject(2,
	 * loginLog.getLoginTime()); pstmt.setObject(3, loginLog.getLogoutTime());
	 * pstmt.setString(4, loginLog.getLoginIp()); pstmt.executeUpdate(); // 자동 생성된
	 * 로그인 로그 코드 값을 가져와서 LoginLog 객체에 설정 try (ResultSet rs =
	 * pstmt.getGeneratedKeys()) { if (rs.next()) { String loginLogCode =
	 * rs.getString(1); loginLog.setLoginLogCode(loginLogCode); // 자동 생성된 로그인 로그 코드
	 * 값을 LoginLog 객체에 설정 } } } catch (SQLException e) { e.printStackTrace(); } }
	 */
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

	public List<User> getUserList(String searchKey, String searchValue) {
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
		List<User> userList = userMapper.getUserList(searchKey, searchValue);

		return userList;
	}

}