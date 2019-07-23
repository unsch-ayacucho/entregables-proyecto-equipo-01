package edu.pe.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.OrdenDao;
import edu.pe.unsch.entities.Orden;
@Service("ordenService")
@Transactional
public class OrdenServiceImpl  implements OrdenService{
	@Autowired
	private OrdenDao ordenDao;

	@Override
	public Orden create(Orden orden) {
		// TODO Auto-generated method stub
		return ordenDao.create(orden);
	}

}
