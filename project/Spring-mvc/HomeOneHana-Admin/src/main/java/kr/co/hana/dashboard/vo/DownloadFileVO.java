package kr.co.hana.dashboard.vo;

public class DownloadFileVO {
	
	private String enrolldt;
	private String file_ori_name;
	private String file_save_name;
	private double filesize;
	
	
	
	public String getEnrolldt() {
		return enrolldt;
	}
	public void setEnrolldt(String enrolldt) {
		this.enrolldt = enrolldt;
	}
	public String getFile_ori_name() {
		return file_ori_name;
	}
	public void setFile_ori_name(String file_ori_name) {
		this.file_ori_name = file_ori_name;
	}
	public String getFile_save_name() {
		return file_save_name;
	}
	public void setFile_save_name(String file_save_name) {
		this.file_save_name = file_save_name;
	}
	public double getFilesize() {
		return filesize;
	}
	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}
	@Override
	public String toString() {
		return "DownloadFileVO [enrolldt=" + enrolldt + ", file_ori_name=" + file_ori_name + ", file_save_name="
				+ file_save_name + ", filesize=" + filesize + "]";
	}
	
	
	

}
