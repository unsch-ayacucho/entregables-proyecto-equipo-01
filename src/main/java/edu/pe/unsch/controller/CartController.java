package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping({"/cart"})
	
	public String carrito(Model model) {
		model.addAttribute("titulo", "Cart : e-commerce");
		return "views/public/carrito/cart";
	}

}
