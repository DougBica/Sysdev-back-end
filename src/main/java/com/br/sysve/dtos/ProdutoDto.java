package com.br.sysve.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.br.sysve.produto.entity.Unidade;

import lombok.Data;


@Data
public class ProdutoDto {
	
	private Long id;
	private String nome;
	private BigDecimal quantidadeEmbalagem;
	private Long codigoBarra;
	private String caminhoImagem;
	private Unidade unidade;
	private Boolean ativo;
	
	
	public ProdutoDto() {};
	public ProdutoDto(Long id,String nome,BigDecimal quantidadeEmbalagem,Long codigoBarra,String caminhoImagem,Unidade unidade) {
		this.id = id;
		this.nome = nome;
		this.quantidadeEmbalagem = quantidadeEmbalagem;
		this.codigoBarra = codigoBarra;
		this.caminhoImagem = caminhoImagem;
		this.unidade = new Unidade();
	}

}
