package com.dior.food.config;

public class OrMassage {
	private String name;
	
	public OrMassage() {};
	
	public OrMassage(String name) {
		this.name = name;
	};
	
	public String getOrMassage() {
		return this.name;
	}
	
	public void setOrMassage(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name [name=" + name + "]";
	}

}
