package service;

import dao.CategoryDao;
import dao.CategoryDaoImpl;
import vo.ExamCategoryVO;
import vo.ExamNo;
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
        System.out.println("---------------시험--------------");
        for(int i = 0; i < examCategoryVO.size(); i++){
            System.out.println(i+1 + ". " + examCategoryVO.get(i).getTitle());
        }
    }

    @Override
    public void getExamNo(int menu) {
        ArrayList<ExamNo> examNo = categoryDao.getExamNo(menu);
        System.out.println("---------------회차--------------");
        for(int i = 0; i < examNo.size(); i++){
            System.out.println(i+1 + ". " + examNo.get(i).getTurn() + examNo.get(i).getTitle());
        }
    }
}
