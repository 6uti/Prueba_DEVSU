package com.prueba.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.api.model.Cliente;
import com.prueba.api.model.Cuenta;
import com.prueba.api.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	//Guardar datos
	@PostMapping(value="/guardar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cuenta>guardar(@RequestBody Cuenta cuenta)
	{
		System.out.println(cuenta);
		return new ResponseEntity<Cuenta>(cuentaService.guardar(cuenta),HttpStatus.OK);
	}
	
	//Obtener todos los datos
	@GetMapping(value="/todos")
	public ResponseEntity<List<Cuenta>>obtenerTodosUsuarios()
	{
		return new ResponseEntity<List<Cuenta>>(cuentaService.obtenerTodos(),HttpStatus.OK);
	}

	//Obtener datos por ID
	@GetMapping(value="/obtener/{id}")
	public Optional<Cuenta> obtenerPorID(@PathVariable("id") Long id) {
		return cuentaService.obtenerById(id);
	}
	

}
