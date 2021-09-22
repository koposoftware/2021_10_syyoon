package kr.co.hana.consult.vo;


public class ChatRoomVO {
	
	
	private int roomid;
	private String roomnm;
	private String managerid;
	private String userid;
	private String usernm;
	private String filesavenm;
	
	
	
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getRoomnm() {
		return roomnm;
	}
	public void setRoomnm(String roomnm) {
		this.roomnm = roomnm;
	}
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getFilesavenm() {
		return filesavenm;
	}
	public void setFilesavenm(String filesavenm) {
		this.filesavenm = filesavenm;
	}
	@Override
	public String toString() {
		return "ChatRoomVO [roomid=" + roomid + ", roomnm=" + roomnm + ", managerid=" + managerid + ", userid=" + userid
				+ ", usernm=" + usernm + ", filesavenm=" + filesavenm + "]";
	}
	
	
	
	

}
