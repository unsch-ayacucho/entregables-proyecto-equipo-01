package edu.pe.unsch.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.unsch.entities.Detalleorden;
import edu.pe.unsch.entities.Item;
import edu.pe.unsch.entities.Login;
import edu.pe.unsch.entities.Orden;
import edu.pe.unsch.service.CuentaService;
import edu.pe.unsch.service.DetalleOrdenService;
import edu.pe.unsch.service.OrdenService;
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
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private OrdenService ordenSevice;
	
	@Autowired
	private DetalleOrdenService detalleOrdenService;
	

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
	
	@PostMapping("/checkout")
	public String checkout(Model model, HttpSession session) {
		model.addAttribute("titulo", "Checkout : e-remate");
		model.addAttribute("login", new Login());
		if (session.getAttribute("correo") == null) {
		return "redirect:/cuenta/registrar";
		} else {
		// Guardar Orden
		Orden orden = new Orden();
		Login login =

				cuentaService.find(session.getAttribute("correo").toString());
				System.out.println(session.getAttribute("correo").toString());
				orden.setLogin(login);
				orden.setFechacreacion(new Date());
				orden.setNombre("nuevo orden");
				orden.setEstado((byte)0);
				Orden nuevoOrden =ordenSevice.create(orden)
				;
				// Guardar Detalle del orden
				List<Item> cart = (List<Item>) session.getAttribute("carrito");
				for (Item item : cart) {
				System.out.println("Detalle Orden " +

				nuevoOrden.getId());
				

				Detalleorden ordeDetalle = new Detalleorden();
				ordeDetalle.setOrden(nuevoOrden);
				ordeDetalle.setProducto(item.getProducto());
				ordeDetalle.setPrecio(item.getProducto().getPrecio());
				ordeDetalle.setCantidad(item.getStock());
				detalleOrdenService.create(ordeDetalle);
				
				}
				// Limpiar carrito
				session.removeAttribute("carrito");
				return "views/public/cuenta/thanks";
				}
	}
	

}
