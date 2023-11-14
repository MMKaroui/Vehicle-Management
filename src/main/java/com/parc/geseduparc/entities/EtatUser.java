package com.parc.geseduparc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class EtatUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_etat")
	private long idEtat;
	private String lib_etat;
	private String desc_etat;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtat")
    private List<User> utilisateurList;
	
	public long getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(long idEtat) {
		this.idEtat = idEtat;
	}
	public String getLib_etat() {
		return lib_etat;
	}
	public void setLib_etat(String lib_etat) {
		this.lib_etat = lib_etat;
	}
	public String getDesc_etat() {
		return desc_etat;
	}
	public void setDesc_etat(String desc_etat) {
		this.desc_etat = desc_etat;
	}
	public EtatUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EtatUser(long idEtat, String lib_etat, String desc_etat) {
		super();
		this.idEtat = idEtat;
		this.lib_etat = lib_etat;
		this.desc_etat = desc_etat;
	}

	
}
