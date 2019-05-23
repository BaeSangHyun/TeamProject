package vo;

//시험종목
public class ExamCategoryVO {
	private String mainNum;	//대분류 번호
	private String categoryNum; //중분류 번호
	private String price;	//가격
	private String qualify;	//검정방법
	private String pass;	//합격기준
	private String examContents;	//출제경향
	
	public String getMainNum() {
		return mainNum;
	}
	public void setMainNum(String mainNum) {
		this.mainNum = mainNum;
	}
	public String getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQualify() {
		return qualify;
	}
	public void setQualify(String qualify) {
		this.qualify = qualify;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getExamContents() {
		return examContents;
	}
	public void setExamContents(String examContents) {
		this.examContents = examContents;
	}
	
	
}
