package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BoardVO;

public interface BoardDao {

	ArrayList<BoardVO> getBoard(String type); //type에 따라 게시판 DB를 가져옴

	void insertbd(String type, BoardVO boardVO); //type에 따라 게시판 DB에 저장
	
	
}
