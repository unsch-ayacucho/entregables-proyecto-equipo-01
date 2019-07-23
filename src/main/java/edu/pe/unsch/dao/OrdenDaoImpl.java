package edu.pe.unsch.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Orden;
@Repository("ordenDao")
public class OrdenDaoImpl implements OrdenDao {
	 
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Orden create(Orden orden) {
		entityManager.persist(orden);
		// TODO Auto-generated method stub
		return orden;
	}

}
