package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.ApplyStatusVO;
import vo.CandidateVO;
import vo.MypageVO;
import data.Database;

public class CertificateDaoImpl implements CertificateDao {
	
	private static CertificateDaoImpl instance;

    private CertificateDaoImpl(){}

    public static CertificateDaoImpl getInstance(){
        if(instance == null){
            instance = new CertificateDaoImpl();
        }
        return instance;
    }
    
//    BoardDB db = BoardDB.getInstance();
    Database database = Database.getInstance();
    MypageDao mypageDao = MypageDaoImpl.getInstance();
	Scanner s = new Scanner(System.in);

	@Override
	public List<CandidateVO> getConfirmPassList() {
		return mypageDao.viewResult(Session.loginUser.getId());
	}


	@Override
    public List<CandidateVO> getCertificate(){
    	return mypageDao.viewResult(Session.loginUser.getId());
		
//    	ApplyStatusVO applyStatus = null;
//    	CandidateVO candidate = null;
//
//    	for(int i = 0; i < database.tb_applyStatusList.size(); i++){
//    		applyStatus = database.tb_applyStatusList.get(i);
//    	}
//    	for(int i = 0; i < database.tb_candidate.size(); i++){
//    		candidate = database.tb_candidate.get(i);
//    	}
//
//    	System.out.println();
//		System.out.println("───────────────────────────시험결과보기──────────────────────────");
//		System.out.println("|	시험명	||		종목명		||	  수험번호 	||	 시험결과	  |");
//		System.out.println("──────────────────────────────────────────────────────────────");
//
//		List<CandidateVO> resultList = mypageDao.viewResult(Session.loginUser.getId());
//		for(int i =0; i<resultList.size(); i++) {
//			System.out.println("|	"+resultList.get(i).getTurn()+"	||	"+"종목명"+"	||	"+"수험번호"+"	|| "+resultList.get(i).getPassStatus()+" |");
//		}
//
//		while(true){
//
//			System.out.println();
//			System.out.println("1. 신청하기 ");
//			System.out.println("0. 뒤로가기");
//
//			int choice = Integer.parseInt(s.nextLine());
//
//			if(choice == 1){
//				if(applyStatus.getExamType().equals("실기") && candidate.getPassStatus().equals("합격")){
//					System.out.println("신청이 완료되었습니다.");
//				}else{
//					System.out.println("자격요건이 맞지 않아 신청할 수 없습니다.");
//				}
//			}else if (choice == 0){
//				break;
//			}else{
//				System.out.println("잘못된 입력입니다.");
//				System.out.println("다시 입력해주세요.");
//			}
//		}
//    	return null;
    }


	//자격증발급내역 조회
	@Override
	public ArrayList<MypageVO> viewCertificateList() {
		
		return null;
	}

}
