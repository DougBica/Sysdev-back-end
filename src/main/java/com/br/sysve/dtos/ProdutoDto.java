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
	private BigDecimal valorVenda;
	private Long codigoBarra;
	private String caminhoImagem;
	private Unidade unidade;
	private Boolean ativo;

}
