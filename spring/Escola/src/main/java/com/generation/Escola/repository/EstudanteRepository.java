package com.generation.Escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.Escola.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{ // Herança da JPA, usando a classe e o tipo do ID
	
}
