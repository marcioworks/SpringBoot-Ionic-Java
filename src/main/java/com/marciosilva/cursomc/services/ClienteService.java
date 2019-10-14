package com.marciosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciosilva.cursomc.domain.Cliente;
import com.marciosilva.cursomc.repositories.ClienteRepository;
import com.marciosilva.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElseThrow(() -> new  ObjectNotFoundException("Cliente nao encontado! Id: "+id 
				+", Tipo: "+Cliente.class.getName()));
	}
	
}
