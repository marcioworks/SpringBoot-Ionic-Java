package com.marciosilva.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciosilva.cursomc.domain.Cidade;
import com.marciosilva.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	
	@Autowired
	private CidadeRepository repo;
	
	
	public List<Cidade> findByEstado(Integer esatdoId){
		return repo.findCidades(esatdoId);
	}
}
