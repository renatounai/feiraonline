package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.exception.NaoEncontradoException;
import br.com.modelo.Usuario;
import br.com.repositorio.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService  {

	@Autowired
	private UsuarioRepository repository;
	
	/**
	 * Precisamos que esse método receba um nome de usuário como parâmetro e retorne o usuário
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(username);
		
		if (usuario == null) {
			throw new NaoEncontradoException();
		}
		
		return usuario;
	}
}
