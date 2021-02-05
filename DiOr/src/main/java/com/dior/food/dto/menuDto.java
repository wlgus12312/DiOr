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
				+ ", fdno=" + fdno + ""
				+ ", ordcnt=" + ordcnt + ""
				+ ", ordstsc=" + ordstsc + "]";
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
