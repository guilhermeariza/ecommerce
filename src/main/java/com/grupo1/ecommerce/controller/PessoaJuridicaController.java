package com.grupo1.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.ecommerce.model.PessoaJuridica;
import com.grupo1.ecommerce.repository.PessoaJuridicaRepository;

@RestController
@RequestMapping(value = "/pessoajuridica")
@CrossOrigin("*")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaJuridicaRepository repository;
	
	@GetMapping 
	public List<PessoaJuridica> findAll(){
		List<PessoaJuridica> lista = repository.findAll();
		return lista;
	}

}
