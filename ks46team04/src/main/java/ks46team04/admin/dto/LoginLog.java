package ks46team04.admin.dto;

import java.time.LocalDateTime;

public class LoginLog {
	private String LoginLogCode;
	private String UserId;
	private LocalDateTime LoginTime;
	private LocalDateTime LogoutTime;
	private String LoginIp;

	public LoginLog(String loginLogCode, String userId, LocalDateTime loginTime, LocalDateTime logoutTime,
			String loginIp) {
		this.LoginLogCode = loginLogCode;
		this.UserId = userId;
		this.LoginTime = loginTime;
		this.LogoutTime = logoutTime;
		this.LoginIp = loginIp;
	}


	public String getLoginLogCode() {
		return LoginLogCode;
	}


	public void setLoginLogCode(String loginLogCode) {
		LoginLogCode = loginLogCode;
	}


	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public LocalDateTime getLoginTime() {
		return LoginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		LoginTime = loginTime;
	}

	public LocalDateTime getLogoutTime() {
		return LogoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		LogoutTime = logoutTime;
	}

	public String getLoginIp() {
		return LoginIp;
	}

	public void setLoginIp(String loginIp) {
		LoginIp = loginIp;
	}

	public static void insertLoginLog(LoginLog loginLog) {
		// 로그인 로그를 DB에 저장하는 로직 구현
	}

	public static void updateLogoutLog(LoginLog loginLog) {
		// 로그아웃 로그를 DB에 저장하는 로직 구현
	}


	@Override
	public String toString() {
		return "LoginLog [LoginLogCode=" + LoginLogCode + ", UserId=" + UserId + ", LoginTime=" + LoginTime
				+ ", LogoutTime=" + LogoutTime + ", LoginIp=" + LoginIp + "]";
	}



}