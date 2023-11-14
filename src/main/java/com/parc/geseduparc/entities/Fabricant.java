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

public class Fabricant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_fabricant")
	private long idFabricant;
	private String lib_fabricant;
	private String adresse_fabricant;
	private String email_fabricant;
	private String phone_fabricant;
	private String site_web;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFabricant")
    private List<Vehicule> vehiculetList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFabricant")
    private List<Marque> marqueList;
	public long getIdFabricant() {
		return idFabricant;
	}
	public void setIdFabricant(long idFabricant) {
		this.idFabricant = idFabricant;
	}
	public String getLib_fabricant() {
		return lib_fabricant;
	}
	public void setLib_fabricant(String lib_fabricant) {
		this.lib_fabricant = lib_fabricant;
	}
	public String getAdresse_fabricant() {
		return adresse_fabricant;
	}
	public void setAdresse_fabricant(String adresse_fabricant) {
		this.adresse_fabricant = adresse_fabricant;
	}
	public String getEmail_fabricant() {
		return email_fabricant;
	}
	public void setEmail_fabricant(String email_fabricant) {
		this.email_fabricant = email_fabricant;
	}
	public String getPhone_fabricant() {
		return phone_fabricant;
	}
	public void setPhone_fabricant(String phone_fabricant) {
		this.phone_fabricant = phone_fabricant;
	}
	public String getSite_web() {
		return site_web;
	}
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}
	public Fabricant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fabricant(long idFabricant, String lib_fabricant, String adresse_fabricant, String email_fabricant,
			String phone_fabricant, String site_web) {
		super();
		this.idFabricant = idFabricant;
		this.lib_fabricant = lib_fabricant;
		this.adresse_fabricant = adresse_fabricant;
		this.email_fabricant = email_fabricant;
		this.phone_fabricant = phone_fabricant;
		this.site_web = site_web;
	}
	

}
