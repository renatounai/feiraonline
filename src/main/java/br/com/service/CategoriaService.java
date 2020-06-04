package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.modelo.Categoria;
import br.com.repositorio.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public void salvar(Categoria categoria) {
		
		if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome da categoria é obrigatório!");
		} 

		categoriaRepository.save(categoria);
	}
}
