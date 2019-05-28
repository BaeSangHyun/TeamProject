package controller;

import java.util.Scanner;

import dao.Session;
import service.BoardService;
import service.BoardServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class BoardController {

	private static BoardService boardService = BoardServiceImpl.getInstance();
	private static UserService userService = UserServiceImpl.getInstance();

	Session session = new Session();

	public void support() {
		Scanner s = new Scanner(System.in);

		System.out.println("-----------고객 지원------------");
		System.out.println("1. 공지사항");
		System.out.println("2. FAQ");
		System.out.println("3. 이의제기");
		System.out.println("0. 뒤로가기");
		System.out.println("------------------------------");
		System.out.print("숫자 입력>");
		int menu = Integer.parseInt(s.nextLine());

		switch (menu) {
		case 1:
			boardFunction("Notice", "NoWrite");
			break;
		case 2:
			boardFunction("FAQ", "NoWrite");
			break;
		case 3: // 고객 참여 게시판
			if (Session.loginUser == null) {
				System.out.println("로그인 해주세요.");
				userService.login();
			}
			if (session.loginUser != null) {
				boardFunction("User", "Write");
				break;
			}
			break;
		case 0:
			break;
		default :
			
		}

	}

	public void boardFunction(String type, String write) {
		int menu = 0;
		do {
			Scanner s = new Scanner(System.in);
			
			//type별 게시판에 저장된 DB 출력
			if (type.equals("Notice")) { 
				boardService.getNoticeBoard(type);
			} else if (type.equals("FAQ")) {
				boardService.getFAQBoard(type);
			} else if (type.equals("User")) {
				boardService.getUserBoard(type);
			}

			if ( session.loginUser == null) { //비로그인일시
				System.out.print("1.게시글 보기/ ");
				System.out.println("0.뒤로가기/ ");
				System.out.print("입력>");
				menu = Integer.parseInt(s.nextLine());

				switch (menu) {
				case 1:
					boardService.contentViewBoard(type); // 게시글 보기
					break;
				case 0:
					support();
					break;
				}
			} else if (session.loginUser.getRank().equals("user")) { //랭크가 user일시
				if (write.equals("Write")) { //쓰기 가능 (이의제기 게시판)
					System.out.print("1.글쓰기/ ");
					System.out.print("2.삭제하기/ ");
					System.out.print("3.수정하기/ ");
					System.out.print("4.게시글 보기/ ");
					System.out.println("0.뒤로가기/ ");
					System.out.print("입력>");
					menu = Integer.parseInt(s.nextLine());

					switch (menu) {
					case 1:
						boardService.insertBoard(type); // 글쓰기
						break;
					case 2:
						boardService.deleteBoard(type); // 삭제하기
						break;
					case 3:
						boardService.updateBoard(type); // 수정하기
						break;
					case 4:
						boardService.contentViewBoard(type); // 게시글 보기
						break;
					case 0:
						support();
						break;
					}
				}else if(write.equals("NoWrite")){ //쓰기 불가능(공지사항, FAQ)
					System.out.print("1.게시글 보기/ ");
					System.out.println("0.뒤로가기/ ");
					System.out.print("입력>");
					menu = Integer.parseInt(s.nextLine());

					switch (menu) {
					case 1:
						boardService.contentViewBoard(type); // 게시글 보기
						break;
					case 0:
						support();
						break;
					}
				}

			}else if (session.loginUser.getRank().equals("admin")) { //랭크가 admin일시
				System.out.print("1.글쓰기/ ");
				System.out.print("2.삭제하기/ ");
				System.out.print("3.수정하기/ ");
				System.out.print("4.게시글 보기/ ");
				System.out.println("0.뒤로가기/ ");
				System.out.print("입력>");
				menu = Integer.parseInt(s.nextLine());

				switch (menu) {
				case 1:
					boardService.insertBoard(type); // 글쓰기
					break;
				case 2:
					boardService.deleteBoard(type); // 삭제하기
					break;
				case 3:
					boardService.updateBoard(type); // 수정하기
					break;
				case 4:
					boardService.contentViewBoard(type); // 게시글 보기
					break;
				case 0:
					support();
					break;
				}
			}
		} while (menu != 0);

	}
}
