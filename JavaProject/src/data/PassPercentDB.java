package data;

import java.util.ArrayList;

import vo.MainCategoryVO;
import vo.PassPercent;

public class PassPercentDB {
	private static PassPercentDB instance;

    private PassPercentDB(){}

    public static PassPercentDB getInstance(){
        if(instance == null){
            instance = new PassPercentDB();
        }
        return instance;
    }
    
    public ArrayList<PassPercent> tb_passpercent = new ArrayList<PassPercent>();
    
    {
    	PassPercent passpercent = new PassPercent();
    	passpercent.setCategoryNum("0101");
    	passpercent.setTurn("2019년 정기 기사 1회");
    	passpercent.setApplyerNum("");
    }
}
