package controller;

import java.util.Scanner;

import service.MypageService;
import service.MypageServiceImpl;
import vo.UserVO;
import dao.Session;

public class MypageController {

	private static MypageService mypageService = MypageServiceImpl.getInstance();
	private static Controller controller = new Controller();
	UserVO user = new UserVO();
	Session session = new Session();
	
	int menu;
	Scanner s = new Scanner(System.in);
	public void info(){
		System.out.println();
		System.out.println("----------마이페이지----------");
		System.out.println("1. 원서접수내역");
		System.out.println("2. 시험결과보기");
		System.out.println("3. 자격증발급내역");
		System.out.println("4. 개인정보관리");
		System.out.println("0. 뒤로가기");
		System.out.println("----------------------------");
		System.out.print("숫자입력>");
		menu = Integer.parseInt(s.nextLine());
		
		switch(menu){
		case 1: 
			viewApplyList();
			info();
			break;
		case 2: 
			viewResult();
			info();
			break;
		case 3:
			viewIssueList();
			info();
			break;
		case 4:
			viewManageList();
			break;
		case 0:
			break;
		}
		
	}
	private void viewIssueList() {
		do{
			System.out.println();
			System.out.println("──────────────────────────자격증발급내역─────────────────────────");
			System.out.println("|	번호	||	자격명(종목명)	||	신청일자	||	발급진행상태	|");
			System.out.println("─────────────────────────────────────────────────────────────");
			System.out.println("0. 뒤로가기");			
		}while(menu!=0);
	}
	
	private void viewResult() {
		do{
			System.out.println();
			System.out.println("───────────────────────────시험결과보기──────────────────────────");
			System.out.println("|	시험명	||	종목명	||	수험번호	||	시험결과	|");
			System.out.println("──────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.println(user.getName()+"님의 ");		
			System.out.println("0. 뒤로가기");			
		}while(menu!=0);
		
	}

	private void viewApplyList() {
		do{
			System.out.println();
			System.out.println("─────────────────────원서접수내역──────────────────────");
			System.out.println("|	시험일자	||	시험명	||	종목명	||	수험번호	|");
			System.out.println("────────────────────────────────────────────────────");
			System.out.println();
			System.out.println("────────────────────────────────────────────────────");		
			System.out.println("0. 뒤로가기");			
		}while(menu!=0);
			
	}

	private void viewManageList() {
		do{
			System.out.println();
			System.out.println("─────────────────────개인정보관리─────────────────────");
			System.out.println("1. 비밀번호변경");
			System.out.println("2. 회원탈퇴");
			System.out.println("0. 뒤로가기");
			System.out.println("───────────────────────────────────────────────────");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			case 1:
				mypageService.changePW();
				break;
			case 2: 
				mypageService.withdrawal();
				controller.begin();
				break;
			case 0:
				info();
				break;
			}
					
		}while(menu!=0);
	}


}
