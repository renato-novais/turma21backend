package com.generation.Escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Entidade no banco de dados
public class Estudante {

	@Id // Chave primaria no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment no banco de dados
	private long id;
	
	private String nome;
	
	private int idade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
