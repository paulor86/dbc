package com.dbc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.TableGenerator;

@Entity
@Table(name = "associado")
public class Associado implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQUENCE_ID = "sequence_associado";
	private static final String SEQUENCE_TABLE_SICREDI = "sequence_table_sicredi";
	private static final String ATRIBUTO_ID = "asd_id";

	@Id
	@GeneratedValue(generator = SEQUENCE_ID, strategy = GenerationType.TABLE)
	@GenericGenerator(name = SEQUENCE_ID, strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
			@Parameter(name = TableGenerator.TABLE_PARAM, value = SEQUENCE_TABLE_SICREDI),
			@Parameter(name = TableGenerator.SEGMENT_VALUE_PARAM, value = SEQUENCE_ID),
			@Parameter(name = TableGenerator.OPT_PARAM, value = "pooled-lo"),
			@Parameter(name = TableGenerator.INCREMENT_PARAM, value = "1") })
	@Column(name = ATRIBUTO_ID, nullable = false, unique = false)
	private Integer asdId;

	@Column(name = "asd_cpf")
	private String asdCpf;

	@Column(name = "asd_nome")
	private String asdNome;

	@Column(name = "asd_id_associacao")
	private Integer associacao;

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

	public Integer getAssociacao() {
		return associacao;
	}

	public void setAssociacao(Integer associacao) {
		this.associacao = associacao;
	}
}
