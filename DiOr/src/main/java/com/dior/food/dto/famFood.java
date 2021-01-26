package com.dior.food.dto;

public class famFood {
	
	private long no;
	private String name;
	private String yn;
	private String today;
		
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
		return "famFood [no=" + no + ", name=" + name + ", yn=" + yn + ", today=" + today + "]";
	}
	
	
}
