package com.prueba.api.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.model.Cliente;
import com.prueba.api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private EntityManager em=null;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Guardar cliente
	public Cliente guardar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//Obtener todos los datos
	public List<Cliente>obtenerTodos()
	{
		return clienteRepository.findAll();
	}
	
	//Obtener por ID
	public Optional<Cliente> obtenerById(Long id)
	{
		return clienteRepository.findById(id);
	}
	
	
	//Buscar por ID
	public Cliente buscarPorId(Long id)
	{
		return (Cliente) em.createQuery("select a from Cliente a where a.id= :p1")
				.setParameter("p1", id).getSingleResult();
	}
	
	//Eliminar por ID
	public void eliminarPorId(Long id)
	{
		clienteRepository.deleteById(id);
	}
	

}
