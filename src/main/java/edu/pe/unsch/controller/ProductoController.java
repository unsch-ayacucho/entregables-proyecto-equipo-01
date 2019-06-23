package edu.pe.unsch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.pe.unsch.entities.Categoria;
import edu.pe.unsch.service.CategoriaService;
import edu.pe.unsch.service.ProductoService;

@Controller
@RequestMapping("/product")
public class ProductoController {	
	
	@Autowired
	public CategoriaService categoriaService;	
	@Autowired
	public ProductoService productoService;
		
	@GetMapping("/categoria/{id}")
	public String categoria(@PathVariable("id") Integer id, Model model) {
		Categoria categoria = categoriaService.find(id);
		
		model.addAttribute("titulo", "Categoria : e-commerce");
		model.addAttribute("productos", categoria.getProductos());
		model.addAttribute("classActive", "active");
		return "views/public/productos/categoria";
	}

	@GetMapping("/detalle_producto/{id}")
	public String detalle_producto(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("titulo", "Detalle_producto : e-commerce");
		model.addAttribute("producto", productoService.find(id));
		
		return "views/public/productos/detalle_producto";
	}

}
