package com.qa.chocolate.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.chocolate.domain.Chocolate;

@RestController
public class ChocolateController {
	private List<Chocolate> choco = new ArrayList<>();

	// CRUD

	// Create - POST
	@PostMapping("/createChoco")
	public void createChoco(@RequestBody Chocolate c) {
		this.choco.add(c);
	}

	// Read - GET
	@GetMapping("/getChoco")
	public List<Chocolate> getChoco() {
		return this.choco;
	}

	// Read by ID - GET
	@GetMapping("/getOne/{id}")
	public Chocolate getOne(@PathVariable int id) {
		return this.choco.get(id - 1);
	}

	// Update - PUT/PATCH - PUT
	@PutMapping("/putChoco/{id}")
	public Chocolate putChoco(@RequestBody Chocolate c, Integer id) {
		return this.choco.set(id - 1, c);
	}

	// Delete - DELETE
	@DeleteMapping("/deleteChoco/{id}")
	public void delete(@PathVariable int id) {
		this.choco.remove(id - 1);
	}
}
