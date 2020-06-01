package com.martinez.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.martinez.ejercicio.models.entities.Alumno;

public interface IAlumno extends CrudRepository<Alumno,Integer> {

}
