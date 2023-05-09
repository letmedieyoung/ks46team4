package ks46team04.admin.dto;

public class NoticeBoard {
	private String noticeBoardCode;
	private String noticeBoardTitle;
	private String noticeBoardContent;
	private String noticeBoardRegId;
	private String noticeBoardRegDate;
	private String noticeBoardUpdId;
	private String noticeBoardUpdDate;
	public String getNoticeBoardCode() {
		return noticeBoardCode;
	}
	public void setNoticeBoardCode(String noticeBoardCode) {
		this.noticeBoardCode = noticeBoardCode;
	}
	public String getNoticeBoardTitle() {
		return noticeBoardTitle;
	}
	public void setNoticeBoardTitle(String noticeBoardTitle) {
		this.noticeBoardTitle = noticeBoardTitle;
	}
	public String getNoticeBoardContent() {
		return noticeBoardContent;
	}
	public void setNoticeBoardContent(String noticeBoardContent) {
		this.noticeBoardContent = noticeBoardContent;
	}
	public String getNoticeBoardRegId() {
		return noticeBoardRegId;
	}
	public void setNoticeBoardRegId(String noticeBoardRegId) {
		this.noticeBoardRegId = noticeBoardRegId;
	}
	public String getNoticeBoardRegDate() {
		return noticeBoardRegDate;
	}
	public void setNoticeBoardRegDate(String noticeBoardRegDate) {
		this.noticeBoardRegDate = noticeBoardRegDate;
	}
	public String getNoticeBoardUpdId() {
		return noticeBoardUpdId;
	}
	public void setNoticeBoardUpdId(String noticeBoardUpdId) {
		this.noticeBoardUpdId = noticeBoardUpdId;
	}
	public String getNoticeBoardUpdDate() {
		return noticeBoardUpdDate;
	}
	public void setNoticeBoardUpdDate(String noticeBoardUpdDate) {
		this.noticeBoardUpdDate = noticeBoardUpdDate;
	}
	@Override
	public String toString() {
		return "NoticeBoard [noticeBoardCode=" + noticeBoardCode + ", noticeBoardTitle=" + noticeBoardTitle
				+ ", noticeBoardContent=" + noticeBoardContent + ", noticeBoardRegId=" + noticeBoardRegId
				+ ", noticeBoardRegDate=" + noticeBoardRegDate + ", noticeBoardUpdId=" + noticeBoardUpdId
				+ ", noticeBoardUpdDate=" + noticeBoardUpdDate + "]";
	}
	
}
