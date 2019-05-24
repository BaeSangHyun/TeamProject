package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import controller.BoardStatusController;
import vo.BoardVO;
import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.Session;


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
		
//		HashMap<String, String> boardMap = new HashMap<String, String>();
		
		/*boardMap.put("type", type);
		boardMap.put("boardTitle", boardTitle);
		boardMap.put("boardContent", boardContent);
		boardMap.put("boardDate", boardDate);*/
		BoardVO boardVO = new BoardVO();
//		if(type.equals("Notice")){
//			boardVO.setBoardType("Notice");
//		}else if(type.equals("FAQ")){
//			boardVO.setBoardType("FAQ");
//		}else if(type.equals("Customer")){
//			boardVO.setBoardType("Customer");
//		}
		
		boardVO.setBoardWriter(Session.loginUser.getId());
		boardVO.setBoardType(type);
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardContent(boardContent);
		boardVO.setBoardDate(boardDate);
		boardVO.setViews(0);
		
		/*boardVO.setBoardTitle(boardMap.get("boardTitle"));
		boardVO.setBoardContent(boardMap.get(boardContent));
		boardVO.setBoardDate(boardMap.get(boardDate));*/
		
		boardDao.insertbd(type, boardVO);
		
	}

	@Override
	public void deleteBoard(String type) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("삭제할 게시물 번호선택> ");
		int num = Integer.parseInt(s.nextLine());
		
		ArrayList<BoardVO> boardVO = boardDao.selectBoard(type);
		
		if(boardVO.get(num-1).getBoardWriter().equals(Session.loginUser.getId())){
			System.out.print("비밀번호를 입력하세요>");
			String userPw = s.nextLine();
			
			if(userPw.equals(Session.loginUser.getPwd())){
				boardVO.remove(num-1);
				System.out.println("삭제되었습니다!");
			}else System.out.println("비밀번호가 일치하지 않습니다.");
			
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
		
		ArrayList<BoardVO> boardVO = boardDao.selectBoard(type);
		
		if(boardVO.get(num-1).getBoardWriter().equals(Session.loginUser.getId())){
			System.out.print("비밀번호를 입력하세요>");
			String userPw = s.nextLine();
			
			if(userPw.equals(Session.loginUser.getPwd())){
				System.out.print("어떤항목을 수정하시겠습니까?(1.제목/ 2.내용/ 0.취소)>");
				int select = Integer.parseInt(s.nextLine());
				
				if(select == 1){
					System.out.println("--------------현재 제목---------------");
					System.out.println(boardVO.get(num-1).getBoardTitle());
					System.out.println("------------------------------------");
					System.out.print("수정할 제목을 입력하세요>");
					String title = s.nextLine();
					boardVO.get(num-1).setBoardTitle(title);
					boardVO.get(num-1).setBoardDate(boardDate+" 수정됨");
					System.out.println("수정완료!");
				}else if(select == 2){
					System.out.println("--------------현재 내용---------------");
					System.out.println(boardVO.get(num-1).getBoardContent());
					System.out.println("------------------------------------");
					System.out.print("수정할 내용을 입력하세요>");
					String content = s.nextLine();
					boardVO.get(num-1).setBoardContent(content);
					boardVO.get(num-1).setBoardDate(boardDate+" 수정됨");
					System.out.println("수정완료!");
				}else if(select == 0){
					BoardStatusController back = new BoardStatusController();
					back.viewStatus(type);
				}
				
			}else System.out.println("비밀번호가 일치하지 않습니다.");
			
		}else System.out.println("권한이없습니다.");
		System.out.println();

	}


	@Override
	public void contentViewBoard(String type) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("내용을 볼 게시판의 번호 입력>");
		int num = Integer.parseInt(s.nextLine());
		
		ArrayList<BoardVO> boardVO = boardDao.selectBoard(type);
		
		boardVO.get(num-1).setViews(boardVO.get(num-1).getViews()+1); //조회수 카운트
		System.out.println("-----------------------------------------------------------");
		System.out.println("제목| "+boardVO.get(num-1).getBoardTitle()+"\t"+"작성자| "+boardVO.get(num-1).getBoardWriter());
		System.out.println("-----------------내용--------------------");
		System.out.println(boardVO.get(num-1).getBoardContent());
		System.out.println("-----------------------------------------");
		System.out.println();
	}

	@Override
	public void mainViewBoard(String type) {
		
		ArrayList<BoardVO> boardVO = boardDao.selectBoard(type);
		System.out.println("번호\t\t제목\t\t작성자\t\t날짜\t\t\t\t조회수");
		if(type.equals("Notice")){
			System.out.println("------------------Notice-------------------------");
		} else if(type.equals("FAQ")){
			System.out.println("------------------FAQ-------------------------");
		} else if(type.equals("Customer")){
			System.out.println("------------------Customer-------------------------");
		}
		for(int i = 0; i < boardVO.size(); i++){
			System.out.println((i+1)+"\t\t"+boardVO.get(i).getBoardTitle()+"\t\t"+
					boardVO.get(i).getBoardWriter()+"\t\t"+boardVO.get(i).getBoardDate()
					+"\t\t"+boardVO.get(i).getViews());	
		}
		System.out.println("-----------------------------------------------");
		System.out.println();
	}
}
