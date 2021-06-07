package org.generation.LojaDeGames.repository;

import java.util.List;

import org.generation.LojaDeGames.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);

}
