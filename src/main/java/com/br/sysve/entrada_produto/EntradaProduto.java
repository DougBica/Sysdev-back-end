package com.br.sysve.entrada_produto;

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
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
	private Entrada entrada;
	
	private Long quantidadeProduto;
	
	


}
