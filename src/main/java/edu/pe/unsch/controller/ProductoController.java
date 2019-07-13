package edu.pe.unsch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.pe.unsch.entities.Categoria;
import edu.pe.unsch.service.CategoriaService;
import edu.pe.unsch.service.MarcaService;
import edu.pe.unsch.service.ProductoService;

@Controller
@RequestMapping("/product")
public class ProductoController {	
	
	@Autowired
	public CategoriaService categoriaService;	
	@Autowired
	public ProductoService productoService;
	@Autowired
	public MarcaService marcaService;
		
	@GetMapping("/categoria/{id}")
	public String categoria(@PathVariable("id") Integer id, Model model) {
		Categoria categoria = categoriaService.find(id);
		
		model.addAttribute("titulo", "Categoria : e-remate");
		model.addAttribute("productos", categoria.getProductos());
		model.addAttribute("classActive", "active");
		model.addAttribute("marcaCa", marcaService.visible(6));
		return "views/public/productos/categoria";
	}
	@GetMapping("/category")
	public String category() {
		return "views/public/productos/categoria";
	}

	@GetMapping("/detalle_producto/{id}")
	public String detalle_producto(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("titulo", "Detalle_producto : e-remate");
		model.addAttribute("productoC", productoService.find(id));
		model.addAttribute("productosreciente", productoService.recientes(3));
		model.addAttribute("productoRecomendado", productoService.recomendado(9));
		model.addAttribute("marca", marcaService.visible(6));
		//model.addAttribute("marcaD", marcaService.visible(id));
		
		return "views/public/productos/detalle_producto";
	}

}
