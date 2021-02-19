package com.dior.food.dto;

import org.json.JSONObject;

public class famFood {
	
	private long no;
	private String name;
	private String yn;
	private String today;
	private long stono    ;
	private String stonm  ;
	private String stoopyn;
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
		return stoopyn;
	}

	public void setStoopyn(String stoopyn) {
		this.stoopyn = stoopyn;
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

	public famFood() {
		super();
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	@Override
	public String toString() {
		
		return "famFood [stono=" + stono + ""
				+ ", stonm=" + stonm + ""
				+ ", stoopyn=" + stoopyn + ""
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
//		
//		return "famFood [{stono=" + stono + ""
//				+ ", stonm=" + stonm + ""
//				+ ", stoopyn=" + stoopyn + ""
//				+ ", fdnm=" + fdnm + ""
//				+ ", fdprice=" + fdprice + ""
//				+ ", fdopyn=" + fdopyn + ""
//				+ ", ordno=" + ordno + ""
//				+ ", fdno=" + fdno + ""
//				+ ", ordcnt=" + ordcnt + ""
//				+ ", ordstsc=" + ordstsc + "}]";
//	}
	
}
