package dao;

import data.ExamCategoryDB;
import data.ExamNoDB;
import data.MainCategoryDB;
import vo.ExamCategoryVO;
import vo.ExamNo;
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

    @Override
    public ArrayList<MainCategoryVO> getMainCategoryList() {
        return mainCategoryDB.tb_mainCategory;
    }

    @Override
    public ArrayList<ExamCategoryVO> getExamCategoryList(int menu) {
        ArrayList<ExamCategoryVO> temp = new ArrayList<ExamCategoryVO>();
        for(int i = 0; i < examCategoryDB.tb_examcategory.size(); i++){
            if(examCategoryDB.tb_examcategory.get(i).getMainNum() == mainCategoryDB.tb_mainCategory.get(menu-1).getMainNum()){
                temp.add(examCategoryDB.tb_examcategory.get(i));
            }
        }
        return temp;
    }

    @Override
    public ArrayList<ExamNo> getExamNo(int menu) {
        ArrayList<ExamNo> temp = new ArrayList<ExamNo>();
        for(int i = 0; i < examNoDB.tb_examno.size(); i++){
            if(examNoDB.tb_examno.get(i).getCategoryNum() == examCategoryDB.tb_examcategory.get(menu-1).getCategoryNum()){
                temp.add(examNoDB.tb_examno.get(i));
            }
        }
        return temp;
    }

}
