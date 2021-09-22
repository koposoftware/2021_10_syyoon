package kr.co.hana.consult.vo;

public class ChatFileVO {
	
	private String sender;
	private String senddt;
	private int fileid;
	private String filesavenm;
	private String fileorinm;
	private String filesize;
	private String roomid;
	
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenddt() {
		return senddt;
	}
	public void setSenddt(String senddt) {
		this.senddt = senddt;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getFilesavenm() {
		return filesavenm;
	}
	public void setFilesavenm(String filesavenm) {
		this.filesavenm = filesavenm;
	}
	public String getFileorinm() {
		return fileorinm;
	}
	public void setFileorinm(String fileorinm) {
		this.fileorinm = fileorinm;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	@Override
	public String toString() {
		return "ChatFileVO [sender=" + sender + ", senddt=" + senddt + ", fileid=" + fileid + ", filesavenm="
				+ filesavenm + ", fileorinm=" + fileorinm + ", filesize=" + filesize + ", roomid=" + roomid + "]";
	}
	
	
	
	

}
