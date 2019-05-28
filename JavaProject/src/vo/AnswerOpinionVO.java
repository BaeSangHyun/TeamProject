package vo;

//의견제시 - 사용안함
public class AnswerOpinionVO {
	private String categoryNum; //중분류 번호
	private String turn;	//회차
	private String title;	//제목
	private String content;	//내용
	private String opinionWriter;	//작성자
	private String opinionDate;	//작성날짜
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOpinionWriter() {
		return opinionWriter;
	}
	public void setOpinionWriter(String opinionWriter) {
		this.opinionWriter = opinionWriter;
	}
	public String getOpinionDate() {
		return opinionDate;
	}
	public void setOpinionDate(String opinionDate) {
		this.opinionDate = opinionDate;
	}
	
}
