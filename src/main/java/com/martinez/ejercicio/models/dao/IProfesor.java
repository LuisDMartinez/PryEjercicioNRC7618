package com.martinez.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.martinez.ejercicio.models.entities.Profesor;

public interface IProfesor extends CrudRepository<Profesor,Integer>{

}
