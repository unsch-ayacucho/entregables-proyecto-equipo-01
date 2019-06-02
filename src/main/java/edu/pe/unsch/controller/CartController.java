package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping({"/cart"})
	
	public String carrito() {
		return "views/public/carrito/cart";
	}

}
