package com.parc.geseduparc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository <Vehicule,Long> {
	@Query("SELECT COUNT(idVehicule) FROM Vehicule v  where v.idVehicule.idTypeVehicule= '1'")
    public Long countFonction();
	@Query("SELECT COUNT(idVehicule) FROM Vehicule v  where v.idVehicule.idTypeVehicule= '2'")
    public Long countService();
	@Query("SELECT COUNT(idVehicule) FROM Vehicule")
    public Long countVehicule();
	@Query("SELECT idVehicule FROM Vehicule")
    public List<Vehicule> idsVehicules();
}
