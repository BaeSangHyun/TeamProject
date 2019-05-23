package data;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BoardVO;
import vo.UserVO;

public class Database {
    private static Database instance;

    private Database(){}

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    //유저테이블
    public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();

    {
        UserVO user = new UserVO();
        user.setId("admin");
        user.setPwd("admin");
        user.setName("관리자");
        user.setRank("admin");
        tb_user.add(user);
    }
    
    
}
