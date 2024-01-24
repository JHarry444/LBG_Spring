package com.qa.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String createHero(@RequestBody Hero newHero) {
		this.heroes.add(newHero);
		return heroes.toString();
	}

	@GetMapping("/get")
	public List<Hero> getHeroes() {
		return heroes;
	}

	// 'id' -> index (for now)
	@GetMapping("/get/{id}")
	public Hero getHero(@PathVariable int id) {
		return this.heroes.get(id);
	}
}
