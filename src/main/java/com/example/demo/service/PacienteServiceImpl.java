package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Paciente;
import com.example.demo.repository.modelo.PacientrRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacientrRepository  pacientrRepository;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacientrRepository.insertar(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacientrRepository.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.pacientrRepository.eliminar(id);
	}

	@Override
	public Paciente seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.pacientrRepository.seleccionar(id);
	}

	@Override
	public Paciente seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.pacientrRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Paciente> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.pacientrRepository.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Paciente seleccionarPorApellidoyNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		return this.pacientrRepository.seleccionarPorApellidoyNombre(apellido, nombre);
	}

	@Override
	public Paciente seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.pacientrRepository.seleccionarPorApellidoTyped(apellido);
	}

}
