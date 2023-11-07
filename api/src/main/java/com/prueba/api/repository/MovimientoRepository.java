package com.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.api.model.Movimientos;

public interface MovimientoRepository  extends JpaRepository<Movimientos, Long> {
	
}
