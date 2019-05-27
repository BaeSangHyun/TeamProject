package service;

public interface UserService {
    void join();    //회원가입

    void login();   //로그인
    
    void logout(); 	//로그아웃

    void userList();    //회원 전체 목록 출력
}
