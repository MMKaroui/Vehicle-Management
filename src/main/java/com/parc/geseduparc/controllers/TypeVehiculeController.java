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

import com.parc.geseduparc.entities.TypeVehicule;
import com.parc.geseduparc.repositories.TypeVehiculeRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypeVehiculeController {
	@Autowired
	TypeVehiculeRepository typeVehiculeRepository;
	
	@GetMapping ("/typeVehicules")
	public List<TypeVehicule> findAll(){
		return this.typeVehiculeRepository.findAll();
		}
	@GetMapping("/typeVehicules/{id}")
	public TypeVehicule findByid (@PathVariable Long id) throws Exception {
		return this.typeVehiculeRepository.findById(id).orElseThrow(()-> new Exception ("Type of vehicule dont exsit"));
	}
@PostMapping ("/typeVehicules") 
public TypeVehicule saveTypeVehicule(@RequestBody TypeVehicule typeVehicule) {
	return this.typeVehiculeRepository.save(typeVehicule);
}

@PutMapping("/typeVehicules/{id}")
public TypeVehicule updateOrSaveTypeVehicule(@RequestBody TypeVehicule typeVehicule, @PathVariable Long id) {
	return this.typeVehiculeRepository.findById(id).map(x-> {
		x.setLib_type_vehicule(typeVehicule.getLib_type_vehicule());
		x.setDesc_type_vehicule(typeVehicule.getDesc_type_vehicule());
        return typeVehiculeRepository.save(typeVehicule);
}).orElseGet(()->{ typeVehicule.setIdTypeVehicule(id);
		return typeVehiculeRepository.save(typeVehicule);
});}
@DeleteMapping ("/typeVehicules/{id}")
public void deleteTypeVehicule(@PathVariable Long id) {
	this.typeVehiculeRepository.deleteById(id);
}
}


