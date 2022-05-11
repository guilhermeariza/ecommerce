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
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> getById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Carrinho> post(@RequestBody Carrinho carrinho){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carrinho));
	}
	
	@PutMapping
	public ResponseEntity<Carrinho> put(@RequestBody Carrinho carrinho){
		return ResponseEntity.ok(repository.save(carrinho));
	}

	@DeleteMapping
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	

}

