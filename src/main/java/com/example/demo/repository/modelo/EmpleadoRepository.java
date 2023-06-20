package com.example.demo.repository.modelo;

public interface EmpleadoRepository {
	
	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	public Empleado seleccionarPorId(Integer id);

}
