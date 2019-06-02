package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {
@GetMapping({"/shop"})

public String shop() {
	return "views/public/productos/shop";
}

@GetMapping({"/detalle_producto"})
public String detalle_producto() {
	return "views/public/productos/detalle_producto";
}

}
