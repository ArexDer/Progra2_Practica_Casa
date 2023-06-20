package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public void agregar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.actualizar(autor);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepository.eliminar(id);
	}

	@Override
	public Autor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorId(id);
	}

}