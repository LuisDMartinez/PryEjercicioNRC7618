package com.martinez.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.ejercicio.models.dao.IMatricula;
import com.martinez.ejercicio.models.entities.Matricula;

@Service
public class MatriculaService implements IMatriculaService{

	@Autowired
	private IMatricula dao;
	
	@Override
	@Transactional
	public void save(Matricula a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Matricula findById(Integer id) {
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
	public List<Matricula> findAll() {
		// TODO Auto-generated method stub
		return (List<Matricula>) dao.findAll();
	}

}
