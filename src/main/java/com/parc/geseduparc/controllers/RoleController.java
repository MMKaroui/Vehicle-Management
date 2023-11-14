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

import com.parc.geseduparc.entities.Role;
import com.parc.geseduparc.repositories.RoleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping ("/roles")
	public List<Role> findAll(){
		return this.roleRepository.findAll();
		}
	@GetMapping("/roles/{id}")
	public Role findByid (@PathVariable Long id) throws Exception {
		return this.roleRepository.findById(id).orElseThrow(()-> new Exception ("Role dont exsit"));
	}
@PostMapping ("/roles") 
public Role saveRole(@RequestBody Role role) {
	return this.roleRepository.save(role);
}

@PutMapping("/roles/{id}")
public Role updateOrSaveRole(@RequestBody Role role, @PathVariable Long id) {
	return this.roleRepository.findById(id).map(x-> {
		x.setLib_role(role.getLib_role());
		x.setDesc_role(role.getDesc_role());
        return roleRepository.save(role);
}).orElseGet(()->{ role.setIdRole(id);
		return roleRepository.save(role);
});}
@DeleteMapping ("/roles/{id}")
public void deleteRole(@PathVariable Long id) {
	this.roleRepository.deleteById(id);
}
}
