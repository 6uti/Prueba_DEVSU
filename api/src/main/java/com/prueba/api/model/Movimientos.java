package com.prueba.api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_movimientos")
public class Movimientos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_movimiento;
	private int tipo_movimiento;
	private double valor;
	private double saldo;
	
	@OneToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "cuenta_id")
    @JsonIgnoreProperties(value ={"entidad","handler", "hibernateLazyInitializer"}) 
	private Cuenta cuenta;
	
	public Movimientos() {
		super();
	}

	public Movimientos(Long id, Date fecha_movimiento, int tipo_movimiento, double valor, double saldo, Cuenta cuenta) {
		super();
		this.id = id;
		this.fecha_movimiento = fecha_movimiento;
		this.tipo_movimiento = tipo_movimiento;
		this.valor = valor;
		this.saldo = saldo;
		this.cuenta = cuenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(int tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}


	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFecha_movimiento() {
		return fecha_movimiento;
	}

	public void setFecha_movimiento(Date fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

}
