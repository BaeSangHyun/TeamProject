package controller;

import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

import dao.Session;

public class Controller {

    private static UserService userService = UserServiceImpl.getInstance();

    public static void main(String[] args) {
        /*
        조 소개 > 주제 소개 > 주제 선정 배경 > 프로그램 구조 > 시연
        발표자 1명, 도우미 1명

        Controller : 메뉴 선택
        Service : 메뉴 기능 수행
        Dao(Data Access Object) : 데이터베이스 접속
        VO(Value Object) : 데이터를 담는 클래스

        VO의 장점 : 무엇이 저장되어 있는지 쉽게 알 수 있다.
        HashMap의 장점 : 클래스를 많이 만들 필요가 없다.
         */
        new Controller().begin();
        
    }

    private void begin(){
        Scanner s = new Scanner(System.in);
        
        int menu;
        if(Session.loginUser == null){
        	do{
                System.out.println("-------------------- 메뉴 --------------------");
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("3. 시험목록");
                System.out.println("0. 프로그램 종료");
                System.out.println("----------------------------------------------");
                System.out.print("메뉴에 해당하는 번호 입력 >");

                menu = Integer.parseInt(s.nextLine());

                switch (menu){
                    case 1: //회원가입
                        userService.join();
                        break;
                    case 2: //로그인
                        userService.login();
                        begin();
                        break;
                    case 3: //시험목록
                        break;
                    case 0: //프로그램 종료
                        System.out.println("프로그램 종료");
                        System.exit(0); //프로그램 종료 메서드
                        break;
                }
            }while(menu != 0);
        } else {
        	if(Session.userRank.equals("user")){
        		System.out.println("-------------------- 시작 --------------------");
                System.out.println("1. 시험목록");
                System.out.println("2. 마이페이지");
                System.out.println("0. 프로그램 종료");
                System.out.println("----------------------------------------------");
                System.out.print("메뉴에 해당하는 번호 입력 >");

                menu = Integer.parseInt(s.nextLine());

                switch (menu){
                    case 1: //회원가입
                        userService.join();
                        break;
                    case 2: //로그인
                        userService.login();
                        break;
                    case 3: //시험목록
                        break;
                    case 0: //프로그램 종료
                        System.out.println("프로그램 종료");
                        System.exit(0); //프로그램 종료 메서드
                        break;
                }
        	} else if(Session.userRank.equals("admin")){
        		System.out.println("-------------------- 메뉴 --------------------");
                System.out.println("1. 시험목록");
                System.out.println("2. 관리자페이지");
                System.out.println("0. 프로그램 종료");
                System.out.println("----------------------------------------------");
                System.out.print("메뉴에 해당하는 번호 입력 >");

                menu = Integer.parseInt(s.nextLine());

                switch (menu){
                    case 1: //회원가입
                        userService.join();
                        break;
                    case 2: //로그인
                        userService.login();
                        break;
                    case 3: //시험목록
                        break;
                    case 0: //프로그램 종료
                        System.out.println("프로그램 종료");
                        System.exit(0); //프로그램 종료 메서드
                        break;
                }
        	}
        }
        
    }

    

}
