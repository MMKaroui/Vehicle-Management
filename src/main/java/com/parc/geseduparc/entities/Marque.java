package com.parc.geseduparc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Marque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_modele")
	private long idModele;
	private String lib_Modele;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idModele")
    private List<Vehicule> vehiculetList;
	@JoinColumn(name = "id_fabricant", referencedColumnName = "id_fabricant")
    @ManyToOne(optional = false)
    private Fabricant idFabricant;
	public long getIdModele() {
		return idModele;
	}
	public void setIdModele(long idModele) {
		this.idModele = idModele;
	}
	public String getLib_Modele() {
		return lib_Modele;
	}
	public void setLib_Modele(String lib_Modele) {
		this.lib_Modele = lib_Modele;
	}
	public Fabricant getIdFabricant() {
		return idFabricant;
	}
	public void setIdFabricant(Fabricant idFabricant) {
		this.idFabricant = idFabricant;
	}
	public Marque(long idModele, String lib_Modele, Fabricant idFabricant) {
		super();
		this.idModele = idModele;
		this.lib_Modele = lib_Modele;
		this.idFabricant = idFabricant;
	}
	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
