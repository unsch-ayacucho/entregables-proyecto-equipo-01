package edu.pe.unsch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unsch.entities.Login;

@Repository("cuentaDao")
public class CuentaDaoImp implements CuentaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Login login) {
		entityManager.persist(login);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Login login(String correo, String password) {
		// TODO Auto-generated method stub
		try {
			return (Login) entityManager
					.createQuery("FROM Login where correo=:correo and password=:password")
					.setParameter("corre",correo).setParameter("password", password).getSingleResult();
		
		} catch (Exception e) {
			e.getMessage();
			return null;
			// TODO: handle exception
		}
		
	}

}
