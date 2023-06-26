package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table (name ="ingreso")
public class Ingreso {
	
	@Id
	@GeneratedValue(generator = "seq_ingreso", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_ingreso", sequenceName = "seq_ingreso", allocationSize = 1)
	@Column(name = "ingr_id")
	private Integer id;
	
	@Column(name = "ingr_numHabitaciones")
	private String numHabitaciones;
	
	@Column(name = "ingr_camaDesignada")
	private String camaDesignada;
	
	@Column(name = "ingr_fechaIngreso")
	private LocalDate fechaIngreso;
	
	@Column(name = "ingr_precio")
	private BigDecimal precio;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "ingr_id_medico")
    private Medico medico;
    
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "ingr_id_paciente")
    private Paciente paciente;
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumHabitaciones() {
		return numHabitaciones;
	}
	public void setNumHabitaciones(String numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	public String getCamaDesignada() {
		return camaDesignada;
	}
	public void setCamaDesignada(String camaDesignada) {
		this.camaDesignada = camaDesignada;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	@Override
	public String toString() {
		return "Ingreso [id=" + id + ", numHabitaciones=" + numHabitaciones + ", camaDesignada=" + camaDesignada
				+ ", fechaIngreso=" + fechaIngreso + ", precio=" + precio + ", medico=" + medico + ", paciente="
				+ paciente + "]";
	}
	
	
	
	
	

}
