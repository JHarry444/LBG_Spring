package com.qa.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Hero;

// Tells spring this class is a controller
@RestController
public class HeroController {

	private List<Hero> heroes = new ArrayList<>();

	// tells spring to listen for a GET request at /hello
	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

	@GetMapping("/yo")
	public String informal() {
		return "Yo, World!";
	}

	@PostMapping("/create")
	public ResponseEntity<Hero> createHero(@RequestBody Hero newHero) {
		this.heroes.add(newHero);
		// returns the last element in the list
		Hero body = this.heroes.get(this.heroes.size() - 1);

		return new ResponseEntity<Hero>(body, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Hero> getHeroes() {
		return heroes;
	}

	// 'id' -> index (for now)
	@GetMapping("/get/{id}")
	public ResponseEntity<Hero> getHero(@PathVariable int id) {
		if (id < 0 || id >= this.heroes.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Hero found = this.heroes.get(id);

		return ResponseEntity.ok(found);
	}

	@PutMapping("/update/{id}")
	public Hero updateHero(@PathVariable int id, @RequestBody Hero newHero) {
		return this.heroes.set(id, newHero);
	}

	@DeleteMapping("/remove/{id}")
	public Hero remove(@PathVariable int id) {
		return this.heroes.remove(id);
	}
}
