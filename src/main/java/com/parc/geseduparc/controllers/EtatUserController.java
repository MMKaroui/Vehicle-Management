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

import com.parc.geseduparc.entities.EtatUser;
import com.parc.geseduparc.repositories.EtatUserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EtatUserController {
	
	@Autowired
	EtatUserRepository etatuserRepository;
	 @GetMapping ("/etats")
	public List<EtatUser> findAll() {
	return this.etatuserRepository.findAll();
		
	}
	@GetMapping("/etats/{id}")
public EtatUser findByid (@PathVariable Long id) throws Exception {
		return this.etatuserRepository.findById(id).orElseThrow(()-> new Exception ("Etat User dont exist"));
	
}
@PostMapping("/etats")
public EtatUser saveEtatUser(@RequestBody EtatUser etatuser) {
	return this.etatuserRepository.save(etatuser);
}
@PutMapping("/etats/{id}")
public EtatUser updateOrSaveEtatUser(@RequestBody EtatUser etatuser, @PathVariable Long id) {
	return this.etatuserRepository.findById(id).map(x-> {
		x.setLib_etat(etatuser.getLib_etat());
		x.setDesc_etat(etatuser.getDesc_etat());
        return etatuserRepository.save(etatuser);
}).orElseGet(()->{ etatuser.setIdEtat(id);
		return etatuserRepository.save(etatuser);
});}
@DeleteMapping("/etats/{id}")
public void deleteEtatUser(@PathVariable Long id) {
	 this.etatuserRepository.deleteById(id);
	
}
}
