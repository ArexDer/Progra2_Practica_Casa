package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Ingreso;
import com.example.demo.repository.modelo.IngresoRepository;
@Service
public class IngresoServiceImpl implements IngresoService {

	@Autowired
	private IngresoRepository ingresoRepository;
	
	@Override
	public void insertar(Ingreso ingreso) {
		// TODO Auto-generated method stub
		this.ingresoRepository.insertar(ingreso);
	}

	@Override
	public void actualizar(Ingreso ingreso) {
		// TODO Auto-generated method stub
		this.ingresoRepository.actualizar(ingreso);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.eliminar(id);
	}

	@Override
	public Ingreso seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.ingresoRepository.seleccionar(id);
	}

	@Override
	public Ingreso seleccionarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.ingresoRepository.seleccionarPorPrecio(precio);
	}

	@Override
	public List<Ingreso> seleccionarListaPorPrecioyFecha(BigDecimal precio, LocalDate fecha) {
		// TODO Auto-generated method stub
		return this.ingresoRepository.seleccionarListaPorPrecioyFecha(precio,fecha);
	}

	@Override
	public Ingreso seleccionarPorPrecioTyped(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.ingresoRepository.seleccionarPorPrecioTyped(precio);
	}

}
