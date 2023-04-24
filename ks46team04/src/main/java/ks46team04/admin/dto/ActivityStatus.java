package ks46team04.admin.dto;

public class ActivityStatus {

	private String activityStatusStandardCode;
	private String activityStatusName;
	private String activityStatusStandardDate;
	private String activityStatusRegId;
	private String activityStatusRegDate;
	private String activityStatusUpdateId;
	private String activityStatusUpdateDate;
	
	public String getActivityStatusStandardCode() {
		return activityStatusStandardCode;
	}

	public void setActivityStatusStandardCode(String activityStatusStandardCode) {
		this.activityStatusStandardCode = activityStatusStandardCode;
	}

	public String getActivityStatusName() {
		return activityStatusName;
	}

	public void setActivityStatusName(String activityStatusName) {
		this.activityStatusName = activityStatusName;
	}

	public String getActivityStatusStandardDate() {
		return activityStatusStandardDate;
	}

	public void setActivityStatusStandardDate(String activityStatusStandardDate) {
		this.activityStatusStandardDate = activityStatusStandardDate;
	}

	public String getActivityStatusRegId() {
		return activityStatusRegId;
	}

	public void setActivityStatusRegId(String activityStatusRegId) {
		this.activityStatusRegId = activityStatusRegId;
	}

	public String getActivityStatusRegDate() {
		return activityStatusRegDate;
	}

	public void setActivityStatusRegDate(String activityStatusRegDate) {
		this.activityStatusRegDate = activityStatusRegDate;
	}

	public String getActivityStatusUpdateId() {
		return activityStatusUpdateId;
	}

	public void setActivityStatusUpdateId(String activityStatusUpdateId) {
		this.activityStatusUpdateId = activityStatusUpdateId;
	}

	public String getActivityStatusUpdateDate() {
		return activityStatusUpdateDate;
	}

	public void setActivityStatusUpdateDate(String activityStatusUpdateDate) {
		this.activityStatusUpdateDate = activityStatusUpdateDate;
	}

	@Override
	public String toString() {
		return "ActivityStatus [activityStatusStandardCode=" + activityStatusStandardCode + ", activityStatusName="
				+ activityStatusName + ", activityStatusStandardDate=" + activityStatusStandardDate
				+ ", activityStatusRegId=" + activityStatusRegId + ", activityStatusRegDate=" + activityStatusRegDate
				+ ", activityStatusUpdateId=" + activityStatusUpdateId + ", activityStatusUpdateDate="
				+ activityStatusUpdateDate + "]";
	}

	

	
}
