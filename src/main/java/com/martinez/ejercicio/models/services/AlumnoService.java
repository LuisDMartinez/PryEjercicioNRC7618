package com.martinez.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.ejercicio.models.dao.IAlumno;
import com.martinez.ejercicio.models.entities.Alumno;


@Service/*Para que la clase se comporte como un servicio*/
public class AlumnoService implements IAlumnoService{

	
	/*Referencia la DAO, es la que se conecta a la base de datos*/
	@Autowired /*Inyeccion de dependencia, permite que se instancie un objeto de la Dao*/
	private IAlumno dao;
	
	@Override
	@Transactional
	public void save(Alumno a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public Alumno findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return (List<Alumno>)dao.findAll();
	}

}
