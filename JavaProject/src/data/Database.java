package data;

import java.util.ArrayList;
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
        user.setTel("010-4688-8949");
        tb_user.add(user);
        
        UserVO user2 = new UserVO();
        user2.setId("aaaa");
        user2.setPwd("1111");
        user2.setName("유저1");
        user2.setRank("user");
        user2.setTel("010-4688-8949");
        tb_user.add(user2);
        
        UserVO user3 = new UserVO();
        user3.setId("bbbb");
        user3.setPwd("2222");
        user3.setName("유저2");
        user3.setRank("user");
        user3.setTel("010-4688-8949");
        tb_user.add(user3);
        
        UserVO user4 = new UserVO();
        user4.setId("cccc");
        user4.setPwd("3333");
        user4.setName("유저3");
        user4.setRank("user");
        user4.setTel("010-4688-8949");
        tb_user.add(user4);
    }
    
    
}
