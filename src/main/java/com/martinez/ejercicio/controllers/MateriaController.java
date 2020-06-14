package com.martinez.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martinez.ejercicio.models.entities.Materia;
import com.martinez.ejercicio.models.services.IMateriaService;

@Controller
@RequestMapping(value="/materia") 
public class MateriaController {

	@Autowired
	private IMateriaService srvMateria;
	
	@GetMapping(value="/create")//https://localhost:8080/alumno/create
	public String create(Model model) {
		Materia materia = new Materia();
		model.addAttribute("title","Registro de nueva Materia");
		model.addAttribute("materia", materia);
		return "materia/form";
	}
	
	@GetMapping(value="/retrieve/{id}")//https://localhost:8080/alumno/retrieve
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Materia materia = srvMateria.findById(id);//consulta
		model.addAttribute("materia", materia);
		return "materia/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Materia materia = srvMateria.findById(id);
		model.addAttribute("materia", materia);
		//el metodo toString se ejecuta por default
		model.addAttribute("title","Actualizando el registro de: "+ materia.toString());
		return "materia/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		this.srvMateria.delete(id);
		//despues de borrar se hace un redirect a una accion por invocar
		return "redirect:/materia/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Materia> materias = this.srvMateria.findAll();
		model.addAttribute("materias", materias);
		model.addAttribute("title","Listado de materias");
		return "materia/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/alumno/create
	public String save(Materia materia, Model model) {
		this.srvMateria.save(materia);
		return "redirect:/materia/list";
	}
}
