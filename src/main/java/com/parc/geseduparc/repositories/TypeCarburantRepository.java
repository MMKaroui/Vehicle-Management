package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.TypeCarburant;


@Repository
public interface TypeCarburantRepository extends JpaRepository <TypeCarburant,Long>{

}
