package controller;

import service.CategoryService;
import service.CategoryServiceImpl;

import java.util.Scanner;

public class CategoryController {

    private static CategoryService categoryService = CategoryServiceImpl.getInstance();

    public void categoryList(){
        Scanner s = new Scanner(System.in);
        categoryService.getMainCategory();
    }
}
