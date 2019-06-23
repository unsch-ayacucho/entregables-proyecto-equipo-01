package edu.pe.unsch.dao;

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
	

}
