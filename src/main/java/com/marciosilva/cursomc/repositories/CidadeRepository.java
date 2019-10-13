package com.marciosilva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciosilva.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
