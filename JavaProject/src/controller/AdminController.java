package controller;

import java.util.ArrayList;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;

public class AdminController {
	UserDao userDao = UserDaoImpl.getInstance();

	public void getUserList() {
		ArrayList<UserVO> userList = userDao.selectUserList();
		Scanner s = new Scanner(System.in);
		int num = 1;
		do{
			System.out.println();
			System.out.println("-------------------------회원목록-------------------------");
			System.out.println("|	계정유형	||	이름	||	ID	||	비밀번호	||	전화번호	|");
			System.out.println("--------------------------------------------------------");
			for(int i=0; i<userList.size(); i++){
				System.out.println(userList.get(i).getRank()+"\t"+userList.get(i).getName()+"\t"+userList.get(i).getPwd()+"\t"+userList.get(i).getTel());
			}
			System.out.println("0. 뒤로가기");
			System.out.println("----------------------------");
			System.out.print("숫자입력>");
			num = Integer.parseInt(s.nextLine());
		}while(num!=0);
		
		
	}

}
