package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.Fabricant;

@Repository
public interface FabricantRepository extends JpaRepository <Fabricant,Long>{
	
	
	
}
