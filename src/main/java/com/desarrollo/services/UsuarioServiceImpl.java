package com.desarrollo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.entities.Usuario;
import com.desarrollo.repositories.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	     @Autowired
	     private UsuarioRepository usuarioRepository;


		public boolean login(String user, String pass) {
			boolean result = false;
			List<Usuario> listUsuario = usuarioRepository.findAll();
			Usuario usuario = listUsuario.get(0);
			if(usuario != null) {
				if(usuario.getPassword().equals(pass)) {
					result = true;
				}
			}
			return result;
		}
		
		public boolean cambiarPassword(String user, String antiguaPassword, String nuevaPassword) {
	        boolean result=false;
	        List<Usuario> listUsuario = usuarioRepository.findByNombre(user);
	        if(listUsuario.isEmpty()) return result;
	        Usuario usuario = listUsuario.get(0);
	        if(login(user, antiguaPassword)){
	            usuario.setPassword(nuevaPassword);
	            usuarioRepository.save(usuario);
	            result = true;
	        }
	        return result;
	    }
}
