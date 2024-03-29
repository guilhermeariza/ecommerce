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
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable Long id){
	    return repository.findById(id)
	    		.map(resp -> ResponseEntity.ok(resp))
	            .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Endereco> post(@RequestBody Endereco endereco){
	    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Endereco> put(@RequestBody Endereco endereco){
	    return ResponseEntity.ok(repository.save(endereco));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
	        repository.deleteById(id);
	}

}

