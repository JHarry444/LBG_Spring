package com.qa.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.demo.domain.Hero;

public interface HeroRepo extends JpaRepository<Hero, Integer> {

}
