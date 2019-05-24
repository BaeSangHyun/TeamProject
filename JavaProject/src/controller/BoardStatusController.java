package controller;

import java.util.Scanner;

import service.BoardService;
import service.BoardServiceImpl;

public class BoardStatusController {

	private static BoardService boardService = BoardServiceImpl.getInstance();
	
	int menu;

	public void viewStatus(String type) {
		
		do {
			Scanner s = new Scanner(System.in);
			
			boardService.mainViewBoard(type);//메인게시판보기
			
			System.out.print("1.글쓰기/ ");
			System.out.print("2.삭제하기/ ");
			System.out.print("3.수정하기/ ");
			System.out.print("4.게시글 보기/ ");
			System.out.println("0.뒤로가기/ ");
			System.out.print("입력>");
			menu = Integer.parseInt(s.nextLine());

			switch (menu) {
			case 1:
				boardService.insertBoard(type); //글쓰기
				break;
			case 2:
				boardService.deleteBoard(type); //삭제하기
				break;
			case 3:
				boardService.updateBoard(type); //수정하기
				break;
			case 4:
				boardService.contentViewBoard(type); //게시글 보기
				break;
			case 0:
				BoardController back = new BoardController(); //뒤로가기
				back.support();
				break;
			}
		} while (menu != 0);
	}
}
