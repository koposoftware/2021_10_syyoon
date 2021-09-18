package kr.co.hana.schedule.vo;

public class ScheduleDetailVO {
	
	private String sbsc_acp_clsg_dt; // 접수기간 종료일
	private String ppr_sbm_ope_anc_dt; // 서류제출대상자발표일
	private String ctrt_st_dt; // 계약기간시작일
	private String ppr_acp_st_dt; // 서류접수기간시작일
	private String sbsc_acp_st_dt; // 접수기간시작일
	private String ppr_acp_clsg_dt; // 서류접수기간 종료일
	private String pzwr_anc_dt; // 서류접수기간
	private String ctrt_ed_dt; // 계약기간 종료일
	
	private String ddo_ar;	//전용면적
	private String lgdn_adr; // 단지주소
	private String lgdn_dtl_adr; // 단지상세주소
	private String lcc_nt_nm; //단지명
	private String mvin_xpc_ym; //입주예정월
	private String htn_fmla_desc; // 난방방식
	private String hsh_cnt;//총세대수
	
	private String sil_ofc_gud_fcts; //안내1
	private String etc_cts; //주의
	
	
	public String getSbsc_acp_clsg_dt() {
		return sbsc_acp_clsg_dt;
	}
	public void setSbsc_acp_clsg_dt(String sbsc_acp_clsg_dt) {
		this.sbsc_acp_clsg_dt = sbsc_acp_clsg_dt;
	}
	public String getPpr_sbm_ope_anc_dt() {
		return ppr_sbm_ope_anc_dt;
	}
	public void setPpr_sbm_ope_anc_dt(String ppr_sbm_ope_anc_dt) {
		this.ppr_sbm_ope_anc_dt = ppr_sbm_ope_anc_dt;
	}
	public String getCtrt_st_dt() {
		return ctrt_st_dt;
	}
	public void setCtrt_st_dt(String ctrt_st_dt) {
		this.ctrt_st_dt = ctrt_st_dt;
	}
	public String getPpr_acp_st_dt() {
		return ppr_acp_st_dt;
	}
	public void setPpr_acp_st_dt(String ppr_acp_st_dt) {
		this.ppr_acp_st_dt = ppr_acp_st_dt;
	}
	public String getSbsc_acp_st_dt() {
		return sbsc_acp_st_dt;
	}
	public void setSbsc_acp_st_dt(String sbsc_acp_st_dt) {
		this.sbsc_acp_st_dt = sbsc_acp_st_dt;
	}
	public String getPpr_acp_clsg_dt() {
		return ppr_acp_clsg_dt;
	}
	public void setPpr_acp_clsg_dt(String ppr_acp_clsg_dt) {
		this.ppr_acp_clsg_dt = ppr_acp_clsg_dt;
	}
	public String getPzwr_anc_dt() {
		return pzwr_anc_dt;
	}
	public void setPzwr_anc_dt(String pzwr_anc_dt) {
		this.pzwr_anc_dt = pzwr_anc_dt;
	}
	public String getCtrt_ed_dt() {
		return ctrt_ed_dt;
	}
	public void setCtrt_ed_dt(String ctrt_ed_dt) {
		this.ctrt_ed_dt = ctrt_ed_dt;
	}
	public String getDdo_ar() {
		return ddo_ar;
	}
	public void setDdo_ar(String ddo_ar) {
		this.ddo_ar = ddo_ar;
	}
	public String getLgdn_adr() {
		return lgdn_adr;
	}
	public void setLgdn_adr(String lgdn_adr) {
		this.lgdn_adr = lgdn_adr;
	}
	public String getLgdn_dtl_adr() {
		return lgdn_dtl_adr;
	}
	public void setLgdn_dtl_adr(String lgdn_dtl_adr) {
		this.lgdn_dtl_adr = lgdn_dtl_adr;
	}
	public String getLcc_nt_nm() {
		return lcc_nt_nm;
	}
	public void setLcc_nt_nm(String lcc_nt_nm) {
		this.lcc_nt_nm = lcc_nt_nm;
	}
	public String getMvin_xpc_ym() {
		return mvin_xpc_ym;
	}
	public void setMvin_xpc_ym(String mvin_xpc_ym) {
		this.mvin_xpc_ym = mvin_xpc_ym;
	}
	public String getHtn_fmla_desc() {
		return htn_fmla_desc;
	}
	public void setHtn_fmla_desc(String htn_fmla_desc) {
		this.htn_fmla_desc = htn_fmla_desc;
	}
	public String getHsh_cnt() {
		return hsh_cnt;
	}
	public void setHsh_cnt(String hsh_cnt) {
		this.hsh_cnt = hsh_cnt;
	}
	public String getSil_ofc_gud_fcts() {
		return sil_ofc_gud_fcts;
	}
	public void setSil_ofc_gud_fcts(String sil_ofc_gud_fcts) {
		this.sil_ofc_gud_fcts = sil_ofc_gud_fcts;
	}
	public String getEtc_cts() {
		return etc_cts;
	}
	public void setEtc_cts(String etc_cts) {
		this.etc_cts = etc_cts;
	}
	@Override
	public String toString() {
		return "ScheduleDetailVO [sbsc_acp_clsg_dt=" + sbsc_acp_clsg_dt + ", ppr_sbm_ope_anc_dt=" + ppr_sbm_ope_anc_dt
				+ ", ctrt_st_dt=" + ctrt_st_dt + ", ppr_acp_st_dt=" + ppr_acp_st_dt + ", sbsc_acp_st_dt="
				+ sbsc_acp_st_dt + ", ppr_acp_clsg_dt=" + ppr_acp_clsg_dt + ", pzwr_anc_dt=" + pzwr_anc_dt
				+ ", ctrt_ed_dt=" + ctrt_ed_dt + ", ddo_ar=" + ddo_ar + ", lgdn_adr=" + lgdn_adr + ", lgdn_dtl_adr="
				+ lgdn_dtl_adr + ", lcc_nt_nm=" + lcc_nt_nm + ", mvin_xpc_ym=" + mvin_xpc_ym + ", htn_fmla_desc="
				+ htn_fmla_desc + ", hsh_cnt=" + hsh_cnt + ", sil_ofc_gud_fcts=" + sil_ofc_gud_fcts + ", etc_cts="
				+ etc_cts + "]";
	}
	


	
	
	
	
	
	
	

	
	
}
