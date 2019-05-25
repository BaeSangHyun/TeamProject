package controller;

import service.CategoryService;
import service.CategoryServiceImpl;

import java.util.Scanner;

public class CategoryController {

    private static CategoryService categoryService = CategoryServiceImpl.getInstance();

    void mainCategoryList(){
        int menu;
        do {
            Scanner s = new Scanner(System.in);
            categoryService.getMainCategory();
            System.out.println("0. 뒤로가기");
            System.out.println("---------------------------------");
            System.out.print("해당 종목 번호를 입력하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            if(menu != 0){
                categoryList(menu);
            }

        } while (menu != 0);
    }

    void categoryList(int m){
        int menu;
        do{
            Scanner s = new Scanner(System.in);
            categoryService.getExamCategory(m);
            System.out.println("0. 뒤로가기");
            System.out.println("---------------------------------");
            System.out.print("해당 시험 번호를 입력하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            if(menu != 0){
                examNo(menu);
            }
        }while(menu != 0);
    }

    void examNo(int m){
        int menu;
        do{
            Scanner s = new Scanner(System.in);
            categoryService.getExamNo(m);
            System.out.println("0. 뒤로가기");
            System.out.println("---------------------------------");
            System.out.print("해당 회차 번호를 입력하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            if(menu != 0){

            }
        }while(menu != 0);
    }

    void applyExam(int m){

    }
}
