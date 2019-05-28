package service;

public interface CertificateService {
	void confirmPass();		//시험 합격 내역보기

	void getCertificateList(); //자격발급 리스트 확인
	
	void issue(int m); //발급하기
}
