package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.TypeReparation;


@Repository
public interface TypeReparationRepository extends JpaRepository <TypeReparation,Long>{

}