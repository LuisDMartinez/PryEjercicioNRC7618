package com.martinez.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {
	
	@GetMapping(value= {"/","/index.html"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping(value= {"/404.html"})
	public String notfound(Model model) {
		return "404";
	}
	

}
