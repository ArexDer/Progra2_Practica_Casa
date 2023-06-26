package com.example.demo.repository.modelo;

import java.util.List;

public interface MedicoRepository {
	
	public void insertar(Medico medico);

	public void actualizar(Medico medico );

	public void eliminar(Integer id);

	public Medico seleccionar(Integer id);
	//-------------------------------------------------------
	
	public Medico seleccionarPorApellido(String apellido);

	public List<Medico> seleccionarListaPorApellido(String apellido);

	public Medico seleccionarPorApellidoyNombre(String apellido, String nombre);

	public Medico seleccionarPorApellidoTyped(String apellido);
	
}
