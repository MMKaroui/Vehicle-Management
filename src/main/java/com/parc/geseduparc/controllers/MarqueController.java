package com.parc.geseduparc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parc.geseduparc.entities.Marque;
import com.parc.geseduparc.repositories.MarqueRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MarqueController {
	@Autowired
	MarqueRepository modeleRepository;
	
	@GetMapping ("/marques")
	public List<Marque> findAll(){
		return this.modeleRepository.findAll();
		}
	@GetMapping("/marques/{id}")
	public Marque findByid (@PathVariable Long id) throws Exception {
		return this.modeleRepository.findById(id).orElseThrow(()-> new Exception ("Marque dont exsit"));
	}
@PostMapping ("/marques") 
public Marque saveModele(@RequestBody Marque modele) {
	return this.modeleRepository.save(modele);
}

@PutMapping("/marques/{id}")
public Marque updateOrSaveFabricant(@RequestBody Marque modele, @PathVariable Long id) {
	return this.modeleRepository.findById(id).map(x-> {
		x.setLib_Modele(modele.getLib_Modele());
		x.setIdFabricant(modele.getIdFabricant());
		
        return modeleRepository.save(modele);
}).orElseGet(()->{ modele.setIdModele(id);
		return modeleRepository.save(modele);
});}
@DeleteMapping ("/marques/{id}")
public void deleteModele(@PathVariable Long id) {
	this.modeleRepository.deleteById(id);

}

@GetMapping("/marques/5/{id}")

public ResponseEntity<List<Marque>> listFabricant(@PathVariable Long id) {
    
	List<Marque> marque = modeleRepository.findByFabricant(id);
   
    return new ResponseEntity<List<Marque>>(marque, HttpStatus.OK);
}

}
