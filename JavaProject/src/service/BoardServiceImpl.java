package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.BoardVO;
import controller.BoardController;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.Session;
import data.Database;


public class BoardServiceImpl implements BoardService {
	private static BoardServiceImpl instance;
	
	private BoardServiceImpl(){};
	
	public static BoardServiceImpl getInstance(){
		if(instance == null){
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	BoardDao boardDao = BoardDaoImpl.getInstance();
	Database database = Database.getInstance();
	
	
	//getNoticeBoard(), getFAQBoard(), getUserBoard() 출력내용
	private void show(ArrayList<BoardVO> boardList, String type){
		System.out.println("=============================================================");
		System.out.println("\t\t\t\t"+type);
		System.out.println("=============================================================");
		System.out.println("번호\t\t제목\t\t작성자\t\t날짜");
		for(int i = 0; i < boardList.size(); i++){
			System.out.println((i+1)+"\t\t"+boardList.get(i).getBoardTitle()+"\t\t"+
					boardList.get(i).getBoardWriter()+"\t\t"+boardList.get(i).getBoardDate());	
		}
		System.out.println("=============================================================");
		System.out.println("\n");
	}
	
	//deleteBoard() 출력내용
	private void deleteShow(String type, int num){
		Scanner s = new Scanner(System.in);
		
		System.out.print("비밀번호를 입력하세요>");
		String userPw = s.nextLine();
		
		if(userPw.equals(Session.loginUser.getPwd())){
			
			if(type.equals("Notice")){
				database.tb_noticeBoardDB.remove(num-1);
			}else if(type.equals("FAQ")){
				database.tb_FAQBoardDB.remove(num-1);
			}else if(type.equals("User")){
				database.tb_userBoardDB.remove(num-1);
			}
			
			System.out.println("삭제되었습니다!");
		}else System.out.println("비밀번호가 일치하지 않습니다.");
	}
	
	//updateBoard() 출력내용
	private void updateShow(ArrayList<BoardVO> boardVO, int num, String boardDate, String type){
		Scanner s = new Scanner(System.in);
		
		System.out.print("비밀번호를 입력하세요>");
		String userPw = s.nextLine();
		
		if(userPw.equals(Session.loginUser.getPwd())){
			System.out.print("어떤항목을 수정하시겠습니까?(1.제목/ 2.내용/ 0.취소)>");
			int select = Integer.parseInt(s.nextLine());
			
			if(select == 1){
				System.out.println("=============================================================");
				System.out.println("\t\t\t\t"+"제목");
				System.out.println("=============================================================");
				System.out.println(boardVO.get(num-1).getBoardTitle());
				System.out.println("=============================================================");
				System.out.print("수정할 제목을 입력하세요>");
				String title = s.nextLine();
				boardVO.get(num-1).setBoardTitle(title);
				boardVO.get(num-1).setBoardDate(boardDate+"(수정)");
				System.out.println("수정완료!");
			}else if(select == 2){
				System.out.println("=============================================================");
				System.out.println("\t\t\t\t"+"내용");
				System.out.println("=============================================================");
				System.out.println(boardVO.get(num-1).getBoardContent());
				System.out.println("=============================================================");
				System.out.print("수정할 내용을 입력하세요>");
				String content = s.nextLine();
				boardVO.get(num-1).setBoardContent(content);
				boardVO.get(num-1).setBoardDate(boardDate+" 수정됨");
				System.out.println("수정완료!");
			}else if(select == 0){
				if(type.equals("Notice") && type.equals("FAQ")){
					new BoardController().boardFunction(type,"NoWrite");
				}else if(type.equals("User")){
					new BoardController().boardFunction(type,"Write");
				}
			}
			
		}else System.out.println("비밀번호가 일치하지 않습니다.");
	}
	
	

	@Override
	public void getNoticeBoard(String type) {
		ArrayList<BoardVO> boardList = boardDao.getBoard(type);
		show(boardList, type);
		System.out.println();
		
	}
	
	@Override
	public void getFAQBoard(String type) {
		ArrayList<BoardVO> boardList = boardDao.getBoard(type);
		show(boardList, type);
	}

	@Override
	public void getUserBoard(String type) {
		ArrayList<BoardVO> boardList = boardDao.getBoard(type);
		show(boardList, type);
	}

	@Override
	public void insertBoard(String type) {
		DateFormat sdFormat = new SimpleDateFormat("yy/MM/dd a h:mm ");
		Date nowDate = new Date();
		String boardDate = sdFormat.format(nowDate);
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("제목을 입력하세요>");
		String boardTitle = s.nextLine();
		System.out.print("내용을 입력하세요>");
		String boardContent = s.nextLine();
		

		BoardVO boardVO = new BoardVO();
		
		boardVO.setBoardWriter(Session.loginUser.getId());
		boardVO.setBoardType(type);
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardContent(boardContent);
		boardVO.setBoardDate(boardDate);
		
		boardDao.insertbd(type, boardVO);
		
	}

	@Override
	public void deleteBoard(String type) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("삭제할 게시물 번호선택> ");
		int num = Integer.parseInt(s.nextLine());
		
		ArrayList<BoardVO> boardVO = boardDao.getBoard(type);
		
		if(boardVO.get(num-1).getBoardWriter().equals(Session.loginUser.getId()) 
				&& !(Session.loginUser.getRank().equals("admin"))){
			
			deleteShow(type, num);
			
//			System.out.print("비밀번호를 입력하세요>");
//			String userPw = s.nextLine();
//			
//			if(userPw.equals(Session.loginUser.getPwd())){
//				
//				if(type.equals("Notice")){
//					notice.boardDB.remove(num-1);
//				}else if(type.equals("FAQ")){
//					faq.boardDB.remove(num-1);
//				}else if(type.equals("User")){
//					user.boardDB.remove(num-1);
//				}
//				
//				System.out.println("삭제되었습니다!");
//			}else System.out.println("비밀번호가 일치하지 않습니다.");
			
		}else if(Session.loginUser.getRank().equals("admin")){
			
			deleteShow(type, num);
				
		}else System.out.println("권한이없습니다.");
		System.out.println();
		
	}

	@Override
	public void updateBoard(String type) {
		DateFormat sdFormat = new SimpleDateFormat("yy/MM/dd a h:mm ");
		Date nowDate = new Date();
		String boardDate = sdFormat.format(nowDate);
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("수정할 게시판의 번호 입력>");
		int num = Integer.parseInt(s.nextLine());
		
		ArrayList<BoardVO> boardVO = boardDao.getBoard(type);
		
		if(boardVO.get(num-1).getBoardWriter().equals(Session.loginUser.getId()) 
				&& !(Session.loginUser.getRank().equals("admin"))){
			
			updateShow(boardVO, num, boardDate, type);
			
//			System.out.print("비밀번호를 입력하세요>");
//			String userPw = s.nextLine();
//			
//			if(userPw.equals(Session.loginUser.getPwd())){
//				System.out.print("어떤항목을 수정하시겠습니까?(1.제목/ 2.내용/ 0.취소)>");
//				int select = Integer.parseInt(s.nextLine());
//				
//				if(select == 1){
//					System.out.println("--------------현재 제목---------------");
//					System.out.println(boardVO.get(num-1).getBoardTitle());
//					System.out.println("------------------------------------");
//					System.out.print("수정할 제목을 입력하세요>");
//					String title = s.nextLine();
//					boardVO.get(num-1).setBoardTitle(title);
//					boardVO.get(num-1).setBoardDate(boardDate+" 수정됨");
//					System.out.println("수정완료!");
//				}else if(select == 2){
//					System.out.println("--------------현재 내용---------------");
//					System.out.println(boardVO.get(num-1).getBoardContent());
//					System.out.println("------------------------------------");
//					System.out.print("수정할 내용을 입력하세요>");
//					String content = s.nextLine();
//					boardVO.get(num-1).setBoardContent(content);
//					boardVO.get(num-1).setBoardDate(boardDate+" 수정됨");
//					System.out.println("수정완료!");
//				}else if(select == 0){
//					if(type.equals("Notice") && type.equals("FAQ")){
//						new BoardController().boardFunction(type,"NoWrite");
//					}else if(type.equals("User")){
//						new BoardController().boardFunction(type,"Write");
//					}
//				}
//				
//			}else System.out.println("비밀번호가 일치하지 않습니다.");
			
		}else if(Session.loginUser.getRank().equals("admin")){
			
			updateShow(boardVO, num, boardDate, type);

		}else System.out.println("권한이없습니다.");
		System.out.println();
		
	}

	@Override
	public void contentViewBoard(String type) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("내용을 볼 게시판의 번호 입력>");
		int num = Integer.parseInt(s.nextLine());
		

		ArrayList<BoardVO> boardVO = boardDao.getBoard(type);
		
		System.out.println("=============================================================");
		System.out.println("제목| "+boardVO.get(num-1).getBoardTitle()+'\t'+"작성자| "+boardVO.get(num-1).getBoardWriter()
				+'\t'+"작성일| "+boardVO.get(num-1).getBoardDate());
		System.out.println("=============================================================");
		System.out.println(boardVO.get(num-1).getBoardContent());
		System.out.println("=============================================================");
		
		if(boardVO.get(num-1).getAnswerContent() != null){
			System.out.println("\n");
			System.out.println("\t\t\t"+"관리자 답변");
			System.out.println("*************************************************************");
			System.out.println("작성자: "+boardVO.get(num-1).getAnswerWriter()+"|\t"+"날짜: "+boardVO.get(num-1).getAnswerDate());
			System.out.println("*************************************************************");
			System.out.println(boardVO.get(num-1).getAnswerContent());
			System.out.println("*************************************************************");
		}
		
		
		if (Session.loginUser != null
				&& Session.loginUser.getRank().equals("admin")) {
			System.out.println("1. 답변등록");
			System.out.println("0. 뒤로가기");

			int menu = Integer.parseInt(s.nextLine());

			switch (menu) {
			case 1:
				comment(type, num, boardVO);
				break;
			case 0:
				break;
			}
		}
	}

	@Override
	public void comment(String type, int num, ArrayList<BoardVO> boardVO) {
		DateFormat sdFormat = new SimpleDateFormat("yy/MM/dd a h:mm ");
		Date nowDate = new Date();
		String boardDate = sdFormat.format(nowDate);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("답변 입력>");
		String comm = s.nextLine();
		
		Session.loginUser.setComment(comm);
		BoardVO commBoard = boardVO.get(num-1);
		commBoard.setAnswerContent(Session.loginUser.getComment());
		commBoard.setAnswerWriter(Session.loginUser.getId());
		commBoard.setAnswerDate(boardDate);
		
		boardVO.set(num-1, commBoard);
		
	}
	
}
