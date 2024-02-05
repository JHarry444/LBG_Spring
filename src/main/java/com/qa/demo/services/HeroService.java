package com.qa.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.Hero;
import com.qa.demo.dtos.HeroDTO;
import com.qa.demo.repos.HeroRepo;

// Tells spring this class is a service
@Service
public class HeroService {

	private HeroRepo repo;

	public HeroService(HeroRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Hero> createHero(Hero newHero) {
		Hero created = this.repo.save(newHero);
		return new ResponseEntity<Hero>(created, HttpStatus.CREATED);
	}

	public List<HeroDTO> getHeroes() {
		List<Hero> heroes = this.repo.findAll();

		List<HeroDTO> dtos = new ArrayList<>();

		for (Hero hero : heroes) {
			HeroDTO dto = new HeroDTO();

			dto.setId(hero.getId());
			dto.setName(hero.getName());
			dto.setPowers(hero.getSuperPowers());
			dto.setCityName(hero.getCity().getName());

			dtos.add(dto);
		}

		return dtos;
	}

	public ResponseEntity<HeroDTO> getHero(int id) {
		// returns a box that might have a hero in it
		Optional<Hero> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<HeroDTO>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Hero body = found.get();

		HeroDTO dto = new HeroDTO();

		dto.setId(body.getId());
		dto.setName(body.getName());
		dto.setPowers(body.getSuperPowers());
		dto.setCityName(body.getCity().getName());

		return ResponseEntity.ok(dto);

	}

	public ResponseEntity<Hero> updateHero(int id, Hero newHero) {
		// returns a box that might have a hero in it
		Optional<Hero> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<Hero>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Hero existing = found.get();

		if (newHero.getName() != null) {
			existing.setName(newHero.getName());
		}

		if (newHero.getSuperPowers() != null) {
			existing.setSuperPowers(newHero.getSuperPowers());
		}

		Hero updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
