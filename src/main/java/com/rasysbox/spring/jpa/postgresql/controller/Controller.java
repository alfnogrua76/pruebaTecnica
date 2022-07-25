package com.rasysbox.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasysbox.spring.jpa.postgresql.model.Model;
import com.rasysbox.spring.jpa.postgresql.repository.Repository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	Repository usuariosRepository;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Model>> getAllUsuarios(@RequestParam(required = false) String nombre) {
		try {
			List<Model> usuarios = new ArrayList<Model>();
			if (nombre == null)
				usuariosRepository.findAll().forEach(usuarios::add);
			else
				usuariosRepository.findByNombre(nombre).forEach(usuarios::add);

			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Model> getUserById(@PathVariable("id") long id) {
		Optional<Model> usuariosData = usuariosRepository.findById(id);
		if (usuariosData.isPresent()) {
			return new ResponseEntity<>(usuariosData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Model> createUser(@RequestBody Model tutorial) {
		try {
			Model _usuarios = usuariosRepository
					.save(new Model(tutorial.getNombre(), tutorial.getEmail(), false));
			return new ResponseEntity<>(_usuarios, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Model> updateUser(@PathVariable("id") long id, @RequestBody Model tutorial) {
		Optional<Model> usuariosData = usuariosRepository.findById(id);
		if (usuariosData.isPresent()) {
			Model _tutorial = usuariosData.get();
			_tutorial.setNombre(tutorial.getNombre());
			_tutorial.setEmail(tutorial.getEmail());
			_tutorial.setEstado(tutorial.isEstado());
			return new ResponseEntity<>(usuariosRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			usuariosRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/usuarios")
	public ResponseEntity<HttpStatus> deleteAllUsuarios() {
		try {
			usuariosRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/usuarios/estado")
	public ResponseEntity<List<Model>> findByEstado() {
		try {
			List<Model> usuarios = usuariosRepository.findByEstado(true);
			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
