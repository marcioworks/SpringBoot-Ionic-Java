package com.marciosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciosilva.cursomc.domain.Pedido;
import com.marciosilva.cursomc.repositories.PedidoRepository;
import com.marciosilva.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow( ()-> new ObjectNotFoundException("Objeto nao encontado! Id: "+ id 
				+", Tipo: "+ Pedido.class.getName()));
		
	}
}


