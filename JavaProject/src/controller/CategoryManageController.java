package controller;

import service.CategoryService;
import service.CategoryServiceImpl;

import java.util.Scanner;

public class CategoryManageController {
    private static CategoryService categoryService = CategoryServiceImpl.getInstance();

    void mainCategoryList(){
        int menu;
        do {
            Scanner s = new Scanner(System.in);
            categoryService.getMainCategory();
            System.out.println("---------------------------------");
            manageMenu();
            System.out.print("수행할 작업을 선택하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            switch (menu){
                case 1 :
                    categoryService.insert("MainCategory", menu);
                    break;
                case 2 :
                    categoryService.delete("MainCategory", menu);
                    break;
                case 3 :
                    categoryService.modify("MainCategory", menu);
                    break;
                case 4 :
                    System.out.printf("항목을 선택하세요 > ");
                    categoryList(Integer.parseInt(s.nextLine()));
                    break;
                case 5 :
                    break;
            }
        } while (menu != 0);
    }

    void categoryList(int m){
        int menu;
        do{
            Scanner s = new Scanner(System.in);
            categoryService.getExamCategory(m);
            System.out.println("---------------------------------");
            manageMenu();
            System.out.print("수행할 작업을 선택하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            switch (menu){
                case 1 :
                    categoryService.insert("Category", m);
                    break;
                case 2 :
                    categoryService.delete("Category", m);
                    break;
                case 3 :
                    categoryService.modify("Category", m);
                    break;
                case 4 :
                    System.out.printf("항목을 선택하세요 > ");
                    examNo(Integer.parseInt(s.nextLine()));
                    break;
                case 5 :
                    break;
            }
        }while(menu != 0);
    }

    void examNo(int m){
        int menu;
        do{
            Scanner s = new Scanner(System.in);
            categoryService.getExamNo(m);
            System.out.println("---------------------------------");
            manageMenu();
            System.out.print("수행할 작업을 선택하세요 > ");
            menu = Integer.parseInt(s.nextLine());
            switch (menu){
                case 1 :
                    categoryService.insert("ExamNo", m);
                    break;
                case 2 :
                    categoryService.delete("ExamNo", m);
                    break;
                case 3 :
                    categoryService.modify("ExamNo", m);
                    break;
                case 4 :
                    break;
                case 5 :
                    break;
            }
        }while(menu != 0);
    }

    void manageMenu(){
        System.out.print("[ 1. 추가 | ");
        System.out.print("2. 삭제 | ");
        System.out.print("3. 수정 | ");
        System.out.print("4. 항목 선택 | ");
        System.out.printf("5. 상세보기 | ");
        System.out.println("0. 뒤로가기 ]");
    }


}
