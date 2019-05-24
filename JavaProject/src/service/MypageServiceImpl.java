package service;

import vo.MypageVO;
import dao.MypageDao;
import dao.MypageDaoImpl;

public class MypageServiceImpl implements MypageService {

	private static MypageServiceImpl instance;
	
	private MypageServiceImpl(){};
	
	public static MypageServiceImpl getInstance(){
		if(instance == null){
			instance = new MypageServiceImpl();
		}
		return instance;
	}
	
	MypageDao mypageDao = MypageDaoImpl.getInstance();
	
	public MypageVO mypageVO = new MypageVO();
	
	@Override
	public void changePW() {
		
	}

	@Override
	public void withdrawal() {
		
	}
}
