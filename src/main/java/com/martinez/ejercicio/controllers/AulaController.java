package com.martinez.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martinez.ejercicio.models.entities.Aula;
import com.martinez.ejercicio.models.services.IAulaService;

@Controller
@RequestMapping(value="/aula") 
public class AulaController {

	@Autowired
	private IAulaService srvAula;
	
	@GetMapping(value="/create")//https://localhost:8080/alumno/create
	public String create(Model model) {
		Aula aula = new Aula();
		model.addAttribute("title","Registro de nueva Aula");
		model.addAttribute("aula", aula);
		return "aula/form";
	}
	
	@GetMapping(value="/retrieve/{id}")//https://localhost:8080/alumno/retrieve
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Aula aula = srvAula.findById(id);//consulta
		model.addAttribute("aula", aula);
		return "aula/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Aula aula = srvAula.findById(id);
		model.addAttribute("aula", aula);
		//el metodo toString se ejecuta por default
		model.addAttribute("title","Actualizando el registro de: "+ aula.toString());
		return "aula/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		this.srvAula.delete(id);
		//despues de borrar se hace un redirect a una accion por invocar
		return "redirect:/aula/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Aula> aulas = this.srvAula.findAll();
		model.addAttribute("aulas", aulas);
		model.addAttribute("title","Listado de aulas");
		return "aula/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/alumno/create
	public String save(Aula aula, Model model) {
		this.srvAula.save(aula);
		return "redirect:/aula/list";
	}
}
