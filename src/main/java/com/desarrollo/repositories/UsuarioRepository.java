package com.desarrollo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import com.desarrollo.entities.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	List<Usuario> findByNombre(String user);
}

