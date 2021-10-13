package com.dbc.sicredi.common.dto;

import java.io.Serializable;

import com.dbc.core.enums.EnumSimNao;
import com.dbc.entities.Pauta;

import lombok.Data;

@Data
public class VotoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer votoId;

	private EnumSimNao votoGerado;

	private Pauta pauta;
}
