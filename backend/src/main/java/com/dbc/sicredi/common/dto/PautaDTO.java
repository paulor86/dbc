package com.dbc.sicredi.common.dto;

import java.io.Serializable;
import java.util.Date;

import com.dbc.entities.Associacao;

import lombok.Data;

@Data
public class PautaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pautaId;

	private String nome;

	private String descricao;

	private Date pautaDtInicio;

	private Date pautaTempoExpira;

	private Associacao associacao;
}
