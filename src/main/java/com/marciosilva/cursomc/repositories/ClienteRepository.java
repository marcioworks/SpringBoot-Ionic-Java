package com.marciosilva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciosilva.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
