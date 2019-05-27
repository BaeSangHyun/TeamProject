package vo;

//마이페이지 등록한 응시시험 목록
public class MyExamListVO {
	private String id;	//아이디
	private String turn;	//회차
	private String categoryNum; //중분류 번호
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTurn() {
		return turn;
	}
	public void setTurn(String turn) {
		this.turn = turn;
	}
	public String getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}
	
}
