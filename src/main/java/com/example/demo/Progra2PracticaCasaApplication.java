package com.example.demo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Progra2PracticaCasaApplication implements CommandLineRunner {
	
	@Autowired
	private HotelService hotelservice;
	
	@Autowired
	private HabitacionService habitacionservice;

	public static void main(String[] args) {
		SpringApplication.run(Progra2PracticaCasaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//main
		Hotel aa = new Hotel();
		Habitacion aA = new Habitacion();
		
		Hotel bb = new Hotel();
		Habitacion bB = new Habitacion();
		
		
		List<Habitacion> cuartos = new ArrayList<>();
		List<Habitacion> cuartosB = new ArrayList<>();
		
		
		aA.setNumero("19");
		aA.setValor(new BigDecimal(5));
		aA.setHotel(aa);
		cuartos.add(aA);
		
		
	
		aa.setNombre("Hotel UCE");
		aa.setDireccion("Seminario");
		aa.setHabitaciones(cuartos);
		
		this.hotelservice.agregar(aa);
		
		//--------------------------------------------
		
		
		bB.setNumero("22");
		bB.setValor(new BigDecimal(20));
		bB.setHotel(bb);
		cuartosB.add(bB);
		
		
	
		bb.setNombre("Hotel de BB");
		bb.setDireccion("Valle");
		bb.setHabitaciones(cuartosB);
		
		this.hotelservice.agregar(bb);
		
	
		
		
		
		
		
	}

}
