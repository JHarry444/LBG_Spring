package com.qa.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.City;
import com.qa.demo.services.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	private CityService service;

	public CityController(CityService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public City create(@RequestBody City newCity) {
		return this.service.create(newCity);
	}

	@GetMapping("/get")
	public List<City> readAll() {
		return this.service.readAll();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<City> read(@PathVariable int id) {
		return this.service.read(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<City> update(@PathVariable int id, @RequestBody City newCity) {
		return this.service.update(id, newCity);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}
}
