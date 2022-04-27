package com.grupo1.ecommerce.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo1.ecommerce.model.Usuario;
import com.grupo1.ecommerce.model.UsuarioLogin;
import com.grupo1.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> userLogin){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(userLogin.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(userLogin.get().getSenha(), usuario.get().getSenha())) {
				String auth = userLogin.get().getUsuario() + ":" + userLogin.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String autoHeader = "Basic" + new String(encodeAuth);
				userLogin.get().setToken(autoHeader);
				userLogin.get().setUsuario(usuario.get().getUsuario());
				
			}
		}
		return userLogin;
	}
}
