package com.dbc.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.TableGenerator;

import com.dbc.core.enums.EnumSimNao;

@Entity
@Table(name = "voto")
public class Voto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQUENCE_ID = "sequence_voto";
	private static final String SEQUENCE_TABLE_SICREDI = "sequence_table_sicredi";
	private static final String ATRIBUTO_ID = "voto_id";

	@Id
	@GeneratedValue(generator = SEQUENCE_ID, strategy = GenerationType.TABLE)
	@GenericGenerator(name = SEQUENCE_ID, strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
			@Parameter(name = TableGenerator.TABLE_PARAM, value = SEQUENCE_TABLE_SICREDI),
			@Parameter(name = TableGenerator.SEGMENT_VALUE_PARAM, value = SEQUENCE_ID),
			@Parameter(name = TableGenerator.OPT_PARAM, value = "pooled-lo"),
			@Parameter(name = TableGenerator.INCREMENT_PARAM, value = "1") })
	@Column(name = ATRIBUTO_ID, nullable = false, unique = false)
	private Integer votoId;

	@Column(name = "voto_gerado")
	private EnumSimNao votoGerado;

	@ManyToOne
	@JoinColumn(name = "voto_id_pauta")
	private Pauta pauta;

	@OneToMany(mappedBy = "voto")
	private Set<Associado> associados;

	public Integer getVotoId() {
		return votoId;
	}

	public void setVotoId(Integer votoId) {
		this.votoId = votoId;
	}

	public EnumSimNao getVotoGerado() {
		return votoGerado;
	}

	public void setVotoGerado(EnumSimNao votoGerado) {
		this.votoGerado = votoGerado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Set<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(Set<Associado> associados) {
		this.associados = associados;
	}
}
