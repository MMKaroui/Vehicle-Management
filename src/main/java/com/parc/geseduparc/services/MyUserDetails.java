package com.parc.geseduparc.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.parc.geseduparc.entities.EtatUser;
import com.parc.geseduparc.entities.Role;
import com.parc.geseduparc.entities.User;




public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private Boolean isActive;
	private Role idRole;
	private EtatUser idEtat;
	private long id;
	private String email;
	
	public MyUserDetails(User user) {
		this.id=user.getId();
		this.login = user.getLogin();
		this.email=user.getEmail();
		this.password = user.getPassword(); 
		this.idRole =user.getIdRole();
		this.idEtat=user.getIdEtat();
		this.isActive = user.getIdEtat().getLib_etat().equals("Activer") ? true : false;
		
	    Arrays.stream(user.getIdRole().getLib_role().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
				
	}
	
	public MyUserDetails(){}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}


	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	public Role getIdRole() {
		return idRole;
	}

	public void setIdRole(Role idRole) {
		this.idRole = idRole;
	}

	public EtatUser getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(EtatUser idEtat) {
		this.idEtat = idEtat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}