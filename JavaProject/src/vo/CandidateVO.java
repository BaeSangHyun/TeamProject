package vo;

//응시자
public class CandidateVO {
	private String categoryNum; //중분류 번호
	private String turn;	//회차
	private String id;	//아이디
	private String passStatus;	//합격여부
	private int score;	//점수
	
	public String getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}
	public String getTurn() {
		return turn;
	}
	public void setTurn(String turn) {
		this.turn = turn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassStatus() {
		return passStatus;
	}
	public void setPassStatus(String passStatus) {
		this.passStatus = passStatus;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
