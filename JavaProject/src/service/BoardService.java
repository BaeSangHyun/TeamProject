package service;

public interface BoardService {
	void insertBoard(String type);
	void deleteBoard();
	void updateBoard();
	void contentViewBoard();
	void mainViewBoard(String type);
}
