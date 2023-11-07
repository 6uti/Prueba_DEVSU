package com.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.model.Movimientos;
import com.prueba.api.repository.MovimientoRepository;

@Service
public class MovimientoService {
	
	@Autowired
	private MovimientoRepository movimientosRepository;
	
	//Guardar cliente
		public Movimientos guardar(Movimientos mov) {
			return movimientosRepository.save(mov);
		}
		
		//Obtener todos los datos
		public List<Movimientos>obtenerTodos()
		{
			return movimientosRepository.findAll();
		}
		
		//Obtener por ID
		public Optional<Movimientos> obtenerById(Long id)
		{
			return movimientosRepository.findById(id);
		}
		
		
		//Buscar por ID
//		public Cliente buscarPorId(Long id)
//		{
//			return (Cliente) em.createQuery("select a from Cliente a where a.id= :p1")
//					.setParameter("p1", id).getSingleResult();
//		}
		
//		//Eliminar por ID
		public void eliminarPorId(Long id)
		{
			movimientosRepository.deleteById(id);
		}

}
