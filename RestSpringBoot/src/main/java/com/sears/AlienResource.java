package com.sears;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {

	@Autowired
	AlienRepository repo;

	@GetMapping("aliens/count_aliens")
	public void CountAliens() {

	int i=	(int) repo.count();
	System.out.println("count : "+i);
	}
	
	@GetMapping("aliens/getbyID/{ID}")
	public Optional<Alien> getAlien(@PathVariable int ID) {

		Optional<Alien> aliens = repo.findById(ID);
       
       Alien a=aliens.get();
       String s=a.getName();
       System.out.println("name :" +s); 
		return aliens;

	}

	@GetMapping("aliens/getAll")
	public List<Alien> getAliens() {

		List<Alien> aliens = (List<Alien>) repo.findAll();
Alien a=aliens.get(1);
int s=a.getSalary();
System.out.println("int :" +s); 
		return aliens;

	}

	@PostMapping("aliens/add_alien")
	public void AddAliens(@RequestBody Alien alien) {

		repo.save(alien);

	}

	@PutMapping("aliens/update_alien/{ID}")
	public void UpdateAliens(@RequestBody Alien alien, @PathVariable int ID) {

		repo.save(alien);

	}

	@DeleteMapping("aliens/delete_alien/{ID}")
	public void DeleteAlien(@PathVariable int ID) {

		repo.deleteById(ID);
	}

	@DeleteMapping("aliens/delete_all_aliens")
	public void DeleteAllAliens() {

		repo.deleteAll();
		
	}
	
	}
