package edu.pe.unsch.service;


import java.util.List;

import edu.pe.unsch.entities.Producto;

public interface ProductoService {
	
	public Producto find(Integer id);
	
	public List<Producto> recomendado( int n);
	public List<Producto> recientes(int n);

}
