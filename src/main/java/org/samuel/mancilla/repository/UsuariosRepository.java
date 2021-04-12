package org.samuel.mancilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.samuel.mancilla.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
