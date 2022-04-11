package com.grupo1.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo1.ecommerce.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{

}
