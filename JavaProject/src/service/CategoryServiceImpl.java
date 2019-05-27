package service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import util.Utility;
import vo.ApplyStatusVO;
import vo.CandidateVO;
import vo.ExamCategoryVO;
import vo.ExamNoVO;
import vo.MainCategoryVO;
import dao.CategoryDao;
import dao.CategoryDaoImpl;
import dao.Session;

import data.Database;

public class CategoryServiceImpl implements CategoryService {
    public static CategoryServiceImpl instance;

    private  CategoryServiceImpl(){}

    public static CategoryServiceImpl getInstance(){
        if(instance == null){
            instance = new CategoryServiceImpl();
        }
        return instance;
    }

    CategoryDao categoryDao = CategoryDaoImpl.getInstance();
    Database database = Database.getInstance();

    @Override
    public void getMainCategory() {
        ArrayList<MainCategoryVO> mainCategoryVO = categoryDao.getMainCategoryList();
        System.out.println("---------------종목--------------");
        for(int i = 0; i < mainCategoryVO.size(); i++){
            System.out.println(i+1 + ". " + mainCategoryVO.get(i).getMainName());
        }
    }

    @Override
    public void getExamCategory(int menu) {
        ArrayList<ExamCategoryVO> examCategoryVO = categoryDao.getExamCategoryList(menu);
//        if(menu > examCategoryVO.size()) {
//            System.out.println("---------------------------------");
//            System.out.println("목록안의 번호를 입력해주세요");
//            return;
//        }
        System.out.println("---------------시험 목록--------------");
        for(int i = 0; i < examCategoryVO.size(); i++){
            System.out.println(i+1 + ". " + examCategoryVO.get(i).getTitle());
        }
    }

    @Override
    public void getExamNo(int menu) {
        ArrayList<ExamNoVO> examNo = categoryDao.getExamNo(menu);
//        if(menu > examNo.size()) {
//            System.out.println("---------------------------------");
//            System.out.println("목록안의 번호를 입력해주세요");
//            return;
//        }
        System.out.println("-------------" + examNo.get(0).getTitle() + "------------");
        System.out.println("\t\t회차\t\t\t필기시험접수기한\t\t필기시험날짜\t합격발표날짜\t\t실기시험 접수기한\t\t\t\t실기시험\t\t\t최종합격 발표");
        for(int i = 0; i < examNo.size(); i++){
            System.out.println(i+1 + ". " + examNo.get(i).toString());
        }
    }

    @Override
    public void showDetail(int menu, int num) {
        Scanner s = new Scanner(System.in);
        ExamCategoryVO examCategoryVO = categoryDao.getExamCategoryList(menu).get(num-1);
        System.out.println("---------------------------------상세보기-------------------------------------");
        System.out.println(examCategoryVO);
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void applyExam(int menu, int type) {
        ExamNoVO exam = categoryDao.getExam(menu);
        if(type == 1){
            String[] writeDate = exam.getWriteApply().split("~");
            if(dateMath(writeDate)){
                setCandidate(exam, type);
            }
        } else if(type == 2){
            if(!writePassCheck(exam)){
                System.out.println("실기시험 대상자가 아닙니다.");
                return;
            }

            String[] skillDate = exam.getSkillApply().split("~");
            if(dateMath(skillDate)){
                setCandidate(exam, type);
            }
        }
    }

    @Override
    public boolean writePassCheck(ExamNoVO examNoVO) {
        ArrayList<CandidateVO> candidateVO = database.tb_candidate;
        for(int i = 0; i < candidateVO.size(); i++){
            CandidateVO candidate = candidateVO.get(i);
            if(Session.loginUser.getId().equals(candidate.getId()) && examNoVO.getTurn().equals(candidate.getTurn())
                && examNoVO.getCategoryNum().equals(candidate.getCategoryNum()) && candidate.getExamType().equals("필기")
                && candidate.getPassStatus().equals("합격")){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean dateMath(String[] date){
        Calendar calendar = Calendar.getInstance();
        Calendar start_d = Calendar.getInstance();
        Calendar end_d = Calendar.getInstance();
        Date d = new Date();

        String[] start_date = date[0].split("-");
        String[] end_date = date[1].split("-");

        calendar.setTime(d);

        start_d.set(Calendar.YEAR, Integer.parseInt(start_date[0]));
        start_d.set(Calendar.MONTH, Integer.parseInt(start_date[1])-1);
        start_d.set(Calendar.DAY_OF_MONTH, Integer.parseInt(start_date[2]));

        end_d.set(Calendar.YEAR, Integer.parseInt(end_date[0]));
        end_d.set(Calendar.MONTH, Integer.parseInt(end_date[1])-1);
        end_d.set(Calendar.DAY_OF_MONTH, Integer.parseInt(end_date[2]));

        if((calendar.compareTo(start_d) == 1 && calendar.compareTo(end_d) == -1)
           || calendar.compareTo(start_d) == 0 || calendar.compareTo(end_d) == 0){
            System.out.println("접수가 완료되었습니다.");
            return true;
        } else {
            System.out.println("접수기간이 아닙니다.");
            return false;
        }
    }

    @Override
    public void setCandidate(ExamNoVO exam, int type){
        CandidateVO candidateVO = new CandidateVO();
        candidateVO.setCategoryNum(exam.getCategoryNum());
        candidateVO.setTurn(exam.getTurn());
        candidateVO.setId(Session.loginUser.getId());
        int score = (int)(Math.floor((Math.random()*61)+40));
        candidateVO.setScore(score);
        if(score >= 60)candidateVO.setPassStatus("합격");
        else candidateVO.setPassStatus("불합격");
        if(type ==1) candidateVO.setExamType("필기");
        else candidateVO.setExamType("실기");
        database.tb_candidate.add(candidateVO);

        ApplyStatusVO applyStatus = new ApplyStatusVO();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        applyStatus.setCategoryNum(exam.getCategoryNum());
        applyStatus.setTurn(exam.getTurn());
        applyStatus.setId(Session.loginUser.getId());
        applyStatus.setExamDate(simpleDateFormat.format(date));
        applyStatus.setApplyStatus("접수완료");

        if(type == 1) applyStatus.setExamType("필기");
        else applyStatus.setExamType("실기");
        database.tb_applyStatusList.add(applyStatus);

//        System.out.println(candidateVO.getCategoryNum() + " / " + candidateVO.getTurn() + " / " + candidateVO.getId() + " / " + candidateVO.getPassStatus() + " / " + candidateVO.getScore());
//        System.out.println(applyStatus.getCategoryNum() + " / " + applyStatus.getTurn() + " / " + applyStatus.getId() + " / " + applyStatus.getApplyStatus() + " / " + applyStatus.getExamType());
    }

    @Override
    public void insert(String type, int menu) {
        Scanner s = new Scanner(System.in);
        if(type.equals("MainCategory")){
            MainCategoryVO mainCategoryVO = new MainCategoryVO();

            System.out.print("추가할 종목명 > ");
            mainCategoryVO.setMainName(s.nextLine());
            mainCategoryVO.setMainNum(String.format("%02d", database.tb_mainCategory.size()+1));
            database.tb_mainCategory.add(mainCategoryVO);

        } else if(type.equals("Category")){
            ArrayList<MainCategoryVO> mainCategoryVO = categoryDao.getMainCategoryList();
            ArrayList<ExamCategoryVO> categoryDBList = categoryDao.getExamCategoryList(menu);
            ExamCategoryVO examCategoryVO = new ExamCategoryVO();

            System.out.print("추가할 시험명 > ");
            examCategoryVO.setMainNum(mainCategoryVO.get(menu-1).getMainNum());
            examCategoryVO.setCategoryNum(examCategoryVO.getMainNum() + String.format("%02d", categoryDBList.size()+1));
            examCategoryVO.setTitle(s.nextLine());
            System.out.print("가격 > ");
            examCategoryVO.setPrice(s.nextLine());
            System.out.print("검정방법 > ");
            examCategoryVO.setQualify(s.nextLine());
            System.out.print("합격기준 > ");
            examCategoryVO.setPass(s.nextLine());
            System.out.print("출제경향 > ");
            examCategoryVO.setExamContents(s.nextLine());
            database.tb_examcategory.add(examCategoryVO);

        } else if(type.equals("ExamNo")){
            ArrayList<ExamCategoryVO> categoryDBList = categoryDao.getExamCategoryList(menu);
            ArrayList<ExamNoVO> examNoVOList = categoryDao.getExamNo(menu);
            ExamNoVO examNoVO = new ExamNoVO();

            examNoVO.setCategoryNum(categoryDBList.get(menu-1).getCategoryNum());
            System.out.print("추가할 시험 회차 > ");
            examNoVO.setTurn(s.nextLine());
            examNoVO.setTitle(categoryDBList.get(menu-1).getTitle());
            System.out.print("필기시험접수기한 > ");
            examNoVO.setWriteApply(s.nextLine());
            System.out.print("필기시험날짜 > ");
            examNoVO.setWriteExam(s.nextLine());
            System.out.print("합격발표날짜 > ");
            examNoVO.setPassDate(s.nextLine());
            System.out.print("실기시험접수기한 > ");
            examNoVO.setSkillApply(s.nextLine());
            System.out.print("실기시험 > ");
            examNoVO.setSkillExam(s.nextLine());
            System.out.print("최종합격 발표 > ");
            examNoVO.setFinalPass(s.nextLine());
            database.tb_examno.add(examNoVO);

        }
    }

    @Override
    public void delete(String type, int menu) {
        Scanner s = new Scanner(System.in);
        if(type.equals("MainCategory")){
            System.out.print("삭제할 항목 > ");
            database.tb_mainCategory.remove(Integer.parseInt(s.nextLine())-1);

        } else if(type.equals("Category")){
            ArrayList<ExamCategoryVO> examCategoryVO = categoryDao.getExamCategoryList(menu);

            System.out.print("삭제할 항목 > ");
            int num = Integer.parseInt(s.nextLine());
            for(int i = 0; i < database.tb_examcategory.size(); i++){
                if(database.tb_examcategory.get(i).getCategoryNum().equals(examCategoryVO.get(num-1).getCategoryNum())){
                	database.tb_examcategory.remove(i);
                }
            }

        } else if(type.equals("ExamNo")){
            ArrayList<ExamNoVO> examNoVO = categoryDao.getExamNo(menu);
            System.out.printf("삭제할 항목 > ");
            String str = s.nextLine();
            if(new Utility().checkNum(str)) return;
            int num = Integer.parseInt(str);
            for(int i = 0; i < database.tb_examno.size(); i++){
                if(database.tb_examno.get(i).getTurn().equals(examNoVO.get(num-1).getTurn())){
                    database.tb_examno.remove(i);
                }
            }
        }
    }

    @Override
    public void modify(String type, int menu) {
        Scanner s = new Scanner(System.in);
        if(type.equals("MainCategory")){
            System.out.print("수정할 항목을 선택해 주세요 > ");
            String str = s.nextLine();
            if(new Utility().checkNum(str)) return;
            MainCategoryVO categoryVO = database.tb_mainCategory.get(Integer.parseInt(str)-1);
            System.out.print("변경하실 이름을 적어주세요 > ");
            categoryVO.setMainName(s.nextLine());

        } else if(type.equals("Category")){
            ArrayList<ExamCategoryVO> categoryDB = categoryDao.getExamCategoryList(menu);
            String modi;

            System.out.print("수정할 항목을 선택해 주세요 > ");
            ExamCategoryVO examCategoryVO = categoryDB.get(Integer.parseInt(s.nextLine())-1);
            System.out.println("[ 1. 시험명 | 2. 가격 | 3. 검정방법 | 4. 합격기준 | 5. 출제경향 | 0. 돌아가기]");
            System.out.print("수정할 항목을 선택하세요 > ");
            String str = s.nextLine();
            if(new Utility().checkNum(str)) return;
            int modify = Integer.parseInt(str);
            switch (modify){
                case 1 :
                    System.out.print("시험명 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examCategoryVO.setTitle(modi);
                    break;
                case 2 :
                    System.out.print("가격 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examCategoryVO.setPrice(modi);
                    break;
                case 3 :
                    System.out.print("검정방법 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examCategoryVO.setQualify(modi);
                    break;
                case 4 :
                    System.out.print("합격기준 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examCategoryVO.setPass(modi);
                    break;
                case 5 :
                    System.out.print("출제경향 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examCategoryVO.setExamContents(modi);
                    break;
                case 0 :
                    break;
                default:
                    System.out.println("[ 잘못된 입력입니다. ]");
                    break;
            }

        } else if(type.equals("ExamNo")){
            ArrayList<ExamNoVO> examNoDB = categoryDao.getExamNo(menu);
            String modi;
            System.out.println("수정할 항목을 선택해 주세요 > ");
            ExamNoVO examNoVO = examNoDB.get(Integer.parseInt(s.nextLine())-1);
            System.out.print("[ 1. 제목 | 2. 필기시험접수기한 | 3. 필기시험날짜 | 4. 합격발표날짜 | 5. 실기시험 접수기한 | 6. 실기시험 | 7. 최종합격 발표 | 0. 돌아가기 ]");
            String str = s.nextLine();
            if(new Utility().checkNum(str)) return;
            int modify = Integer.parseInt(str);
            switch (modify){
                case 1 :
                    System.out.print("제목 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setTurn(modi);
                    break;
                case 2 :
                    System.out.print("필기시험접수기한 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setWriteApply(modi);
                    break;
                case 3 :
                    System.out.print("필기시험날짜 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setWriteExam(modi);
                    break;
                case 4 :
                    System.out.print("합격발표날짜 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setPassDate(modi);
                    break;
                case 5 :
                    System.out.print("실기시험 접수기한 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setSkillApply(modi);
                    break;
                case 6 :
                    System.out.print("실기시험 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setSkillExam(modi);
                    break;
                case 7 :
                    System.out.print("최종합격발표 > ");
                    modi = s.nextLine();
                    if(!(modi.equals("0") || modi.equals(""))) examNoVO.setFinalPass(modi);
                    break;
                case 0 :
                    break;
                default:
                    System.out.println("[ 잘못된 입력입니다. ]");
                    break;
            }
        }
    }

}
