package com.grupo1.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.ecommerce.model.Endereco;
import com.grupo1.ecommerce.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin("*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping 
	public List<Endereco> findAll(){
		List<Endereco> lista = repository.findAll();
		return lista;
	}

}
