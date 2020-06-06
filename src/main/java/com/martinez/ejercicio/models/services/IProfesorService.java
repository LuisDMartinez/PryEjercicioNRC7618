package com.martinez.ejercicio.models.services;

import java.util.List;

import com.martinez.ejercicio.models.entities.Profesor;

public interface IProfesorService {

	public void save(Profesor a);
	public Profesor findById(Integer id);
	public void delete(Integer id);
	public List<Profesor> findAll();
}
