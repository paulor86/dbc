package com.dbc.sicredi.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.core.infrastructure.CRUDResourceImpl;
import com.dbc.entities.Pauta;
import com.dbc.sicredi.common.dto.PautaDTO;
import com.dbc.sicredi.common.map.PautaMapper;
import com.dbc.sicredi.service.PautaService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/pauta")
public class PautaController extends CRUDResourceImpl<PautaDTO, Pauta, PautaService, PautaMapper> {

	public PautaController(PautaService service, PautaMapper mapper) {
		super(service, mapper);
	}
}
