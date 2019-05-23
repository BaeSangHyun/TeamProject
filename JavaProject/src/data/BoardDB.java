package data;

import java.util.ArrayList;

import vo.BoardVO;

public class BoardDB {
	private static BoardDB instance;

    private BoardDB(){}

    public static BoardDB getInstance(){
        if(instance == null){
            instance = new BoardDB();
        }
        return instance;
    }

	public ArrayList<BoardVO> boardDB = new ArrayList<BoardVO>();
    
    {
    	BoardVO vo = new BoardVO();
    	vo.setBoardType("Customer");
    	vo.setBoardContent("sdfsdfs");
    	vo.setBoardTitle("제에에에에목");
    	vo.setBoardWriter("글쓰으응으은이");
    	boardDB.add(vo);
    	
    }
}
