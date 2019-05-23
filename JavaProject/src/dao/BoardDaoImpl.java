package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import vo.BoardVO;
import vo.UserVO;
import data.BoardDB;
import data.Database;

public class BoardDaoImpl implements BoardDao {
	private static BoardDaoImpl instance;

    private BoardDaoImpl(){}

    public static BoardDaoImpl getInstance(){
        if(instance == null){
            instance = new BoardDaoImpl();
        }
        return instance;
    }
    
    BoardDB db = BoardDB.getInstance();
    /*
     for(int i = 0; i < 
     */
	@Override
	public void insertbd(String type, BoardVO boardVO) {
//		db.bd.put(boardVO);
		db.boardDB.add(boardVO);
	}

	@Override
	public ArrayList<BoardVO> mainViewBoard(String type) {
		
		ArrayList<BoardVO> rtnBoard = new ArrayList<BoardVO>();
		for(int i=0; i<db.boardDB.size(); i++){
			BoardVO board = db.boardDB.get(i);
			if(type.equals("Customer")){
				rtnBoard.add(board);
			}
		}
//		Iterator<String> itr = db.bd.keySet().iterator();
//		while(itr.hasNext()){
//			String key = itr.next();
//			if(key.equals(type)){
//				rtnBoard.add(db.bd.get(key)); 
//			}
//		}
		return rtnBoard;

	}
}
