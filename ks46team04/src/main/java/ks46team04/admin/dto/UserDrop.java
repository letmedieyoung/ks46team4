package ks46team04.admin.dto;

public class UserDrop {
	private String userId;
	private String userDropDate;
	private String activityStatusStandardCode;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserDropDate() {
		return userDropDate;
	}
	public void setUserDropDate(String userDropDate) {
		this.userDropDate = userDropDate;
	}
	public String getActivityStatusStandardCode() {
		return activityStatusStandardCode;
	}
	public void setActivityStatusStandardCode(String activityStatusStandardCode) {
		this.activityStatusStandardCode = activityStatusStandardCode;
	}
	
	@Override
	public String toString() {
		return "UserDrop [userId=" + userId + ", userDropDate=" + userDropDate + ", activityStatusStandardCode="
				+ activityStatusStandardCode + "]";
	}
}
