package edu.pe.unsch.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Categoria;


@Repository("categoriaDao")
public class CategoriaDaoImpl  implements CategoriaDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Categoria> findAll() {
		
		return entityManager
				.createQuery("from Categoria where categoriapadre=0", Categoria.class)
				.getResultList();
	}

	@Override
	public Categoria find(Integer id) {
		// TODO Auto-generated method stub
		return (Categoria) entityManager
				.find(Categoria.class, id);
	}
	

}
