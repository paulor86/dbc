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

	public Integer getPautaId() {
		return pautaId;
	}

	public void setPautaId(Integer pautaId) {
		this.pautaId = pautaId;
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

	public Date getPautaDtInicio() {
		return pautaDtInicio;
	}

	public void setPautaDtInicio(Date pautaDtInicio) {
		this.pautaDtInicio = pautaDtInicio;
	}

	public Date getPautaTempoExpira() {
		return pautaTempoExpira;
	}

	public void setPautaTempoExpira(Date pautaTempoExpira) {
		this.pautaTempoExpira = pautaTempoExpira;
	}

	public Associacao getAssociacao() {
		return associacao;
	}

	public void setAssociacao(Associacao associacao) {
		this.associacao = associacao;
	}
}
