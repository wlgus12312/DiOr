package com.dior.food.dto;

public class famQR {
	
	private long qr_seq;
	private String qr_div;
	private String qr_url;
	private String qr_code;	

	private byte[] timg;
	private String vimg;
	
	public famQR() {
		super();
	}
	
	public long getQr_seq() {
		return qr_seq;
	}

	public void setQr_seq(long qr_seq) {
		this.qr_seq = qr_seq;
	}

	public String getQr_div() {
		return qr_div;
	}

	public void setQr_div(String qr_div) {
		this.qr_div = qr_div;
	}
	
	public String getQr_url() {
		return qr_url;
	}

	public void setQr_url(String qr_url) {
		this.qr_url = qr_url;
	}
	
	public String getQr_code() {
		return qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}	
	
	public byte[] getTimg() {
		return timg;
	}

	public void setTimg(byte[] timg) {
		this.timg = timg;
	}	


	@Override
	public String toString() {
		
		return "famQR [qr_seq=" + qr_seq + ""
				+ ", qr_div=" + qr_div + ""
				+ ", qr_url=" + qr_url + ""
				+ ", qr_code=" + qr_code + "]";
				//+ ", qr_code=" + qr_code + ""
				//+ ", vimg=" + vimg + "]";
	}

	public String getVimg() {
		return vimg;
	}

	public void setVimg(String vimg) {
		this.vimg = vimg;
	}
	

}
