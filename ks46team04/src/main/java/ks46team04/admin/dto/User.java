package ks46team04.admin.dto;

public class User {
	
	private String userId;
	private String userLevel;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userPhone;
	private String userEmailAgree;
	private String userEmail;
	private String userAddr;
	private String userJoinDate;
	private String loginLogCode;
	private String logDateCalcul;
	private String userUpdateDate;
	private String activityStatusStandardCode;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmailAgree() {
		return userEmailAgree;
	}
	public void setUserEmailAgree(String userEmailAgree) {
		this.userEmailAgree = userEmailAgree;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public String getLoginLogCode() {
		return loginLogCode;
	}
	public void setLoginLogCode(String loginLogCode) {
		this.loginLogCode = loginLogCode;
	}
	public String getLogDateCalcul() {
		return logDateCalcul;
	}
	public void setLogDateCalcul(String logDateCalcul) {
		this.logDateCalcul = logDateCalcul;
	}
	public String getUserUpdateDate() {
		return userUpdateDate;
	}
	public void setUserUpdateDate(String userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}
	public String getActivityStatusStandardCode() {
		return activityStatusStandardCode;
	}
	public void setActivityStatusStandardCode(String activityStatusStandardCode) {
		this.activityStatusStandardCode = activityStatusStandardCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userLevel=");
		builder.append(userLevel);
		builder.append(", userPw=");
		builder.append(userPw);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userBirth=");
		builder.append(userBirth);
		builder.append(", userPhone=");
		builder.append(userPhone);
		builder.append(", userEmailAgree=");
		builder.append(userEmailAgree);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userAddr=");
		builder.append(userAddr);
		builder.append(", userJoinDate=");
		builder.append(userJoinDate);
		builder.append(", loginLogCode=");
		builder.append(loginLogCode);
		builder.append(", logDateCalcul=");
		builder.append(logDateCalcul);
		builder.append(", userUpdateDate=");
		builder.append(userUpdateDate);
		builder.append(", activityStatusStandardCode=");
		builder.append(activityStatusStandardCode);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
		
}
