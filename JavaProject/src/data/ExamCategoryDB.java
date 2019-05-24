package data;

import java.util.ArrayList;

import vo.ExamCategoryVO;

public class ExamCategoryDB {
	private static ExamCategoryDB instance;

    private ExamCategoryDB(){}

    public static ExamCategoryDB getInstance(){
        if(instance == null){
            instance = new ExamCategoryDB();
        }
        return instance;

    }
    
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
    	category.setCategoryNum("0104");
    	category.setTitle("컬러리스트기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 34,000원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 과목당 20문항(과목당 30분) / 실기 : 작업형(6시간 정도)");
    	category.setPass("합격 기준 - 필기 : 100점 만점 40점이상, 전과목 평균 60점 이상 / 실기 : 100점 만점 60점 이상");
    	category.setExamContents("출제 경향 - 색채에 관한 이론지식과 실무능력을 가지고 조사, 분석, 계획, 디자인, 관리 등의 기술업무를 수행할 수 있는 능력을 검증하며, 특히 색채업무를 종합적으로 계획∙ 실행∙검증하는 능력의 유무");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("02");
    	category.setCategoryNum("0105");
    	category.setTitle("제품디자인산업기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 31,800원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 과목당 20문항(과목당 30분) / 실기 : 작업형(7시간 정도)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 주어진 과제와 범위에 따라 제품디자인의 계획 및 디자인실무작업 ");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("02");
    	category.setCategoryNum("0106");
    	category.setTitle("시각디자인기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 29,900원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형 과목당 20문항(과목당 30분) / 실기 : 작업형(7시간 정도)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 시각디자인계획 및 디자인 실무작업 수행 ");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("03");
    	category.setCategoryNum("0107");
    	category.setTitle("전기기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 22,600원");
    	category.setQualify("검정방법 - 필기 : 객관식 4지 택일형, 과목당 20문항(과목당 30분) / 실기 : 필답형(2시간 30분)");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 답형 실기시험이므로 시험과목 및 출제기준을 참조하여 수험준비 ");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("03");
    	category.setCategoryNum("0108");
    	category.setTitle("전기철도산업기사");
    	category.setPrice("시험수수료 - 필기 : 19,400원 / 실기 : 65,700원");
    	category.setQualify("검정방법 - 필기 : 필기 : 객관식 4지 택일형, 과목당 20문항(과목당 30분) / 실기 : 필답형(2시간) ");
    	category.setPass("합격 기준 - 필기 : 100점을 만점으로 하여 과목당 40점 이상, 전과목 평균 60점 이상 / 실기 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 전기철도에 관한 기술, 기초이론 지식 또는 숙련된 기능을 바탕으로 복합적인 기능업무 를 수행할 수 있는 능력의 유무");

    	tb_examcategory.add(category);
    	
    	category = new ExamCategoryVO();
    	category.setMainNum("03");
    	category.setCategoryNum("0109");
    	category.setTitle("전기응용기술사");
    	category.setPrice("시험수수료 - 필기 : 67,700원 / 실기 : 87,100원");
    	category.setQualify("검정방법 -  필기 : 단답형 및 주관식 논술형(매교시당 100분, 총 400분) / 면접 : 구술형 면접(30분 정도)");
    	category.setPass("합격 기준 - 필기·면접 : 100점을 만점으로 하여 60점 이상");
    	category.setExamContents("출제 경향 - 전기응용과 관련된 실무경험, 전문지식 및 응용능력");

    	tb_examcategory.add(category);
    }
    
}
