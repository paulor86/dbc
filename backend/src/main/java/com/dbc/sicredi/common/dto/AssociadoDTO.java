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

	public Integer getAsdId() {
		return asdId;
	}

	public void setAsdId(Integer asdId) {
		this.asdId = asdId;
	}

	public String getAsdCpf() {
		return asdCpf;
	}

	public void setAsdCpf(String asdCpf) {
		this.asdCpf = asdCpf;
	}

	public String getAsdNome() {
		return asdNome;
	}

	public void setAsdNome(String asdNome) {
		this.asdNome = asdNome;
	}

	public AssociacaoDTO getAssociacao() {
		return associacao;
	}

	public void setAssociacao(AssociacaoDTO associacao) {
		this.associacao = associacao;
	}
}
