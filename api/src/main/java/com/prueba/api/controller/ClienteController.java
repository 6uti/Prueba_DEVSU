package com.prueba.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.prueba.api.model.Cliente;
import com.prueba.api.model.Persona;
import com.prueba.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	//Guardar datos
	
	@PostMapping(value="/guardar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cliente>guardar(@RequestBody Cliente cliente)
	{
		return new ResponseEntity<Cliente>(clienteService.guardar(cliente),HttpStatus.OK);
	}
	
	//Obtenes
	@GetMapping(value="/todos")
	public ResponseEntity<List<Cliente>>obtenerTodosUsuarios()
	{
		return new ResponseEntity<List<Cliente>>(clienteService.obtenerTodos(),HttpStatus.OK);
	}
	
	//Obtener datos por ID
	@GetMapping(value="/obtener/{id}")
	public Optional<Cliente> obtenerPorID(@PathVariable("id") Long id) {
		return clienteService.obtenerById(id);
	}
	
	//actualizar datos
	@PutMapping(value="/modificar/{id}")
	public ResponseEntity<Cliente> modificabyID(@PathVariable("id") Long id,@RequestBody Cliente cliente)
	{
		Persona per = new Persona();
		per.setId(cliente.getPersona().getId());
		per.setDireccion(cliente.getPersona().getDireccion());
		per.setEdad(cliente.getPersona().getEdad());
		per.setGenero(cliente.getPersona().getGenero());
		per.setNombre(cliente.getPersona().getNombre());
		per.setTelefono(cliente.getPersona().getTelefono());

		Cliente cli = new Cliente();
		cli.setId(id);
		cli.setContrasenia(cliente.getContrasenia());
		cli.setEstado(cliente.isEstado());
		cli.setPersona(per);
		
		return new ResponseEntity<Cliente>(clienteService.guardar(cli),HttpStatus.OK);
	}
	
	//eliminar datos
	@DeleteMapping(value="/eliminar/{id}")
	public String eliminarbyID(@PathVariable("id")Long id)
	{
		clienteService.eliminarPorId(id);

		return "Usuario eliminado - ID: "+id;
	}

}
