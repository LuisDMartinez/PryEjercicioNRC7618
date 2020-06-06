package com.martinez.ejercicio.models.services;

import java.util.List;

import com.martinez.ejercicio.models.entities.Semestre;

public interface ISemestreService {

	public void save(Semestre a);
	public Semestre findById(Integer id);
	public void delete(Integer id);
	public List<Semestre> findAll();
}
