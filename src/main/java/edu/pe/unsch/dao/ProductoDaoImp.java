package edu.pe.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import edu.pe.unsch.entities.Producto;
@Repository("productDao")
public class ProductoDaoImp  implements ProductoDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Producto find(Integer id) {
		return entityManager 
				.find(Producto.class, id);
	}

	@Override
	public List<Producto> recomendado(int n) {
		// TODO Auto-generated method stub
		return entityManager
				.createQuery("from Producto where recomendado=:recomendado order by id desc",Producto.class)
				.setParameter("recomendado", true)
				.setMaxResults(n)
				.getResultList();
	}

	@Override
	public List<Producto> recientes(int n) {
		// TODO Auto-generated method stub
		return entityManager
				.createQuery("fom Producto order by id desc", Producto.class)
				.setMaxResults(n)
				.getResultList();
	}



	
	
	
	

}
