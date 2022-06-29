package com.grupo1.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo1.ecommerce.model.Carrinho;
import com.grupo1.ecommerce.model.Usuario;
import com.grupo1.ecommerce.repository.CarrinhoRepository;
import com.grupo1.ecommerce.repository.UsuarioRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public Optional<Carrinho> fazerPedido(Carrinho carrinho){
		if(carrinhoRepository.findById(carrinho.getId()).isPresent()) {
			Optional<Carrinho> car = carrinhoRepository.findById(carrinho.getId());
			car.get().setStatus("pedido");
		}
		return Optional.empty();
	}
}