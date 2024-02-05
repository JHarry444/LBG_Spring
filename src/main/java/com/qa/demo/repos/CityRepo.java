package com.qa.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.demo.domain.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}
