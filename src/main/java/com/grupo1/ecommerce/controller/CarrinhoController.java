package com.grupo1.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.ecommerce.model.Carrinho;
import com.grupo1.ecommerce.repository.CarrinhoRepository;

@RestController
@RequestMapping(value = "/carrinho")
@CrossOrigin("*")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoRepository repository;
	
	@GetMapping 
	public List<Carrinho> findAll(){
		List<Carrinho> lista = repository.findAll();
		return lista;
	}

}
