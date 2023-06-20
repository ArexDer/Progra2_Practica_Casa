package com.example.demo;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Progra2PracticaCasaApplication implements CommandLineRunner {
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(Progra2PracticaCasaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//main
		Autor autor = new Autor();
		autor.setApellido("Rivas");
		autor.setNombre("Diego");
		
		Autor autor2 = new Autor();
		autor2.setApellido("Ocapana");
		autor.setNombre("Josue");
		
		Libro libro = new Libro();
		libro.setEditorial("editorial UCE");
		libro.setTitulo("Mimir vol 1");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(autor);
		autores.add(autor2);
		
		libro.setAutores(autores);
		
		Set<Libro> libros = new HashSet<>();
		libros.add(libro);
		
		libro.setAutores(autores);
		
		this.libroService.agregar(libro);
		
		this.libroService.actualizar(libro);
		this.libroService.borrar(1);
		this.libroService.buscarPorId(1);
	
		
		
		
		
		
	}

}
