package com.martinez.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.ejercicio.models.dao.ISemestre;
import com.martinez.ejercicio.models.entities.Semestre;

@Service
public class SemestreService implements ISemestreService {

	@Autowired
	private ISemestre dao;
	
	@Override
	@Transactional
	public void save(Semestre a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Semestre findById(Integer id) {
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
	public List<Semestre> findAll() {
		// TODO Auto-generated method stub
		return (List<Semestre>) dao.findAll();
	}

}
