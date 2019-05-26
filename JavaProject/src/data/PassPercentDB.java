package data;

import java.util.ArrayList;

import vo.PassPercentVO;

public class PassPercentDB {
    private static PassPercentDB instance;

    private PassPercentDB(){}

    public static PassPercentDB getInstance(){
        if(instance == null){
            instance = new PassPercentDB();
        }
        return instance;
    }

    public ArrayList<PassPercentVO> tb_passpercent = new ArrayList<PassPercentVO>();

    {
        PassPercentVO passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0101");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("385");
        passpercent.setPassNum("232");
        passpercent.setPassPercent("60.3%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0101");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("212");
        passpercent.setPassNum("58");
        passpercent.setPassPercent("27.4%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0101");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("268");
        passpercent.setPassNum("72");
        passpercent.setPassPercent("26.9");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0102");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("585");
        passpercent.setPassNum("156");
        passpercent.setPassPercent("26.6%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0102");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("44920");
        passpercent.setPassNum("12329");
        passpercent.setPassPercent("27.4%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0102");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("38632");
        passpercent.setPassNum("9085");
        passpercent.setPassPercent("23.5%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0103");
        passpercent.setTurn("2019년 정기 기능사 1회");
        passpercent.setApplyerNum("48869");
        passpercent.setPassNum("15183");
        passpercent.setPassPercent("31.1%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0104");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("2500");
        passpercent.setPassNum("1495");
        passpercent.setPassPercent("59.8%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0104");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("2639");
        passpercent.setPassNum("1623");
        passpercent.setPassPercent("61.5%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0104");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("2623");
        passpercent.setPassNum("1575");
        passpercent.setPassPercent("60%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0105");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("3479");
        passpercent.setPassNum("2085");
        passpercent.setPassPercent("59.9%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0106");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("4282");
        passpercent.setPassNum("2656");
        passpercent.setPassPercent("62%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0107");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("54676");
        passpercent.setPassNum("15878");
        passpercent.setPassPercent("29%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0107");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("3951");
        passpercent.setPassNum("1305");
        passpercent.setPassPercent("33%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0107");
        passpercent.setTurn("2019년 정기 기사 3회");
        passpercent.setApplyerNum("2288");
        passpercent.setPassNum("728");
        passpercent.setPassPercent("31.8%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0108");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("33504");
        passpercent.setPassNum("7311");
        passpercent.setPassPercent("21.8%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0109");
        passpercent.setTurn("2019년 정기 기사 1회");
        passpercent.setApplyerNum("250");
        passpercent.setPassNum("16");
        passpercent.setPassPercent("6.4%");

        tb_passpercent.add(passpercent);

        passpercent = new PassPercentVO();
        passpercent.setCategoryNum("0109");
        passpercent.setTurn("2019년 정기 기사 2회");
        passpercent.setApplyerNum("222");
        passpercent.setPassNum("21");
        passpercent.setPassPercent("9.5%");

        tb_passpercent.add(passpercent);

    }
}
