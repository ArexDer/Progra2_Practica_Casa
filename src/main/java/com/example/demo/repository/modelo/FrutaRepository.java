package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface FrutaRepository {
	
	public void insertar(Fruta fruta);

	public void actualizar(Fruta fruta);

	public void eliminar(Integer id);

	public Fruta seleccionarPorId(Integer id);
	
	//-------------------------------------
	
    public Fruta seleccionarPorNombrePais(String nombre);
	
	public List<Fruta> seleccionarListaPorPrecio(BigDecimal precio);
	
	public Fruta seleccionarPorNombreyPrecio(String nombre, BigDecimal precio);
	
	public Fruta seleccionarPorNombrePaisTyped(String nombre);
	
	public List<Fruta> seleccionarListaPorFecha(LocalDate fechaCaducidad);
	
	//------------Querys dinamicas    
	public Fruta seleccionarFrutaDinamico(String pais, BigDecimal precio, Double peso);
	//Busqueda por Pais y precio  en donde mi Or y AND tiene que ver con el PRECIO del producto

}
