package service;

public interface MypageService {

	public void viewApplyList(String loginId);
	
	// 시험결과 보기
	public void viewResult(String loginId);
	
	// 자격증 발급 내역
	public void viewIssueList(String loginId);
	
	// 패스워드 변경
	public void changePW();
	
	// 회원탈퇴
	public void withdrawal();
	
}
