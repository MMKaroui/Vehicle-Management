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

public class TypeVehicule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_type_vehicule")
	private long idTypeVehicule;
	private String lib_type_vehicule;
	private String desc_type_vehicule;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeVehicule")
    private List<Vehicule> vehiculetList;
	public long getIdTypeVehicule() {
		return idTypeVehicule;
	}
	public void setIdTypeVehicule(long idTypeVehicule) {
		this.idTypeVehicule = idTypeVehicule;
	}
	public String getLib_type_vehicule() {
		return lib_type_vehicule;
	}
	public void setLib_type_vehicule(String lib_type_vehicule) {
		this.lib_type_vehicule = lib_type_vehicule;
	}
	public String getDesc_type_vehicule() {
		return desc_type_vehicule;
	}
	public void setDesc_type_vehicule(String desc_type_vehicule) {
		this.desc_type_vehicule = desc_type_vehicule;
	}
	public TypeVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeVehicule(long idTypeVehicule, String lib_type_vehicule, String desc_type_vehicule) {
		super();
		this.idTypeVehicule = idTypeVehicule;
		this.lib_type_vehicule = lib_type_vehicule;
		this.desc_type_vehicule = desc_type_vehicule;
	}
	
}
