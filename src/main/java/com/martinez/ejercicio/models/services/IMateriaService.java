package com.martinez.ejercicio.models.services;

import java.util.List;

import com.martinez.ejercicio.models.entities.Materia;

public interface IMateriaService {

	public void save(Materia a);
	public Materia findById(Integer id);
	public void delete(Integer id);
	public List<Materia> findAll();
}
