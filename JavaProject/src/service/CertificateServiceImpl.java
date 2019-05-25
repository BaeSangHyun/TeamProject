package service;

import java.util.Scanner;


public class CertificateServiceImpl implements CertificateService{

	private static CertificateServiceImpl instance;
	
	private CertificateServiceImpl(){}
	
	public static CertificateServiceImpl getInstance(){
		if(instance == null){
			instance = new CertificateServiceImpl();
		}
		return instance;
	}

	@Override
	public void getCertificate() {
		
	}

	@Override
	public void issue() {
		//getLicense
		System.out.println("------------합격 종목------------");
		//for()
		//system(i+1 + ". " + dkkdlfj.get(i).getTitle())
		
		
		
	}
	
}
