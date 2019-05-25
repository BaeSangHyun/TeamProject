package controller;

import java.util.Scanner;

import service.AnnounceService;
import service.AnnounceServiceImpl;
import service.CategoryService;
import service.CategoryServiceImpl;


public class AnnounceController {
	private CategoryController categoryController = new CategoryController();
	private CategoryService categoryService = CategoryServiceImpl.getInstance();
	private AnnounceService announceService = AnnounceServiceImpl.getInstance();
	
	
	void announce(){
		Scanner s = new Scanner(System.in);
		
		int menu;
		
		System.out.println("┌────────────────────┐");
        System.out.println(" Q_net ★합격자/답안발표★");
        System.out.println("└────────────────────┘"); 
		System.out.println("1.합격발표");
		System.out.println("2.답안발표");
		System.out.println("0.뒤로가기");

		menu = Integer.parseInt(s.nextLine());
		
		switch(menu){
			case 1: //합격발표
				announceMainCategoryList();
				break;
			case 2: //답안발표
				announceMainCategoryList();
				break;
			case 0: //뒤로가기
				break;
		}		
	}
	
	void announceMainCategoryList(){
        int menu;
        do {
            Scanner s = new Scanner(System.in);
            categoryService.getMainCategory();
            System.out.println("0. 뒤로가기");
            System.out.println("---------------------------------");
            System.out.print("해당 종목 번호를 입력하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            if(menu != 0){
            	announceCategoryList(menu);
            }

        } while (menu != 0);
    }

    void announceCategoryList(int m){
        int menu;
        do{
            Scanner s = new Scanner(System.in);
            categoryService.getExamCategory(m);
            System.out.println("0. 뒤로가기");
            System.out.println("---------------------------------");
            System.out.print("해당 시험 번호를 입력하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            if(menu != 0){
            	announceExamNo(menu);
            }
        }while(menu != 0);
    }

    void announceExamNo(int m){
        int menu;
        do{
            Scanner s = new Scanner(System.in);
            categoryService.getExamNo(m);
            System.out.println("0. 뒤로가기");
            System.out.println("---------------------------------");
            System.out.print("해당 회차 번호를 입력하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            if(menu != 0){
            	announceService.passAnnounce(menu);
            }
        }while(menu != 0);
    }
    
    void candidate(int m){
    	int menu;
    		
    }
	
}
