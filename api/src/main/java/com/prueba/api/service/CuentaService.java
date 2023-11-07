package com.prueba.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.model.Cuenta;
import com.prueba.api.repository.CuentaRepository;

@Service
public class CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	//Guardar cuenta
	public Cuenta guardar(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	//Obtener todos los datos
	public List<Cuenta>obtenerTodos()
	{
		return cuentaRepository.findAll();
	}

	//Obtener por ID
	public Optional<Cuenta> obtenerById(Long id)
	{
		return cuentaRepository.findById(id);
	}

}
