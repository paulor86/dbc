package com.dbc.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.TableGenerator;

@Entity
@Table(name = "associacao")
public class Associacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQUENCE_ID = "sequence_associacao";
	private static final String SEQUENCE_TABLE_SICREDI = "sequence_table_sicredi";
	private static final String ATRIBUTO_ID = "associacao_id";

	@Id
	@GeneratedValue(generator = SEQUENCE_ID, strategy = GenerationType.TABLE)
	@GenericGenerator(name = SEQUENCE_ID, strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
			@Parameter(name = TableGenerator.TABLE_PARAM, value = SEQUENCE_TABLE_SICREDI),
			@Parameter(name = TableGenerator.SEGMENT_VALUE_PARAM, value = SEQUENCE_ID),
			@Parameter(name = TableGenerator.OPT_PARAM, value = "pooled-lo"),
			@Parameter(name = TableGenerator.INCREMENT_PARAM, value = "1") })
	@Column(name = ATRIBUTO_ID, nullable = false, unique = false)
	private Integer assId;

	@Column(name = "ass_nome")
	private String nome;

	@Column(name = "pauta_descricao")
	private String descricao;

	@OneToMany(mappedBy = "associacao")
	private Set<Associado> associados;

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

	public Set<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(Set<Associado> associados) {
		this.associados = associados;
	}
}
