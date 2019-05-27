package dao;

import java.util.ArrayList;

import vo.AnswerSheetVO;
import vo.CandidateVO;

public interface AnnounceDao {
	
	
	
	ArrayList<AnswerSheetVO> answerAnnounce();

	ArrayList<CandidateVO> passAnnounce();

	void insert(AnswerSheetVO answer);
	
	
}
