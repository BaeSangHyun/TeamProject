package dao;

import java.util.ArrayList;

import vo.MypageVO;

public class CertificateDaoImpl implements CertificateDao {
	
	private static CertificateDaoImpl instance;

    private CertificateDaoImpl(){}

    public static CertificateDaoImpl getInstance(){
        if(instance == null){
            instance = new CertificateDaoImpl();
        }
        return instance;
    }
    
//    BoardDB db = BoardDB.getInstance();

	//자격증발급내역 조회
	@Override
	public ArrayList<MypageVO> viewCertificateList() {
		
		return null;
	}

}
