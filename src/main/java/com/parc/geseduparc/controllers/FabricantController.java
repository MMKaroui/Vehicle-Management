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

import com.parc.geseduparc.entities.Fabricant;
import com.parc.geseduparc.repositories.FabricantRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FabricantController {	
	@Autowired
	FabricantRepository fabricantRepository;
	
	@GetMapping ("/fabricants")
	public List<Fabricant> findAll(){
		return this.fabricantRepository.findAll();
		}
	@GetMapping("/fabricants/{id}")
	public Fabricant findByid (@PathVariable Long id) throws Exception {
		return this.fabricantRepository.findById(id).orElseThrow(()-> new Exception ("Fabricant dont exsit"));
	}
@PostMapping ("/fabricants") 
public Fabricant saveFabricant(@RequestBody Fabricant fabricant) {
	return this.fabricantRepository.save(fabricant);
}

@PutMapping("/fabricants/{id}")
public Fabricant updateOrSaveFabricant(@RequestBody Fabricant fabricant, @PathVariable Long id) {
	return this.fabricantRepository.findById(id).map(x-> {
		x.setLib_fabricant(fabricant.getLib_fabricant());
		x.setAdresse_fabricant(fabricant.getAdresse_fabricant());
		x.setEmail_fabricant(fabricant.getEmail_fabricant());
		x.setPhone_fabricant(fabricant.getPhone_fabricant());
		x.setSite_web(fabricant.getSite_web());
        return fabricantRepository.save(fabricant);
}).orElseGet(()->{ fabricant.setIdFabricant(id);
		return fabricantRepository.save(fabricant);
});}
@DeleteMapping ("/fabricants/{id}")
public void deletefabricant(@PathVariable Long id) {
	this.fabricantRepository.deleteById(id);

}}