package dao;

import java.util.ArrayList;
import java.util.List;

import vo.ApplyStatusVO;
import vo.CandidateVO;
import vo.ExamNoVO;
import vo.MypageVO;

public interface MypageDao {
	//단일회원 조회
	//UserVO selectUser(String key, String value);
	
	// 접수내역 DB에서 가져오기
	public List<ApplyStatusVO> viewApplyList(String loginId);
	
	// 시험결과 DB에서 가져오기
	public List<CandidateVO> viewResult(String loginId);
	
	// 자격증발급내역 DB에서 가져오기
	public List<MypageVO> viewIssueList(String loginId);
	//접수번호조회
	public List<ApplyStatusVO> getApplierNum(String loginId);
	
	//시험명 목록 조회
	public ArrayList<ExamNoVO> getExamNoVOList();

	public List<ApplyStatusVO> list();

}
