package br.com.sysve.entity;

import br.com.sysve.entities.BasicEntity;
import br.com.sysve.entrada.entity.Entrada;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name="entrada_produto")
public class EntradaProduto extends BasicEntity {

	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private ProductDto produto;

    @ManyToOne(cascade = CascadeType.ALL)
	private Entrada entrada;
	
	private Long quantidadeProduto;
	private BigDecimal valorUnitario;
	private BigDecimal custoUnitario;
	
}
