package com.RHPback.projeto.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionario")


public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	////////////// ATRIBUTOS////////////////////////
	/////////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;

	@Column(nullable = false, name = "nome", length = 50)
	private String nome;

	@Column(nullable = false, unique = true, name = "email", length = 50)
	private String email;

	@Column(name = "senha", length = 50)
	private String senha;
	
	
	//@JsonIgnore
	//@OneToOne
	//@MapsId
	//private Reuniao criador_reuniao;

	////////////////////// ASSOCIAÇÕES///////////////////////
	///////////////////////////////////////////////////////

	@ManyToMany
	@JoinTable(name = "tb_reuniao_funcionario", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "reuniao_id"))
	private Set<Reuniao> reuniao = new HashSet<>();

	///////////////// CONSTRUTORES/////////////////////////////
////////////////////////////////////////////////////////////////
	public Funcionario() {

	}

	public Funcionario(Long id,String nome, String email, String senha) {
		this.idFuncionario=id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
       ////////////////// GET E SETTERS DE ATRIBUTOS/////////////
	////////////////////////////////////////////////////////////
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	//public void setIdFuncionario(UUID idFuncionario) {
		//this.idFuncionario = idFuncionario;
	//}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	//public void setReuniao(Reuniao criador_reuniao) {
		//this.criador_reuniao = criador_reuniao;
	//}
	

	///////////////////////////// COLLETCTIONS GET///////////////////
	///////////////////////////////////////////////////////////////////
	public Set<Reuniao> getReuniao() {
		return reuniao;
	}
	
          ////////////////// HASH, EQUALS DE ID ///////////////////////
	///////////////////////////////////////////////////////////////////
	@Override
	public int hashCode() {
		return Objects.hash(idFuncionario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(idFuncionario, other.idFuncionario);
	}

}
