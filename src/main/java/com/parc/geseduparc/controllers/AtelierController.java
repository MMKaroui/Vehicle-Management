package com.parc.geseduparc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parc.geseduparc.entities.Atelier;

import com.parc.geseduparc.repositories.AtelierRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AtelierController {
	
	@Autowired
	AtelierRepository atelierRepository;
	
	@GetMapping ("/ateliers")
	public List<Atelier> findAll(){
		return this.atelierRepository.findAll();
		}
	@GetMapping("/ateliers/{id}")
	public Atelier findByid (@PathVariable Long id) throws Exception {
		return this.atelierRepository.findById(id).orElseThrow(()-> new Exception ("Atelier dont exsit"));
	}
@PostMapping ("/ateliers") 
public Atelier saveTypeVehicule(@RequestBody Atelier atelier) {
	return this.atelierRepository.save(atelier);
}

@PutMapping("/ateliers/{id}")
public Atelier updateOrSaveAtelier(@RequestBody Atelier atelier, @PathVariable Long id) {
	return this.atelierRepository.findById(id).map(x-> {
		x.setNom_atelier(atelier.getNom_atelier());
		x.setDesc_atelier(atelier.getDesc_atelier());
		x.setAdrersse_atelier(atelier.getAdrersse_atelier());
		x.setEmail_atelier(atelier.getEmail_atelier());
		x.setFax_atelier(atelier.getFax_atelier());
		x.setNum_registre(atelier.getNum_registre());
		x.setPhone_atelier(atelier.getPhone_atelier());
		
        return atelierRepository.save(atelier);
}).orElseGet(()->{ atelier.setIdAtelier(id);
		return atelierRepository.save(atelier);
});}
@DeleteMapping ("/ateliers/{id}")
public void deleteTypeVehicule(@PathVariable Long id) {
	this.atelierRepository.deleteById(id);
}
}