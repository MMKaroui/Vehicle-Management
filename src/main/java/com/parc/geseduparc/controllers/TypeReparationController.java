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

import com.parc.geseduparc.entities.TypeReparation;
import com.parc.geseduparc.repositories.TypeReparationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypeReparationController {
	@Autowired
	TypeReparationRepository typeReparationRepository;
	
	@GetMapping ("/typeReparations")
	public List<TypeReparation> findAll(){
		return this.typeReparationRepository.findAll();
		}
	@GetMapping("/typeReparations/{id}")
	public TypeReparation findByid (@PathVariable Long id) throws Exception {
		return this.typeReparationRepository.findById(id).orElseThrow(()-> new Exception ("Type of carburant dont exsit"));
	}
@PostMapping ("/typeReparations") 
public TypeReparation saveTypeReparation(@RequestBody TypeReparation typeReparation) {
	return this.typeReparationRepository.save(typeReparation);
}

@PutMapping("/typeReparations/{id}")
public TypeReparation updateOrSaveTypeReparation(@RequestBody TypeReparation typeReparation, @PathVariable Long id) {
	return this.typeReparationRepository.findById(id).map(x-> {
		
		x.setLib_type_reparation(typeReparation.getLib_type_reparation());
        return typeReparationRepository.save(typeReparation);
}).orElseGet(()->{ typeReparation.setIdTypeReparation(id);
		return typeReparationRepository.save(typeReparation);
});}
@DeleteMapping ("/typeReparations/{id}")
public void deleteTypeVehicule(@PathVariable Long id) {
	this.typeReparationRepository.deleteById(id);
}
}