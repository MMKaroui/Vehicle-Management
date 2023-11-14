package com.parc.geseduparc.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

public class Vehicule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_vehicule")
	private long idVehicule;
	private String num_chassis;
	private String num_vehicule;
	@Temporal(TemporalType.DATE)
	private Date date_circulation;
	private int nbr_chv;
	@JoinColumn(name = "id_fabricant", referencedColumnName = "id_fabricant")
    @ManyToOne(optional = false)
    private Fabricant idFabricant;
	@JoinColumn(name = "id_Modele", referencedColumnName = "id_Modele")
    @ManyToOne(optional = false)
    private Marque idModele;
	@JoinColumn(name = "id_type_vehicule", referencedColumnName = "id_type_vehicule")
    @ManyToOne(optional = false)
    private TypeVehicule idTypeVehicule;
	@JoinColumn(name = "id_type_carburant", referencedColumnName = "id_type_carburant")
    @ManyToOne(optional = false)
    private TypeCarburant idTypeCarburant;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehicule")
    private List<Facture> factureList;
	
	public String getNum_vehicule() {
		return num_vehicule;
	}
	public void setNum_vehicule(String num_vehicule) {
		this.num_vehicule = num_vehicule;
	}
	public long getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(long idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getNum_chassis() {
		return num_chassis;
	}
	public void setNum_chassis(String num_chassis) {
		this.num_chassis = num_chassis;
	}
	public Date getDate_circulation() {
		return date_circulation;
	}
	public void setDate_circulation(Date date_circulation) {
		this.date_circulation = date_circulation;
	}
	public int getNbr_chv() {
		return nbr_chv;
	}
	public void setNbr_chv(int nbr_chv) {
		this.nbr_chv = nbr_chv;
	}
	public Fabricant getIdFabricant() {
		return idFabricant;
	}
	public void setIdFabricant(Fabricant idFabricant) {
		this.idFabricant = idFabricant;
	}
	public Marque getIdModele() {
		return idModele;
	}
	public void setIdModele(Marque idModele) {
		this.idModele = idModele;
	}
	public TypeVehicule getIdTypeVehicule() {
		return idTypeVehicule;
	}
	public void setIdTypeVehicule(TypeVehicule idTypeVehicule) {
		this.idTypeVehicule = idTypeVehicule;
	}
	public TypeCarburant getIdTypeCarburant() {
		return idTypeCarburant;
	}
	public void setIdTypeCarburant(TypeCarburant idTypeCarburant) {
		this.idTypeCarburant = idTypeCarburant;
	}
	
	public Vehicule(long idVehicule, String num_chassis, String num_vehicule, Date date_circulation, int nbr_chv,
			Fabricant idFabricant, Marque idModele, TypeVehicule idTypeVehicule, TypeCarburant idTypeCarburant) {
		super();
		this.idVehicule = idVehicule;
		this.num_chassis = num_chassis;
		this.num_vehicule = num_vehicule;
		this.date_circulation = date_circulation;
		this.nbr_chv = nbr_chv;
		this.idFabricant = idFabricant;
		this.idModele = idModele;
		this.idTypeVehicule = idTypeVehicule;
		this.idTypeCarburant = idTypeCarburant;
	}
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
