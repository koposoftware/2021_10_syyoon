package kr.co.hana.search.vo;

public class FavoriteVO {
	
	private String id;
	private int hsmpsn;
	private String enrolldt;
	private String rnadres;
	private String suplytynm;
	private String housetynm;
	private String insttnm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHsmpsn() {
		return hsmpsn;
	}
	public void setHsmpsn(int hsmpsn) {
		this.hsmpsn = hsmpsn;
	}
	public String getEnrolldt() {
		return enrolldt;
	}
	public void setEnrolldt(String enrolldt) {
		this.enrolldt = enrolldt;
	}
	public String getRnadres() {
		return rnadres;
	}
	public void setRnadres(String rnadres) {
		this.rnadres = rnadres;
	}
	public String getSuplytynm() {
		return suplytynm;
	}
	public void setSuplytynm(String suplytynm) {
		this.suplytynm = suplytynm;
	}
	public String getHousetynm() {
		return housetynm;
	}
	public void setHousetynm(String housetynm) {
		this.housetynm = housetynm;
	}
	public String getInsttnm() {
		return insttnm;
	}
	public void setInsttnm(String insttnm) {
		this.insttnm = insttnm;
	}
	@Override
	public String toString() {
		return "FavoriteVO [id=" + id + ", hsmpsn=" + hsmpsn + ", enrolldt=" + enrolldt + ", rnadres=" + rnadres
				+ ", suplytynm=" + suplytynm + ", housetynm=" + housetynm + ", insttnm=" + insttnm + "]";
	}
	
	
	

	
	
	
}
