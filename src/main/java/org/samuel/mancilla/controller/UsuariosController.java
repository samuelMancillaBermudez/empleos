package org.samuel.mancilla.controller;

import java.util.List;

import org.samuel.mancilla.model.Usuario;
import org.samuel.mancilla.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@GetMapping("/login")
	public String login() {
		return "formLogin";
	}
	
	@PostMapping("/guardar")
	public String guardar(Usuario usuario) {
		usuariosService.guardar(usuario);
		//Se regresa al formLogin para que el usuario pueda iniciar sesión después de registrarse
		return "formLogin";
	}
	
	@GetMapping("/crear")
	public String crear() {
		return "usuarios/formRegistro";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista=usuariosService.obtenerTodas();
		for(Usuario u: lista) {
			System.out.println(u);
		}
		model.addAttribute("usuarios",lista);
		return "usuarios/listaUsuarios";
	}
}
