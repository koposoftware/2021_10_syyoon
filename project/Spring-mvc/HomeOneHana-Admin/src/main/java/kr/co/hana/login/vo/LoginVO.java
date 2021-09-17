package kr.co.hana.login.vo;

public class LoginVO {
	
	private String id;
	private String password;
	private String name;
	private String job;
	private String dept;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + ", name=" + name + ", job=" + job + ", dept=" + dept
				+ "]";
	}

	

}
