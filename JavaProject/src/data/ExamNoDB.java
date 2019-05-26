package data;

import java.util.ArrayList;

import vo.ExamNoVO;

public class ExamNoDB {
		private static ExamNoDB instance;

	    private ExamNoDB(){}

	    public static ExamNoDB getInstance(){
	        if(instance == null){
	            instance = new ExamNoDB();
	        }
	        return instance;

	    }
	    
	    public ArrayList<ExamNoVO> tb_examno = new ArrayList<ExamNoVO>();
	    
	    {
	    	ExamNoVO examno = new ExamNoVO();
	    	examno.setCategoryNum("0101");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("정보처리기사");
	    	examno.setWriteApply("2019-01-25~2019-01-31");
	    	examno.setWriteExam("2019-03-03");
	    	examno.setPassDate("2019-03-14");
	    	examno.setSkillApply("2019-03-15~2019-03-21");
	    	examno.setSkillExam("2019-04-13~2019-04-27");
	    	examno.setFinalPass("2019-05-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0101");
	    	examno.setTurn("2019년 정기 기사 2회");
	    	examno.setTitle("정보처리기사");
	    	examno.setWriteApply("2019-03-29~2019-04-04");
	    	examno.setWriteExam("2019-04-27");
	    	examno.setPassDate("2019-05-17");
	    	examno.setSkillApply("2019-05-20~2019-05-27");
	    	examno.setSkillExam("2019-06-29~2019-07-12");
	    	examno.setFinalPass("2019-08-16");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0101");
	    	examno.setTurn("2019년 정기 기사 3회");
	    	examno.setTitle("정보처리기사");
	    	examno.setWriteApply("2019-07-05~2019-07-11");
	    	examno.setWriteExam("2019-08-04");
	    	examno.setPassDate("2019-08-30");
	    	examno.setSkillApply("2019-09-02~2019-09-05");
	    	examno.setSkillExam("2019-10-12~2019-10-25");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0102");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("정보관리기술사");
	    	examno.setWriteApply("2019-01-04~2019-01-10");
	    	examno.setWriteExam("2019-01-27");
	    	examno.setPassDate("2019-03-08");
	    	examno.setSkillApply("2019-03-04~2019-03-13");
	    	examno.setSkillExam("2019-04-13~2019-04-22");
	    	examno.setFinalPass("2019-05-03");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0102");
	    	examno.setTurn("2019년 정기 기사 2회");
	    	examno.setTitle("정보관리기술사");
	    	examno.setWriteApply("2019-04-12~2019-04-18");
	    	examno.setWriteExam("2019-05-05");
	    	examno.setPassDate("2019-06-14");
	    	examno.setSkillApply("2019-06-17~2019-06-20");
	    	examno.setSkillExam("2019-07-13~2019-07-22");
	    	examno.setFinalPass("2019-08-02");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0102");
	    	examno.setTurn("2019년 정기 기사 3회");
	    	examno.setTitle("정보관리기술사");
	    	examno.setWriteApply("2019-07-19~2019-07.25");
	    	examno.setWriteExam("2019-08-10");
	    	examno.setPassDate("2019-09-11");
	    	examno.setSkillApply("2019-09-16~2019-09.19");
	    	examno.setSkillExam("2019-11-02~2019-11.11");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0103");
	    	examno.setTurn("2019년 정기 기능사 1회");
	    	examno.setTitle("정보처리기능사");
	    	examno.setWriteApply("2019-07-19~2019-07-25");
	    	examno.setWriteExam("2019-08-10");
	    	examno.setPassDate("2019-09-11");
	    	examno.setSkillApply("2019-09-16~2019-09-19");
	    	examno.setSkillExam("2019-11-02~2019-11-11");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0104");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("컬러리스트기사");
	    	examno.setWriteApply("2019-01-25~2019-01-31");
	    	examno.setWriteExam("2019-03-03");
	    	examno.setPassDate("2019-03-14");
	    	examno.setSkillApply("2019-03-15~2019-03-21");
	    	examno.setSkillExam("2019-04-13~2019-04-27");
	    	examno.setFinalPass("2019-05-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0104");
	    	examno.setTurn("2019년 정기 기사 2회");
	    	examno.setTitle("컬러리스트기사");
	    	examno.setWriteApply("2019-03-29~2019-04-04");
	    	examno.setWriteExam("2019-04-27");
	    	examno.setPassDate("2019-05-17");
	    	examno.setSkillApply("2019-05-20~2019-05-23");
	    	examno.setSkillExam("2019-06-29~2019-07-12");
	    	examno.setFinalPass("2019-08-16");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0104");
	    	examno.setTurn("2019년 정기 기사 3회");
	    	examno.setTitle("컬러리스트기사");
	    	examno.setWriteApply("2019-07-05~2019-07-11");
	    	examno.setWriteExam("2019-08-04");
	    	examno.setPassDate("2019-08-30");
	    	examno.setSkillApply("2019-09-02~2019-09-05");
	    	examno.setSkillExam("2019-10-12~2019-10-25");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0105");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("제품디자인산업기사");
	    	examno.setWriteApply("2019-01-25~2019-01-31");
	    	examno.setWriteExam("2019-03-03");
	    	examno.setPassDate("2019-03-14");
	    	examno.setSkillApply("2019-03-15~2019-03-21");
	    	examno.setSkillExam("2019-04-13~2019-04-27");
	    	examno.setFinalPass("2019-05-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0106");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("시각디자인기사");
	    	examno.setWriteApply("2019-03-29~2019-04-04");
	    	examno.setWriteExam("2019-04-27");
	    	examno.setPassDate("2019-05-17");
	    	examno.setSkillApply("2019-05-20~2019-05-23");
	    	examno.setSkillExam("2019-06-29~2019-07-12");
	    	examno.setFinalPass("2019-08-16");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0107");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("전기기사");
	    	examno.setWriteApply("2019-01-25~2019-01-31");
	    	examno.setWriteExam("2019-03-03");
	    	examno.setPassDate("2019-03-14");
	    	examno.setSkillApply("2019-03-15~2019-03-21");
	    	examno.setSkillExam("2019-04-13~2019-04-27");
	    	examno.setFinalPass("2019-05-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0107");
	    	examno.setTurn("2019년 정기 기사 2회");
	    	examno.setTitle("전기기사");
	    	examno.setWriteApply("2019-03-29~2019-04-04");
	    	examno.setWriteExam("2019-04-27");
	    	examno.setPassDate("2019-05-17");
	    	examno.setSkillApply("2019-05-20~2019-05-23");
	    	examno.setSkillExam("2019-06-29~2019-07-12");
	    	examno.setFinalPass("2019-08-16");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0107");
	    	examno.setTurn("2019년 정기 기사 3회");
	    	examno.setTitle("전기기사");
	    	examno.setWriteApply("2019-07-05~2019-07-11");
	    	examno.setWriteExam("2019-08-04");
	    	examno.setPassDate("2019-08-30");
	    	examno.setSkillApply("2019-09-02~2019-09-05");
	    	examno.setSkillExam("2019-10-12~2019-10-25");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0108");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("전기철도산업기사");
	    	examno.setWriteApply("2019-07-05~2019-07-11");
	    	examno.setWriteExam("2019-08-04");
	    	examno.setPassDate("2019-08-30");
	    	examno.setSkillApply("2019-09-02~2019-09-05");
	    	examno.setSkillExam("2019-10-12~2019-10-25");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0109");
	    	examno.setTurn("2019년 정기 기사 1회");
	    	examno.setTitle("전기응용기술사");
	    	examno.setWriteApply("2019-04-12~2019-04-18");
	    	examno.setWriteExam("2019-05-05");
	    	examno.setPassDate("2019-06-14");
	    	examno.setSkillApply("2019-06-17~2019-06-20");
	    	examno.setSkillExam("2019-07-13~2019-07-22");
	    	examno.setFinalPass("2019-08-02");
	    	
	    	tb_examno.add(examno);
	    	
	    	examno = new ExamNoVO();
	    	examno.setCategoryNum("0109");
	    	examno.setTurn("2019년 정기 기사 2회");
	    	examno.setTitle("전기응용기술사");
	    	examno.setWriteApply("2019-07-19~2019-07-25");
	    	examno.setWriteExam("2019-08-10");
	    	examno.setPassDate("2019-09-11");
	    	examno.setSkillApply("2019-09-16~2019-09-19");
	    	examno.setSkillExam("2019-11-02~2019-11-11");
	    	examno.setFinalPass("2019-11-22");
	    	
	    	tb_examno.add(examno);
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
}
