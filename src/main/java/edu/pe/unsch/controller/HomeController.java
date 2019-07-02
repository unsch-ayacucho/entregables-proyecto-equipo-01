package edu.pe.unsch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pe.unsch.service.ProductoService;

@Controller
public class HomeController {

	@Autowired
	private ProductoService productoService;

	@GetMapping({ "/", "/home" })

	// @RequestMapping(value = "/home", method = RequestMethod.GET)

	public String home(Model model) {
		model.addAttribute("titulo", "Home : e-renmate");
		model.addAttribute("classActive", "active");
		model.addAttribute("productoRecomendado", productoService.recomendado(9));

		return "views/public/home/index";
	}

}
