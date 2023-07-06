package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Fruta;
import com.example.demo.repository.modelo.FrutaRepository;

@Service
public class FrutaServiceImpl implements FrutaService {
	
	@Autowired
	private FrutaRepository frutaRepository;

	@Override
	public void insertar(Fruta fruta) {
		// TODO Auto-generated method stub
		this.frutaRepository.insertar(fruta);
		
	}

	@Override
	public void actualizar(Fruta fruta) {
		// TODO Auto-generated method stub
		this.frutaRepository.actualizar(fruta);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.frutaRepository.eliminar(id);
		
	}

	@Override
	public Fruta seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.frutaRepository.seleccionarPorId(id);
	}

	@Override
	public Fruta seleccionarPorNombrePais(String nombre) {
		// TODO Auto-generated method stub
		return this.frutaRepository.seleccionarPorNombrePais(nombre);
	}

	@Override
	public List<Fruta> seleccionarListaPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.frutaRepository.seleccionarListaPorPrecio(precio);
	}

	@Override
	public Fruta seleccionarPorNombreyPrecio(String nombre, BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.frutaRepository.seleccionarPorNombreyPrecio(nombre, precio);
	}

	@Override
	public Fruta seleccionarPorNombrePaisTyped(String nombrePais) {
		// TODO Auto-generated method stub
		return this.frutaRepository.seleccionarPorNombrePaisTyped(nombrePais);
	}

	@Override
	public List<Fruta> seleccionarListaPorFecha(LocalDate  fechaCaducidad) {
		// TODO Auto-generated method stub
		return this.seleccionarListaPorFecha(fechaCaducidad);
	}

	@Override
	public Fruta BuscarFrutaDinamico(String pais, BigDecimal precio, Double peso) {
		// TODO Auto-generated method stub
		return this.frutaRepository.seleccionarFrutaDinamico(pais, precio, peso);
	}

}
