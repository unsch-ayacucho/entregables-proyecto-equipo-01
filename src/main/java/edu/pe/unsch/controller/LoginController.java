package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping({"/public/login/login.html","/login"})
	public String ligin() {
		return "views/public/login/login";
	}

}
