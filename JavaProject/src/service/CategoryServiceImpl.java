package service;

import dao.CategoryDao;
import dao.CategoryDaoImpl;
import vo.ExamCategoryVO;
import vo.ExamNoVO;
import vo.MainCategoryVO;

import java.util.ArrayList;

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
        System.out.println("---------------시험--------------");
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
        System.out.println("\t\t회차\t\t\t\t\t필기시험접수기한\t\t필기시험날짜\t합격발표날짜\t\t실기시험 접수기한\t\t\t\t실기시험\t\t\t최종합격 발표");
        for(int i = 0; i < examNo.size(); i++){
            System.out.println(i+1 + ". " + examNo.get(i).toString());
        }
    }
}
