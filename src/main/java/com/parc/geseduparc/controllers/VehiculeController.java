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
import com.parc.geseduparc.entities.Vehicule;
import com.parc.geseduparc.repositories.VehiculeRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VehiculeController {
	@Autowired
	VehiculeRepository vehiculeRepository;
	
	@GetMapping ("/vehicules")
	public List<Vehicule> findAll(){
		return this.vehiculeRepository.findAll();
		}
	@GetMapping("/vehicules/{id}")
	public Vehicule findByid (@PathVariable Long id) throws Exception {
		return this.vehiculeRepository.findById(id).orElseThrow(()-> new Exception ("Vehicule dont exsit"));
	}
@PostMapping ("/vehicules") 
public Vehicule saveVehicule(@RequestBody Vehicule vehicule) {
	return this.vehiculeRepository.save(vehicule);
}

@PutMapping("/vehicules/{id}")
public Vehicule updateOrSaveVehicule(@RequestBody Vehicule vehicule, @PathVariable Long id) {
	return this.vehiculeRepository.findById(id).map(x-> {
		x.setNum_chassis(vehicule.getNum_chassis());
		x.setNbr_chv(vehicule.getNbr_chv());
		x.setDate_circulation(vehicule.getDate_circulation());
		x.setIdModele(vehicule.getIdModele());
		x.setIdTypeVehicule(vehicule.getIdTypeVehicule());
		x.setIdFabricant(vehicule.getIdFabricant());
		x.setIdTypeCarburant(vehicule.getIdTypeCarburant());
        return vehiculeRepository.save(vehicule);
}).orElseGet(()->{ vehicule.setIdVehicule(id);
		return vehiculeRepository.save(vehicule);
});}
@DeleteMapping ("/vehicules/{id}")
public void deleteVehicule(@PathVariable Long id) {
	this.vehiculeRepository.deleteById(id);

}
@GetMapping("/vehicules/countf")
public float getCountVF() {
    return vehiculeRepository.countFonction();}

@GetMapping("/vehicules/counts")
public float getCountVS() {
    return vehiculeRepository.countService();}
@GetMapping("/vehicules/count")
public float getCountV() {
    return vehiculeRepository.countVehicule();}
@GetMapping("/vehicules/Ids")

public ResponseEntity<List<Vehicule>> listIdsVehicule() {
    
	List<Vehicule> vehicule = vehiculeRepository.idsVehicules();
   
    return new ResponseEntity<List<Vehicule>>(vehicule, HttpStatus.OK);
}

}
