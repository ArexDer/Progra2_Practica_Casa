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
public class PacientrRepositoryImpl implements PacientrRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente paciente = this.seleccionar(id);
		this.entityManager.remove(paciente);
		
	}

	@Override
	public Paciente seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Medico p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Paciente)myQuery.getSingleResult();
	}

	@Override
	public List<Paciente> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Medico p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Paciente seleccionarPorApellidoyNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Medico p WHERE p.apellido = :datoApellido AND p.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Paciente)myQuery.getSingleResult();
	}

	@Override
	public Paciente seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Medico p WHERE p.apellido = :datoApellido",Paciente.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}
	

}
