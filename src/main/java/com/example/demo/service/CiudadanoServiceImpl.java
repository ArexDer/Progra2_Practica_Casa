package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.CiudadanoRepository;
import com.example.demo.repository.modelo.Libro;

@Service
public class CiudadanoServiceImpl implements CiudadanoService {
	
	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Override
	public void agregar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public Ciudadano buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorId(id);
	}
	

}
