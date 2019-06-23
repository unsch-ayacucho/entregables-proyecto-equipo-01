package edu.pe.unsch.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.pe.unsch.dao.CategoriaDao;
import edu.pe.unsch.entities.Categoria;
@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public List<Categoria> findAll() {
		
		return categoriaDao.findAll();
	}

	@Override
	public Categoria find(Integer id) {
		// TODO Auto-generated method stub
		return categoriaDao.find(id);
	}
	

}
