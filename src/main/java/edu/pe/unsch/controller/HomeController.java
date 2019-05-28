package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	@GetMapping({"/", "/home"})
	//@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index() {
	return "views/public/home/index";
	}
	

}
