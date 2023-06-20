package com.example.demo;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;

@SpringBootApplication
public class Progra2PracticaCasaApplication implements CommandLineRunner {
	
	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private CiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Progra2PracticaCasaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//main
		Empleado e1 = new Empleado();
		Ciudadano c1 = new Ciudadano();
		
		
		e1.setCargo("Pasante");
		e1.setSueldo(new BigDecimal(300));
		
		c1.setNombre("Diego");
		c1.setApellido("Rivas");
		c1.setCedula("123456789");
		
		c1.setEmpleado(e1);
		e1.setCiudadano(c1);
		
		this.ciudadanoService.agregar(c1);
		this.ciudadanoService.buscarPorId(2);
		
		Ciudadano c2 = new Ciudadano();
		
		c2.setNombre("Persona");
		c2.setApellido("Ec");
		c2.setCedula("000002");
		e1.setCiudadano(c2);
		this.empleadoService.actualizar(e1);
		
		this.empleadoService.borrar(2);
		
	
		
		
		

	
		
		
		
		
		
	}

}
