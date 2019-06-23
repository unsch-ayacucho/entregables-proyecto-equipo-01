package edu.pe.unsch.service;

import java.util.List;

import edu.pe.unsch.entities.Categoria;

public interface CategoriaService {
	
	public List<Categoria> findAll();
	public Categoria find(Integer id);
	

}
