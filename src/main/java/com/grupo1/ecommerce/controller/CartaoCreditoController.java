package com.grupo1.ecommerce.controller;

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

import com.grupo1.ecommerce.model.CartaoCredito;
import com.grupo1.ecommerce.repository.CartaoCreditoRepository;

@RestController
@RequestMapping(value = "/cartaocredito")
@CrossOrigin("*")
public class CartaoCreditoController {
	
	@Autowired
	private CartaoCreditoRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<CartaoCredito>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartaoCredito> getById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("apelido/{apelido}")
	public ResponseEntity<List<CartaoCredito>> getByApelido(@PathVariable String apelido){
		return ResponseEntity.ok(repository.findAllByApelidoContainingIgnoreCase(apelido));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<CartaoCredito> post(@RequestBody CartaoCredito cartao){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cartao));
	}
	
	@PutMapping
	public ResponseEntity<CartaoCredito> put(@RequestBody CartaoCredito cartao){
		return ResponseEntity.ok(repository.save(cartao));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}