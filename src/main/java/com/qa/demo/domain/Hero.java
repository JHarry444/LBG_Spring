package com.qa.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Table controls the name of matching table
@Entity
public class Hero {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Integer id;

	private String name;

	private String superPowers;

	// NEED
	// Default constructor
	public Hero() {
		super();
	}

//	GETTERS and SETTERS
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

	public String getSuperPowers() {
		return superPowers;
	}

	public void setSuperPowers(String superPowers) {
		this.superPowers = superPowers;
	}

}
