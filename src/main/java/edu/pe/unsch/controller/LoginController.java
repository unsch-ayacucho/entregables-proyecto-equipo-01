package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping({"/public/login/login.html","/login"})
	public String ligin(Model model) {
		model.addAttribute("titulo", "Login : e-commerce");
		model.addAttribute("classActive", "active");
		return "views/public/login/login";
	}

}
