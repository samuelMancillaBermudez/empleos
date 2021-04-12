package org.samuel.mancilla.service;

import java.util.LinkedList;
import java.util.List;

import org.samuel.mancilla.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImp implements IntCategoriasService {
	//Atributo de tipo LinkedList
	private List<Categoria> lista=null;
	//MÉTODO CONSTRUCTOR
	public CategoriasServiceImp() {
		lista=new LinkedList<Categoria>();
	
			Categoria c1=new Categoria();
			c1.setId(1);
			c1.setNombre("Economía");
			c1.setDescripcion("Relacionado con la economía");
			lista.add(c1);
			/*//////////////////////////*/
			Categoria c2=new Categoria();
			c2.setId(2);
			c2.setNombre("Derecho");
			c2.setDescripcion("Relacionado con el derecho");
			lista.add(c2);
			/*////////////////////////*/
			Categoria c3=new Categoria();
			c3.setId(3);
			c3.setNombre("Humanidad");
			c3.setDescripcion("Relacionado con la humanidad");
			lista.add(c3);
			/////////////////////////////////////////
			Categoria c4=new Categoria();
			c4.setId(4);
			c4.setNombre("Informática");
			c4.setDescripcion("Relacionado con la informática");
			lista.add(c4);
			/////////////////////////////////////////
			Categoria c5=new Categoria();
			c5.setId(5);
			c5.setNombre("Psicología");
			c5.setDescripcion("Relacionado con la psicología");
			lista.add(c5);
	
	}
	
	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Categoria buscarPorId1(Integer idCategoria) {
		// TODO Auto-generated method stub
		for(Categoria c:obtenerTodas()) {
			if(c.getId()==idCategoria) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void guardar1(Categoria categoria) {
		// TODO Auto-generated method stub
		lista.add(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
