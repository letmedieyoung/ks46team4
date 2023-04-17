package ks46team04.admin.dto;

public class UserLevel {

	private String userLevel;
	private String userLevelName;

public String getUserLevel() {
	return userLevel;
}
public void setUserLevel(String userLevel) {
	this.userLevel = userLevel;
}

public String getUserLevelName() {
	return userLevelName;
}
public void setUserLevelName(String userLevelName) {
	this.userLevelName = userLevelName;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("User [userLevel=");
	builder.append(userLevel);
	builder.append(", userLevelName=");
	builder.append(userLevelName);
	builder.append("]");
	return builder.toString();
}


}