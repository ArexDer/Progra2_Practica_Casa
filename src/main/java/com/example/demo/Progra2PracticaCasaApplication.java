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
		
		Fruta f = new Fruta();
		
		f.setNombre("Sandia");
		f.setPeso(3.24);
		f.setTipo("Templado");
		f.setPrecio(new BigDecimal(3.25));
		f.setPaisOrigen("Latam");
		
		f.setFechallegada(LocalDate.now());  //FECHA DE INGRESO
		f.setFechaCaducidad(LocalDate.of(2023, Month.AUGUST, 5)); //FECHA DE CADUCIDAD
		this.frutaService.insertar(f);
		
		
		
	
		//PRIMERA CONSULTA
		System.out.println("Ejemplo de Query con single result");
		System.out.println(this.frutaService.seleccionarPorNombrePais("Ecuador"));

		//SEGUNDA CONSULTA
		System.out.println("---------------------------------------");
		System.out.println("Ejemplo de Query con result list");
		System.out.println(this.frutaService.seleccionarListaPorPrecio(new BigDecimal(0.50)));
		
		//List<Fruta> listaFrutas = this.frutaService.seleccionarListaPorPrecio(new BigDecimal(0.50));
		//for(Fruta fru: listaFrutas) {
		//	System.out.println(fru);
		//} UNA MANERA DE VERLO PERO TODO ESTO DEBE ESTAR DEBAJO DE LA CAPA CONTROLLER
		
		//TERCERA CONSULTA TYPE
		System.out.println("---------------------------------------");
		System.out.println("Ejemplo de TypedQuery con single result");
		System.out.println(this.frutaService.seleccionarPorNombrePaisTyped("Brazil"));

/*
		//CURATA CONSULTA TYPE
		System.out.println("---------------------------------------");
		System.out.println("Ejemplo de TypedQuery con result list");
		System.out.println(this.frutaService.seleccionarListaPorFecha(LocalDate.of(2023, Month.AUGUST, 5)));
		
*/		
		
	}

}
