package dao;

public class MypageDaoImpl implements MypageDao {

	private static MypageDaoImpl instance;

    private MypageDaoImpl(){}

    public static MypageDaoImpl getInstance(){
        if(instance == null){
            instance = new MypageDaoImpl();
        }
        return instance;
    }
    
}
