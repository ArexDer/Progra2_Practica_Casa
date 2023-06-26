package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class IngresoRepositoryImpl implements IngresoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ingreso ingreso) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ingreso);
	}

	@Override
	public void actualizar(Ingreso ingreso) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ingreso);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ingreso ingreso = this.seleccionar(id);
		this.entityManager.remove(ingreso);
		
	}

	@Override
	public Ingreso seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ingreso.class, id);
	}

	@Override
	public Ingreso seleccionarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT pre FROM Ingreso pre WHERE pre.precio = :datoPrecio");
		myQuery.setParameter("datoPrecio", precio);
		return (Ingreso)myQuery.getSingleResult();
	}

	@Override
	public List<Ingreso> seleccionarListaPorPrecioyFecha(BigDecimal precio, LocalDate fecha) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT pre FROM Ingreso pre WHERE pre.precio = :datoPrecio");
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}

	

	@Override
	public Ingreso seleccionarPorPrecioTyped(BigDecimal precio) {
		// TODO Auto-generated method stub
		TypedQuery<Ingreso> myQuery = this.entityManager.createQuery("SELECT pre FROM Ingreso pre WHERE pre.precio = :datoPrecio",Ingreso.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getSingleResult();
	}

}
