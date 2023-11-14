package com.parc.geseduparc.domaine;

import com.parc.geseduparc.entities.EtatUser;
import com.parc.geseduparc.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class JwtResponse  {

	private String token;
	private Long id;
	private String login;
	private String email;
	private Role idRole;
	private EtatUser idEtat;

	

	


	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	
	


	

	public JwtResponse(String login, Role idRole, EtatUser idEtat) {
		super();
		this.login = login;
		this.idRole = idRole;
		this.idEtat = idEtat;
	}

	public JwtResponse(String token, String login, Role idRole, EtatUser idEtat) {
		super();
		this.token = token;
		this.login = login;
		this.idRole = idRole;
		this.idEtat = idEtat;
	}

	
}