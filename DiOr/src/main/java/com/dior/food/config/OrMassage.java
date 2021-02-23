package com.dior.food.config;

public class OrMassage {
	private String ordno;
	private String fdno;
	private String fdnm;
	private String ordcnt;
	private String ordstsc;
	private String ords;
	
	public OrMassage() {}

	public OrMassage(String ordno, String fdno, String fdnm, String ordcnt, String ordstsc, String ords) {
		super();
		this.ordno = ordno;
		this.fdno = fdno;
		this.fdnm = fdnm;
		this.ordcnt = ordcnt;
		this.ordstsc = ordstsc;
		this.ords = ords;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getFdno() {
		return fdno;
	}

	public void setFdno(String fdno) {
		this.fdno = fdno;
	}

	public String getFdnm() {
		return fdnm;
	}

	public void setFdnm(String fdnm) {
		this.fdnm = fdnm;
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

	public String getOrds() {
		return ords;
	}

	public void setOrds(String ords) {
		this.ords = ords;
	}

	@Override
	public String toString() {
		return "OrMassage [ordno=" + ordno + ", fdno=" + fdno + ", fdnm=" + fdnm + ", ordcnt=" + ordcnt + ", ordstsc="
				+ ordstsc + ", ords=" + ords + "]";
	}



}
