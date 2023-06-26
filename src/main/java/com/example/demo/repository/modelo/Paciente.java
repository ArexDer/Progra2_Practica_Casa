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
@Table(name ="paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1)
	@Column(name = "paci_id")
	private Integer id;

	@Column(name = "paci_nombre")
	private String nombre;
	
	@Column(name = "paci_apellido")
	private String apellido;
	
	@Column(name = "paci_provincia")
	private String provincia;
	
	//----------------------------------------------------
	@OneToMany(mappedBy ="paciente")
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", provincia=" + provincia
				+ ", ingresos=" + ingresos + "]";
	}
	
	
	
	
	
	

}
