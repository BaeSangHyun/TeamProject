package service;

import vo.ExamNoVO;

public interface CategoryService {

    //대분류 리스트 받기(시험 큰 종류)
    void getMainCategory();

    //중분류 리스트 받기(시험 종목)
    void getExamCategory(int menu);

    //시험 회차 리스트
    void getExamNo(int menu);

    //시험 접수
    void applyExam(int menu, int type);

    //시험 날짜 비교
    boolean dateMath(String[] date);

    //응시자, 시험접수현황에 추가
    void setCandidate(ExamNoVO exam, int type);


    //추가
    void insert(String type, int menu);
    //삭제
    void delete(String type, int menu);
    //수정
    void modify(String type, int menu);
}
