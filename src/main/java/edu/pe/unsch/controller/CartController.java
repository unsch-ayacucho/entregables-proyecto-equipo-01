package edu.pe.unsch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.unsch.entities.Item;
import edu.pe.unsch.service.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CartController {

	@GetMapping
	public String carrito(Model model) {
		model.addAttribute("titulo", "Carrito : e-commerce|Remate");

		return "views/public/carrito/cart";
	}
	@Autowired
	private ProductoService productoService;

	@GetMapping("/compra/{id}")
	public String add(@PathVariable("id") int id, HttpSession session, Model model) {
	model.addAttribute("titulo", "Carrito : e-commerce|remate");
	if (session.getAttribute("carrito") == null) {
		
		List<Item> carrito =new ArrayList<Item>();
		carrito.add(new Item(productoService.find(id),1));
		session.setAttribute("carrito", carrito);
	}
	
	 else {
		 List<Item> carrito= (List<Item>) session.getAttribute("carrito");
		 int index=isEXists(id, session);
		 
		 if(index==-1) {
			 carrito.add(new Item(productoService.find(id),1));
		 }else {
			 int cantidad= carrito.get(index).getStock()+1;
			 carrito.get(index).setStock(cantidad);
			 session.setAttribute("carrito", cantidad);
		 }
		 session.setAttribute("carrito",carrito);
		 
	 }
	return "views/public/carrito/cart";
	}
	
	@GetMapping("delete/{index}")
	public String delete(@PathVariable("index") int index, HttpSession session)
	{
	List<Item> carrito = (List<Item>) session.getAttribute("carrito");
	carrito.remove(index);
	session.setAttribute("carrito", carrito);
	return "redirect:/carrito";
	}
	
	private int isEXists(int id, HttpSession session) {
		List<Item> carrit = (List<Item>) session.getAttribute("carrito");
		for (int i = 0; i < carrit.size(); i++) {
		if (carrit.get(i).getProducto().getId() == id) {
		return i;
		}
		}
		return -1;
		}
	

}
