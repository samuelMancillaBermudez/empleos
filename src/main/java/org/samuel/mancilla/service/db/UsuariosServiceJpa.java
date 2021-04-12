package org.samuel.mancilla.service.db;

import java.util.List;
import java.util.Optional;

import org.samuel.mancilla.model.Usuario;
import org.samuel.mancilla.repository.UsuariosRepository;
import org.samuel.mancilla.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UsuariosServiceJpa implements IntUsuariosService {

	/*Se añade este repositorio para poder acceder a la base de datos*/
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Override
	public List<Usuario> obtenerTodas() {
		//El método "findAll()" trae todos los Usuarios, en este caso, que estén en la base de datos
		return repoUsuarios.findAll();
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		//Creamos un objeto optional
		Optional<Usuario> optional=repoUsuarios.findById(idUsuario);
		
		//Sí optional tiene un objeto dentro, regresará ese valor, caso contrario, retornará un null
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		//.save() guarda el registro
		repoUsuarios.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		//deleteById busca a través del idUsuario el registro para eliminar
		repoUsuarios.deleteById(idUsuario);
	}

}
