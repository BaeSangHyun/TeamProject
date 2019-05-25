package service;

import java.util.Scanner;

import vo.MypageVO;
import vo.UserVO;
import controller.Controller;
import dao.MypageDao;
import dao.MypageDaoImpl;
import dao.Session;
import dao.UserDao;
import dao.UserDaoImpl;

public class MypageServiceImpl implements MypageService {

	private static MypageServiceImpl instance;
	
	private MypageServiceImpl(){};
	
	public static MypageServiceImpl getInstance(){
		if(instance == null){
			instance = new MypageServiceImpl();
		}
		return instance;
	}
	
	MypageDao mypageDao = MypageDaoImpl.getInstance();
	public MypageVO mypageVO = new MypageVO();
	UserVO user = new UserVO();
	UserDao userDao = UserDaoImpl.getInstance();
	
	Scanner s = new Scanner(System.in);
	@Override
	public void changePW() {
		System.out.println("비밀번호를 입력하세요.");
		String userPW = s.nextLine();
		
		if(userPW.equals(Session.loginUser.getPwd())){
			System.out.println("수정할 비밀번호를 입력하세요.");
			userPW = s.nextLine();
			user.setPwd(userPW);
			System.out.println("비밀번호가" + user.getPwd() + "로 변경되었습니다.");
		}
		
	}
	
	Controller controller = new Controller();
	@Override
	public void withdrawal() {
		System.out.println("비밀번호를 입력하세요.");
		String userPW = s.nextLine();
		
		if(userPW.equals(Session.loginUser.getPwd())){
			System.out.println("정말 탈퇴하시겠습니까?(Y/N)");
			String answer = s.nextLine();
			if(answer.equals("Y") || answer.equals("y")){
				userDao.deleteUser(Session.loginUser);
				Session.loginUser = null;
			}
		}
	}
}
