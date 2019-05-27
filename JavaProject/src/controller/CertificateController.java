package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.CertificateService;
import service.CertificateServiceImpl;
import vo.UserVO;
import dao.Session;

public class CertificateController {
	CertificateService certificateService = CertificateServiceImpl.getInstance();
	
	void getCertificate(){
		Scanner s = new Scanner(System.in);
		
		int menu;
		
		System.out.println();
		System.out.println("1.시험합격 내역보기");
		System.out.println("2.자격증 발급내역");
		System.out.println("0.뒤로가기");
		System.out.print("메뉴에 해당하는 번호 입력 >");
		menu = Integer.parseInt(s.nextLine());
		
		
		switch(menu){
			case 1: //시험합격내역보기
				finalpass();
				break;
			case 2: //발급하기
				getLicense();
				break;
			case 0: //뒤로가기
				break;
		}		
		
	}
	
	
	
	private void finalpass() {
		certificateService.getCertificate();
		
	}



	void getLicense(){
		certificateService.issue();
		Scanner s = new Scanner(System.in);
	}
}
