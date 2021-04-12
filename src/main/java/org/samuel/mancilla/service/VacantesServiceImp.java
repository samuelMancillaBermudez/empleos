package org.samuel.mancilla.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.samuel.mancilla.model.Categoria;
import org.samuel.mancilla.model.Vacante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImp implements IntVacantesService {
	//Atributo de tipo LinkedList
	private List<Vacante> lista=null;
	//MÉTODO CONSTRUCTOR
	public VacantesServiceImp() {
		lista=new LinkedList<Vacante>();
		try {
			Vacante v1=new Vacante();
			v1.setId(1);
			v1.setNombre("Arquitecto");
			v1.setDescripcion("Relacionado con la construcción");
			v1.setFecha(LocalDate.parse("12-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v1.setSalario(9500.00);
			v1.setDestacado(1);
			v1.setImagen("Batman.jpg");
			v1.setEstatus("Creada");
			
			Categoria c1=new Categoria();
			c1.setId(1);
			c1.setNombre("Constructor");
			c1.setDescripcion("Relacionado con construcciones");
			v1.setCategoria(c1);
			
			lista.add(v1);
			/*//////////////////////////*/
			Vacante v2=new Vacante();
			v2.setId(2);
			v2.setNombre("Contador");
			v2.setDescripcion("Para llevar la contabilidad general");
			v2.setFecha(LocalDate.parse("20-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v2.setSalario(8500.00);
			v2.setDestacado(0);
			v2.setImagen("Dragon Ball 1.jpg");
			v2.setEstatus("Aprobada");
			
			Categoria c2=new Categoria();
			c2.setId(1);
			c2.setNombre("Contaduría");
			c2.setDescripcion("Relacionado con contabilidad y auditoria");
			v2.setCategoria(c2);
			
			lista.add(v2);
			/*////////////////////////*/
			Vacante v3=new Vacante();
			v3.setId(3);
			v3.setNombre("Técnico de mantenimiento");
			v3.setDescripcion("Para soporte a equipos de cómputo");
			v3.setFecha(LocalDate.parse("02-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v3.setSalario(5500.00);
			v3.setDestacado(1);
			v3.setImagen("El hombre araña 8.jpg");
			v3.setEstatus("Eliminada");
			
			Categoria c3=new Categoria();
			c3.setId(1);
			c3.setNombre("Mantenimiento");
			c3.setDescripcion("Para soporte");
			v3.setCategoria(c3);
			
			lista.add(v3);
			/////////////////////////////////////////
			Vacante v4=new Vacante();
			v4.setId(4);
			v4.setNombre("Ingeniero eléctrico");
			v4.setDescripcion("Para desarrollo de aplicaciones de IoT");
			v4.setFecha(LocalDate.parse("08-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v4.setSalario(8500.00);
			v4.setDestacado(0);
			v4.setEstatus("Creada");
			
			Categoria c4=new Categoria();
			c4.setId(4);
			c4.setNombre("Ingeniería");
			c4.setDescripcion("Relacionado con ingeniería");
			v4.setCategoria(c4);
			
			lista.add(v4);
		}catch(DateTimeParseException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		for(Vacante vacante:obtenerTodas()) {
			if(vacante.getId()==idVacante) {
				return vacante;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
