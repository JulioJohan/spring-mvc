package com.bolsadeideas.springboot.web.app.controllers;

import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//@Controller configura esta clase como tipo controller
@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	
	//Mapear a una ruta URL
	//Alternativa method = RequestMethod.GET
	@GetMapping(value = {"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		//regresa una plantilla html
		return "index";
	}
	//@RequestMapping = metodo get
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		//Creando el objeto de usuario
		Usuario usuario = new Usuario();
		//Estableciendo los atributos por defecto
		usuario.setNombre("Johan");
		usuario.setApellido("Mejia");
		usuario.setEmail("juliojohan10@gmail.com");
		//pasamos el objeto usuario
		model.addAttribute("usuario",usuario);
		//obtenemos el nombre
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		
		//creando el una lista 
		//primero la clase luego el nombre de la lista
//		List<Usuario> usuarios = new ArrayList<>();
//		usuarios.add(new Usuario("Johan","Mejia","juliojohan10@gmail.com"));
//		usuarios.add(new Usuario("karla","moya","karla@gmail.com"));
//		usuarios.add(new Usuario("s4vitar","s","s4vitar@gmail.com"));

		//Arrays es una clase y asList es un metodo estatico as list 
		//donde los elemntos se pasan por ,
//		List<Usuario> usuarios = Arrays.asList(new Usuario("Johan","Mejia","juliojohan10@gmail.com"),
//				new Usuario("karla","moya","karla@gmail.com"),
//				new Usuario("s4vitar","s","s4vitar@gmail.com"),
//				new Usuario ("Estefainia","Mejia","fani@gmail.com "));

		model.addAttribute("titulo",textoListar);
//		model.addAttribute("usuarios",usuarios);
		return "listar";
	}
	//usuarios tiene que ser igual que en el model attribute
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Johan","Mejia","juliojohan10@gmail.com"),
				new Usuario("karla","moya","karla@gmail.com"),
				new Usuario("s4vitar","s","s4vitar@gmail.com"),
				new Usuario ("Estefainia","Mejia","fani@gmail.com "));
		return usuarios;
	}
	
}
