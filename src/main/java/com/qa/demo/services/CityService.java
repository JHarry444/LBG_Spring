package com.qa.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.City;
import com.qa.demo.repos.CityRepo;

@Service
public class CityService {

	private CityRepo repo;

	public CityService(CityRepo repo) {
		super();
		this.repo = repo;
	}

	public City create(City newCity) {

		return this.repo.save(newCity);
	}

	public List<City> readAll() {
		return this.repo.findAll();
	}

	public ResponseEntity<City> read(int id) {
		Optional<City> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(found.get());
	}

	public ResponseEntity<City> update(int id, City newCity) {
		Optional<City> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		City existing = found.get();

		existing.setName(newCity.getName());
		existing.setCountry(newCity.getCountry());

		City body = this.repo.save(existing);

		return ResponseEntity.ok(body);

	}

	public boolean delete(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
