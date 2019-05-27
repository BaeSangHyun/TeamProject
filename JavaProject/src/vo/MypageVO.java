package vo;

public class MypageVO {
	private String id; //유저아이디
	//날짜 서식 : yyyy-MM-dd
	private String title; //시험종목명
	private String issueRequestDate; //신청일자
	private String progressStatus; //발급진행상태
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIssueRequestDate() {
		return issueRequestDate;
	}
	public void setIssueRequestDate(String issueRequestDate) {
		this.issueRequestDate = issueRequestDate;
	}
	public String getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}
}
