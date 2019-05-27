package service;

import java.util.List;
import java.util.Scanner;

import vo.CandidateVO;
import dao.MypageDao;
import dao.MypageDaoImpl;
import dao.Session;


public class CertificateServiceImpl implements CertificateService{

	private static CertificateServiceImpl instance;
	
	private CertificateServiceImpl(){}
	
	public static CertificateServiceImpl getInstance(){
		if(instance == null){
			instance = new CertificateServiceImpl();
		}
		return instance;
	}

	MypageService myPageService = MypageServiceImpl.getInstance();
	MypageDao mypageDao = MypageDaoImpl.getInstance();
	Scanner s = new Scanner(System.in);
	
	@Override
	public void getCertificate() {
		//myPageService.viewResult(Session.loginUser.getId());
		System.out.println();
		System.out.println("───────────────────────────시험결과보기──────────────────────────");
		System.out.println("|	시험명	||		종목명		||	  수험번호 	||	 시험결과	  |");
		System.out.println("──────────────────────────────────────────────────────────────");

		List<CandidateVO> resultList = mypageDao.viewResult(Session.loginUser.getId());
		for(int i =0; i<resultList.size(); i++) {
			System.out.println("|	"+resultList.get(i).getTurn()+"	||	"+"종목명"+"	||	"+"수험번호"+"	|| "+resultList.get(i).getPassStatus()+" |");
		} 
		
		
		while(true){
			
			System.out.println();
			System.out.println("1. 신청하기 ");
			System.out.println("2. 취소하기 ");
			System.out.println("0. 뒤로가기");		
			
			int choice = Integer.parseInt(s.nextLine());
			
			if(choice == 1){
				
				
			}else if(choice == 2){
				break;
			}else if (choice == 0){
				break;
			}else{
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
		
		
//		Scanner s = new Scanner(System.in);
//        int menu= 1;
//		System.out.println();
//		System.out.println("1.신청하기 ");
//		System.out.println("2.취소하기 ");
//		System.out.print("메뉴에 해당하는 번호 입력 >");
//		
//		 menu = Integer.parseInt(s.nextLine());
		
	}

	@Override
	public void issue() {
		//getLicense
		myPageService.viewIssueList(Session.loginUser.getId());
		
		
		
	}
	
}
