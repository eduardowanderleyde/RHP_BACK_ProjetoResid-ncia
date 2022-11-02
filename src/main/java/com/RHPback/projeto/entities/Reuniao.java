package com.RHPback.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_reuniao")
public class Reuniao implements Serializable {
	private static final long serialVersionUID = 1L;

	/////////////////// ATRIBUTOS//////////////////////////////////////
	/////////////////////////////////////////////////////////////////

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReuniao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'", timezone = "GMT")
	private Instant moment;
	
	

	@Column(nullable = false, length = 10)
	private String sala;

	////////////////// ASSOCIAÇÕES/////////////////////////////
	//////////////////////////////////////////////////////////

	// @OneToMany(mappedBy="material")
	// private List<NomeMaterial> listamaterial=new ArrayList<>();

	
	//@OneToOne
	//(mappedBy = "criador_reuniao", cascade = CascadeType.ALL)
	//@JoinColumn(name = "criador_id")
	//private Funcionario criador;
     
	private String criador;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "reuniao")
	private Set<Funcionario> convidados = new HashSet<>();

	/////////////////// CONSTRUTORES///////////////////////////////////
	////////////////////////////////////////////////////////////////////

	public Reuniao() {

	}

	public Reuniao(Long idReuniao, Instant moment, String sala,String criador) {
		super();
		this.idReuniao = idReuniao;
		this.moment = moment;
		this.sala = sala;
		this.setCriador(criador);

	}
	//////////////////////// GET E SETTERS DE ATRIBUTOS///////////////////////
	//////////////////////////////////////////////////////////////////////////

	public Long getIdReuniao() {
		return idReuniao;
	}

	public void setIdReuniao(Long idReuniao) {
		this.idReuniao = idReuniao;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
     
	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}
	
	////////// GET DE COLECTIONS//////////////////
	/////////////////////////////////////////////

	// public void setListamaterial(List<NomeMaterial> listamaterial) {
	// this.listamaterial = listamaterial;
	// }


	public Set<Funcionario> getConvidados() {
		return convidados;
	}

	////////////// HASH E EQUALS DE ID///////////////////////////
	////////////////////////////////////////////////////////////

	@Override
	public int hashCode() {
		return Objects.hash(idReuniao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reuniao other = (Reuniao) obj;
		return Objects.equals(idReuniao, other.idReuniao);
	}

}
