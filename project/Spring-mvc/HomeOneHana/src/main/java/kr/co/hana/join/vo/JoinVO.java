package kr.co.hana.join.vo;

public class JoinVO {
	
	
	private String id;
	private String password;
	private String addr1;
	private String addr2;
	private String name;
	private String email;
	private String tel;
	private String enrollDt;
	
	public JoinVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(String enrollDt) {
		this.enrollDt = enrollDt;
	}
	@Override
	public String toString() {
		return "JoinVO [id=" + id + ", password=" + password + ", addr1=" + addr1 + ", addr2=" + addr2 + ", name="
				+ name + ", email=" + email + ", tel=" + tel + ", enrollDt=" + enrollDt + "]";
	}
	
	
	
	
	
	
	

}
