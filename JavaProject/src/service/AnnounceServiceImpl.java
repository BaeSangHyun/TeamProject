package service;

import java.util.Scanner;

import vo.ExamNoVO;
import dao.CategoryDaoImpl;

public class AnnounceServiceImpl implements AnnounceService{
	
	private static AnnounceServiceImpl instance;
	
	private AnnounceServiceImpl(){}
	
	public static AnnounceServiceImpl getInstance(){
		if(instance == null){
			instance = new AnnounceServiceImpl();
		}
		return instance;
	}	
	
	CategoryDaoImpl categoryDaoImpl = CategoryDaoImpl.getInstance();
	
	@Override
	public void passAnnounce(int menu) {
		Scanner s = new Scanner(System.in);

		ExamNoVO round1 = categoryDaoImpl.tempExam.get(menu-1);
	}

	@Override
	public void answerAnnounce() {
		
	
		
	}
	
	
}
