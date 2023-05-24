package ks46team04.admin.constant;

public enum DeadlineCheck {
		CLOSED("closed", "마감완료"),
		WAITING("waiting", "마감대기중"),
		BEFORE_DEADLINE("before_deadline", "마감전");
	
	  private final String checkStr;
	  private final String replaceStr;
	  
	  private DeadlineCheck(String checkStr, String replaceStr) {
	  	this.checkStr = checkStr;
	    this.replaceStr = replaceStr;
	  }
	  
	  public String getCheck() {
	  	return checkStr;
	  }
	  
	  public String getReplace() {
	  	return replaceStr;
	  }
}
