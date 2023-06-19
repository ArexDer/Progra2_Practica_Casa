package com.example.demo.repository.modelo;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements HabitacionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
		
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion habitacion = this.seleccionarPorId(id);
		this.entityManager.remove(habitacion);
		
	}

	@Override
	public Habitacion seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

}
