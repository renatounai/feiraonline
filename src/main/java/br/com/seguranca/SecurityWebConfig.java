package br.com.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.service.UsuarioService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().disable()
			.csrf().disable()
        	.authorizeRequests()
        	.antMatchers("/", "/login").permitAll()
            .anyRequest().permitAll()
            .and().formLogin().permitAll(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .userDetailsService(usuarioService)
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }
	
}
