package service;

public interface CategoryService {

    //대분류 리스트 받기(시험 큰 종류)
    void getMainCategory();

    //중분류 리스트 받기(시험 종목)
    void getExamCategory();

    //시험 회차 리스트
    void getExamNo();
}
