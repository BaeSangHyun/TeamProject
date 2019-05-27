package vo;

//유저
public class UserVO {
    private String id;	//아이디
    private String pwd;	//패스워드
    private String name;	//이름
    private String rank;	//등급
    private String comment; //댓글 (추가)
    private String tel;		//전화번호
//    private String addr;	//주소
    
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
//	public String getAddr() {
//		return addr;
//	}
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

    
}
