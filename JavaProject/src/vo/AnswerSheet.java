package vo;

//답안지
public class AnswerSheet {
	private String categoryNum; //중분류 번호
	private String turn;	//회차
	private String answer;	//답
	
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
