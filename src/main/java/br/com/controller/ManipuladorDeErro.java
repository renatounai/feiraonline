package br.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.exception.NaoEncontradoException;

@RestControllerAdvice
public class ManipuladorDeErro {
	
	@ExceptionHandler(IllegalArgumentException.class)	
	protected ResponseEntity<Object> errosDeValidacao(Exception ex, WebRequest request) {		
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NaoEncontradoException.class)	
	protected ResponseEntity<Object> naoEncontrato(Exception ex, WebRequest request) {		
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
