package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.TypeVehicule;

@Repository
public interface TypeVehiculeRepository extends JpaRepository <TypeVehicule,Long>{

}
