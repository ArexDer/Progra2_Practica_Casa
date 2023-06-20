package com.example.demo.repository.modelo;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
		
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.seleccionarPorIdHotel(id);
		this.entityManager.remove(hotel);
		
	}

	@Override
	public Hotel seleccionarPorIdHotel(Integer id) {
		
		//System.out.println(this.entityManager.find(Hotel.class, id));
		return this.entityManager.find(Hotel.class, id);
	}

}
