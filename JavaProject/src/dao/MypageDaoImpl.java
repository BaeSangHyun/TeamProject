package dao;

import java.util.ArrayList;
import java.util.List;

import vo.ApplyStatusVO;
import vo.CandidateVO;
import vo.ExamNoVO;
import vo.MypageVO;
import vo.UserVO;
import data.Database;

public class MypageDaoImpl implements MypageDao {
	
	private static MypageDaoImpl instance;

    private MypageDaoImpl(){}

    public static MypageDaoImpl getInstance(){
        if(instance == null){
            instance = new MypageDaoImpl();
        }
        return instance;
    }

	Database database = Database.getInstance();
	UserVO userVO;

    //단일회원 조회
//	@Override
//	public UserVO selectUser(String key, String value) {
//		for(int i=0; i < database.tb_user.size(); i++){
//			userVO = database.tb_user.get(i);
//			
//			if(key.equals("ID")){
//				if(userVO.getId().equals(value)){
//					return userVO;
//				}
//			}
//		}
//		return null;
//	}


	
	
	/**
	 * 시험접수내역보기
	 */
	@Override
	public List<ApplyStatusVO> viewApplyList(String loginId){
		
		List<ApplyStatusVO> rtnApplyStatusList = new ArrayList<ApplyStatusVO>();
		
		ApplyStatusVO applyStatusVO = null;
		
		for(int i=0; i<database.tb_applyStatusList.size(); i++) 
		{
			applyStatusVO = database.tb_applyStatusList.get(i);
			if(loginId.equals(applyStatusVO.getId())) {
				rtnApplyStatusList.add(applyStatusVO);
			}
		}
		
		return rtnApplyStatusList;
	}
		
	
	/**
	 * 시험결과보기
	 * @param loginId
	 * @return
	 */
	@Override
	public List<CandidateVO> viewResult(String loginId){
		
		List<CandidateVO> rtnMypageVOList = new ArrayList<CandidateVO>();
		
		CandidateVO candidateVO = null;
		
		for(int i=0; i<database.tb_candidate.size(); i++)
		{
			candidateVO = database.tb_candidate.get(i);
			
			if(loginId.equals(candidateVO.getId()))
			{
				rtnMypageVOList.add(candidateVO);
			}
		}
		
		return rtnMypageVOList;
	}
	
	/**
	 * 자격증 발급내역 DB 
	 */
	@Override
	public List<MypageVO> viewIssueList(String loginId){
		
		List<MypageVO> rtnIssueList = new ArrayList<MypageVO>();
		
		MypageVO mypageVO = null;
		
		for(int i=0; i<database.tb_certificateIssueList.size(); i++)
		{
			mypageVO = database.tb_certificateIssueList.get(i);

			if(loginId.equals(mypageVO.getId()))
			{
				rtnIssueList.add(mypageVO);
			}
		}	
		return rtnIssueList;
	}

	/**
	 * 수험번호 가져오기
	 */
	@Override
	public List<ApplyStatusVO> getApplierNum(String loginId) {
		
		List<ApplyStatusVO> rtnApplyStatusList = new ArrayList<ApplyStatusVO>(); 
		
//		for (ApplyStatusVO e : database.tb_applyStatusList) {
		for (int i = 0; i < database.tb_applyStatusList.size(); i++) {
			
			ApplyStatusVO e = database.tb_applyStatusList.get(i);
			
			if (e.getId().equals(loginId)) rtnApplyStatusList.add(e);
		}
		return rtnApplyStatusList;
	}

	/**
	 * 시험종목명(중분류명) 가져오기
	 * 
	 */
	@Override
	public ArrayList<ExamNoVO> getExamNoVOList() {
		
//		ArrayList<ExamNoVO> rtnExamTitleList = new ArrayList<ExamNoVO>();
//		
//		for(int i = 0; i < database.tb_examno.size(); i++){
//			
//			ExamNoVO examNoVO = database.tb_examno.get(i);
//			
//			for(int j = 0; j < database.tb_applyStatusList.size(); j++){
//				
//				ApplyStatusVO applyStatusVO = database.tb_applyStatusList.get(i);
//				
//				if(examNoVO.getCategoryNum().equals(applyStatusVO.getCategoryNum())){
//					
//					rtnExamTitleList.add(examNoVO);
//				}
//			}
//			
//		}		
		
		return database.tb_examno;
	}

	@Override
	public List<ApplyStatusVO> list() {
		
		return database.tb_applyStatusList;
	}


    
}
