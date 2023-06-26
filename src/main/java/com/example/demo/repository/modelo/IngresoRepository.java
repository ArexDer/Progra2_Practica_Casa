package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IngresoRepository {
	
	public void insertar(Ingreso ingreso);

	public void actualizar(Ingreso ingreso);

	public void eliminar(Integer id);

	public Ingreso seleccionar(Integer id);
	//-------------------------------------------------------
	
	public Ingreso seleccionarPorPrecio(BigDecimal precio);

	public List<Ingreso> seleccionarListaPorPrecioyFecha(BigDecimal precio, LocalDate fecha);


	public Ingreso seleccionarPorPrecioTyped(BigDecimal precio);

}
