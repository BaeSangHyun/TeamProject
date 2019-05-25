package dao;

import vo.UserVO;

public interface MypageDao {
	//단일회원 조회
	UserVO selectUser(String key, String value);
	
	
}
