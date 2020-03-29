package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.modelo.Categoria;
import br.com.repositorio.CategoriaRepository;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	/**
	 * Esse método irá retornar todas as categorias.
	 * @return
	 */
	@GetMapping(value = "/categorias")
	public List<Categoria> selecionarTodasAsCategorias() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping(value = "/categoria/{id}")
	public Categoria selecionarCategoriaPeloId(@PathVariable int id) {
		return categoriaRepository.findById(id).get();
	}
	
	@PostMapping(value = "/categoria")
	public void salvarCategoria(@RequestBody Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	@DeleteMapping(value = "/categoria/{id}")
	public void deletarCategoria(@PathVariable int id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		categoriaRepository.delete(categoria);
	}
	
}
