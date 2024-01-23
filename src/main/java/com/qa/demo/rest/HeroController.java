package com.qa.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Tells spring this class is a controller
@RestController
public class HeroController {

	// tells spring to listen for a GET request at /hello
	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

	@GetMapping("/yo")
	public String informal() {
		return "Yo, World!";
	}
}
