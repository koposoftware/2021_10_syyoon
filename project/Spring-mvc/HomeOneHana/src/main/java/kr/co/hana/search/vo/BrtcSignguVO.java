package kr.co.hana.search.vo;

public class BrtcSignguVO {
	
	
	private String brtcnm; 
	private String signgunm;
	private int brtccode;	
	private int signgucode; 
	
	
	public String getBrtcnm() {
		return brtcnm;
	}
	public void setBrtcnm(String brtcnm) {
		this.brtcnm = brtcnm;
	}
	public String getSigngunm() {
		return signgunm;
	}
	public void setSigngunm(String signgunm) {
		this.signgunm = signgunm;
	}
	public int getBrtccode() {
		return brtccode;
	}
	public void setBrtccode(int brtccode) {
		this.brtccode = brtccode;
	}
	public int getSigngucode() {
		return signgucode;
	}
	public void setSigngucode(int signgucode) {
		this.signgucode = signgucode;
	}
	@Override
	public String toString() {
		return "BrtcSigngu [brtcnm=" + brtcnm + ", signgunm=" + signgunm + ", brtccode=" + brtccode + ", signgucode="
				+ signgucode + "]";
	}
	
	

}
