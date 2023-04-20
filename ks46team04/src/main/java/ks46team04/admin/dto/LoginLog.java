package ks46team04.admin.dto;

public class LoginLog {
	private String LoginLogCode;
	private String UserId;
	private String LoginTime;
	private String LogoutTime;
	private String LoginIp;
	
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
	public String getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(String loginTime) {
		LoginTime = loginTime;
	}
	public String getLogoutTime() {
		return LogoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		LogoutTime = logoutTime;
	}
	public String getLoginIp() {
		return LoginIp;
	}
	public void setLoginIp(String loginIp) {
		LoginIp = loginIp;
	}
	@Override
	public String toString() {
		return "LoginLog [LoginLogCode=" + LoginLogCode + ", UserId=" + UserId + ", LoginTime=" + LoginTime
				+ ", LogoutTime=" + LogoutTime + ", LoginIp=" + LoginIp + "]";
	}
	

	
	
	
}
