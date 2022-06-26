package com.grupo1.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo1.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
