package com.dbc.sicredi.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.core.infrastructure.CRUDResourceImpl;
import com.dbc.entities.Associacao;
import com.dbc.sicredi.common.dto.AssociacaoDTO;
import com.dbc.sicredi.common.map.AssociacaoMapper;
import com.dbc.sicredi.service.AssociacaoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/associacao")
public class AssociacaoController
		extends CRUDResourceImpl<AssociacaoDTO, Associacao, AssociacaoService, AssociacaoMapper> {

	public AssociacaoController(AssociacaoService service, AssociacaoMapper mapper) {
		super(service, mapper);
	}
}
