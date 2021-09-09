package br.com.sysve.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sysve.produto.entity.Produto;
import br.com.sysve.saida.entity.Saida;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="saida_produto")
@Data
public class SaidaProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "saida_id")
	@JsonIgnore
	private Saida saida;
	
	private Long quantidadeProduto;
	private BigDecimal valorUnitario;
}
