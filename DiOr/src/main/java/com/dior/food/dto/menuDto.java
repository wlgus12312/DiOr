package com.dior.food.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class menuDto {
	
	@JsonInclude(Include.NON_NULL)
	
	private long stono    ;
	private String stonm  ;
	private long fddiv    ;
	private String fdnm   ;
	private long fdprice  ;
	private long fdop_yn  ;
	private long ordno    ;
	private long fdno     ;
	private long tabno    ;
	private String ordcnt ;
	private String ordstsc;
	private String ordstnm;
	private String rg_dt  ;
	private String ud_dt  ;
	private byte[] timg   ;
	private String viewImg;
	
	
	@Override
	public String toString() {
		
		return "[stono=" + stono + ""
				+ ", stonm=" + stonm + ""
				+ ", fddiv=" + fddiv + ""
				+ ", fdnm=" + fdnm + ""
				+ ", fdprice=" + fdprice + ""
				+ ", fdop_yn=" + fdop_yn + ""
				+ ", ordno=" + ordno + ""
				+ ", fdno=" + fdno + ""				
				+ ", tabno=" + tabno + ""
				+ ", ordcnt=" + ordcnt + ""
				+ ", ordstsc=" + ordstsc + ""
				+ ", ordstnm=" + ordstnm + ""
				+ ", rg_dt=" + rg_dt + ""
				+ ", ud_dt=" + ud_dt + ""
				+ "]";
	}
	
	public long getStono() {
		return stono;
	}

	public void setStono(long stono) {
		this.stono = stono;
	}

	public String getStonm() {
		return stonm;
	}

	public void setStonm(String stonm) {
		this.stonm = stonm;
	}

	public String getFdnm() {
		return fdnm;
	}

	public void setFdnm(String fdnm) {
		this.fdnm = fdnm;
	}

	public long getFdprice() {
		return fdprice;
	}

	public void setFdprice(long fdprice) {
		this.fdprice = fdprice;
	}

	
	public long getOrdno() {
		return ordno;
	}

	public void setOrdno(long ordno) {
		this.ordno = ordno;
	}

	
	public long getFdno() {
		return fdno;
	}

	public void setFdno(long fdno) {
		this.fdno = fdno;
	}

	public String getOrdcnt() {
		return ordcnt;
	}

	public void setOrdcnt(String ordcnt) {
		this.ordcnt = ordcnt;
	}

	public String getOrdstsc() {
		return ordstsc;
	}

	public void setOrdstsc(String ordstsc) {
		this.ordstsc = ordstsc;
	}

	public String getOrdstnm() {
		return ordstnm;
	}

	public void setOrdstnm(String ordstnm) {
		this.ordstnm = ordstnm;
	}
	
	public String getRg_dt() {
		return rg_dt;
	}

	public void setRg_dt(String rg_dt) {
		this.rg_dt = rg_dt;
	}

	public String getUd_dt() {
		return ud_dt;
	}

	public void setUd_dt(String ud_dt) {
		this.ud_dt = ud_dt;
	}

	public byte[] getTimg() {
		return timg;
	}

	public void setTimg(byte[] timg) {
		this.timg = timg;
	}
	
	public String getViewImg() {
		return viewImg;
	}

	public void setViewImg(String viewImg) {
		this.viewImg = viewImg;
	}

	public long getTabno() {
		return tabno;
	}

	public void setTabno(long tabno) {
		this.tabno = tabno;
	}

	public long getFddiv() {
		return fddiv;
	}

	public void setFddiv(long fddiv) {
		this.fddiv = fddiv;
	}

	public long getFdop_yn() {
		return fdop_yn;
	}

	public void setFdop_yn(long fdop_yn) {
		this.fdop_yn = fdop_yn;
	}


}
