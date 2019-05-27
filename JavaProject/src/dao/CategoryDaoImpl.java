package dao;

import java.util.ArrayList;

import vo.ExamCategoryVO;
import vo.ExamNoVO;
import vo.MainCategoryVO;
import data.Database;

public class CategoryDaoImpl implements CategoryDao{
    private static CategoryDaoImpl instance;

    private CategoryDaoImpl(){}

    public static CategoryDaoImpl getInstance(){
        if(instance == null){
            instance = new CategoryDaoImpl();
        }
        return instance;
    }

    Database database = Database.getInstance();
    ArrayList<ExamCategoryVO> tempCategory;
    public ArrayList<ExamNoVO> tempExam;

    @Override
    public ArrayList<MainCategoryVO> getMainCategoryList() {
        return database.tb_mainCategory;
    }

    @Override
    public ArrayList<ExamCategoryVO> getExamCategoryList(int menu) {
        tempCategory = new ArrayList<ExamCategoryVO>();
        for(int i = 0; i < database.tb_examcategory.size(); i++){
            if(database.tb_examcategory.get(i).getMainNum() == database.tb_mainCategory.get(menu-1).getMainNum()){
                tempCategory.add(database.tb_examcategory.get(i));
            }
        }
        return tempCategory;
    }

    @Override
    public ArrayList<ExamNoVO> getExamNo(int menu) {
        tempExam = new ArrayList<ExamNoVO>();
        for(int i = 0; i < database.tb_examno.size(); i++){
            if(database.tb_examno.get(i).getCategoryNum() == tempCategory.get(menu-1).getCategoryNum()){
                tempExam.add(database.tb_examno.get(i));
            }
        }
        return tempExam;
    }

    @Override
    public ExamNoVO getExam(int menu) {
        return tempExam.get(menu-1);
    }
}
