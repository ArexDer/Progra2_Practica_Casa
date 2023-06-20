package com.example.demo.service;

import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoService {
	public void agregar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void borrar(Integer id);

	public Empleado buscarPorId(Integer id);
	
	

}
