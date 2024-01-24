package com.qa.demo.domain;

public class Hero {

	private String name;

	private String powers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", powers=" + powers + "]";
	}

}
