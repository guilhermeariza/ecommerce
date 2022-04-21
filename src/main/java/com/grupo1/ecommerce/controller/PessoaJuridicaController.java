package com.grupo1.ecommerce.controller;

//usuario quer fazer e resposta do usuario

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

import com.grupo1.ecommerce.model.PessoaJuridica;

import com.grupo1.ecommerce.repository.PessoaJuridicaRepository;

@RestController
@RequestMapping(value = "/pessoajuridica")
@CrossOrigin("*") // indica que recebe requisição de quaqlquer outra parte do codigo
public class PessoaJuridicaController {

	@Autowired
	private PessoaJuridicaRepository repository;

	@GetMapping
	public List<PessoaJuridica> findAll() {
		List<PessoaJuridica> lista = repository.findAll();
		return lista;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaJuridica> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nomeFantasia/{nomeFantasia}")
	public ResponseEntity<List<PessoaJuridica>> GetBynomeFantasia(@PathVariable String nomeFantasia) {
		return ResponseEntity.ok(repository.findAllBynomeFantasiaContainingIgnoreCase(nomeFantasia));
	}


	@PostMapping
	public ResponseEntity<PessoaJuridica> post(@RequestBody PessoaJuridica pessoaJuridica) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoaJuridica));
	}

	@PutMapping
	public ResponseEntity<PessoaJuridica> put(@RequestBody PessoaJuridica pessoaJuridica) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoaJuridica));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
