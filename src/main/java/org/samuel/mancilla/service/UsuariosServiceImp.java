package org.samuel.mancilla.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.samuel.mancilla.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImp implements IntUsuariosService {

	/*Para generar la vista*/
	private List<Usuario> lista=null;
	public UsuariosServiceImp() {
		lista=new LinkedList<Usuario>();
		try {
			Usuario u1=new Usuario();
			u1.setId(1);
			u1.setNombre("Josue");
			u1.setEmail("josueArmadillo@gmail.com");
			u1.setUsername("Jouse Armadillo");
			u1.setPassword("12345");
			u1.setEstatus(0);
			u1.setFechaRegistro(LocalDate.parse("01-03-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			lista.add(u1);
			//////////////////////////////
			Usuario u2=new Usuario();
			u2.setId(2);
			u2.setNombre("Samuel");
			u2.setEmail("samuelmbcr9@gmail.com");
			u2.setUsername("Samueleithor");
			u2.setPassword("67890");
			u2.setEstatus(1);
			u2.setFechaRegistro(LocalDate.parse("01-03-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			lista.add(u2);
			//////////////////////////////
			Usuario u3=new Usuario();
			u3.setId(3);
			u3.setNombre("Yair");
			u3.setEmail("flakoYair@gmail.com");
			u3.setUsername("Llayr");
			u3.setPassword("098765");
			u3.setEstatus(1);
			u3.setFechaRegistro(LocalDate.parse("01-03-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			lista.add(u3);
		}catch(DateTimeParseException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	/*Se hace una iteración en este controlador*/
	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		for(Usuario usuario:lista) {
			if(usuario.getId()==idUsuario) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}

}
