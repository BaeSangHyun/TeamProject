package service;

public interface BoardService {
	void insertBoard(String type); //삽입
	void deleteBoard(String type); //삭제
	void updateBoard(String type); //수정
	void contentViewBoard(String type); //게시판 제목 안의 내용보기
	void mainViewBoard(String type); //게시판 메인보기
}
