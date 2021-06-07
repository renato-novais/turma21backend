/*
 * Tudo em Spring funciona com anotação, são elas que dão comportamento para o trecho de código
 */

package com.generation.Escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.Escola.model.Estudante;
import com.generation.Escola.repository.EstudanteRepository;

@RestController // a classe se comporte como controller
@RequestMapping("/estudante") // define o caminho (endpoint) do controller que estou trabalhando
@CrossOrigin(origins = "*", allowedHeaders = "*") //padrão de segurança de IP, 
public class EstudanteController {
	
	@Autowired // injeção de dependencia do EstudanteRepository, implementa o repository no controller
	private EstudanteRepository repository;
	
	@GetMapping // busca 
	public ResponseEntity<List<Estudante>> getAll() {
		return ResponseEntity.ok(repository.findAll()); // recebe todas as informações da tabela estudante
	}
	
	@GetMapping("/{id}") // busca pela variável em {variavel de transporte}
	public ResponseEntity<Estudante> getById(@PathVariable long id) { // PathVariable conecta a variavel de transporte para o parametro do método, envia informação pra variavel do caminho
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)) // .map faz mapeamento do resultado da busca da variavel de transporte 
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Estudante> post(@RequestBody Estudante estudante) { // RequestBody envia informação para o corpo da requisição
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(estudante)); // CREATED pq estou usando o verbo Post, criei um novo registro)
	}
	
	@PutMapping
	public ResponseEntity<Estudante> put(@RequestBody Estudante estudante) { //put atualiza um dado que já existe
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(estudante)); // OK pq estou usando o verbo put, criei um novo registro)
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
