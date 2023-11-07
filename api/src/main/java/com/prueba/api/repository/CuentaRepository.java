package com.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.api.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
