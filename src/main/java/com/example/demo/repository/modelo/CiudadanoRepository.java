package com.example.demo.repository.modelo;

public interface CiudadanoRepository {
	
	public void insertar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	public Ciudadano seleccionarPorId(Integer id);

}
