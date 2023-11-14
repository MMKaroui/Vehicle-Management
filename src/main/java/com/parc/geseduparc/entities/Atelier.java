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
public class Atelier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_atelier")
	private long idAtelier;
	private String num_registre;
	private String nom_atelier;
	private String phone_atelier;
	private String email_atelier;
	private String fax_atelier;
	private String adrersse_atelier;
	private String desc_atelier;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtelier")
    private List<Facture> factureList;
	public long getIdAtelier() {
		return idAtelier;
	}
	public void setIdAtelier(long idAtelier) {
		this.idAtelier = idAtelier;
	}
	public String getNum_registre() {
		return num_registre;
	}
	public void setNum_registre(String num_registre) {
		this.num_registre = num_registre;
	}
	
	public String getNom_atelier() {
		return nom_atelier;
	}
	public void setNom_atelier(String nom_atelier) {
		this.nom_atelier = nom_atelier;
	}
	public String getPhone_atelier() {
		return phone_atelier;
	}
	public void setPhone_atelier(String phone_atelier) {
		this.phone_atelier = phone_atelier;
	}
	public String getEmail_atelier() {
		return email_atelier;
	}
	public void setEmail_atelier(String email_atelier) {
		this.email_atelier = email_atelier;
	}
	public String getFax_atelier() {
		return fax_atelier;
	}
	public void setFax_atelier(String fax_atelier) {
		this.fax_atelier = fax_atelier;
	}
	public String getAdrersse_atelier() {
		return adrersse_atelier;
	}
	public void setAdrersse_atelier(String adrersse_atelier) {
		this.adrersse_atelier = adrersse_atelier;
	}
	public String getDesc_atelier() {
		return desc_atelier;
	}
	public void setDesc_atelier(String desc_atelier) {
		this.desc_atelier = desc_atelier;
	}
	public Atelier(long idAtelier, String num_registre, String nom_atelier, String phone_atelier, String email_atelier,
			String fax_atelier, String adrersse_atelier, String desc_atelier) {
		super();
		this.idAtelier = idAtelier;
		this.num_registre = num_registre;
		this.nom_atelier = nom_atelier;
		this.phone_atelier = phone_atelier;
		this.email_atelier = email_atelier;
		this.fax_atelier = fax_atelier;
		this.adrersse_atelier = adrersse_atelier;
		this.desc_atelier = desc_atelier;
	}
	public Atelier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
