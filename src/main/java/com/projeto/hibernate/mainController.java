package com.projeto.hibernate;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.model.Contato;
import com.projeto.repository.ContatoRepository;

@Controller
@EntityScan("com.projeto.model")
@ComponentScan("com.projeto.model")
@EnableJpaRepositories("com.projeto.repository")
public class mainController {
	@Autowired
	private ContatoRepository repository;
	
	mainController(ContatoRepository contatoRepository) {
		this.repository = contatoRepository;
	}
	@GetMapping("/contato")
	public @ResponseBody List<Contato> teste(){
		return repository.findAll();
	}
}
