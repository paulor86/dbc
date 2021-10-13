package com.dbc.sicredi.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AssociacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer assId;

	private String nome;

	private String descricao;

	public Integer getAssId() {
		return assId;
	}

	public void setAssId(Integer assId) {
		this.assId = assId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
