package org.samuel.mancilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.samuel.mancilla.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	//query Methods (Métodos personalizados por un campo en específico) 
	List<Vacante> findByEstatus(String estatus);
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	List<Vacante> findBySalarioBetween(double s1, double s2);
	List<Vacante> findByEstatusIn(String[] estatus);
}