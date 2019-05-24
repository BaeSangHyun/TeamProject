package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BoardVO;

public interface BoardDao {
	
	void insertbd(String type, BoardVO boardVO); //DB삽입

	ArrayList<BoardVO> selectBoard(String type); //DB가져오기

	


}
