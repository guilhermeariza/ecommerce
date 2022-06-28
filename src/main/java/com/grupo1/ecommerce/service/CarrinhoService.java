package com.grupo1.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupo1.ecommerce.model.Carrinho;
import com.grupo1.ecommerce.model.Usuario;
import com.grupo1.ecommerce.repository.CarrinhoRepository;
import com.grupo1.ecommerce.repository.UsuarioRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Carrinho> fazerPedido(Carrinho carrinho){

		if(carrinhoRepository.findById(carrinho.getId()).isPresent()) {

			Optional<Usuario> usuario = usuarioRepository.findById(carrinho.getUsuario().getId());
			if((usuario.isPresent())&&(carrinho.getUsuario().getId()) != usuario.get().getId()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrinho sem usuario!", null);
			}
			carrinho.setUsuario(usuario.get());
			carrinho.setStatus("pedido");
			return Optional.ofNullable(carrinhoRepository.save(carrinho));
		}
		return Optional.empty();
	}
}