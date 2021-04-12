package org.samuel.mancilla.service;

import java.util.List;
import org.samuel.mancilla.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IntCategoriasService {
	public List<Categoria> obtenerTodas();
	public Categoria buscarPorId1(Integer idCategoria);
	public void guardar1(Categoria categoria);
	public void eliminar(Integer idCategoria);
	public Page<Categoria>buscarTodas(Pageable page);
}
