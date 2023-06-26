package com.example.demo.repository.modelo;

import java.util.List;

public interface PacientrRepository {
	
	public void insertar(Paciente paciente);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);

	public Paciente seleccionar(Integer id);
	//-------------------------------------------------------
	
	public Paciente seleccionarPorApellido(String apellido);

	public List<Paciente> seleccionarListaPorApellido(String apellido);

	public Paciente seleccionarPorApellidoyNombre(String apellido, String nombre);

	public Paciente seleccionarPorApellidoTyped(String apellido);

}
