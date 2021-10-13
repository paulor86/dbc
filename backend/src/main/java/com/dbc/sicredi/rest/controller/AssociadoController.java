package com.dbc.sicredi.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.core.infrastructure.CRUDResourceImpl;
import com.dbc.entities.Associado;
import com.dbc.sicredi.common.dto.AssociadoDTO;
import com.dbc.sicredi.common.map.AssociadoMapper;
import com.dbc.sicredi.service.AssociadoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/associado")
public class AssociadoController extends CRUDResourceImpl<AssociadoDTO, Associado, AssociadoService, AssociadoMapper> {

	public AssociadoController(AssociadoService service, AssociadoMapper mapper) {
		super(service, mapper);
	}
}
