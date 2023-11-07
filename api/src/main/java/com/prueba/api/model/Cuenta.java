package com.prueba.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero_cuenta;
	private int tipo_cuenta;
	private double saldo_inicial;
	private boolean estado;
	
	@OneToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties(value ={"entidad","handler", "hibernateLazyInitializer"}) 
	private Cliente cliente; 
	
	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuenta(Long id, String numero_cuenta, int tipo_cuenta, double saldo_inicial, boolean estado,
			Cliente cliente) {
		super();
		this.id = id;
		this.numero_cuenta = numero_cuenta;
		this.tipo_cuenta = tipo_cuenta;
		this.saldo_inicial = saldo_inicial;
		this.estado = estado;
		this.cliente = cliente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero_cuenta() {
		return numero_cuenta;
	}
	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
	public int getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(int tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
	public double getSaldo_inicial() {
		return saldo_inicial;
	}
	public void setSaldo_inicial(double saldo_inicial) {
		this.saldo_inicial = saldo_inicial;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
