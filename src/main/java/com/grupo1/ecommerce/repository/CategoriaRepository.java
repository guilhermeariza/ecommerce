package com.grupo1.ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.grupo1.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public List<Categoria> findByNomeCategoriaContainingIgnoreCase(@Param("nomeCategoria") String nomeCategoria);
}
