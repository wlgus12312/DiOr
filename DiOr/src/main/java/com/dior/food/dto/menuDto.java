package com.dior.food.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class menuDto {
	
	@JsonInclude(Include.NON_NULL)
	
	private long stono    ;
	private String stonm  ;
	private String stopyn ;
	private String fdnm   ;
	private String fdprice;
	private String fdopyn ;
	private long ordno    ;
	private long fdno     ;
	private String ordcnt ;
	private String ordstsc;
	private String ordstnm;
	private long   ords   ;
	private String rg_dt  ;
	private String ud_dt  ;
	private byte[] timg   ;
	
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

	public String getStoopyn() {
		return stopyn;
	}

	public void setStoopyn(String stoopyn) {
		this.stopyn = stoopyn;
	}

	public String getFdnm() {
		return fdnm;
	}

	public void setFdnm(String fdnm) {
		this.fdnm = fdnm;
	}

	public String getFdprice() {
		return fdprice;
	}

	public void setFdprice(String fdprice) {
		this.fdprice = fdprice;
	}

	public String getFdopyn() {
		return fdopyn;
	}

	public void setFdopyn(String fdopyn) {
		this.fdopyn = fdopyn;
	}
	
	public long getOrdno() {
		return ordno;
	}

	public void setOrdno(long ordno) {
		this.ordno = ordno;
	}

	public long getOrds() {
		return ords;
	}

	public void setOrds(long ords) {
		this.ords = ords;
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
	
	
	public menuDto() {
		super();
	}

	
	@Override
	public String toString() {
		
		return "famFood [stono=" + stono + ""
				+ ", stonm=" + stonm + ""
				+ ", stopyn=" + stopyn + ""
				+ ", fdnm=" + fdnm + ""
				+ ", fdprice=" + fdprice + ""
				+ ", fdopyn=" + fdopyn + ""
				+ ", ordno=" + ordno + ""
				+ ", ords=" + ords + ""
				+ ", fdno=" + fdno + ""
				+ ", ordcnt=" + ordcnt + ""
				+ ", ordstsc=" + ordstsc + ""
				+ ", ordstnm=" + ordstnm + ""
				+ ", rg_dt=" + rg_dt + ""
				+ ", ud_dt=" + ud_dt + ""
				+ "]";
	}


//	@Override
//	public String toString() {
//		return "{\"stono\":" + stono 
//				+ ", \"stonm\":" + stonm 
//				+ ", \"stopyn\":" + stopyn 
//				+ ", \"fdnm\":" + fdnm 
//				+ ", \"fdprice\":" + fdprice 
//				+ ", \"fdopyn\":" + fdopyn 
//				+ ", \"ordno\":" + ordno 
//				+ ", \"fdno\":" + fdno 
//				+ ", \"ordcnt\":" + ordcnt 
//				+ ", \"ordstsc\":" + ordstsc 
//				+ "}";
//	}
	
}
