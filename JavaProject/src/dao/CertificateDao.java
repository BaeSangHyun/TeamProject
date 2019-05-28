package dao;

import java.util.List;

import vo.CandidateVO;
import vo.MypageVO;

public interface CertificateDao{
	List<CandidateVO> getConfirmPassList();

	//자격증발급내역 DB에서 가져오기
	List<MypageVO> viewCertificateList();
	
	//자격증발급 및 확인 메서드
	List<CandidateVO> getCertificate();

}
