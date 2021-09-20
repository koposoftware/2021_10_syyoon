package kr.co.hana.dashboard.vo;

public class UserDashBoardVO {
	
	private int contractcode;
	private String userid;
	private String name; 
	private String loanname;
	private String status;
	private String contractdt;
	
	
	public int getContractcode() {
		return contractcode;
	}
	public void setContractcode(int contractcode) {
		this.contractcode = contractcode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoanname() {
		return loanname;
	}
	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContractdt() {
		return contractdt;
	}
	public void setContractdt(String contractdt) {
		this.contractdt = contractdt;
	}
	@Override
	public String toString() {
		return "UserDashBoardVO [contractcode=" + contractcode + ", userid=" + userid + ", name=" + name + ", loanname="
				+ loanname + ", status=" + status + ", contractdt=" + contractdt + "]";
	}
	
	
	

}
