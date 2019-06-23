package edu.pe.unsch.dao;

import java.util.List;

import edu.pe.unsch.entities.Categoria;

public interface CategoriaDao {
	public List<Categoria> findAll();
	public Categoria find(Integer id);
	
	
	
	

}
