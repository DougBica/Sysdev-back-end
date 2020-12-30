package com.br.sysve.entrada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.sysve.entrada.entity.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long>{


}
