package br.com.sysve.produto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysve.produto.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findByCodigoBarraAndAtivo(Long codigoBarra, Boolean ativo);
	
}
