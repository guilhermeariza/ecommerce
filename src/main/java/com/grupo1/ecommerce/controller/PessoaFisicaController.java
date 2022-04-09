package com.grupo1.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.ecommerce.model.PessoaFisica;
import com.grupo1.ecommerce.repository.PessoaFisicaRepository;

@RestController
@RequestMapping(value = "/pessoafisica")
@CrossOrigin("*")
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaRepository repository;
	
	@GetMapping 
	public List<PessoaFisica> findAll(){
		List<PessoaFisica> lista = repository.findAll();
		return lista;
	}

}
