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
public class TypeReparation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_type_reparation")
	private long idTypeReparation;
	private String lib_type_reparation;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeReparation")
    private List<Facture> factureList;
	public long getIdTypeReparation() {
		return idTypeReparation;
	}
	public void setIdTypeReparation(long idTypeReparation) {
		this.idTypeReparation = idTypeReparation;
	}
	public String getLib_type_reparation() {
		return lib_type_reparation;
	}
	public void setLib_type_reparation(String lib_type_reparation) {
		this.lib_type_reparation = lib_type_reparation;
	}
	public TypeReparation(long idTypeReparation, String lib_type_reparation) {
		super();
		this.idTypeReparation = idTypeReparation;
		this.lib_type_reparation = lib_type_reparation;
	}
	public TypeReparation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
