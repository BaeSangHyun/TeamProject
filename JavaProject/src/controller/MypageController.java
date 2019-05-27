package controller;

import java.util.Scanner;

import dao.Session;
import service.MypageService;
import service.MypageServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class MypageController {

	UserService userService = UserServiceImpl.getInstance();
	MypageService mypageService = MypageServiceImpl.getInstance();
	
	int menu;
	private String answer;
	Scanner s = new Scanner(System.in);
	
	
	public void info(){
		do{
			if(Session.loginUser == null) return;
			System.out.println();
			System.out.println("┌─────────────────────────마이페이지─────────────────────────┐");
			System.out.println("|                      1. 원서접수내역                            	  |");
			System.out.println("|                      2. 시험결과보기                        	   		|");
			System.out.println("|                      3. 자격증발급내역                      	     	|");
			System.out.println("|                      4. 개인정보관리                         	    	  |");
			System.out.println("|                      0. 뒤로가기                                	  |");
			System.out.println("└─────────────────────────────────────────────────────────┘");
			System.out.print("숫자입력>");
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			//원서접수내역
			case 1: 
				exucuteApplyList();
				break;
			//시험결과보기
			case 2: 
				executeResult();
				break;
			//자격증발급내역
			case 3:
				executeIssueList();
				break;
			//개인정보관리
			case 4:
				viewManageList();
				break;
			//뒤로가기
			case 0:
				break;
			}
		}while(menu != 0);
	}
	//접수내역조회로 이동
	private void exucuteApplyList() {
		mypageService.viewApplyList(Session.loginUser.getId());
		
	}
	//시험결과조회로 이동
	private void executeResult() {
		mypageService.viewResult(Session.loginUser.getId());
		
	}
	//자격증발급내역조회로 이동
	private void executeIssueList() {
		mypageService.viewIssueList(Session.loginUser.getId());
		
	}
	
	//개인정보관리
	private void viewManageList() {
		do{
			System.out.println();
			System.out.println("─────────────────────개인정보관리─────────────────────");
			System.out.println("|                  1. 비밀번호변경                 		       |");
			System.out.println("|                  2. 회원탈퇴                         		   |");
			System.out.println("|                  0. 뒤로가기                    	           |");
			System.out.println("───────────────────────────────────────────────────");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			case 1:
				mypageService.changePW();
				break;
			case 2: 
				mypageService.withdrawal();
				if(Session.loginUser == null) return;
				break;
			case 0:
				break;
			}
					
		}while(menu!=0);
	}
	
	
	
	
	void logout() {
		System.out.println("로그아웃 하시겠습니까?(Y/N)");
		answer = s.nextLine();
		
		if("Y".equals(answer) || "y".equals(answer)) {			
			userService.logout();
		}

	}


}
