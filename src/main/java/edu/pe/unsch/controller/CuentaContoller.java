package edu.pe.unsch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.pe.unsch.entities.Login;
import edu.pe.unsch.service.CuentaService;


@Controller
@RequestMapping("/cuenta")
public class CuentaContoller {
	
	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping("/registrar")
	public String register(Model model) {
		model.addAttribute("titulo", "Nuevo cuenta : e-Remate");
		model.addAttribute("cuentas", new Login());
		return "views/public/cuenta/registrar";
	}
	@GetMapping("/ordenCliente")
	public String ordenCliente(Model model) {
		model.addAttribute("titulo", "mi cuenta : e-Remate");
		model.addAttribute("cuenta", new Login());
		return  "views/public/cuenta/orden_cliente";
	}
	
	@PostMapping("/registrar")
	public String Resgistrar(@ModelAttribute("cuenta") Login login, RedirectAttributes redigir) {
		redigir.addAttribute("titulo", "Nuevo Cuenta : e-Remate");
		System.out.println( "pueba cuenta: " + login.getCorreo());
	try {
		
		cuentaService.create(login);
		redigir.addFlashAttribute("message", "La cuenta fue creada correctamente");
		return "redirect:/cuenta/registrar";		
		
	} catch (Exception e) {
		redigir.addFlashAttribute("message", "Se puede registrar nueva cuenta");
		return "redirect:/cuenta/registrar";	
	}	

		
	}
	@PostMapping("/login")
	public String micuenta(HttpServletRequest requiere, HttpSession sesion, RedirectAttributes redigir ) {
		redigir.addFlashAttribute("cuenta", new Login());
		Login cuenta = this.cuentaService.login(requiere.getParameter("correo"), requiere.getParameter("password"));
		
		if(cuenta==null) {
			redigir.addFlashAttribute("error","cuenta Invalida");
			return "redirect:/cuenta/registrar";
		}
		else {
			sesion.setAttribute("correo", cuenta.getCorreo());
			return "redirect:/cuenta/registrar";
		}
			
	}

}
