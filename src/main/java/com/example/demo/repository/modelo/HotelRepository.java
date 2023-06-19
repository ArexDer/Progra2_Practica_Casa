package com.example.demo.repository.modelo;

public interface HotelRepository {
	
	public void insertar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

	public Hotel seleccionarPorIdHotel(Integer id);

}
