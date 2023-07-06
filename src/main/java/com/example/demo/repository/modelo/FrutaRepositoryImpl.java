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
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Fruta seleccionarFrutaDinamico(String pais, BigDecimal precio, Double peso) {
	
				CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

				// 1.- Especificar el tipo de retorno que tiene mi Query
				CriteriaQuery<Fruta> myCriteriaQuery = myBuilder.createQuery(Fruta.class);

			
				Root<Fruta> miTablaFrom = myCriteriaQuery.from(Fruta.class);

				// Construir las condiciones de manera DINAMICA
				//EN DONDE SI EL PRECIO ESTA SOBRE UN RANGO SE APLICA UNA BUSQUEDA,
				//CASO CONTRARIO OTRA BUSQUEDA
				
				

				
				Predicate fruPais = myBuilder.equal(miTablaFrom.get("paisOrigen"), pais);

				
				Predicate fruPeso = myBuilder.equal(miTablaFrom.get("peso"), peso);

				// if((peso.compareTo(new Double(0)) <= 0))<= 0{// se raya el double cuando es
				// innecesario o esta obsoleto

				Predicate predicadoFinal = null;
				
                BigDecimal valor1, valor2;
			

                valor1= new BigDecimal(2.10);
                
                valor2= new BigDecimal(4.00);
                
                /*
                 *   1 Cuando el primer valor BigDecimal sea mayor que el segundo valor BigDecimal.
                     0 Cuando el primer valor BigDecimal sea igual que el segundo valor BigDecimal.
                    -1 Cuando el primer valor BigDecimal sea menor que el segundo valor BigDecimal.
                 */
				
				if (precio.compareTo(valor1)==1 && precio.compareTo(valor2)== -1)  {
					
					predicadoFinal = myBuilder.or(fruPais, fruPeso);
					
				} else {
					
					predicadoFinal = myBuilder.and(fruPais, fruPeso);
				
				}

				//CONSULTA FINAL
				myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);

				TypedQuery<Fruta> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery); 
																										
				// 5.-AL FINAL LA QUERY LA REALIZAMOS CON TYPED
				return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorPais(String paisOrigen) {
		
				Query myQuery = this.entityManager.createQuery("DELETE from Fruta f where f.paisOrigen = :datoPaisOrigen");
				myQuery.setParameter("datoPaisOrigen", paisOrigen);
				return myQuery.executeUpdate();
				//ME IMPRIME EL NUMERO DE REGISTROS ELIMINADOS
	}

	@Override
	public int actualizarPorNombre(String nombre, String paisOrigen, BigDecimal precio) {
		
				Query myQuery = this.entityManager.createQuery("UPDATE Fruta f SET f.paisOrigen = :datoPaisOrigen, f.precio = :datoPrecio WHERE f.nombre = :datoNombre");
				myQuery.setParameter("datoPaisOrigen", paisOrigen);
				myQuery.setParameter("datoPrecio", precio);
				myQuery.setParameter("datoNombre", nombre);
				
				return myQuery.executeUpdate();// numero de registros afectados
	}

}
