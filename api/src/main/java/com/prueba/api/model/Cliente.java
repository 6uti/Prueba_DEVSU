package com.prueba.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contrasenia;
	private boolean estado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(Long id, String contrasenia, boolean estado, Persona persona) {
		super();
		this.id = id;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.persona = persona;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
}
