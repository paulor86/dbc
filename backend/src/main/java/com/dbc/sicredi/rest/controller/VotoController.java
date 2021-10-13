package com.dbc.sicredi.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.core.infrastructure.CRUDResourceImpl;
import com.dbc.entities.Voto;
import com.dbc.sicredi.common.dto.VotoDTO;
import com.dbc.sicredi.common.map.VotoMapper;
import com.dbc.sicredi.service.VotoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/voto")
public class VotoController extends CRUDResourceImpl<VotoDTO, Voto, VotoService, VotoMapper> {

	public VotoController(VotoService service, VotoMapper mapper) {
		super(service, mapper);
	}
}
