package data;

import java.util.ArrayList;

import vo.CandidateVO;
import vo.MainCategoryVO;

public class CandidateDB {
    private static CandidateDB instance;

    private CandidateDB(){}

    public static CandidateDB getInstance(){
        if(instance == null){
            instance = new CandidateDB();
        }
        return instance;
    }

    public ArrayList<CandidateVO> tb_candidate = new ArrayList<CandidateVO>();

    {
        CandidateVO candidate = new CandidateVO();
        candidate.setCategoryNum("0103");
        candidate.setTurn("2019년 정기 기능사 1회");
        candidate.setId("cccc");
        candidate.setPassStatus("합격입니다");
        candidate.setScore("82점");

        tb_candidate.add(candidate);

        candidate = new CandidateVO();
        candidate.setCategoryNum("0107");
        candidate.setTurn("2019년 정기 기사 2회");
        candidate.setId("bbbb");
        candidate.setPassStatus("합격입니다");
        candidate.setScore("61점");

        tb_candidate.add(candidate);

        candidate = new CandidateVO();
        candidate.setCategoryNum("0101");
        candidate.setTurn("2019년 정기 기사 1회");
        candidate.setId("aaaa");
        candidate.setPassStatus("불합격입니다");
        candidate.setScore("52점");

        tb_candidate.add(candidate);
    }

}
