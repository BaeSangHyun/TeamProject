package data;

public class MypageDB {

	private static MypageDB instance;

    private MypageDB(){}

    public static MypageDB getInstance(){
        if(instance == null){
            instance = new MypageDB();
        }
        return instance;
    }
}
