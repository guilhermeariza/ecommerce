package com.grupo1.ecommerce.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.grupo1.ecommerce.model.Usuario;

public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	
	public UserDetailsImpl(Usuario usuario) {
		this.user = usuario.getUsuario();
		this.password = usuario.getSenha();
	}

	public UserDetailsImpl()
	{
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return user;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
