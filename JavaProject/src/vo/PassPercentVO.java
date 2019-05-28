package vo;

//합격자 통계
public class PassPercentVO {
	private String categoryNum;	//중분류 번호
	private String turn;		//회차
	private String applyerNum;	//응시자 수
	private String passNum;		//합격자 수
	private String passPercent;	//합격률
	
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
	public String getApplyerNum() {
		return applyerNum;
	}
	public void setApplyerNum(String applyerNum) {
		this.applyerNum = applyerNum;
	}
	public String getPassNum() {
		return passNum;
	}
	public void setPassNum(String passNum) {
		this.passNum = passNum;
	}
	public String getPassPercent() {
		return passPercent;
	}
	public void setPassPercent(String passPercent) {
		this.passPercent = passPercent;
	}
}
