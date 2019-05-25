package controller;

import java.util.Scanner;

import service.CertificateService;
import service.CertificateServiceImpl;
import dao.Session;

public class CertificateController {
	CertificateService certificateService = CertificateServiceImpl.getInstance();
	
	void getCertificate(){
		Scanner s = new Scanner(System.in);
		
		int menu;
		
		System.out.println();
		System.out.println("1.발급하기");
		System.out.println("0.뒤로가기");

		menu = Integer.parseInt(s.nextLine());
		
		switch(menu){
			case 1: //발급하기
				getLicense();
				break;
			case 0: //뒤로가기
				break;
		}		
		
	}
	
	void getLicense(){
		certificateService.issue();
		Scanner s = new Scanner(System.in);
	}
}
