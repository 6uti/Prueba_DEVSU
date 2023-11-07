package com.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
