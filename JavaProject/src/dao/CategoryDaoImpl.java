package dao;

public class CategoryDaoImpl implements CategoryDao{
    private static CategoryDaoImpl instance;

    private CategoryDaoImpl(){}

    public static CategoryDaoImpl getInstance(){
        if(instance == null){
            instance = new CategoryDaoImpl();
        }
        return instance;
    }
}
