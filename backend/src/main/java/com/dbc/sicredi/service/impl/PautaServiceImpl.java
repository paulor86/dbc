package com.dbc.sicredi.service.impl;

import org.springframework.stereotype.Service;

import com.dbc.core.infrastructure.CRUDServiceImpl;
import com.dbc.entities.Pauta;
import com.dbc.sicredi.jpa.repository.PautaRepository;
import com.dbc.sicredi.service.PautaService;

@Service
public class PautaServiceImpl extends CRUDServiceImpl<Pauta, PautaRepository> implements PautaService {

	public PautaServiceImpl(PautaRepository repository) {
		super(repository);
	}
}
