package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

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
	
	public BoardVO boardVO = new BoardVO();
	
	@Override
	public void insertBoard(String type) {
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
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
		
		boardVO.setBoardWriter(Session.loginUser.getName());
		boardVO.setBoardType(type);
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardContent(boardContent);
		boardVO.setBoardDate(boardDate);
		
		/*boardVO.setBoardTitle(boardMap.get("boardTitle"));
		boardVO.setBoardContent(boardMap.get(boardContent));
		boardVO.setBoardDate(boardMap.get(boardDate));*/
		
		boardDao.insertbd(type, boardVO);
		
	}

	@Override
	public void deleteBoard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub

	}


	@Override
	public void contentViewBoard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mainViewBoard(String type) {
//		HashMap<String, String> mainBoard = new HashMap<String, String>();
//		mainBoard.put("type", type);
		
		ArrayList<BoardVO> boardVO = boardDao.mainViewBoard(type);
		
		System.out.println("------------------의견 건의------------------");
		System.out.println("번호\t제목\t작성자\t날짜");
		for(int i = 0; i < boardVO.size(); i++){
			System.out.println((i+1)+'\t'+boardVO.get(i).getBoardTitle()+'\t'+
					boardVO.get(i).getBoardWriter());
		}
	}

}
