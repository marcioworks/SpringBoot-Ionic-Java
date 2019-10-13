package com.marciosilva.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciosilva.cursomc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>  {

}