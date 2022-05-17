package com.grupo1.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo1.ecommerce.model.PessoaJuridica;
import com.grupo1.ecommerce.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	public Optional<PessoaJuridica> CadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        if (pessoaJuridicaRepository.findByCnpj(pessoaJuridica.getCnpj()).isPresent())
            return Optional.empty();
        pessoaJuridica.setCnpj((pessoaJuridica.getCnpj()));
        return Optional.of(pessoaJuridicaRepository.save(pessoaJuridica));
    }


}
