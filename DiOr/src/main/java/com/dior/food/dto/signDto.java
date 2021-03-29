package com.dior.food.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class signDto {
	
	@JsonInclude(Include.NON_NULL)
	
	private long stono   ;
	private String stonm ;
	private String userid;
	private String apv_yn;
	private String stotel;
	private String tel;
	
	@Override
	public String toString() {
		
		return "[stono=" + stono + ""
				+ ", stonm=" + stonm + ""
				+ ", userid=" + userid + ""
				+ ", apv_yn=" + apv_yn + ""
				+ ", stotel=" + stotel + ""
				+ ", tel=" + tel + ""
				+ "]";
	}
	
	public long getStono() {
		return stono;
	}

	public void setStono(long stono) {
		this.stono = stono;
	}

	public String getStotel() {
		return stotel;
	}

	public void setStotel(String stotel) {
		this.stotel = stotel;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getApv_yn() {
		return apv_yn;
	}

	public void setApv_yn(String apv_yn) {
		this.apv_yn = apv_yn;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStonm() {
		return stonm;
	}

	public void setStonm(String stonm) {
		this.stonm = stonm;
	}


}
