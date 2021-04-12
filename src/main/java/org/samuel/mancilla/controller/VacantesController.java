package org.samuel.mancilla.controller;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.samuel.mancilla.model.Vacante;
import org.samuel.mancilla.service.IntCategoriasService;
import org.samuel.mancilla.service.IntVacantesService;
import org.samuel.mancilla.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@Autowired
	private IntVacantesService serviceVacantes;

	
	
	@GetMapping("/editar")
	/*RequestParam recupera el valor que le mandemos desde el HTML*/
	public String editar(@RequestParam("id") int idVacante,Model model) {
		/*Reenvia al formulario de registro, pues Editar no necesita realizar acciones propias, pues puede utilizar el formulario de registro*/
		
		/*También se le debe envíar al formVacante el objeto de tipo vacante, para ello usamos la siguiente línea*/
		Vacante vacante=serviceVacantes.buscarPorId(idVacante);
		
		//También debemos mandar las categorías, pues para que el formVacante pueda usarse, requiere que se le pase también estas categorías
		model.addAttribute("categorias",serviceCategorias.obtenerTodas());
		model.addAttribute("vacante",vacante);
		return "vacantes/formVacante";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Vacante> lista = serviceVacantes.buscarTodas(page);
		model.addAttribute("vacantes", lista);
		return "vacantes/listaVacantes";
	}

	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista=serviceVacantes.obtenerTodas();
		//List<Vacante> lista=serviceVacantes.buscarDestacadas();
		model.addAttribute("vacantes",lista);
		return "vacantes/listaVacantes";
	}
	
	//implementación de Data Biding(Vinculación entre clase modelo y formulario
	@PostMapping("/guardar")
	public String guardar(Vacante vacante, 
							BindingResult result, 
							RedirectAttributes attributes, 
							Model model,  
							@RequestParam("archivoImagen") MultipartFile multiPart) {
		
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}
			model.addAttribute("categorias", serviceCategorias.obtenerTodas());
			return "vacantes/formVacante";
		}
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}

		
		System.out.println("Vacante: "+vacante);
		//guardar el objeto de tipo vacante
		//vacante.setId(serviceVacantes.obtenerTodas().size()+1);
		serviceVacantes.guardar(vacante);
		System.out.println("Número de registros: "+serviceVacantes.obtenerTodas().size());
		attributes.addFlashAttribute("msg","Registro guardado con éxito!");
		return "redirect:/vacantes/index";
	}
	/*@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estatus") String estatus,
			@RequestParam("fecha") String fecha,
			@RequestParam("destacado") int destacado,
			@RequestParam("salario") double salario,
			@RequestParam("detalles") String detalles) {
		Vacantes v = new Vacante();
		v.setNombre(nombre);
		v.setDescripcion(descripcion);
		v.setEstatus(estatus);
		//v.setFecha(fecha);
		v.setDestacado(destacado);
		v.setSalario(salario);
		v.setDetalles(detalles);
		System.out.println("Vacante: "+v);
		return "vacantes/listaVacantes";
	}*/
	
	
	/*Con el objeto Model podemos adquirir las categorias, es decir, datos de otra clase*/
	@GetMapping("/crear")
	public String crear(Vacante vacante, Model model) {
		//model.addAttribute("categorias",serviceCategorias.obtenerTodas());
		return "vacantes/formVacante";
	}
	
	
	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") int idVacante,Model model) {
		
		System.out.println("IdVacante: "+idVacante);
		model.addAttribute("vacante",serviceVacantes.buscarPorId(idVacante));
		System.out.println(serviceVacantes.buscarPorId(idVacante));
		model.addAttribute("id",idVacante);
		return "vacantes/detalle";
	}
	
	@GetMapping("eliminar")  								/*Aquí se coloca RedirectAttributes para poder mandar el mensaje de Eliminado, pues sí no se usa no mostrará el mensaje*/
	public String eliminar(@RequestParam("id") int idVacante, RedirectAttributes attributes) {
		//System.out.println("IdVacante: "+idVacante);
		attributes.addFlashAttribute("msg", "Vacante eliminada"); //Permite envíar un mensaje
		serviceVacantes.eliminar(idVacante); //Elimina la vacante en base al idVacante que tiene como parámetro
		return ("redirect:/vacantes/index"); //Redirige al index para poder mostrar el mensaje de "Vacante Eliminada"
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", serviceCategorias.obtenerTodas());
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
    		  LocalDate.class, (PropertyEditor) new PropertyEditorSupport() {
		        @Override
		        public void setAsText(String text) throws IllegalArgumentException{
		          setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		        }
		
		        @Override
		        public String getAsText() throws IllegalArgumentException {
		          return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
		        }
    		  }
    	);
    }
}
