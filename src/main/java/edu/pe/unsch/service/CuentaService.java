package edu.pe.unsch.service;

import edu.pe.unsch.entities.Login;

public interface CuentaService {
	public void create(Login login);
	
	public Login login(String correo, String password);

}
