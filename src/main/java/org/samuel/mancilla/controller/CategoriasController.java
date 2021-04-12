package org.samuel.mancilla.controller;

import java.util.List;

import org.samuel.mancilla.model.Categoria;
/*import org.samuel.mancilla.model.Vacante;
import org.samuel.mancilla.service.IntVacantesService;*/
import org.samuel.mancilla.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//Anotación
@RequestMapping(value="/categorias")
public class CategoriasController {
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@RequestMapping(value="/modificar",method=RequestMethod.GET)
	public String modificar(@RequestParam("id") int idCategoria, Model model) {
		Categoria categoria = serviceCategorias.buscarPorId1(idCategoria);
		model.addAttribute("categoria",categoria);
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/eliminar",method=RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idCategoria, RedirectAttributes attributes) {
		serviceCategorias.eliminar(idCategoria);
		attributes.addFlashAttribute("msg2", "Categoria eliminada");
		return "redirect:/categorias/index";
	}
	
	/*@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = serviceCategorias.buscarTodas(page);
	model.addAttribute("categorias", lista);
	return "categorias/listaCategorias";
	}*/
	
	@RequestMapping(value="/indexPaginate",method=RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria> lista = serviceCategorias.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	//Anotación a nivel de método
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista=serviceCategorias.obtenerTodas();
		
		for(Categoria c:serviceCategorias.obtenerTodas()) {
		System.out.println("ID: "+c.getId());
		System.out.println("Categoría: "+c.getNombre());
		System.out.println("Descripción: "+c.getDescripcion());
		//recuperar categorias
		//iterar
		}

		model.addAttribute("categorias", lista);
		return("categorias/listaCategorias");
	}
	
	//@GetMapping("/crear")
	@RequestMapping(value="/crear",method=RequestMethod.GET)	
	public String crear(Categoria categorias) {
		return ("categorias/formCategoria");
	}
	
	//@PostMapping("/guardar")
	@RequestMapping(value="/guardar",method=RequestMethod.POST)	
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		System.out.println("Nombre categoria: "+categoria.getNombre());
		System.out.println("Descripción: "+categoria.getDescripcion());
		
		
		//categoria.setId(serviceCategorias.obtenerTodas().size()+1);
		serviceCategorias.guardar1(categoria);
		System.out.println("Número de registros: "+serviceCategorias.obtenerTodas().size());
		attributes.addFlashAttribute("msg","Registro guardado con éxito!");
		
		return ("redirect:/categorias/index");
		
	}

	public IntCategoriasService getServiceCategorias() {
		return serviceCategorias;
	}

	public void setServiceCategorias(IntCategoriasService serviceCategorias) {
		this.serviceCategorias = serviceCategorias;
	}
}
