package com.grupo1.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.grupo1.ecommerce.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{

		public List<PessoaJuridica>findAllBynomeFantasiaContainingIgnoreCase(String nomeFantasia);

		public List<PessoaJuridica> findAllByemailContainingIgnoreCase(String email);

		public Optional<PessoaJuridica> findByCnpj(String cnpj);

}
