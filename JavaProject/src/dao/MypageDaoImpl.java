package dao;

import vo.UserVO;
import data.Database;
import data.MypageDB;

public class MypageDaoImpl implements MypageDao {

	private static MypageDaoImpl instance;

    private MypageDaoImpl(){}

    public static MypageDaoImpl getInstance(){
        if(instance == null){
            instance = new MypageDaoImpl();
        }
        return instance;
    }

    MypageDB db = MypageDB.getInstance();
    Database database = Database.getInstance();
    
	@Override
	public UserVO selectUser(String key, String value) {
		for(int i=0; i < database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			
			if(key.equals("ID")){
				if(user.getId().equals(value)){
					return user;
				}
			}
		}
		return null;
	}
    
}
