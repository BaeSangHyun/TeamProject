package data;

import java.util.ArrayList;

import vo.MainCategoryVO;

public class MainCategoryDB {
	private static MainCategoryDB instance;

    private MainCategoryDB(){}

    public static MainCategoryDB getInstance(){
        if(instance == null){
            instance = new MainCategoryDB();
        }
        return instance;
    }
    
    
    public ArrayList<MainCategoryVO> tb_mainCategory = new ArrayList<MainCategoryVO>();

    {
    	MainCategoryVO mainCategory = new MainCategoryVO();
    	mainCategory.setMainNum("01");
    	mainCategory.setMainName("정보기술");
    	
    	tb_mainCategory.add(mainCategory);
    	
    	mainCategory = new MainCategoryVO();
    	mainCategory.setMainNum("02");
    	mainCategory.setMainName("디자인");
    	
    	tb_mainCategory.add(mainCategory);
    	
    	mainCategory = new MainCategoryVO();
    	mainCategory.setMainNum("03");
    	mainCategory.setMainName("전기");

        tb_mainCategory.add(mainCategory);
    }
}
