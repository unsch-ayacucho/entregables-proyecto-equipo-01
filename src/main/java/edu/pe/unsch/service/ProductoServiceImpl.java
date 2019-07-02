package edu.pe.unsch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.ProductoDao;

import edu.pe.unsch.entities.Producto;

@Service("productoService")
@Transactional
public class ProductoServiceImpl  implements ProductoService{
	
	@Autowired
	private ProductoDao productoDoa;

	@Override
	public Producto find(Integer id) {
		
		return productoDoa.find(id);
	}

	@Override
	public List<Producto> recomendado(int n) {
		// TODO Auto-generated method stub
		return productoDoa.recomendado(n);
	}

	@Override
	public List<Producto> recientes(int n) {
		// TODO Auto-generated method stub
		return productoDoa.recientes(n);
	}



	

}
