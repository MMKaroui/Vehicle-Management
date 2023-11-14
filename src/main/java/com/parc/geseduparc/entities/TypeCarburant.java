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
public class TypeCarburant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_type_carburant")
	private long idTypeCarburant;
	private String lib_type_carburant;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeCarburant")
	 private List<Vehicule> vehiculetList;
	public long getIdTypeCarburant() {
		return idTypeCarburant;
	}
	public void setIdTypeCarburant(long idTypeCarburant) {
		this.idTypeCarburant = idTypeCarburant;
	}
	public String getLib_type_carburant() {
		return lib_type_carburant;
	}
	public void setLib_type_carburant(String lib_type_carburant) {
		this.lib_type_carburant = lib_type_carburant;
	}
	public TypeCarburant(long idTypeCarburant, String lib_type_carburant) {
		super();
		this.idTypeCarburant = idTypeCarburant;
		this.lib_type_carburant = lib_type_carburant;
	}
	public TypeCarburant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
