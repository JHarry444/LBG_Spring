package com.qa.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.Hero;

// Tells spring this class is a controller
@Service
public class HeroService {

	private List<Hero> heroes = new ArrayList<>();

	public ResponseEntity<Hero> createHero(Hero newHero) {
		this.heroes.add(newHero);
		// returns the last element in the list
		Hero body = this.heroes.get(this.heroes.size() - 1);

		return new ResponseEntity<Hero>(body, HttpStatus.CREATED);
	}

	public List<Hero> getHeroes() {
		return heroes;
	}

	public ResponseEntity<Hero> getHero(int id) {
		if (id < 0 || id >= this.heroes.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Hero found = this.heroes.get(id);

		return ResponseEntity.ok(found);
	}

	public Hero updateHero(int id, Hero newHero) {
		return this.heroes.set(id, newHero);
	}

	public Hero remove(int id) {
		return this.heroes.remove(id);
	}
}
