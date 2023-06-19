package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService{
	
	@Autowired
	private HabitacionRepository habitacionRepository;

	@Override
	public void agregar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.actualizar(habitacion);
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepository.eliminar(id);
		
	}

	@Override
	public Habitacion buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorId(id);
	}

}
