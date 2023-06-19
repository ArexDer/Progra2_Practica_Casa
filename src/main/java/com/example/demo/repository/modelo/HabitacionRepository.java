package com.example.demo.repository.modelo;

public interface HabitacionRepository {
	
	public void insertar(Habitacion habitacion);

	public void actualizar(Habitacion habitacion);

	public void eliminar(Integer id);

	public Habitacion seleccionarPorId(Integer id);

}
