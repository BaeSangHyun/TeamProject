package util;

public class Utility {
    public void checkNull(Object o){
        if(!(o instanceof Integer || o == null || o == 0)){

        }
    }

    public boolean checkNum(Object o){
        if(!(o instanceof Integer)){
            System.out.println("[ 숫자를 입력해주세요. ]");
            return true;
        }
        return false;
    }
}
