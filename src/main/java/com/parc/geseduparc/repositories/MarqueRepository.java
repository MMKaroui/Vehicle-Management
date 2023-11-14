package com.parc.geseduparc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.Marque;

@Repository
public interface MarqueRepository extends JpaRepository <Marque,Long>{
	
	@Query("SELECT t FROM Marque t where t.idFabricant.idFabricant= :id")
    public List<Marque> findByFabricant(@Param("id") Long id);

}
