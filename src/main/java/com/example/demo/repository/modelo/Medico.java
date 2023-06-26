package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="medico")
public class Medico {
	
	@Id
	@GeneratedValue(generator = "seq_medico", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_medico", sequenceName = "seq_medico", allocationSize = 1)
	@Column(name = "medi_id")
	private Integer id;
	
	@Column(name = "medi_nombre")
	private String nombre;
	
	@Column(name = "medi_apellido")
	private String apellido;
	
	@Column(name = "medi_cargo")
	private String cargo;
	
	//-------------------------------------------------------------
	@OneToMany(mappedBy ="medico")
	private List<Ingreso> ingresos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo + ", ingresos="
				+ ingresos + "]";
	}
	
	
	
	
	
	
	
	

}
