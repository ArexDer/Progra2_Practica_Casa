package com.example.demo.repository.modelo;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MedicoRepositoryImpl implements MedicoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Medico medico) {
		// TODO Auto-generated method stub
		this.entityManager.persist(medico);
	}

	@Override
	public void actualizar(Medico medico) {
		// TODO Auto-generated method stub
		this.entityManager.merge(medico);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Medico medico = this.seleccionar(id);
		this.entityManager.remove(medico);
	}

	@Override
	public Medico seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Medico.class, id);
	}

	@Override
	public Medico seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		//Query myQuery = this.entityManager.createQuery("SELECT m FROM Medico m JOIN FETCH m.roles");
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Medico m WHERE m.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Medico)myQuery.getSingleResult();
	}

	@Override
	public List<Medico> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Medico m WHERE m.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Medico seleccionarPorApellidoyNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Medico m WHERE m.apellido = :datoApellido AND m.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Medico)myQuery.getSingleResult();
	}

	@Override
	public Medico seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Medico> myQuery = this.entityManager.createQuery("SELECT m FROM Medico m WHERE m.apellido = :datoApellido",Medico.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

}
