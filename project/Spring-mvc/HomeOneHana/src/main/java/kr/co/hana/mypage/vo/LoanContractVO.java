package kr.co.hana.mypage.vo;

public class LoanContractVO {
	private int contractcode;
	private String loanname;
	private String status;
	private String stratdt;
	private String accountdt;
	private String account;
	private String loanaccount;
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
	public String getAccountdt() {
		return accountdt;
	}
	public void setAccountdt(String accountdt) {
		this.accountdt = accountdt;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLoanaccount() {
		return loanaccount;
	}
	public void setLoanaccount(String loanaccount) {
		this.loanaccount = loanaccount;
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
				+ ", stratdt=" + stratdt + ", accountdt=" + accountdt + ", account=" + account + ", loanaccount="
				+ loanaccount + ", contractdt=" + contractdt + "]";
	}
	
	
	

}
