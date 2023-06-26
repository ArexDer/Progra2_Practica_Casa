package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruta")
public class Fruta {
	
	@GeneratedValue(generator = "seq_fruta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_fruta", sequenceName = "seq_fruta", allocationSize = 1)
	@Id
	@Column(name = "frut_id")
	private Integer id;
	
	@Column(name = "frut_nombre")
	private String nombre;
	
	@Column(name = "frut_tipo")
	private String tipo; 
	
	@Column(name = "frut_precio")
	private BigDecimal precio;
	
	@Column(name = "frut_peso")
	private Double peso;
	
	@Column(name = "frut_fechaCaducidad")
	private LocalDate fechaCaducidad;
	
	@Column(name = "frut_fechallegada")
	private LocalDate fechallegada;
	
	@Column(name = "frut_paisOrigen")
	private String paisOrigen;
	
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public LocalDate getFechallegada() {
		return fechallegada;
	}
	public void setFechallegada(LocalDate fechallegada) {
		this.fechallegada = fechallegada;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	@Override
	public String toString() {
		return "Fruta [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", peso=" + peso
				+ ", fechaCaducidad=" + fechaCaducidad + ", fechallegada=" + fechallegada + ", paisOrigen=" + paisOrigen
				+ "]";
	}
	
	

}
