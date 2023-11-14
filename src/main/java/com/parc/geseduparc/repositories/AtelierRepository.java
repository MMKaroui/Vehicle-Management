package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.Atelier;


@Repository
public interface AtelierRepository extends JpaRepository <Atelier,Long>{

}
