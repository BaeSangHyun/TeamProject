package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.CertificateService;
import service.CertificateServiceImpl;
import vo.UserVO;
import dao.Session;

public class CertificateController {
	CertificateService certificateService = CertificateServiceImpl.getInstance();
	Scanner s = new Scanner(System.in);
	void getCertificate(){
		int menu;
		do {
			System.out.println();
			System.out.println("1.시험합격 내역보기 / 자격증 발급 신청");
			System.out.println("2.자격증 발급내역");
			System.out.println("0.뒤로가기");
			System.out.print("메뉴에 해당하는 번호 입력 >");
			menu = Integer.parseInt(s.nextLine());

			switch (menu) {
				case 1: //시험합격내역보기
					getCertificateList();
					break;
				case 2: //발급내역
					certificateService.getCertificateList();
					break;
				case 0: //뒤로가기
					break;
			}
		}while(menu != 0);
	}

	private void getCertificateList() {
		int menu;
		do {
			certificateService.confirmPass();
			System.out.println("──────────────────────────────────────────────────────────────");
			System.out.println("[ 1. 신청하기 | 0. 뒤로가기 ]");
			System.out.print("수행할 동작을 선택하세요 > ");
			menu = Integer.parseInt(s.nextLine());
			switch (menu) {
				case 1:
					System.out.print("발급할 자격증을 선택하세요 > ");
					menu = Integer.parseInt(s.nextLine());
					applyCertificate(menu);
					break;
				case 0:
					break;
				default:
					System.out.println("잘못된 번호입니다.");
					break;
			}
		}while (menu != 0);
	}

	private void applyCertificate(int m){
		certificateService.issue(m);
	}

	void CertificateManage(){
		int menu;
		do {
			System.out.println();
			System.out.println("1.자격증 발급내역");
			System.out.println("0.뒤로가기");
			System.out.print("메뉴에 해당하는 번호 입력 >");
			menu = Integer.parseInt(s.nextLine());

			switch (menu) {
				case 1: //발급내역
					certificateService.getCertificateList();
					break;
				case 0: //뒤로가기
					break;
			}
		}while(menu != 0);
	}
}
	
	

