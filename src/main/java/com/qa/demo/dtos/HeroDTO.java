package com.qa.demo.dtos;

import com.qa.demo.domain.Hero;

public class HeroDTO {

	private Integer id;

	private String name;

	private String powers;

	private String cityName;

	public HeroDTO(Hero hero) {
		this.setId(hero.getId());
		this.setName(hero.getName());
		this.setPowers(hero.getSuperPowers());
		this.setCityName(hero.getCity().getName());
	}

	public HeroDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
