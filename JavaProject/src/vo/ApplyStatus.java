package vo;

//시험접수현황
public class ApplyStatus {
	private String categoryNum; //중분류 번호
	private String turn;	//회차
	private String id;	//id
	private String applyStatus;	//접수상태
	private String examType;	//시험유형(필기/실기)
	
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
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	
	
}
