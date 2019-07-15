package edu.pe.unsch.dao;

import edu.pe.unsch.entities.Login;

public interface CuentaDao {
 public  void create(Login login );
 
 public Login login(String correo, String password);
}
