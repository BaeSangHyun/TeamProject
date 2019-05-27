package data;

import java.util.ArrayList;
import java.util.List;

import vo.AnswerSheetVO;
import vo.ApplyStatusVO;
import vo.BoardVO;
import vo.CandidateVO;
import vo.ExamCategoryVO;
import vo.ExamNoVO;
import vo.MainCategoryVO;
import vo.MypageVO;
import vo.PassPercentVO;
import vo.UserVO;

public class Database {
    private static Database instance;

    private Database(){}

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    //유저테이블
    public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();

    {
        UserVO user = new UserVO();
        user.setId("admin");
        user.setPwd("admin");
        user.setName("관리자");
        user.setRank("admin");
        user.setTel("010-4688-8949");
        tb_user.add(user);
        
        UserVO user2 = new UserVO();
        user2.setId("aaaa");
        user2.setPwd("1111");
        user2.setName("유저1");
        user2.setRank("user");
        user2.setTel("010-4688-8949");
        tb_user.add(user2);
        
        UserVO user3 = new UserVO();
        user3.setId("bbbb");
        user3.setPwd("2222");
        user3.setName("유저2");
        user3.setRank("user");
        user3.setTel("010-4688-8949");
        tb_user.add(user3);
        
        UserVO user4 = new UserVO();
        user4.setId("cccc");
        user4.setPwd("3333");
        user4.setName("유저3");
        user4.setRank("user");
        user4.setTel("010-4688-8949");
        tb_user.add(user4);
    }
   
    //대분류 정보
    public ArrayList<MainCategoryVO> tb_mainCategory = new ArrayList<MainCategoryVO>();

    {
    	MainCategoryVO mainCategory = new MainCategoryVO();
    	mainCategory.setMainNum("01");
    	mainCategory.setMainName("정보기술");
    	
    	tb_mainCategory.add(mainCategory);
    	
    	mainCategory = new MainCategoryVO();
    	mainCategory.setMainNum("02");
    	mainCategory.setMainName("디자인");
    	
    	tb_mainCategory.add(mainCategory);
    	
    	mainCategory = new MainCategoryVO();
    	mainCategory.setMainNum("03");
    	mainCategory.setMainName("전기");

        tb_mainCategory.add(mainCategory);
    }
    
    //중분류 정보 테이블
public ArrayList<ExamCategoryVO> tb_examcategory = new ArrayList<ExamCategoryVO>();
    
    {
    	ExamCategoryVO category = new ExamCategoryVO();
    	category.setMainNum("01");
    	category.setCategoryNum("0101");
    	category.setTitle("정보처리기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 22,600원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형, 과목당 20문항(과목당 30분) / 실기 : 필답형(3시간)");
    	category.setPass("합격 기준 - 필기 : 100점만점의 과목당 40이상, 전과목 평균 60점이상 / 실기 : 100점만점의 60점이상");
    	category.setExamContents("출제 경향 - 국가 IT 기술 경쟁력 제고 및 급변하는 정보화 환경에 대처하기위해 실무중심의 업무 프로세스 기능 및 절차 ");
    	
    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("01");
    	category.setCategoryNum("0102");
    	category.setTitle("정보관리기술사");
    	category.setPrice("시험수수료 - 필기 : 67,800원 / 실기 : 87,100원");
    	category.setQualify("검정방법 - 필기 : 단답형 및 주관식 논술형(매교시당 100분, 총 400분) / 면접 : 구술형 면접(30분정도)");
    	category.setPass("합격 기준 - 필기 : 면접 100점을 만점으로하여 60점 이상");
    	category.setExamContents("출제 경향 - 정보관리에 관련된 실무경험, 일반지식 및 응용능력  ");
    	
    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("01");
    	category.setCategoryNum("0103");
    	category.setTitle("정보처리기능사");
    	category.setPrice("시험수수료 - 필기 : 11,900원 / 실기 : 17,200원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 / 실기 : 필답형(2시간)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로하여 60점 이상 득점자");
    	category.setExamContents("출제 경향 - 필답형 실기시험이므로 출제기준을 참조");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("02");
    	category.setCategoryNum("0201");
    	category.setTitle("컬러리스트기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 34,000원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 과목당 20문항(과목당 30분) / 실기 : 작업형(6시간 정도)");
    	category.setPass("합격 기준 - 필기 : 100점 만점 40점이상, 전과목 평균 60점 이상 / 실기 : 100점 만점 60점 이상");
    	category.setExamContents("출제 경향 - 색채에 관한 이론지식과 실무능력을 가지고 조사, 분석, 계획, 디자인, 관리 등의 기술업무를 수행할 수 있는 능력을 검증하며, 특히 색채업무를 종합적으로 계획∙ 실행∙검증하는 능력의 유무");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("02");
    	category.setCategoryNum("0202");
    	category.setTitle("제품디자인산업기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 31,800원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 과목당 20문항(과목당 30분) / 실기 : 작업형(7시간 정도)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 주어진 과제와 범위에 따라 제품디자인의 계획 및 디자인실무작업 ");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("02");
    	category.setCategoryNum("0203");
    	category.setTitle("시각디자인기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 29,900원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 과목당 20문항(과목당 30분) / 실기 : 작업형(7시간 정도)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 시각디자인계획 및 디자인 실무작업 수행 ");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("03");
    	category.setCategoryNum("0301");
    	category.setTitle("전기기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 22,600원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형, 과목당 20문항(과목당 30분) / 실기 : 필답형(2시간 30분)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 답형 실기시험이므로 시험과목 및 출제기준을 참조하여 수험준비 ");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("03");
    	category.setCategoryNum("0302");
    	category.setTitle("전기철도산업기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 65,700원");
    	category.setQualify("검정방법 - 필기 : 필기 : 객관식 4지 택일형, 과목당 20문항(과목당 30분) / 실기 : 필답형(2시간) ");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 전기철도에 관한 기술, 기초이론 지식 또는 숙련된 기능을 바탕으로 복합적인 기능업무 를 수행할 수 있는 능력의 유무");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("03");
    	category.setCategoryNum("0303");
    	category.setTitle("전기응용기술사");
    	category.setPrice("시험수수료 - 필기 : 67,700원 / 실기 : 87,100원");
    	category.setQualify("검정방법 -  필기 : 단답형 및 주관식 논술형(매교시당 100분, 총 400분) / 면접 : 구술형 면접(30분 정도)");
    	category.setPass("합격 기준 - 필기·면접 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 전기응용과 관련된 실무경험, 전문지식 및 응용능력");

    	tb_examcategory.add(category);
    }
    
    
    //중분류에 따른 시험정보 테이블
    public ArrayList<ExamNoVO> tb_examno = new ArrayList<ExamNoVO>();
    
    {
    	ExamNoVO examno = new ExamNoVO();
    	examno.setCategoryNum("0101");
    	examno.setTurn("2019년 정기 기사 1회");
    	examno.setTitle("정보처리기사");
    	examno.setWriteApply("2019-01-25~2019-01-31");
    	examno.setWriteExam("2019-03-03");
    	examno.setPassDate("2019-03-14");
    	examno.setSkillApply("2019-05-15~2019-07-21");
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
    	examno.setSkillApply("2019-05-20~2019-07-27");
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
    	examno.setCategoryNum("0201");
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
    	examno.setCategoryNum("0201");
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
    	examno.setCategoryNum("0201");
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
    	examno.setCategoryNum("0202");
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
    	examno.setCategoryNum("0203");
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
    	examno.setCategoryNum("0301");
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
    	examno.setCategoryNum("0301");
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
    	examno.setCategoryNum("0301");
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
    	examno.setCategoryNum("0302");
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
    	examno.setCategoryNum("0303");
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
    	examno.setCategoryNum("0303");
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
    	
    //접수내역 테이블
	public List<ApplyStatusVO> tb_applyStatusList = new ArrayList<ApplyStatusVO>();
    
    {
    	ApplyStatusVO ExamList = new ApplyStatusVO();
    	ExamList.setId("aaaa");
    	ExamList.setCategoryNum("0101");
    	ExamList.setApplierNum("12456734");
    	ExamList.setTurn("2019년 정기 기사 1회");
    	ExamList.setExamType("필기");
    	ExamList.setExamDate("2019-03-03");
    	ExamList.setApplyStatus("접수완료");
    	tb_applyStatusList.add(ExamList);
    	
    	ExamList = new ApplyStatusVO();
    	ExamList.setId("bbbb");
    	ExamList.setCategoryNum("0303");
    	ExamList.setApplierNum("17468567");
    	ExamList.setTurn("2019년 정기 기사 2회");
    	ExamList.setExamType("필기");
    	ExamList.setExamDate("2019-04-27");
    	ExamList.setApplyStatus("접수진행중(미결제)");
    	tb_applyStatusList.add(ExamList);
    	
    	ExamList = new ApplyStatusVO();
    	ExamList.setId("cccc");
    	ExamList.setCategoryNum("0103");
    	ExamList.setApplierNum("47457934");
    	ExamList.setTurn("2019년 정기 기능사 1회");
    	ExamList.setExamType("필기");
    	ExamList.setExamDate("2019-08-10");
    	ExamList.setApplyStatus("접수완료");
    	tb_applyStatusList.add(ExamList);
    	
    }
    	
    
    //응시자 정보 테이블
    public ArrayList<CandidateVO> tb_candidate = new ArrayList<CandidateVO>();
    {
        CandidateVO candidate = new CandidateVO();
        candidate.setCategoryNum("0103");
        candidate.setTurn("2019년 정기 기능사 1회");
        candidate.setId("cccc");
		candidate.setPassStatus("합격");
        candidate.setScore(82);
		candidate.setExamType("필기");

        tb_candidate.add(candidate);

        candidate = new CandidateVO();
        candidate.setCategoryNum("0201");
        candidate.setTurn("2019년 정기 기사 2회");
        candidate.setId("bbbb");
		candidate.setPassStatus("합격");
        candidate.setScore(61);
		candidate.setExamType("실기");

        tb_candidate.add(candidate);

        candidate = new CandidateVO();
        candidate.setCategoryNum("0101");
        candidate.setTurn("2019년 정기 기사 1회");
        candidate.setId("aaaa");
		candidate.setPassStatus("합격");
        candidate.setScore(92);
		candidate.setExamType("필기");

        tb_candidate.add(candidate);
        
        candidate = new CandidateVO();
        candidate.setCategoryNum("0101");
        candidate.setTurn("2019년 정기 기사 1회");
        candidate.setId("bbbs");
		candidate.setPassStatus("합격");
        candidate.setScore(82);
		candidate.setExamType("필기");

        tb_candidate.add(candidate);
        
        candidate = new CandidateVO();
        candidate.setCategoryNum("0101");
        candidate.setTurn("2019년 정기 기사 1회");
        candidate.setId("bbdbs");
		candidate.setPassStatus("합격");
        candidate.setScore(72);
		candidate.setExamType("실기");

        tb_candidate.add(candidate);
        
        candidate = new CandidateVO();
        candidate.setCategoryNum("0301");
        candidate.setTurn("2019년 정기 기사 1회");
        candidate.setId("aaaa");
		candidate.setPassStatus("불합격");
        candidate.setScore(52);
		candidate.setExamType("필기");

        tb_candidate.add(candidate);
        
        candidate = new CandidateVO();
        candidate.setCategoryNum("0303");
        candidate.setTurn("2019년 정기 기사 2회");
        candidate.setId("bbb");
        candidate.setPassStatus("합격");
        candidate.setScore(89);
		candidate.setExamType("실기");

        tb_candidate.add(candidate);
    }
    
    //자격증발급내역 테이블
    public List<MypageVO> tb_certificateIssueList = new ArrayList<MypageVO>();
    
    {
    	MypageVO mypageVO = new MypageVO();
    	mypageVO.setId("aaaa");
    	mypageVO.setTitle("정보처리기사");
    	mypageVO.setIssueRequestDate("2019-05-25");
    	mypageVO.setProgressStatus("발급완료");
    	tb_certificateIssueList.add(mypageVO);
    	
    	mypageVO = new MypageVO();
    	mypageVO.setId("bbbb");
    	mypageVO.setTitle("정보처리기사");
    	mypageVO.setIssueRequestDate("2019-05-25");
    	mypageVO.setProgressStatus("발급중");
    	tb_certificateIssueList.add(mypageVO);
    }
    
    //합격율 정보 테이블
    public ArrayList<PassPercentVO> tb_passpercent = new ArrayList<PassPercentVO>();

    {
        PassPercentVO passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0101");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("385");
        passpercent.setPassNum("232");
        passpercent.setPassPercent("60.3%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0101");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("212");
        passpercent.setPassNum("58");
        passpercent.setPassPercent("27.4%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0101");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("268");
        passpercent.setPassNum("72");
        passpercent.setPassPercent("26.9");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0102");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("585");
        passpercent.setPassNum("156");
        passpercent.setPassPercent("26.6%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0102");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("44920");
        passpercent.setPassNum("12329");
        passpercent.setPassPercent("27.4%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0102");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("38632");
        passpercent.setPassNum("9085");
        passpercent.setPassPercent("23.5%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0103");
        passpercent.setTurn("2019년 정기 기능사 1회");
        passpercent.setApplyerNum("48869");
        passpercent.setPassNum("15183");
        passpercent.setPassPercent("31.1%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0201");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("2500");
        passpercent.setPassNum("1495");
        passpercent.setPassPercent("59.8%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0201");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("2639");
        passpercent.setPassNum("1623");
        passpercent.setPassPercent("61.5%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0201");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("2623");
        passpercent.setPassNum("1575");
        passpercent.setPassPercent("60%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0202");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("3479");
        passpercent.setPassNum("2085");
        passpercent.setPassPercent("59.9%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0203");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("4282");
        passpercent.setPassNum("2656");
        passpercent.setPassPercent("62%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0301");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("54676");
        passpercent.setPassNum("15878");
        passpercent.setPassPercent("29%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0301");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("3951");
        passpercent.setPassNum("1305");
        passpercent.setPassPercent("33%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0301");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("2288");
        passpercent.setPassNum("728");
        passpercent.setPassPercent("31.8%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0302");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("33504");
        passpercent.setPassNum("7311");
        passpercent.setPassPercent("21.8%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0303");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("250");
        passpercent.setPassNum("16");
        passpercent.setPassPercent("6.4%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0303");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("222");
        passpercent.setPassNum("21");
        passpercent.setPassPercent("9.5%");

        tb_passpercent.add(passpercent);

    }
    
    //답안 발표 DB
    public ArrayList<AnswerSheetVO> answer = new ArrayList<AnswerSheetVO>();

    {
    	AnswerSheetVO answerSheet = new AnswerSheetVO();
        answerSheet.setCategoryNum("0101");
        answerSheet.setTurn("2019년 정기 기사 1회");
        answerSheet.setAnswer("답이다 이게********************1회차");
        answer.add(answerSheet);
        
        answerSheet = new AnswerSheetVO();
        answerSheet.setCategoryNum("0101");
        answerSheet.setTurn("2019년 정기 기사 2회");
        answerSheet.setAnswer("답이다 이게********************2회차");
        answer.add(answerSheet);
        
        answerSheet = new AnswerSheetVO();
        answerSheet.setCategoryNum("0101");
        answerSheet.setTurn("2019년 정기 기사 3회");
        answerSheet.setAnswer("답이다 이게********************3회차");
        answer.add(answerSheet);
        
        answerSheet = new AnswerSheetVO();
        answerSheet.setCategoryNum("0103");
        answerSheet.setTurn("2019년 정기 기능사 1회");
        answerSheet.setAnswer("답이다 이게********************1+회차");
        answer.add(answerSheet);

    }
    
    //게시판 - 공지사항 테이블
	public ArrayList<BoardVO> tb_noticeBoardDB = new ArrayList<BoardVO>();
    
    {
    	BoardVO vo = new BoardVO();
    	vo.setBoardType("Notice");
    	vo.setBoardContent("sdfsdfs");
    	vo.setBoardTitle("제에에에에목");
    	vo.setBoardWriter("글쓰으응으은이");
    	tb_noticeBoardDB.add(vo);
    	
    	vo = new BoardVO();
    	vo.setBoardType("Notice");
    	vo.setBoardContent("sdfsdsddfs");
    	vo.setBoardTitle("제sdf");
    	vo.setBoardWriter("글asdg은이");
    	tb_noticeBoardDB.add(vo);
    	
    }
    
    //게시판 - FAQ 테이블
	public ArrayList<BoardVO> tb_FAQBoardDB = new ArrayList<BoardVO>();
    
    {   	
    	BoardVO vo = new BoardVO();
    	vo.setBoardType("FAQ");
    	vo.setBoardContent("s1111dfs");
    	vo.setBoardTitle("제s2242f");
    	vo.setBoardWriter("글a145은123이");
    	tb_FAQBoardDB.add(vo);  	
    }

    //게시판 - 이의제기
	public ArrayList<BoardVO> tb_userBoardDB = new ArrayList<BoardVO>();
    
	{
    	
    	BoardVO vo = new BoardVO();
    	vo.setBoardType("User");
    	vo.setBoardContent("s1153");
    	vo.setBoardTitle("제s1fwf");
    	vo.setBoardWriter("글a1이");
    	tb_userBoardDB.add(vo);
    	
    	vo = new BoardVO();
    	vo.setBoardType("User");
    	vo.setBoardContent("sgggrg");
    	vo.setBoardTitle("제f");
    	vo.setBoardWriter("글이");
    	tb_userBoardDB.add(vo);
    	
    }
}
