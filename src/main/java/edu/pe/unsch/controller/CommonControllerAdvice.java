package edu.pe.unsch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.pe.unsch.service.CategoriaService;

@ControllerAdvice
public class CommonControllerAdvice {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@ModelAttribute
	public void addAtributes(Model model) {
		
		model.addAttribute("categories",categoriaService.findAll());
	}

}
