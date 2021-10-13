package com.dbc.sicredi.service.impl;

import org.springframework.stereotype.Service;

import com.dbc.core.infrastructure.CRUDServiceImpl;
import com.dbc.entities.Associado;
import com.dbc.sicredi.jpa.repository.AssociadoRepository;
import com.dbc.sicredi.service.AssociadoService;

@Service
public class AssociadoServiceImpl extends CRUDServiceImpl<Associado, AssociadoRepository> implements AssociadoService {

	public AssociadoServiceImpl(AssociadoRepository repository) {
		super(repository);
	}
}
