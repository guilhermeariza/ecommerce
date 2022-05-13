//package com.grupo1.ecommerce.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.grupo1.ecommerce.model.CartaoCredito;
//import com.grupo1.ecommerce.repository.CartaoCreditoRepository;
//
//@Service
//public class CartaoCreditoService {
//	@Autowired
//	private CartaoCreditoRepository cartaoCreditoRepository;
//
//	public Optional<CartaoCredito> CadastrarCartao(CartaoCredito cartao) {
//		if (cartaoCreditoRepository.findByNumeroCartao(cartao.getNumeroCartao()).isPresent())
//			return Optional.empty();
//
//		return Optional.of(cartaoCreditoRepository.save(cartao));
//	}
//}