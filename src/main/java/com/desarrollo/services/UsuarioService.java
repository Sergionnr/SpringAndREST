package com.desarrollo.services;

public interface UsuarioService {
	public boolean login(String user, String pass);
	public boolean cambiarPassword(String user, String antiguaPassword, String newnuevaPassword);
}
