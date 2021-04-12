package org.samuel.mancilla.service.db;

import java.util.List;
import java.util.Optional;

import org.samuel.mancilla.model.Vacante;
import org.samuel.mancilla.repository.VacantesRepository;
import org.samuel.mancilla.service.IntVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesService {
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	
	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoVacantes.findAll();
	}

	@Override	
	public Vacante buscarPorId(Integer idVacante){
		Optional<Vacante> 
		equisde=
		repoVacantes.findById
		(idVacante);
		if(equisde.isPresent()) {
			return equisde.get();
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		repoVacantes.deleteById(idVacante);
	}
	
	@Override
	public List<Vacante> buscarDestacadas(){
		//return repoVacantes.findByEstatus("Aprobada");
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(page);
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(example);
	}
}
