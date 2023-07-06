package com.example.demo;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Fruta;
import com.example.demo.service.FrutaService;


@SpringBootApplication
public class Progra2PracticaCasaApplication implements CommandLineRunner {
	
	
	@Autowired
	private FrutaService frutaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Progra2PracticaCasaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//main
		/*
		Fruta f = new Fruta();
		
		f.setNombre("Sandia");
		f.setPeso(3.24);
		f.setTipo("Templado");
		f.setPrecio(new BigDecimal(3.25));
		f.setPaisOrigen("Latam");
		
		f.setFechallegada(LocalDate.now());  //FECHA DE INGRESO
		f.setFechaCaducidad(LocalDate.of(2023, Month.AUGUST, 5)); //FECHA DE CADUCIDAD
		this.frutaService.insertar(f);
		*/		
		
		/*
		//BUSQUEDA CON QUERY DINAMICA
		System.out.println("Busqueda Dinamica AND");
		System.out.println(this.frutaService.BuscarFrutaDinamico("Ecuador",new BigDecimal(14.20),9.5));
                                                                //PAIS      PRECIO         PESO
		
		System.out.println("Busqueda Dinamica OR");
		System.out.println(this.frutaService.BuscarFrutaDinamico("Brazil",new BigDecimal(0.50),3.88));
                                                                //PAIS      PRECIO         PESO
                                                                 
        */
		
		// DELETE  Y UPDATE
		System.out.println("Eliminar por Pais de Origen de la FRUTA");
		System.out.println(this.frutaService.borrarPorPais("Latam"));

		System.out.println("Actualizar por Nombre los atributos de Pais de origen y precio ");
		System.out.println(this.frutaService.actualizarPorNombre("Mango", "Brazil", new BigDecimal(0.85)));
		

	
		
		

		
	}

}
