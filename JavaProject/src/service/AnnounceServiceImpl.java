package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.AnswerSheetVO;
import vo.ApplyStatusVO;
import vo.CandidateVO;
import vo.ExamNoVO;
import dao.AnnounceDao;
import dao.AnnounceDaoImpl;
import dao.CategoryDaoImpl;
import dao.MypageDao;
import dao.MypageDaoImpl;
import dao.Session;

public class AnnounceServiceImpl implements AnnounceService{
	
	private static AnnounceServiceImpl instance;
	
	private AnnounceServiceImpl(){}
	
	public static AnnounceServiceImpl getInstance(){
		if(instance == null){
			instance = new AnnounceServiceImpl();
		}
		return instance;
	}	
	
	CategoryDaoImpl categoryDaoImpl = CategoryDaoImpl.getInstance();
	AnnounceDao announceDao = AnnounceDaoImpl.getInstance();
	MypageDao mypageDao = MypageDaoImpl.getInstance();
	
	
	@Override
	public void passAnnounce(int menu) {
		Scanner s = new Scanner(System.in);

		ExamNoVO round1 = categoryDaoImpl.tempExam.get(menu-1);
		
		List<ApplyStatusVO> applyStatusVO = mypageDao.list();
		ArrayList<CandidateVO> condidateVO = announceDao.passAnnounce();
		if(Session.loginUser==null || Session.loginUser.getRank().equals("user")){
			System.out.println("=================================================");
	        System.out.println("시험종목\t시험이름\tID\t시험유형\t점수\t합격여부");
	        System.out.println("=================================================");
			for(int i=0; i<condidateVO.size(); i++){
				if(condidateVO.get(i).getTurn().equals(round1.getTurn())
						&& condidateVO.get(i).getCategoryNum().equals(round1.getCategoryNum())){

					System.out.println(condidateVO.get(i).getTurn() + "\t\t"
							+ round1.getTitle() + "\t"
							+ condidateVO.get(i).getId() + "\t"
							+ applyStatusVO.get(i).getExamType() + "\t"
							+ condidateVO.get(i).getScore() + "\t"
							+ condidateVO.get(i).getPassStatus());
				}
			}
			System.out.println("=================================================");
		}else if(Session.loginUser.getRank().equals("admin")){
			System.out.println("=================================================");
	        System.out.println("시험종목\t시험이름\tID\t시험유형\t점수\t합격여부");
	        System.out.println("=================================================");
			for(int i=0; i<condidateVO.size(); i++){
				if(condidateVO.get(i).getTurn().equals(round1.getTurn()) 
						&& condidateVO.get(i).getCategoryNum().equals(round1.getCategoryNum())){
					if(condidateVO.get(i).getScore() >= 60){
						condidateVO.get(i).setPassStatus("합격");
						System.out.println(condidateVO.get(i).getTurn() + "\t\t"
									+ round1.getTitle() + "\t"
									+ condidateVO.get(i).getId() + "\t"
									+ applyStatusVO.get(i).getExamType() + "\t"
									+ condidateVO.get(i).getScore()+"점" + "\t"
									+ condidateVO.get(i).getPassStatus());
					}
					else if(condidateVO.get(i).getScore() < 60){
						condidateVO.get(i).setPassStatus("불합격");
					}

				}
			}
		}
		
	}

	@Override
	public void answerAnnounce(int menu) {
		Scanner s = new Scanner(System.in);

		ExamNoVO round1 = categoryDaoImpl.tempExam.get(menu-1);
		
		ArrayList<AnswerSheetVO> answerSheetVO = announceDao.answerAnnounce();
		
			System.out.println("답안발표");
			System.out.println("=================================================");
	        System.out.println("답");
	        System.out.println("=================================================");
	        
			for(int i=0; i<answerSheetVO.size(); i++){
				if(answerSheetVO.get(i).getTurn().equals(round1.getTurn())
						&& answerSheetVO.get(i).getCategoryNum().equals(round1.getCategoryNum())){
					
						System.out.println(answerSheetVO.get(i).getAnswer());
					
				}
			}
			System.out.println("=================================================");
			
		if(Session.loginUser.getRank().equals("admin")){
			
			System.out.println("1.작성/ 2.수정/ 0. 뒤로가기");
			System.out.print("입력>");
			int sel = Integer.parseInt(s.nextLine());
			
			switch(sel){
			case 1:
				System.out.println("답안작성>");
				String ans = s.nextLine();
				AnswerSheetVO answer = new AnswerSheetVO();
				
				answer.setAnswer(ans);
				answer.setCategoryNum(round1.getCategoryNum());
				answer.setTurn(round1.getTurn());
				
				announceDao.insert(answer);
				
				break;
			case 2:
				System.out.println("답안수정>");
				String ansChange = s.nextLine();
				for(int i=0; i<answerSheetVO.size(); i++){
					if(answerSheetVO.get(i).getTurn().equals(round1.getTurn())
							&& answerSheetVO.get(i).getCategoryNum().equals(round1.getCategoryNum())){
						
						answerSheetVO.get(i).setAnswer(ansChange);
					}
				}
				
			case 0:
				break;
			}
		}
	
		
	}
	
	
}
