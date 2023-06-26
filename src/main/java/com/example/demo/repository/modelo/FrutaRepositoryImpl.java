package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FrutaRepositoryImpl implements FrutaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static List<Fruta> baseDatos = new ArrayList<>();
	
	@Override
	public void insertar(Fruta fruta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(fruta);
	}

	@Override
	public void actualizar(Fruta fruta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(fruta);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Fruta fruta = this.seleccionarPorId(id);
		this.entityManager.remove(fruta);
	}

	@Override
	public Fruta seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Fruta.class, id);
	}

	@Override
	public Fruta seleccionarPorNombrePais(String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT f FROM Fruta f WHERE f.paisOrigen = :datoPaisOrigen");
		myQuery.setParameter("datoPaisOrigen", nombre);
		return (Fruta)myQuery.getSingleResult();
	}

	@Override
	public List<Fruta> seleccionarListaPorPrecio(BigDecimal precio) {
		Query myQuery = this.entityManager.createQuery("SELECT f FROM Fruta f WHERE f.precio = :datoPrecio");
		myQuery.setParameter("datoPrecio", precio);
		List<Fruta> f = myQuery.getResultList();
		return f;
	}

	@Override
	public Fruta seleccionarPorNombreyPrecio(String nombre, BigDecimal precio) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT f FROM Fruta f WHEREf.nombre = :datoNombre AND f.precio = :datoPrecio");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoPrecio", precio);
		return (Fruta)myQuery.getSingleResult();
	}

	@Override
	public Fruta seleccionarPorNombrePaisTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Fruta> myQuery = this.entityManager.createQuery("SELECT f FROM Fruta f WHERE f.paisOrigen = :datoPaisOrigen",Fruta.class);
		myQuery.setParameter("datoPaisOrigen", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Fruta> seleccionarListaPorFecha(LocalDate fechaCaducidad) {
		TypedQuery<Fruta> myQuery = this.entityManager.createQuery("SELECT f FROM Fruta f WHERE f.fechaCaducidad = :datoFechaCaducidad",Fruta.class);
		myQuery.setParameter("datoFechaCaducidad", fechaCaducidad);
		List<Fruta> f = myQuery.getResultList();
		return f;
	}

}
