package com.qa.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Hero;
import com.qa.demo.services.HeroService;

// Tells spring this class is a controller
@RestController
public class HeroController {

//	@Autowired
//	private HeroService service;

	private HeroService service;

	public HeroController(HeroService service) {
		super();
		this.service = service;
	}

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
		return this.service.createHero(newHero);
	}

	@GetMapping("/get")
	public List<Hero> getHeroes() {
		return this.service.getHeroes();
	}

	// 'id' -> index (for now)
	@GetMapping("/get/{id}")
	public ResponseEntity<Hero> getHero(@PathVariable int id) {
		return this.service.getHero(id);
	}

	@PutMapping("/update/{id}")
	public Hero updateHero(@PathVariable int id, @RequestBody Hero newHero) {
		return this.service.updateHero(id, newHero);
	}

	@DeleteMapping("/remove/{id}")
	public Hero remove(@PathVariable int id) {
		return this.service.remove(id);
	}
}
