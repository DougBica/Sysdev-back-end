package com.br.sysve.entrada_produto.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.sysve.entrada.entity.Entrada;
import com.br.sysve.produto.entity.Produto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="entrada_produto")
@Data
public class EntradaProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
	private Entrada entrada;
	
	private Long quantidadeProduto;
	private BigDecimal valorUnitario;
	private BigDecimal custoUnitario;
	
}
