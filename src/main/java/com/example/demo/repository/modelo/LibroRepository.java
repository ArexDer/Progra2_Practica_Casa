package com.example.demo.repository.modelo;

public interface LibroRepository {
	
	public void insertar(Libro libro);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

	public Libro seleccionarPorId(Integer id);

}
