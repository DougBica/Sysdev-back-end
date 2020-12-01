package com.br.sysve.produto.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.br.sysve.interfaces.CadastroGenerico;
import com.br.sysve.produto.entity.enumerator.TipoProduto;

import lombok.Data;

@Entity
@Table(name="produto")
@Data
public class Produto extends CadastroGenerico{
	
	private String nome;
	private BigDecimal quantidade;
	private BigInteger codigoBarra;
	private String caminhoImagem;
	private Unidade unidade;
	private TipoProduto tipoProduto;
	

}
