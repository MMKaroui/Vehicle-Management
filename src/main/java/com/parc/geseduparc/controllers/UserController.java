package com.parc.geseduparc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parc.geseduparc.entities.User;
import com.parc.geseduparc.exception.ResourceNotFoundException;
import com.parc.geseduparc.domaine.JwtResponse;
import com.parc.geseduparc.domaine.Message;
import com.parc.geseduparc.repositories.UserRepository;


import com.parc.geseduparc.security.JwtTokenUtil;
import com.parc.geseduparc.services.MyUserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired	BCryptPasswordEncoder encoder;

	@Autowired	
	JwtTokenUtil jwtUtils;
    @Autowired
	UserRepository userRepository;
    @Autowired 	AuthenticationManager authenticationManager;
    
  
    @GetMapping ("/users")
	public List<User> findAll(){
		return this.userRepository.findAll();
				
	}
	@GetMapping("/users/{id}")
	public User findByid(@PathVariable Long id) throws Exception
	{
		return this.userRepository.findById(id).orElseThrow(()-> new Exception("user d'ont exist"));
	}
	@PostMapping("/users")
	public ResponseEntity<?> registerUser(@Validated @RequestBody User signUpRequest) {
		if (userRepository.existsByLogin((signUpRequest.getLogin()) )) {
			return ResponseEntity.badRequest().body(new Message("Error: Login is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new Message("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User( 
				signUpRequest.getFirstname(),
				signUpRequest.getLastname(),  
				signUpRequest.getPhone(),
				signUpRequest.getEmail(),
				              signUpRequest.getLogin(), 							 
							 encoder.encode(signUpRequest.getPassword()),
									 signUpRequest.getIdRole(),
									 signUpRequest.getIdEtat(),
									 signUpRequest.getDate_creation() 
									
									 );
		userRepository.save(user);

		return ResponseEntity.ok(new Message("User registered successfully!"));
	}	  

	@PutMapping("/users/{id}")
	  public ResponseEntity<User> updateEtat(@PathVariable(value = "id") Long id,
	       @RequestBody User userDetails) throws ResourceNotFoundException {
	  	User user = userRepository.findById(id)
	      .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + id));

	  
	  	  user.setFirstname(userDetails.getFirstname());
		 user.setLastname(userDetails.getLastname());
		 user.setLogin(userDetails.getLogin());
		 user.setPassword(encoder.encode(userDetails.getPassword()));
		 user.setEmail(userDetails.getEmail());
		 user.setIdRole(userDetails.getIdRole());
		 user.setIdEtat(userDetails.getIdEtat());
		 user.setDate_update(user.getDate_update());
	      final User updatedUser = userRepository.save(user);
	      return ResponseEntity.ok(updatedUser);
	  }
	@DeleteMapping ("/users/{id}")
	public void deleteUser (@PathVariable  Long id) {
		this.userRepository.deleteById(id);
	}
	
	@RequestMapping(value="/authenticate" , method  = RequestMethod.POST)
	  public ResponseEntity <?> loginUser (@Validated @RequestBody User data){
		  
		  Authentication authentication = authenticationManager.authenticate(
				  new UsernamePasswordAuthenticationToken(
						  data.getLogin(),
						  data.getPassword()
						
						  
						  )
				  
				  
				  );
		  
		  SecurityContextHolder.getContext().setAuthentication(authentication);
		  String jwt = jwtUtils.generateJwtToken(authentication);
		  
		  MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
		  System.out.println(jwt);
		  System.out.println(userDetails.getId());
		  System.out.println(userDetails.getUsername());
		  System.out.println(userDetails.getEmail());
		  System.out.println(userDetails.getPassword());
		  System.out.println(userDetails.getIdRole().getLib_role());
		  System.out.println(userDetails.getIdEtat().getLib_etat());
		  
		  return ResponseEntity.ok(new JwtResponse (jwt ,
				                                      
				                                        userDetails.getUsername(),
				                                   	                                    
					                                      userDetails.getIdRole(),
					                                      userDetails.getIdEtat()
					 ));
	 	  
		  
	  }
	  



}
