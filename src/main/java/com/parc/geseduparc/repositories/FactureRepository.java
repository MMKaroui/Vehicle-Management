package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.Facture;



@Repository
public interface FactureRepository extends JpaRepository <Facture,Long>{
	@Query("SELECT SUM(total) FROM Facture f where f.idVehicule.idVehicule= :id")
    public float sumTotal(@Param("id") Long id);
	@Query("SELECT SUM(total) FROM Facture f")
    public float sumTotalVehicule();
	@Query("SELECT SUM(total) FROM Facture f where f.idTypeReparation= '1'")
    public float sumEntretien();
	@Query("SELECT SUM(total) FROM Facture f where f.idTypeReparation= '2'")
    public float sumMecanique();
	@Query("SELECT SUM(total) FROM Facture f where f.idTypeReparation= '3'")
    public float sumElectricite();
	@Query("SELECT SUM(total) FROM Facture f where f.idTypeReparation= '4'")
    public float sumTolerie();
	@Query("SELECT SUM(total) FROM Facture f where f.idVehicule.idTypeVehicule= '1'")
    public float sumRepF();
	@Query("SELECT SUM(total) FROM Facture f where f.idVehicule.idTypeVehicule= '2'")
    public float sumRepS();
	//@Query("SELECT SUM(total) FROM Facture f   where f.idVehicule =('SELECT idVehicule FROM Vehicule')")" 
    //public List<float[]>  sumTotalByVehicule();
}
