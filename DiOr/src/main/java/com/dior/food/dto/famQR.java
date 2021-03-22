package com.dior.food.dto;

public class famQR {
	
	private long qrno;
	private String div;
	private String url;
	private String qimg;	
	private byte[] timg;
	private String vimg;
	
	public famQR() {
		super();
	}
	
	public long getQrno() {
		return qrno;
	}

	public void setQrno(long qrno) {
		this.qrno = qrno;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getQimg() {
		return qimg;
	}

	public void setQimg(String qimg) {
		this.qimg = qimg;
	}	
	
	public byte[] getTimg() {
		return timg;
	}

	public void setTimg(byte[] timg) {
		this.timg = timg;
	}	


	@Override
	public String toString() {
		
		return "famQR [qr_seq=" + qrno + ""
				+ ", qdiv=" + div + ""
				+ ", url=" + url + ""
				+ ", qimg=" + qimg + "]";
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
