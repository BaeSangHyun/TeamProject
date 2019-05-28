package controller;

import java.util.Scanner;

import service.UserService;
import service.UserServiceImpl;
import dao.Session;

public class Controller {
	//서비스
    private static UserService userService  = UserServiceImpl.getInstance();
    //컨트롤러
    private BoardController boardController = new BoardController();
    private CertificateController certificateController = new CertificateController();
    private CategoryController categoryController = new CategoryController();
    private MypageController mypageController = new MypageController();
    private AnnounceController announceController = new AnnounceController();
    private CategoryManageController categoryManageController = new CategoryManageController();

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

	void begin(){
		Scanner s = new Scanner(System.in);
        int menu=1;
        do{
            if(Session.loginUser == null){
        		System.out.println();
        		System.out.println("	┌──────────┐");
        		System.out.println(" 	  ♡ Q_net	");
       			System.out.println("	└──────────┘");
       			System.out.println("	  /)_ /) 	");
        		System.out.println("  	 ( ⊼⌔⊼ ) 	");
        		System.out.println("  	 /      づ	");
        		System.out.println("메뉴에 해당하는 번호를 입력하시면 됩니다♥");
        		System.out.println();
    			System.out.println("---------------------------------");
    			System.out.println("1. 회원가입");
    			System.out.println("2. 로그인");
    			System.out.println("3. 기술 자격시험 안내 & 접수");
    			System.out.println("4. 합격자 & 답안 발표");
    			System.out.println("5. 고객지원");
    			System.out.println("6. 자격증 발급 및 확인");
    			System.out.println("0. 종료하기");
    			System.out.println("---------------------------------");
    			menu = Integer.parseInt(s.nextLine());


                switch (menu){
                    case 1: //회원가입
                        userService.join();
                        break;
                    case 2: //로그인
                        userService.login();
                        if(Session.loginUser != null){
                            break;
                        }
                        break;
                    case 3: //기술 자격시험 안내 & 접수
                        categoryController.mainCategoryList();
                        break;
                    case 4: //합격자 & 답안 발표
                    	announceController.announce();
                    	break;
                    case 5: //고객지원
                    	boardController.support();
                    	break;
                    case 6: //자격증 발급 및 확인
                        userService.login();
                        if(Session.loginUser == null){
                            break;
                        }
                    	certificateController.getCertificate();
                    	break;
                    case 0: //프로그램 종료
                        System.out.println("프로그램 종료");
                        System.exit(0); //프로그램 종료 메서드
                        break;
                    default :
                    	break;
                }
           
	        } else {
	        	if(Session.userRank.equals("user")){
	        		System.out.println("--------------Q_net--------------");
	                System.out.println("1. 마이페이지");
	                System.out.println("2. 로그아웃");
	                System.out.println("3. 기술 자격시험 안내 & 접수");
	                System.out.println("4. 합격자 & 답안 발표");
	    			System.out.println("5. 고객지원");
	    			System.out.println("6. 자격증 발급 및 확인");
	    			System.out.println("0. 종료하기");
	    			System.out.println("---------------------------------");
	                System.out.print("메뉴에 해당하는 번호 입력 >");
	                
	                menu = Integer.parseInt(s.nextLine());
	                
	                switch (menu){
	                    case 1: //마이페이지
	                    	mypageController.info();
	                        break;
	                    case 2: //로그아웃
	                    	Session.loginUser = null;
	                        break;
	                    case 3: //기술 자격시험 안내 & 접수
	                    	categoryController.mainCategoryList();
	//                        CategorySearch<CategoryController> categorySearch = new CategorySearch<CategoryController>();
	//                        categorySearch.set(categoryController);
	//                        categorySearch.mainCategoryList();
	                        break;
	                    case 4: //합격자 & 답안 발표
	                    	announceController.announce();
	                        break;
	                    case 5: //고객지원
	                    	boardController.support();
	                        break;
	                    case 6: //자격증 발급 및 확인
	                    	certificateController.getCertificate();
	                    	break;
	                    case 0: //프로그램 종료
	                        System.out.println("프로그램 종료");
	                        System.exit(0); //프로그램 종료 메서드
	                        break;
	                    default :
	                    	break;
	                }
                } else if(Session.userRank.equals("admin")){
                    System.out.println("--------관리자 페이지 입니다----------");
                    System.out.println("1. 회원목록");
                    System.out.println("2. 로그아웃");
                    System.out.println("3. 기술 자격시험 안내 & 접수");
                    System.out.println("4. 합격자 & 답안 발표");
                    System.out.println("5. 고객지원");
                    System.out.println("6. 자격증 발급 및 확인");
                    System.out.println("0. 종료하기");
                    System.out.println("---------------------------------");
                    System.out.print("메뉴에 해당하는 번호 입력 >");

                    menu = Integer.parseInt(s.nextLine());

                    switch (menu){
                        case 1: //회원목록
                        	userService.getUserList();
                            break;
                        case 2: //로그아웃
                        	Session.loginUser = null;
                            break;
                        case 3: //기술 자격시험 안내 & 접수
                            categoryManageController.mainCategoryList();
    //                        CategorySearch<CategoryController> categorySearch = new CategorySearch<CategoryController>();
    //                        categorySearch.set(categoryController);
    //                        categorySearch.mainCategoryList();
                            break;
                        case 4: //합격자 & 답안 발표
                        	announceController.announce();
                        	break;
                        case 5: //고객지원
                            boardController.support();
                            break;
                        case 6: //자격증 발급 및 확인
                            certificateController.CertificateManage();
                            break;
                        case 0: //프로그램 종료
                            System.out.println("프로그램 종료");
                            System.exit(0); //프로그램 종료 메서드
                            break;
                        default :
                        	break;
                    }
                }
            }
        }while(menu != 0);
    }
}
