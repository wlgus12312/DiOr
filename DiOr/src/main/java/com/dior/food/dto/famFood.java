package com.dior.food.dto;

import org.apache.tomcat.util.codec.binary.Base64;

public class famFood {
	
	private long stono    ;
	private String stonm  ;
	private String stotel ;
	private String fdnm   ;
	private String fdprice;
	private String fdop_yn ;
	private long ordno    ;
	private long fdno     ;
	private String ordcnt ;
	private String ordstsc;
	private byte[] timg;
	private String vimg;
	
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
	
	public String getStotel() {
		return stotel;
	}

	public void setStotel(String stotel) {
		this.stotel = stotel;
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

	public String getFdop_yn() {
		return fdop_yn;
	}

	public void setFdop_yn(String fdop_yn) {
		this.fdop_yn = fdop_yn;
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
	
	public byte[] getTimg() {
		return timg;
	}

	public void setTimg(byte[] timg) {
		this.timg = timg;
	}	


	@Override
	public String toString() {
		
		return "famFood [stono=" + stono + ""
				+ ", stonm=" + stonm + ""
				+ ", stotel=" + stotel + ""
				+ ", fdnm=" + fdnm + ""
				+ ", fdprice=" + fdprice + ""
				+ ", fdop_yn=" + fdop_yn + ""
				+ ", ordno=" + ordno + ""
				+ ", fdno=" + fdno + ""
				+ ", ordcnt=" + ordcnt + "" 
				+ ", vimg=" + vimg + ""
				+ ", ordstsc=" + ordstsc + "]";
	}

	public String getVimg() {
		return vimg;
	}

	public void setVimg(String vimg) {
		this.vimg = vimg;
	}
	

}
