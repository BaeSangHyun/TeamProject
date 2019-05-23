package controller;

import java.util.Scanner;

import dao.Session;
import service.BoardService;
import service.BoardServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class BoardController {
	
	private static BoardService boardService = BoardServiceImpl.getInstance();
	private static UserService userService = UserServiceImpl.getInstance();
	
	public BoardStatusController boardStatusController = new BoardStatusController();
	
	Session session = new Session();
	
	int menu;
	public void info(){
		Scanner s = new Scanner(System.in);
		System.out.println("-----------고객 지원------------");
		System.out.println("1. 공지사항");
		System.out.println("2. FAQ");
		System.out.println("3. 고객 참여 게시판");
		System.out.println("0. 뒤로가기");
		System.out.println("------------------------------");
		System.out.print("숫자 입력>");
		menu = Integer.parseInt(s.nextLine());
		
		switch(menu){
		case 1:
			break;
		case 2:
			break;
		case 3:
			if(session.loginUser == null){
				System.out.println("로그인 해주세요.");
				userService.login();
				
				if(session.loginUser != null){
					boardStatusController.viewStatus("Customer");
				}
				break;
			}
			boardStatusController.viewStatus("Customer");
			break;
		case 0:
			break;
		
		}
		
	}
}
