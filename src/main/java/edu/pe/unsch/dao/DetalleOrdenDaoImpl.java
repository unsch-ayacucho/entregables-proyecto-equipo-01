package edu.pe.unsch.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Detalleorden;
@Repository("detalleOrdenDao")
public class DetalleOrdenDaoImpl implements DetalleOrdenDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(Detalleorden detalleorden) {
		entityManager.persist(detalleorden);
		// TODO Auto-generated method stub
		
	}
	

}
