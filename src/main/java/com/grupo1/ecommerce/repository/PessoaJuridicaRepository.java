package com.grupo1.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.grupo1.ecommerce.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{

		public List<PessoaJuridica>findAllBynomeFantasiaContainingIgnoreCase(String nomeFantasia);

		public List<PessoaJuridica> findAllByemailContainingIgnoreCase(String email);

		public List<PessoaJuridica> findAllBycnpjContainingIgnoreCase(String cnpj);

}
