package service;

import java.util.ArrayList;

import vo.BoardVO;

public interface BoardService {
	void getNoticeBoard(String type); //Notice 게시판 데이터 가져오기
	void getFAQBoard(String type); //FAQ 게시판 데이터 가져오기
	void getUserBoard(String type); //User 게시판 데이터 가져오기
	
	void insertBoard(String type); //삽입
	void deleteBoard(String type); //삭제
	void updateBoard(String type); //수정
	void contentViewBoard(String type); //게시판 제목 안의 내용보기
	void comment(String type, int num, ArrayList<BoardVO> boardVO); //답변
}
