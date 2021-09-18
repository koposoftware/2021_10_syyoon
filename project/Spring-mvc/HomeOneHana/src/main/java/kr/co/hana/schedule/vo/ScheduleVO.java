package kr.co.hana.schedule.vo;

public class ScheduleVO {
	
	
	private String pan_ss; 			// 공고상태
	private String pan_nt_st_dt; 	// 게시일
	private String ais_tp_cd; 		//매물유형코드
	private String spl_inf_tp_cd; 	// 공급정보구분코드
	private String cnp_cd_nm; 		// 지역
	private String pan_id; 			// 공고문id
	private String ais_tp_cd_nm; 	// 매물유형이름
	private String clsg_dt; 		// 마감일
	private String pan_dt; 			//모집공고일
	private String upp_ais_tp_cd; 	// 상위매물유형코드
	private String pan_nm; 			// 공고문제목
	private String dtl_url; 		//공고문 url
	private String ccr_cnnt_sys_ds_cd; //고객센터연계시스템구분코드
	
	private String menu_id;

	public String getPan_ss() {
		return pan_ss;
	}

	public void setPan_ss(String pan_ss) {
		this.pan_ss = pan_ss;
	}

	public String getPan_nt_st_dt() {
		return pan_nt_st_dt;
	}

	public void setPan_nt_st_dt(String pan_nt_st_dt) {
		this.pan_nt_st_dt = pan_nt_st_dt;
	}

	public String getAis_tp_cd() {
		return ais_tp_cd;
	}

	public void setAis_tp_cd(String ais_tp_cd) {
		this.ais_tp_cd = ais_tp_cd;
	}

	public String getSpl_inf_tp_cd() {
		return spl_inf_tp_cd;
	}

	public void setSpl_inf_tp_cd(String spl_inf_tp_cd) {
		this.spl_inf_tp_cd = spl_inf_tp_cd;
	}

	public String getCnp_cd_nm() {
		return cnp_cd_nm;
	}

	public void setCnp_cd_nm(String cnp_cd_nm) {
		this.cnp_cd_nm = cnp_cd_nm;
	}

	public String getPan_id() {
		return pan_id;
	}

	public void setPan_id(String pan_id) {
		this.pan_id = pan_id;
	}

	public String getAis_tp_cd_nm() {
		return ais_tp_cd_nm;
	}

	public void setAis_tp_cd_nm(String ais_tp_cd_nm) {
		this.ais_tp_cd_nm = ais_tp_cd_nm;
	}

	public String getClsg_dt() {
		return clsg_dt;
	}

	public void setClsg_dt(String clsg_dt) {
		this.clsg_dt = clsg_dt;
	}

	public String getPan_dt() {
		return pan_dt;
	}

	public void setPan_dt(String pan_dt) {
		this.pan_dt = pan_dt;
	}

	public String getUpp_ais_tp_cd() {
		return upp_ais_tp_cd;
	}

	public void setUpp_ais_tp_cd(String upp_ais_tp_cd) {
		this.upp_ais_tp_cd = upp_ais_tp_cd;
	}

	public String getPan_nm() {
		return pan_nm;
	}

	public void setPan_nm(String pan_nm) {
		this.pan_nm = pan_nm;
	}

	public String getDtl_url() {
		return dtl_url;
	}

	public void setDtl_url(String dtl_url) {
		this.dtl_url = dtl_url;
	}

	public String getCcr_cnnt_sys_ds_cd() {
		return ccr_cnnt_sys_ds_cd;
	}

	public void setCcr_cnnt_sys_ds_cd(String ccr_cnnt_sys_ds_cd) {
		this.ccr_cnnt_sys_ds_cd = ccr_cnnt_sys_ds_cd;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	@Override
	public String toString() {
		return "ScheduleVO [pan_ss=" + pan_ss + ", pan_nt_st_dt=" + pan_nt_st_dt + ", ais_tp_cd=" + ais_tp_cd
				+ ", spl_inf_tp_cd=" + spl_inf_tp_cd + ", cnp_cd_nm=" + cnp_cd_nm + ", pan_id=" + pan_id
				+ ", ais_tp_cd_nm=" + ais_tp_cd_nm + ", clsg_dt=" + clsg_dt + ", pan_dt=" + pan_dt + ", upp_ais_tp_cd="
				+ upp_ais_tp_cd + ", pan_nm=" + pan_nm + ", dtl_url=" + dtl_url + ", ccr_cnnt_sys_ds_cd="
				+ ccr_cnnt_sys_ds_cd + ", menu_id=" + menu_id + "]";
	}

	
	
	
	
	
	
}
