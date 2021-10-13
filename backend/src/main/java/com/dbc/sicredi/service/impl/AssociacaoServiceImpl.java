package com.dbc.sicredi.service.impl;

import org.springframework.stereotype.Service;

import com.dbc.core.infrastructure.CRUDServiceImpl;
import com.dbc.entities.Associacao;
import com.dbc.sicredi.jpa.repository.AssociacaoRepository;
import com.dbc.sicredi.service.AssociacaoService;

@Service
public class AssociacaoServiceImpl extends CRUDServiceImpl<Associacao, AssociacaoRepository>
		implements AssociacaoService {

	public AssociacaoServiceImpl(AssociacaoRepository repository) {
		super(repository);
	}
}
