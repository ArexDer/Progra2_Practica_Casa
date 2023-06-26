package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Medico;
import com.example.demo.repository.modelo.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {
 
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public void insertar(Medico medico) {
		// TODO Auto-generated method stub
		this.medicoRepository.insertar(medico);
	}

	@Override
	public void actualizar(Medico medico) {
		// TODO Auto-generated method stub
		this.medicoRepository.actualizar(medico);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.medicoRepository.eliminar(id);
		
	}

	@Override
	public Medico seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.medicoRepository.seleccionar(id);
	}

	@Override
	public Medico seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.medicoRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Medico> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.medicoRepository.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Medico seleccionarPorApellidoyNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		return this.medicoRepository.seleccionarPorApellidoyNombre(apellido, nombre);
	}

	@Override
	public Medico seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.medicoRepository.seleccionarPorApellidoTyped(apellido);
	}

}
