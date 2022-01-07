package br.com.sysve.entity;

import br.com.sysve.saida.entity.Saida;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="saida_produto")
@Data
public class SaidaProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "produto_id")
//	private ProductDto produto;
//
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "saida_id")
	private Saida saida;
//
//	private Long quantidadeProduto;
//	private BigDecimal valorUnitario;
}
