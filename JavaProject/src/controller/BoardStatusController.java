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
			boardService.mainViewBoard(type);
			System.out.println("1. 글쓰기");
			System.out.println("2. 삭제하기");
			System.out.println("3. 수정하기");
			System.out.println("4. 게시글 보기");
			System.out.println("0. 뒤로가기");
			System.out.print("입력>");

			menu = Integer.parseInt(s.nextLine());

			switch (menu) {
			case 1:
				boardService.insertBoard(type);
				break;
			case 2:
				boardService.deleteBoard();
				break;
			case 3:
				boardService.updateBoard();
				break;
			case 4:
				boardService.contentViewBoard();
				break;
			case 0:
				BoardController back = new BoardController();
				back.info();
				break;
			}
		} while (menu != 0);
	}
}
