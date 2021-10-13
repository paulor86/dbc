package com.dbc.sicredi.service.impl;

import org.springframework.stereotype.Service;

import com.dbc.core.infrastructure.CRUDServiceImpl;
import com.dbc.entities.Voto;
import com.dbc.sicredi.jpa.repository.VotoRepository;
import com.dbc.sicredi.service.VotoService;

@Service
public class VotoServiceImpl extends CRUDServiceImpl<Voto, VotoRepository> implements VotoService {

	public VotoServiceImpl(VotoRepository repository) {
		super(repository);
	}
}
