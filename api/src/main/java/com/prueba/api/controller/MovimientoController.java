package com.prueba.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.prueba.api.model.Movimientos;
import com.prueba.api.service.CuentaService;
import com.prueba.api.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin
public class MovimientoController {
	
	@Autowired
	MovimientoService movimientosService;
	
	@Autowired
	CuentaService cuentaService;
	
	@PostMapping(value="/guardar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Movimientos>guardar(@RequestBody Movimientos mov) throws ParseException
	{
		
		double saldoInicial = cuentaService.obtenerById(mov.getCuenta().getId()).get().getSaldo_inicial();
		double saldoActual = mov.getTipo_movimiento()==1 ? saldoInicial+mov.getValor() : saldoInicial-mov.getValor();
		mov.setSaldo(saldoActual);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//	    String toParse = "2023-10-05";
//	    Date date = df.parse(toParse);
//		System.out.println(mov.getFecha_movimiento());
//		mov.setFecha_movimiento(date);
		//mov.setFecha_movimiento(null);
		return new ResponseEntity<Movimientos>(movimientosService.guardar(mov),HttpStatus.OK);
	}
	
	//Obtenes
	@GetMapping(value="/todos")
	public ResponseEntity<List<Movimientos>>obtenerTodosUsuarios()
	{
		return new ResponseEntity<List<Movimientos>>(movimientosService.obtenerTodos(),HttpStatus.OK);
	}
	
	//Obtener datos por ID
	@GetMapping(value="/obtener/{id}")
	public Optional<Movimientos> obtenerPorID(@PathVariable("id") Long id) {
		return movimientosService.obtenerById(id);
	}

}
