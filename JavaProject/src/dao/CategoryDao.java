package dao;

import vo.ExamCategoryVO;
import vo.ExamNoVO;
import vo.MainCategoryVO;

import java.util.ArrayList;

public interface CategoryDao {

    //메인카테고리 리스트 조회
    ArrayList<MainCategoryVO> getMainCategoryList();
    //시험제목 리스트 조회
    ArrayList<ExamCategoryVO> getExamCategoryList(int menu);
    //회차 리스트 조회
    ArrayList<ExamNoVO> getExamNo(int menu);
    //시험 접수를 위한 회차 정보 조회
    ExamNoVO getExam(int menu);
}
