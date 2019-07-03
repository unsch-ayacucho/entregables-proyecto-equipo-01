package edu.pe.unsch.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.MarcaDao;
import edu.pe.unsch.entities.Marca;
@Service("marcaService")
@Transactional
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaDao marcaDao;

	@Override
	public List<Marca> visible(int n) {
		// TODO Auto-generated method stub
		return marcaDao.visible(n);
	}

}
