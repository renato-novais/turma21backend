/*
 * A aplicação deverá conter um end-point que retorna uma string com as habilidades
 * e mentalidades que você utilizou para realizar essa atividade.
 */

package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {

	@GetMapping
	public String hello() {
		return "Persistencia";
	}
	
}
