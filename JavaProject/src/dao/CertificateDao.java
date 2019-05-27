package dao;

import java.util.ArrayList;

import vo.MypageVO;

public interface CertificateDao{

	//자격증발급내역 DB에서 가져오기
	ArrayList<MypageVO> viewCertificateList();

}
