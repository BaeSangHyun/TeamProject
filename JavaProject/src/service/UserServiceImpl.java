package service;

import dao.Session;
import dao.UserDao;
import dao.UserDaoImpl;
import vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserServiceImpl implements UserService{

    private static UserServiceImpl instance;

    private UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }
    
    Scanner s = new Scanner(System.in);
    UserDao userDao = UserDaoImpl.getInstance();

    //회원가입
    @Override
    public void join() {
        
        System.out.println("┌────────────────────┐");
        System.out.println("   Q_net ★회원가입★	");
        System.out.println("└────────────────────┘"); 
        
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String pwd = s.nextLine();
        System.out.print("이름 : ");
        String name = s.nextLine();
        System.out.print("전화번호 : ");
        String tel = s.nextLine();

        UserVO user = new UserVO();
        user.setId(id);
        user.setPwd(pwd);
        user.setName(name);
        user.setRank("user");
        user.setTel(tel);

        UserVO userCheck = userDao.selectUser("ID", user.getId());

        if(userCheck == null){
            userDao.insertUser(user);
            System.out.println("가입해주셔서 감사합니다.");
        } else {
            System.out.println("아이디가 중복되었습니다.");
        }
    }

    //로그인
    @Override
    public void login() {
        
        System.out.println("┌────────────────────┐");
        System.out.println("    Q_net ★로그인★	  ");
        System.out.println("└────────────────────┘");     
        
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String pwd = s.nextLine();

        HashMap<String,String> param = new HashMap<String, String>();
        param.put("ID", id);
        param.put("PASSWORD", pwd);

        
        //id체크
        boolean flag = userDao.checkUserId(param);
        if(!flag) {
        	System.out.println("아이디가 존재하지 않습니다.");
        }else{
        	UserVO user = userDao.selectUser(param);
        	if(user == null){
        		System.out.println("비밀번호를 잘못 입력하셨습니다.");
        	} else {
        		Session.loginUser = user;
        		Session.userRank = user.getRank();
        		System.out.println("로그인 성공!!");
        		System.out.println(user.getName() + "님 환영합니다♡");
        	}     	
        }
    }

    //회원목록
    @Override
    public void userList() {
        ArrayList<UserVO> userList = userDao.selectUserList();

        System.out.println("-------------Q_net 회원 목록--------------");
        System.out.println();
        System.out.println("번호\t아이디\t이름");
        System.out.println();
        System.out.println("---------------------------------------");
        for(int i = 0; i < userList.size(); i++){
            UserVO user = userList.get(i);
            System.out.println(i + 1 + "\t" + user.getId() + "\t" + user.getName());
        }
        System.out.println("---------------------------------------");
    }

    //로그아웃
	@Override
	public void logout() {
		Session.loginUser = null;
	}
}
