package dao;

import java.util.ArrayList;

import vo.BoardVO;
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
    Database database = Database.getInstance();
    
	@Override
	public ArrayList<BoardVO> getBoard(String type) {
		ArrayList<BoardVO> rtnBoard = new ArrayList<BoardVO>();
		if(type.equals("Notice")){
			for(int i=0; i<database.tb_noticeBoardDB.size(); i++){
				BoardVO boardVO = database.tb_noticeBoardDB.get(i);
				rtnBoard.add(boardVO);
			}
		}else if(type.equals("FAQ")){
			for(int i=0; i<database.tb_FAQBoardDB.size(); i++){
				BoardVO boardVO = database.tb_FAQBoardDB.get(i);
				rtnBoard.add(boardVO);
			}
		}else if(type.equals("User")){
			for(int i=0; i<database.tb_userBoardDB.size(); i++){
				BoardVO boardVO = database.tb_userBoardDB.get(i);
				rtnBoard.add(boardVO);
			}
		}
		
		return rtnBoard;
	}

	@Override
	public void insertbd(String type, BoardVO boardVO) {
		if (type.equals("Notice")) {
			database.tb_noticeBoardDB.add(boardVO);
		} else if (type.equals("FAQ")) {
			database.tb_FAQBoardDB.add(boardVO);
		} else if (type.equals("User")) {
			database.tb_userBoardDB.add(boardVO);
		}

	}

}
