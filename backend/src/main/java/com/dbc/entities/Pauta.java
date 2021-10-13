package com.dbc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.TableGenerator;

@Entity
@Table(name = "pauta")
public class Pauta implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQUENCE_ID = "sequence_pauta";
	private static final String SEQUENCE_TABLE_SICREDI = "sequence_table_sicredi";
	private static final String ATRIBUTO_ID = "pauta_id";

	@Id
	@GeneratedValue(generator = SEQUENCE_ID, strategy = GenerationType.TABLE)
	@GenericGenerator(name = SEQUENCE_ID, strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
			@Parameter(name = TableGenerator.TABLE_PARAM, value = SEQUENCE_TABLE_SICREDI),
			@Parameter(name = TableGenerator.SEGMENT_VALUE_PARAM, value = SEQUENCE_ID),
			@Parameter(name = TableGenerator.OPT_PARAM, value = "pooled-lo"),
			@Parameter(name = TableGenerator.INCREMENT_PARAM, value = "1") })
	@Column(name = ATRIBUTO_ID, nullable = false, unique = false)
	private Integer pautaId;

	@Column(name = "pauta_nome")
	private String nome;

	@Column(name = "pauta_descricao")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pauta_dt_inicio")
	private Date pautaDtInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pauta_tempo_expira")
	private Date pautaTempoExpira;

	@ManyToOne
	@JoinColumn(name = "pauta_id_associacao")
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
