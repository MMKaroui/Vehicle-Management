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

import com.parc.geseduparc.entities.TypeCarburant;
import com.parc.geseduparc.repositories.TypeCarburantRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypeCarburantController {
	@Autowired
	TypeCarburantRepository typeCarburantRepository;
	
	@GetMapping ("/typeCarburants")
	public List<TypeCarburant> findAll(){
		return this.typeCarburantRepository.findAll();
		}
	@GetMapping("/typeCarburants/{id}")
	public TypeCarburant findByid (@PathVariable Long id) throws Exception {
		return this.typeCarburantRepository.findById(id).orElseThrow(()-> new Exception ("Type of carburant dont exsit"));
	}
@PostMapping ("/typeCarburants") 
public TypeCarburant saveTypeCarburant(@RequestBody TypeCarburant typeCarburant) {
	return this.typeCarburantRepository.save(typeCarburant);
}

@PutMapping("/typeCarburants/{id}")
public TypeCarburant updateOrSaveTypeCarburant(@RequestBody TypeCarburant typeCarburant, @PathVariable Long id) {
	return this.typeCarburantRepository.findById(id).map(x-> {
		
		x.setLib_type_carburant(typeCarburant.getLib_type_carburant());
        return typeCarburantRepository.save(typeCarburant);
}).orElseGet(()->{ typeCarburant.setIdTypeCarburant(id);
		return typeCarburantRepository.save(typeCarburant);
});}
@DeleteMapping ("/typeCarburants/{id}")
public void deleteTypeVehicule(@PathVariable Long id) {
	this.typeCarburantRepository.deleteById(id);
}
}