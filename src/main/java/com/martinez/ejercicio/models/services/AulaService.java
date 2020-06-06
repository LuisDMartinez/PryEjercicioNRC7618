package com.martinez.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.ejercicio.models.dao.IAula;
import com.martinez.ejercicio.models.entities.Aula;

@Service
public class AulaService implements IAulaService {

	@Autowired
	private IAula dao;
	
	@Override
	@Transactional
	public void save(Aula a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Aula findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Aula> findAll() {
	
		return (List<Aula>) dao.findAll();
	}

}
