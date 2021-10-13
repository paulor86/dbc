package com.dbc.sicredi.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AssociadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer asdId;

	private String asdCpf;

	private String asdNome;

	private AssociacaoDTO associacao;
}
