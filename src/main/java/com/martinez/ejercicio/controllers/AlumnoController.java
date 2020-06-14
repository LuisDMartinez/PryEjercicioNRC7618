package com.martinez.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martinez.ejercicio.models.entities.Alumno;
import com.martinez.ejercicio.models.services.IAlumnoService;

@Controller
@RequestMapping(value="/alumno") 
public class AlumnoController {
	//Todas las peticiones que gestion este controlador
	//Empiezan por /alumno
	//p.e: https://localhost:8080/alumno/create
	@Autowired
	private IAlumnoService srvAlumno;
	
	//Cada método en el controlador gestiona una petición al back-end
	//A travez de una url (puede ser> 
	//1. Escrita en el navegador
	//2. Puede ser Hyperlink
	//3. Puede ser un action de un Form)
	
	
	@GetMapping(value="/create")//https://localhost:8080/alumno/create
	public String create(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("title","Registro de nuevo alumn@");
		model.addAttribute("alumno",alumno);//Similar al ViewBag de ASP.net
		return "alumno/form"; //va la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")//https://localhost:8080/alumno/retrieve
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Alumno alumno = srvAlumno.findById(id);//consulta
		model.addAttribute("alumno",alumno);
		return "alumno/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Alumno alumno = srvAlumno.findById(id);
		model.addAttribute("alumno",alumno);
		//el metodo toString se ejecuta por default
		model.addAttribute("title","Actualizando el registro de: "+ alumno.toString());
		return "alumno/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		this.srvAlumno.delete(id);
		//despues de borrar se hace un redirect a una accion por invocar
		return "redirect:/alumno/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Alumno> alumnos = this.srvAlumno.findAll();
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("title","Listado de alumnos");
		return "alumno/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/alumno/create
	public String save(Alumno alumno, Model model) {
		this.srvAlumno.save(alumno);
		return "redirect:/alumno/list";
	}

}
