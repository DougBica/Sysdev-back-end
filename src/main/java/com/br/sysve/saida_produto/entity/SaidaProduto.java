package com.br.sysve.saida_produto.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.sysve.produto.entity.Produto;
import com.br.sysve.saida.entity.Saida;

import lombok.Data;

@Entity
@Table(name="saida_produto")
@Data
public class SaidaProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Saida saida;
	
	private Long quantidadeProduto;
	private BigDecimal valorUnitario;
}
