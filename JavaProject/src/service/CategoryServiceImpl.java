package service;

import dao.CategoryDao;
import dao.CategoryDaoImpl;

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

    }

    @Override
    public void getExamCategory() {

    }

    @Override
    public void getExamNo() {

    }
}
