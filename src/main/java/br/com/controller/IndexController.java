package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.modelo.Categoria;
import br.com.repositorio.CategoriaRepository;

@Controller
public class IndexController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping(value = "/home")
	public String selecionarTodasAsCategorias(Model model) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias);
		return "index";
	}
}
