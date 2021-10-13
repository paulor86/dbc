package com.dbc.sicredi.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AssociacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer assId;

	private String nome;

	private String descricao;
}
