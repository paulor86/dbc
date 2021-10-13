package com.dbc.sicredi.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dbc.entities.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer>, JpaSpecificationExecutor<Voto> {

}
