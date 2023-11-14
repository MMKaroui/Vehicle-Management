package com.parc.geseduparc.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Facture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFacture;
	private String num_facture;
	@Temporal(TemporalType.DATE)
	private Date date_facture;
	private float total;
	private String observation;
	@JoinColumn(name = "id_atelier", referencedColumnName = "id_atelier")
    @ManyToOne(optional = false)
    private Atelier idAtelier;
	@JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule")
    @ManyToOne(optional = false)
    private Vehicule idVehicule;
	@JoinColumn(name = "id_type_reparation", referencedColumnName = "id_type_reparation")
    @ManyToOne(optional = false)
    private TypeReparation idTypeReparation;

}
