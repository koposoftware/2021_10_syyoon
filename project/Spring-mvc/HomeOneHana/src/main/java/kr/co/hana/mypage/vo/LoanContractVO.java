package kr.co.hana.mypage.vo;

public class LoanContractVO {
	private int contractcode;
	private String loanname;
	private String status;
	private String stratdt;
	private String contractdt;
	
	
	public int getContractcode() {
		return contractcode;
	}
	public void setContractcode(int contractcode) {
		this.contractcode = contractcode;
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
	public String getStratdt() {
		return stratdt;
	}
	public void setStratdt(String stratdt) {
		this.stratdt = stratdt;
	}
	public String getContractdt() {
		return contractdt;
	}
	public void setContractdt(String contractdt) {
		this.contractdt = contractdt;
	}
	@Override
	public String toString() {
		return "LoanContractVO [contractcode=" + contractcode + ", loanname=" + loanname + ", status=" + status
				+ ", stratdt=" + stratdt + ", contractdt=" + contractdt + "]";
	}
	
	

}
