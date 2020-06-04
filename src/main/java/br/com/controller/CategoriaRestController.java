package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exception.NaoEncontradoException;
import br.com.modelo.Categoria;
import br.com.repositorio.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	/**
	 * Esse método irá retornar todas as categorias.
	 * @return
	 */
	@GetMapping
	public List<Categoria> selecionarTodasAsCategorias() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Categoria selecionarCategoriaPeloId(@PathVariable int id) {
		return categoriaRepository.findById(id).orElseThrow(NaoEncontradoException::new);
	}
	
	@PostMapping
	public void salvarCategoria(@RequestBody Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletarCategoria(@PathVariable int id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		categoriaRepository.delete(categoria);
	}
	
	@PostMapping(value = "/testa-optional")
	public Categoria criaCategoriaSeNaoExiste(@RequestBody Categoria categoria) {
		return categoriaRepository.findById(categoria.getId()).orElseGet(() -> {			
			categoriaRepository.save(categoria);
			return categoria;
		});
	}
	
}
