package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Ingreso;

public interface IngresoService {
	
	public void insertar(Ingreso ingreso);

	public void actualizar(Ingreso ingreso);

	public void eliminar(Integer id);

	public Ingreso seleccionar(Integer id);
	//-------------------------------------------------------
	
	public Ingreso seleccionarPorPrecio(BigDecimal precio);

	public List<Ingreso> seleccionarListaPorPrecioyFecha(BigDecimal precio, LocalDate fecha);


	public Ingreso seleccionarPorPrecioTyped(BigDecimal precio);

}
