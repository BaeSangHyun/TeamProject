package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BoardVO;

public interface BoardDao {
	
	void insertbd(String type, BoardVO boardVO);

	ArrayList<BoardVO> mainViewBoard(String type);

	


}
