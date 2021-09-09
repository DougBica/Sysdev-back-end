package br.com.sysve.entrada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysve.entrada.entity.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long>{


}
