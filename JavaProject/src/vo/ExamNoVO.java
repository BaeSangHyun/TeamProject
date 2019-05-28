package vo;

//시험 회차
public class ExamNoVO {
	private String categoryNum;	//중분류 번호
	private String turn;		//회차
	private String title;		//회차제목
	//날짜 서식 : yyyy-MM-dd or yyyy-MM-dd~yyyy-MM-dd
	private String writeApply;	//필기시험접수기한
	private String writeExam;	//필기시험날짜
	private String passDate;	//합격발표날짜
	private String skillApply;	//실기시험 접수기한
	private String skillExam;	//실기시험
	private String finalPass;	//최종합격 발표
	
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
	public String getWriteApply() {
		return writeApply;
	}
	public void setWriteApply(String writeApply) {
		this.writeApply = writeApply;
	}
	public String getWriteExam() {
		return writeExam;
	}
	public void setWriteExam(String writeExam) {
		this.writeExam = writeExam;
	}
	public String getPassDate() {
		return passDate;
	}
	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}
	public String getSkillApply() {
		return skillApply;
	}
	public void setSkillApply(String skillApply) {
		this.skillApply = skillApply;
	}
	public String getSkillExam() {
		return skillExam;
	}
	public void setSkillExam(String skillExam) {
		this.skillExam = skillExam;
	}
	public String getFinalPass() {
		return finalPass;
	}
	public void setFinalPass(String finalPass) {
		this.finalPass = finalPass;
	}

	@Override
	public String toString() {
		return turn+"\t"+writeApply+"\t"+writeExam+"\t"+passDate+"\t"+skillApply+"\t"
				+skillExam+"\t"+finalPass;
	}
}
