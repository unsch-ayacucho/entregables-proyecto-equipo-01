package edu.pe.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Marca;

@Repository("marcaDao")
public class MarcaDaoImpl implements MarcaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Marca> visible (int n) {
		// TODO Auto-generated method stub
		return entityManager
				.createQuery("FROM Marca where visible =: visible order by id desc", Marca.class)
				.setParameter("visible", true)
				.setMaxResults(n).getResultList();
	}

}
