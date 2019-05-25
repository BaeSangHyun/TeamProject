package dao;

public class AnnounceDaoImpl implements AnnounceDao{

	private static AnnounceDaoImpl instance;
	
	private AnnounceDaoImpl(){}
	
	public static AnnounceDaoImpl getInstance(){
		if(instance == null){
			instance = new AnnounceDaoImpl();
		}
		return instance;	
	}

	//AnnounceDB = AnnounceDB.getInstance();
	
	@Override
	public void passAnnounce() {
			
	}

	
	@Override
	public void answerAnnounce() {

		
	}
	
	
	
	
	
	
	
	
}
