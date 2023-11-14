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

import com.parc.geseduparc.entities.Facture;
import com.parc.geseduparc.entities.Marque;
import com.parc.geseduparc.repositories.FactureRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FactureController {
	@Autowired
	FactureRepository factureRepository;
	
	@GetMapping ("/factures")
	public List<Facture> findAll(){
		return this.factureRepository.findAll();
		}
	@GetMapping("/factures/{id}")
	public Facture findByid (@PathVariable Long id) throws Exception {
		return this.factureRepository.findById(id).orElseThrow(()-> new Exception ("Atelier dont exsit"));
	}
@PostMapping ("/factures") 
public Facture saveTypeVehicule(@RequestBody Facture facture) {
	return this.factureRepository.save(facture);
}

@PutMapping("/factures/{id}")
public Facture updateOrSaveFacture(@RequestBody Facture facture, @PathVariable Long id) {
	return this.factureRepository.findById(id).map(x-> {
		x.setNum_facture(facture.getNum_facture());
		x.setDate_facture(facture.getDate_facture());
		x.setObservation(facture.getObservation());
		x.setTotal(facture.getTotal());
		x.setIdAtelier(facture.getIdAtelier());
		x.setIdTypeReparation(facture.getIdTypeReparation());
		x.setIdVehicule(facture.getIdVehicule());
		
        return factureRepository.save(facture);
}).orElseGet(()->{ facture.setIdFacture(id);
		return factureRepository.save(facture);
});}
@DeleteMapping ("/factures/{id}")
public void deleteTypeVehicule(@PathVariable Long id) {
	this.factureRepository.deleteById(id);
}
@GetMapping("/factures/coutvehicule/{id}")
public float getCoutTotals(@PathVariable Long id) {
    return factureRepository.sumTotal(id);
}
@GetMapping("/factures/cout")
public float getCoutTotalsVehicule() {
    return factureRepository.sumTotalVehicule();
}
@GetMapping("/factures/coutEn")
public float getCoutTotalEntertien() {
    return factureRepository.sumEntretien();
}
@GetMapping("/factures/coutMe")
public float getCoutTotalMecanique() {
    return factureRepository.sumMecanique();
}
@GetMapping("/factures/coutEl")
public float getCoutTotalElectricite() {
    return factureRepository.sumElectricite();
}
@GetMapping("/factures/coutTo")
public float getCoutTotalTolerie() {
    return factureRepository.sumTolerie();
}
@GetMapping("/factures/coutRepF")
public float getCoutTotalFonction() {
    return factureRepository.sumRepF();
}
@GetMapping("/factures/coutRepS")
public float getCoutTotalService() {
    return factureRepository.sumRepS();
}



/*@GetMapping("/factures/coutVehicule")

public List<float[]>  coutFacturebyVehicule( ) {
    
	List<float[]>  coutVehicule = factureRepository.sumTotalByVehicule();
   
    return  coutVehicule;
}*/


}