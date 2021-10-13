package com.dbc.sicredi.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dbc.entities.Associacao;

@Repository
public interface AssociacaoRepository extends JpaRepository<Associacao, Integer>, JpaSpecificationExecutor<Associacao> {

}
