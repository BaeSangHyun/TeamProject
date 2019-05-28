package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.ApplyStatusVO;
import vo.CandidateVO;
import vo.ExamNoVO;
import vo.MypageVO;
import controller.MypageController;
import dao.CategoryDaoImpl;
import dao.MypageDao;
import dao.MypageDaoImpl;
import dao.Session;
import dao.UserDao;
import dao.UserDaoImpl;

public class MypageServiceImpl implements MypageService {
	
	private static MypageServiceImpl instance;

    private MypageServiceImpl(){}

    public static MypageServiceImpl getInstance(){
        if(instance == null){
            instance = new MypageServiceImpl();
        }
        return instance;
    }

	MypageDao mypageDao = MypageDaoImpl.getInstance();
	UserDao userDao = new UserDaoImpl();	
	MypageService mypageService;
	MypageController mypageController;
	CategoryDaoImpl categoryDaoImpl = CategoryDaoImpl.getInstance();
	
	Scanner s = new Scanner(System.in);
	int menu;
	
	// 접수내역목록 조회
	public void viewApplyList(String loginId) {
		
		do{
			System.out.println();
			System.out.println("─────────────────────────────────────────────────────원서접수내역─────────────────────────────────────────────────────");
			System.out.println("|	시험일자		||		시험명		||	종목명		||	수험번호		||	접수상태	|");
			System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

			
			
			List<ApplyStatusVO> applyList = mypageDao.viewApplyList(loginId);
			
			
			
			
			for(int i=0; i<applyList.size(); i++) {
				System.out.println("|	"+applyList.get(i).getExamDate()+"	||	"
						+applyList.get(i).getTurn()+"("
						+applyList.get(i).getExamType()+")	||	"				 
						+getExamTitle(applyList.get(i).getCategoryNum())+"	||	"				 // 이거 시험명 가져와야대 여기서는 시험명만 가져오면돼 시험 코드 이용해서			 
						+applyList.get(i).getApplierNum()+"	||	"
						+applyList.get(i).getApplyStatus()+" |");				
			}
			
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

			System.out.println("0. 뒤로가기");	
			menu = Integer.parseInt(s.nextLine());
		}while(menu!=0);			
	}
	
	// 시험결과조회
	public void viewResult(String loginId) {
		do{
			System.out.println();
			System.out.println("───────────────────────────시험결과보기──────────────────────────");
			System.out.println("|	시험명 (turn+ExamType)	||		종목명(Title)		||	  수험번호(ApplierNum) 	||	 시험결과(PassStatus)	  |");
			System.out.println("──────────────────────────────────────────────────────────────");
	        
			ApplyStatusVO applyStatusVO = null;
	        List<ApplyStatusVO> applyList = mypageDao.viewApplyList(loginId);
	        for(int i=0; i<applyList.size(); i++){
	        	applyStatusVO = applyList.get(i);
	        	
	        	System.out.println(
	        			  "|"+applyStatusVO.getTurn()
	        			+ "|"+applyStatusVO.getExamType()
	        			+ "|"+getExamTitle(applyStatusVO.getCategoryNum())
	        			+ "|"+applyStatusVO.getApplierNum()
	        			+ "|"+getPassStatus(applyStatusVO.getId(), applyStatusVO.getCategoryNum())
	        			
	        			);	
	        }
			
			System.out.println("0. 뒤로가기");		
			menu = Integer.parseInt(s.nextLine());
		}while(menu!=0);			
		
	}
	
	
	//자격증발급내역
	public void viewIssueList(String loginId) {
		do{
			System.out.println();
			System.out.println("──────────────────────────자격증발급내역────────────────────────");
			System.out.println("|	번호		||	자격명(종목명)		||	신청일자	||	발급진행상태	|");
			System.out.println("─────────────────────────────────────────────────────────────");
			
			List<MypageVO> issueList = mypageDao.viewIssueList(loginId);
			
			for(int i = 0; i < issueList.size(); i++) {
				System.out.println("|	"+(i+1)+"	|	"+issueList.get(i).getTitle()+"	||	"+issueList.get(i).getIssueRequestDate()+"	||	"+issueList.get(i).getProgressStatus()+"	|");
			} 
			
			System.out.println("0. 뒤로가기");	
			menu = Integer.parseInt(s.nextLine());
		}while(menu!=0);
		
	}


	//비밀번호변경
	@Override
	public void changePW() {
		System.out.println("비밀번호를 입력하세요.");
		String userPW = s.nextLine();
		
		if(userPW.equals(Session.loginUser.getPwd())){
			System.out.println("수정할 비밀번호를 입력하세요.");
			userPW = s.nextLine();
			Session.loginUser.setPwd(userPW);
			System.out.println("비밀번호가" + Session.loginUser.getPwd() + "로 변경되었습니다.");
		}
		
	}
	
	
	//회원탈퇴
	@Override
	public void withdrawal() {
		System.out.println("비밀번호를 입력하세요.");
		String userPW = s.nextLine();
		
		if(userPW.equals(Session.loginUser.getPwd())){
			System.out.println("정말 탈퇴하시겠습니까?(Y/N)");
			String answer = s.nextLine();
			if("Y".equals(answer) || "y".equals(answer)){
				userDao.deleteUser(Session.loginUser);
				Session.loginUser = null;
			}
		}
	}

		
		
	//개인정보관리
	public void viewManageList() {
		do{
			System.out.println();
			System.out.println("─────────────────────개인정보관리─────────────────────");
			System.out.println("|                  1. 비밀번호변경                        |");
			System.out.println("|                  2. 회원탈퇴                            |");
			System.out.println("|                  0. 뒤로가기                            |");
			System.out.println("───────────────────────────────────────────────────");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			case 1:
				mypageService.changePW();
				break;
			case 2: 
				mypageService.withdrawal();
				break;
			case 0:
				mypageController.info();
				break;
			}
					
		}while(menu!=0);
	}
	
	
	/**
	 * 시험명 조회
	 * @param categoryNum
	 * @return
	 */
	public String getExamTitle(String categoryNum){
		
		String title = null;
		
		List<ExamNoVO> examNoVoList = mypageDao.getExamNoVOList();
		ExamNoVO examNoVO = null;
		
		for(int i=0; i<examNoVoList.size(); i++){
			examNoVO = examNoVoList.get(i);
			
			if(categoryNum.equals(examNoVO.getCategoryNum()))
			{
				title = examNoVO.getTitle();
				break;
			}
		}
    	
    	return title;
	}
	
	/**
	 * 시험결과 조회
	 * @param id
	 * @param categoryNum
	 * @return
	 */
	public String getPassStatus(String id, String categoryNum){
		String passStatus = null;
		
		List<CandidateVO> candidateVOList = mypageDao.viewResult(id);
		CandidateVO candidateVO = null;
		
		
		for(int i=0; i<candidateVOList.size(); i++){
			candidateVO = candidateVOList.get(i);
			
			if(categoryNum.equals(candidateVO.getCategoryNum()))
			{
				passStatus = candidateVO.getPassStatus();
				break;
			}
		}
    	
    	return passStatus;
	}

	public String getPassStatus(String id, String categoryNum, String turn){
		String passStatus = null;

		List<CandidateVO> candidateVOList = mypageDao.viewResult(id);
		CandidateVO candidateVO = null;


		for(int i=0; i<candidateVOList.size(); i++){
			candidateVO = candidateVOList.get(i);

			if(categoryNum.equals(candidateVO.getCategoryNum()) && turn.equals(candidateVO.getTurn()))
			{
				passStatus = candidateVO.getPassStatus();
				break;
			}
		}

		return passStatus;
	}
}
