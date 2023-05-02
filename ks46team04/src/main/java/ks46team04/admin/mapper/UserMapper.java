package ks46team04.admin.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;

import ks46team04.admin.dto.ActivityStatus;
import ks46team04.admin.dto.LoginLog;
import ks46team04.admin.dto.User;
import ks46team04.admin.dto.UserDrop;
import ks46team04.admin.dto.UserLevel;
import ks46team04.admin.dto.UserSleep;


@Mapper
public interface UserMapper {
	
	// 회원 탈퇴
	public int removeUserById(String userId);
	// 회원수정
	public int modifyUser(User user);
	// 특정회원조회
	public User getUserInfoById(String userId);
	// 회원가입
	public int addUser(User user);
	// 회원아이디 중복체크
	public boolean idCheck(String userId);
	// 회원의 목록 조회
	public List<User> getUserList(String searchKey, String searchValue);
	// 회원의 목록 상세 조회
	public List<User> getUserDetailList(String userId);
	// 회원 등급 조회
	public List<UserLevel> getUserLevelList();
	// 회원 활동상태 조회
	public List<ActivityStatus> getActivityStatusList();
	// 회원 로그인 기록 조회
	public List<LoginLog> getLoginLogList();
	// 휴면 회원 목록 조회
	public List<UserSleep> getUserSleepList();
	// 탈퇴 회원 목록 조회
	public List<UserDrop> getUserDropList();
}
