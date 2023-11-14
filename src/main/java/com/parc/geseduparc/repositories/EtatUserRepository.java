package com.parc.geseduparc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parc.geseduparc.entities.EtatUser;
@Repository
public interface EtatUserRepository extends JpaRepository  <EtatUser,Long>{

}
