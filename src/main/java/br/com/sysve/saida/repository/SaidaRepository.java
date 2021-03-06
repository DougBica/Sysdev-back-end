package br.com.sysve.saida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysve.saida.entity.Saida;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long>{

}
