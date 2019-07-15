package edu.pe.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unsch.dao.CuentaDao;
import edu.pe.unsch.entities.Login;
@Service("cuentaService")
@Transactional
public class CuentaServiceImp implements CuentaService{
	
	@Autowired
	private CuentaDao cuentaDao;

	@Override
	public void create(Login login) {
		login.setEstado((byte)1);
		cuentaDao.create(login);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Login login(String correo, String password) {
		// TODO Auto-generated method stub
		return cuentaDao.login(correo , password);
	}

}
