package kr.co.hana.schedule.vo;

public class DetailFileVO {
	
	private String homenm;
	private String filenm;
	private String fileurl;
	
	
	public String getHomenm() {
		return homenm;
	}
	public void setHomenm(String homenm) {
		this.homenm = homenm;
	}
	public String getFilenm() {
		return filenm;
	}
	public void setFilenm(String filenm) {
		this.filenm = filenm;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	@Override
	public String toString() {
		return "DetailFileVO [homenm=" + homenm + ", filenm=" + filenm + ", fileurl=" + fileurl + "]";
	}

	
}
