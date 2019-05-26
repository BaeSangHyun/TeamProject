package dao;

import data.ExamCategoryDB;
import data.ExamNoDB;
import data.MainCategoryDB;
import vo.ExamCategoryVO;
import vo.ExamNoVO;
import vo.MainCategoryVO;

import java.util.ArrayList;

public class CategoryDaoImpl implements CategoryDao{
    private static CategoryDaoImpl instance;

    private CategoryDaoImpl(){}

    public static CategoryDaoImpl getInstance(){
        if(instance == null){
            instance = new CategoryDaoImpl();
        }
        return instance;
    }

    MainCategoryDB mainCategoryDB = MainCategoryDB.getInstance();
    ExamCategoryDB examCategoryDB = ExamCategoryDB.getInstance();
    ExamNoDB examNoDB = ExamNoDB.getInstance();
    ArrayList<ExamCategoryVO> tempCategory;
    public ArrayList<ExamNoVO> tempExam;

    @Override
    public ArrayList<MainCategoryVO> getMainCategoryList() {
        return mainCategoryDB.tb_mainCategory;
    }

    @Override
    public ArrayList<ExamCategoryVO> getExamCategoryList(int menu) {
        tempCategory = new ArrayList<ExamCategoryVO>();
        for(int i = 0; i < examCategoryDB.tb_examcategory.size(); i++){
            if(examCategoryDB.tb_examcategory.get(i).getMainNum() == mainCategoryDB.tb_mainCategory.get(menu-1).getMainNum()){
                tempCategory.add(examCategoryDB.tb_examcategory.get(i));
            }
        }
        return tempCategory;
    }

    @Override
    public ArrayList<ExamNoVO> getExamNo(int menu) {
        tempExam = new ArrayList<ExamNoVO>();
        for(int i = 0; i < examNoDB.tb_examno.size(); i++){
            if(examNoDB.tb_examno.get(i).getCategoryNum() == tempCategory.get(menu-1).getCategoryNum()){
                tempExam.add(examNoDB.tb_examno.get(i));
            }
        }
        return tempExam;
    }

    @Override
    public ExamNoVO getExam(int menu) {
        return tempExam.get(menu-1);
    }
}
