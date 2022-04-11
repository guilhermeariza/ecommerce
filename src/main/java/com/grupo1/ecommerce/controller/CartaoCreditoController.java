package com.grupo1.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.ecommerce.model.CartaoCredito;
import com.grupo1.ecommerce.repository.CartaoCreditoRepository;

@RestController
@RequestMapping(value = "/cartaocredito")
@CrossOrigin("*")
public class CartaoCreditoController {
	
	@Autowired
	private CartaoCreditoRepository repository;
	
	@GetMapping 
	public List<CartaoCredito> findAll(){
		List<CartaoCredito> lista = repository.findAll();
		return lista;
	}

}
