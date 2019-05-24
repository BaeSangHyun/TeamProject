package dao;

import vo.ExamCategoryVO;
import vo.ExamNo;
import vo.MainCategoryVO;

import java.util.ArrayList;

public interface CategoryDao {

    //메인카테고리 조회
    ArrayList<MainCategoryVO> getMainCategoryList();
    //시험제목 조회
    ArrayList<ExamCategoryVO> getExamCategoryList(int menu);
    //회차 조회
    ArrayList<ExamNo> getExamNo(int menu);

}
