package com.grupo1.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.ecommerce.model.Produto;
import com.grupo1.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping 
	public List<Produto> findAll(){
		List<Produto> lista = repository.findAll();
		return lista;
	}

}
