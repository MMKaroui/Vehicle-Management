package com.parc.geseduparc.entities;

 import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String login;
	private String password;
	@JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(optional = false)
    private Role idRole;
	@JoinColumn(name = "id_etat", referencedColumnName = "id_etat")
    @ManyToOne(optional = false)
    private EtatUser idEtat;
	@Temporal(TemporalType.DATE)
	@JsonProperty(access = Access.READ_ONLY)
	private Date  date_creation ;
	@PrePersist
	private void onCreate() {
		date_creation=new Date();
		
	}
	@Temporal(TemporalType.DATE)
	@JsonProperty(access = Access.READ_ONLY)
	private Date date_update ;
	
	
	public User(String firstname, String lastname, String phone, String email, String login, String password,
			Role idRole, EtatUser idEtat) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.login = login;
		this.password = password;
		this.idRole = idRole;
		this.idEtat = idEtat;
	}
	public User(String firstname, String lastname, String phone, String email, String login, String password,
			Role idRole, EtatUser idEtat, Date date_creation) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.login = login;
		this.password = password;
		this.idRole = idRole;
		this.idEtat = idEtat;
		this.date_creation = date_creation;
	}
	
	 
	  

	

}
