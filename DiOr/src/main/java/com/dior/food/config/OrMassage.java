package com.dior.food.config;

public class OrMassage {
	private String ordno;
	private String fdno;
	private String fdnm;
	private String ordcnt;
	private String ordstsc;
	
	public OrMassage() {}

	public OrMassage(String ordno, String fdno, String fdnm, String ordcnt, String ordstsc) {
		super();
		this.ordno = ordno;
		this.fdno = fdno;
		this.fdnm = fdnm;
		this.ordcnt = ordcnt;
		this.ordstsc = ordstsc;
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

	@Override
	public String toString() {
		return "OrMassage [ordno=" + ordno + ", fdno=" + fdno + ", fdnm=" + fdnm + ", ordcnt=" + ordcnt + ", ordstsc="
				+ ordstsc + "]";
	};


}
