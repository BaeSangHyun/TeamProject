package dao;

import vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserDao {
    //단일회원 조회
    UserVO selectUser(String key, String value);

    //다수조건 회원 조회
    UserVO selectUser(HashMap<String, String> param);

    //회원 삽입
    void insertUser(UserVO user);

    //전체 회원 조회
    ArrayList<UserVO> selectUserList();
    
    //회원 삭제
    void deleteUser(UserVO user);
    
    //id체크
	boolean checkUserId(HashMap<String, String> param);
}
