package edu.pe.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pe.unsch.dao.DetalleOrdenDao;
import edu.pe.unsch.entities.Detalleorden;

@Repository("detalleOrdenDao")
@Transactional
public class DetalleOrdenServiceImpl implements DetalleOrdenService {
  @Autowired
	private DetalleOrdenDao detalleOrdenDao;

@Override
public void create(Detalleorden detalleorden) {
	detalleOrdenDao.create(detalleorden);
	// TODO Auto-generated method stub
	
}
  
}
