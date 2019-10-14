package com.marciosilva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciosilva.cursomc.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
